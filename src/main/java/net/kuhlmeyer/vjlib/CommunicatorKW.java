package net.kuhlmeyer.vjlib;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by christof on 15.09.14.
 */
public class CommunicatorKW implements Communicator {


    public static final int WAIT_TIME = 200;
    private static Logger LOG = Logger.getLogger(CommunicatorKW.class);

    @Override
    public short[] sendAndReceive(InputStream is, OutputStream os, SendMode sendMode, short responseLength, short... request) throws IOException {
        return new short[0];
    }


    private void waitFor05Byte(InputStream is, OutputStream os) throws IOException {
        boolean wait = true;

        while (wait) {
            LOG.trace("Waiting for 0x05");
            if (is.available() <= 0) {
                try {
                    Thread.sleep(WAIT_TIME);
                } catch (InterruptedException e) {
                    LOG.error(e);
                }
            }

            byte[] bytes = new byte[is.available()];
            is.read(bytes);

            if (LOG.isTraceEnabled()) {
                StringBuilder logBuffer = new StringBuilder();
                for (byte b : bytes) {
                    logBuffer.append(String.format("%02X", b));
                }
                LOG.trace(logBuffer.toString());
            }
            if (bytes != null && bytes.length > 0 && bytes[bytes.length - 1] == 0x05)
            {
                wait = false;
                break;
            }
        }

        LOG.trace("0x05 received. Starting to send data...");
    }

    private synchronized short[] sendAndReceiveKW(InputStream is, OutputStream os, int retry, boolean
            readData, short responseLength, short... req) throws IOException {

        waitFor05Byte(is, os);

        // Sending telegram start byte (0x01)
        StringBuilder sendBuffer = new StringBuilder("01 ");
        os.write((byte) 0x01);

        // Send read or write...
        if (readData) {
            sendBuffer.append("F7 ");
            os.write((byte) 0xF7);
        } else {
            sendBuffer.append("F4 ");
            os.write((byte) 0xF4);
        }

        // Send request...
        for (short reqVal : req) {
            sendBuffer.append(String.format("%02X ", reqVal));
            os.write((byte) reqVal);
        }

        // Send requested bytes
        sendBuffer.append(responseLength + " ");
        os.write(responseLength);
        os.flush();

        LOG.trace("Waiting to receive data...");

        try {
            Thread.sleep(200);

            byte[] recvBytes = new byte[is.available()];
            is.read(recvBytes);

            short[] response = new short[recvBytes.length];
            if (recvBytes != null && recvBytes.length > 0) {
                StringBuilder recvBuffer = new StringBuilder();
                for (int i = 0; i < recvBytes.length; i++) {
                    if (LOG.isDebugEnabled()) {
                        recvBuffer.append(String.format("%02X ", recvBytes[i]));
                    }
                    response[i] = (short) recvBytes[i];
                }
                LOG.debug(String.format("SND [%s] => RCV [%s]",
                        sendBuffer.toString().trim(), recvBuffer.toString().trim()));
            } else {
                LOG.debug(String.format("SND [%s] => No response",
                        sendBuffer.toString().trim()));
                return null;
            }

            return response;
        } catch (IOException ex) {

            // Handle retry...
            if (retry > 0) {
                LOG.warn(String.format("No response received."), ex);
                return sendAndReceiveKW(is, os, retry - 1, readData, responseLength, req);
            } else {
                throw new RuntimeException("Reading failed.", ex);
            }
        } catch (InterruptedException ex) {
            LOG.error("Waiting interrupted.", ex);
        }

        return null;
    }

}
