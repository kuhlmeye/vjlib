package net.kuhlmeyer.vjlib;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Communicator300 implements Communicator {


    private static Logger LOG = Logger.getLogger(Communicator300.class);
    private static final int RETRY_COUNT = 5;
    private static final int WAIT_TIME = 250;

    @Override
    public short[] sendAndReceive(InputStream is, OutputStream os, SendMode sendMode, short responseLength, short... request) throws IOException {
        return sendAndReceive(is, os, RETRY_COUNT, sendMode, responseLength, responseLength);
    }

    private short[] sendAndReceive(InputStream is, OutputStream os, int retry, SendMode sendMode, short responseLength, short... request) throws IOException {

        String requestAsString = sendRequest(os, sendMode, responseLength, request);
        LOG.debug("Sending: " + requestAsString);

        try {
            Thread.sleep(WAIT_TIME);
        } catch (InterruptedException ex) {
            LOG.error(ex);
        }

        try {
            if (SendMode.Write.equals(sendMode)) {
                responseLength = 0x00;
            }

            return receiveResponse(is, requestAsString, responseLength);
        } catch (IOException ex) {

            // Handle retry...
            if (retry > 0) {
                LOG.warn(String.format("No response received."), ex);
                return sendAndReceive(is, os, retry - 1, sendMode, responseLength, request);
            } else {
                throw new RuntimeException("Reading failed.", ex);
            }
        }
    }


    private String sendRequest(OutputStream os, SendMode sendMode, short responseLength, short... req) throws IOException {

        short len = 0x03;
        len += req != null ? req.length : 0x00;
        short checksum = len;
        checksum += sendMode.getSendByte();
        os.write((byte) 0x41);
        os.write((byte) len);
        os.write((byte) 0x00);
        os.write(sendMode.getSendByte());

        StringBuilder requestAsStringBuffer = new StringBuilder("41 ");
        requestAsStringBuffer.append(String.format("%02X", len)).append(" 00 ").append(String.format("%02X", sendMode.getSendByte())).append(" ");

        for (int i = 0; i < 2; i++) {
            requestAsStringBuffer.append(String.format("%02X ", req[i]));
            os.write((byte) req[i]);
            checksum += req[i];
        }

        requestAsStringBuffer.append(String.format("%02X ", responseLength));
        os.write((byte) responseLength);
        checksum += responseLength;

        for (int i = 2; i < req.length; i++) {
            requestAsStringBuffer.append(String.format("%02X ", req[i]));
            os.write((byte) req[i]);
            checksum += req[i];
        }

        requestAsStringBuffer.append(String.format("%02X ", checksum));
        os.write((byte) checksum);
        os.flush();

        return requestAsStringBuffer.toString();
    }


    private short[] receiveResponse(InputStream is, String requestAsString, short responseLength) throws IOException {
        int[] recvBytes = new int[responseLength + 9];
        // TODO Timeout?
        for (int i = 0; i < recvBytes.length; i++) {
            recvBytes[i] = is.read();
        }
        int numBytes = responseLength + 9;

        StringBuilder fullRecvBuffer = new StringBuilder();
        for (int i = 0; i < numBytes; i++) {
            if (LOG.isDebugEnabled()) {
                fullRecvBuffer.append(String.format("%02X ", recvBytes[i]));
            }
        }

        if (recvBytes != null && numBytes > 9) {
            short[] response = new short[numBytes - 9];

            StringBuilder recvBuffer = new StringBuilder();

            int checksum = 0x00;
            for (int i = 2; i < numBytes - 1; i++) {
                checksum += recvBytes[i];
            }
            if (checksum % 0x100 != recvBytes[numBytes - 1]) {
                LOG.warn(String.format("Expected checksum '%02X' does not fit to checksum received '%02X' (SND [%s] => RCV [%s])", checksum, recvBytes[numBytes - 1],
                        requestAsString.trim(), fullRecvBuffer.toString().trim()));
                return null;
            }

            if (recvBytes[0] != 0x06) {
                LOG.warn(String.format("Error Code not ok. %02X (SND [%s] => RCV [%s])", recvBytes[0], requestAsString.trim(), fullRecvBuffer.toString().trim()));
                return null;
            }

            if (recvBytes[7] != numBytes - 9) {
                LOG.warn(String.format("Expected bytes of %02X does not fit to data bytes received %02X (SND [%s] => RCV [%s])", recvBytes[6], (numBytes - 8),
                        requestAsString.trim(), fullRecvBuffer.toString().trim()));
                return null;
            }

            for (int i = 8; i < numBytes - 1; i++) {
                if (LOG.isDebugEnabled()) {
                    recvBuffer.append(String.format("%02X ", recvBytes[i]));
                }
                response[i - 8] = (short) recvBytes[i];
            }
            LOG.debug(String.format("SND [%s] => RCV [%s] Cnt: [%s] (ErrCode: %02X, Chksum: %02X)", requestAsString.trim(), fullRecvBuffer.toString().trim(), recvBuffer.toString()
                    .trim(), recvBytes[0], recvBytes[numBytes - 1]));

            return response;
        } else if (numBytes <= 9) {
            StringBuilder recvBuffer = new StringBuilder();
            for (int i = 0; i < numBytes; i++) {
                if (LOG.isDebugEnabled()) {
                    recvBuffer.append(String.format("%02X ", recvBytes[i]));
                }
            }
            LOG.warn(String.format("SND [%s] => RCV [%s] (Answer too short).", requestAsString.trim(), recvBuffer.toString().trim()));
        } else {
            LOG.warn(String.format("SND [%s] => No response", requestAsString.trim()));
        }

        return null;
    }
}
