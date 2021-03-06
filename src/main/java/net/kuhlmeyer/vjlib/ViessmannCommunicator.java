package net.kuhlmeyer.vjlib;


import gnu.io.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;


public class ViessmannCommunicator {


    private static Logger LOG = Logger.getLogger(ViessmannCommunicator.class);
    private final Communicator communicator;
    private InputStream is;
    private OutputStream os;

    public ViessmannCommunicator(Communicator communicator) {
        super();
        this.communicator = communicator;
    }

    public Double getNormaleRaumtemperatur() throws IOException {
        return NumberConverter.convertByteToDouble(communicator.sendAndReceive(is, os, (short) 0x01, new short[]{0x23, 0x06}), 1.0d);
    }

    public void setNormaleRaumtemperatur(short temperature) throws IOException {
        if (temperature >= 3 && temperature <= 37) {
            LOG.info("Setting normal room temperature to " + temperature);
            communicator.sendAndReceive(is, os, SendMode.Write, (short) 0x01, new short[]{0x23, 0x06, temperature});
        }
    }

    public Double getReduzierteRaumtemperatur() throws IOException {
        return NumberConverter.convertByteToDouble(communicator.sendAndReceive(is, os, (short) 0x01, new short[]{0x23, 0x07}), 1.0d);
    }

    public void setReduzierteRaumtemperatur(short temperature) throws IOException {
        if (temperature >= 3 && temperature <= 37) {
            communicator.sendAndReceive(is, os, SendMode.Write, (short) 0x01, new short[]{0x23, 0x07, temperature});
        }
    }

    public Double getTemperaturPartybetrieb() throws IOException {
        return NumberConverter.convertByteToDouble(communicator.sendAndReceive(is, os, (short) 0x01, new short[]{0x23, 0x08}), 1.0d);
    }

    public void setTemperaturPartybetrieb(short temperature) throws IOException {
        if (temperature >= 3 && temperature <= 37) {
            communicator.sendAndReceive(is, os, SendMode.Write, (short) 0x01, new short[]{0x23, 0x08, temperature});
        }
    }

    public Double getNeigung() throws IOException {
        return NumberConverter.convertByteToDouble(communicator.sendAndReceive(is, os, (short) 0x01, new short[]{0x23, 0x05}), 10.0d);
    }

    public void setNeigung(double temperature) throws IOException {
        // TODO Zwischen 0.2 und 3.5
    }

    public Double getNiveau() throws IOException {
        return NumberConverter.convertByteToDouble(communicator.sendAndReceive(is, os, (short) 0x01, new short[]{0x23, 0x04}), 1.0d);
    }

    public void setNiveau(short temperature) throws IOException {
        // TODO Zwischen -30 und 40
    }

    public Double getVerbrauch() throws IOException {
        // TODO Mal B4 Probieren...Gefördertes Material Pellet 08B0 (oder 08B4)
        return NumberConverter.convertIntBytesToDouble(communicator.sendAndReceive(is, os, (short) 0x04, new short[]{0x08, 0xb4}), 1000.0d);
    }

    public Double getAussenTemperatur() throws IOException {
        return NumberConverter.convertShortBytesToDouble(communicator.sendAndReceive(is, os, (short) 0x02, new short[]{0x55, 0x25}), 10.0d);
    }

    public String getBetriebsArt() throws IOException {
        // short[] response = sendAndReceive((short) 0x01, new short[] { 0x25,
        // 0x00 });
        short[] response = communicator.sendAndReceive(is, os, (short) 0x01, new short[]{0x23, 0x23});
        if (response != null && response.length > 0) {
            switch (response[0]) {
                case 0x00:
                    return "WW";
                case 0x01:
                    return "RED";
                case 0x02:
                    return "NORM";
                case 0x03:
                case 0x04:
                    return "H+WW";
                case 0x05:
                    return "ABSCHALT";
            }
        }
        LOG.info(String.format("BETRIEBSART IST: %s", response == null ? "null" : Arrays.toString(response)));
        return "UNBEKANNT";
    }

    public boolean setBetriebsArt(OperatingMode betriebsArt) throws IOException {
        communicator.sendAndReceive(is, os, SendMode.Write, (short) 0x01, new short[]{0x23, 0x23, betriebsArt.getSendByte()});
        return true;
    }

    public Integer getBrennerStarts() throws IOException {
        return NumberConverter.convertIntBytesToInt(communicator.sendAndReceive(is, os, (short) 0x04, new short[]{0x08, 0x8a}));
    }

    public Double getBrennerStunden() throws IOException {
        return NumberConverter.convertIntBytesToDouble(communicator.sendAndReceive(is, os, (short) 0x04, new short[]{0x08, 0xa7}), 3600.0d);
    }

    public Double getKesseltemperaturIst() throws IOException {
        return NumberConverter.convertShortBytesToDouble(communicator.sendAndReceive(is, os, (short) 0x02, new short[]{0xa2, 0x02}), 100.0d);
    }

    public Double getKesseltemperaturSoll() throws IOException {
        return NumberConverter.convertShortBytesToDouble(communicator.sendAndReceive(is, os, (short) 0x02, new short[]{0xa2, 0x66}), 100.0d);
    }

    public Double getKollektortemperatur() throws IOException {
        return NumberConverter.convertShortBytesToDouble(communicator.sendAndReceive(is, os, (short) 0x02, new short[]{0x65, 0x64}), 10.0d);
    }

    public Double getLeistung() throws IOException {
        return NumberConverter.convertShortBytesToDouble(communicator.sendAndReceive(is, os, (short) 0x02, new short[]{0xA3, 0x05}), 10.0d);
    }

    public Double getMischer() throws IOException {
        return NumberConverter.convertByteToDouble(communicator.sendAndReceive(is, os, (short) 0x01, new short[]{0x25, 0xc4}), 2.0d);
    }

    public Boolean getPartyBetrieb() throws IOException {
        return NumberConverter.convertByteToBoolean(communicator.sendAndReceive(is, os, (short) 0x01, new short[]{0x23, 0x03}));
    }

    public boolean setPartyBetrieb(boolean partyBetrieb) throws IOException {
        if (partyBetrieb) {
            communicator.sendAndReceive(is, os, SendMode.Write, (short) 0x01, new short[]{0x23, 0x03, 0x01});
        } else {
            communicator.sendAndReceive(is, os, SendMode.Write, (short) 0x01, new short[]{0x23, 0x03, 0x00});
        }
        return true;
    }

    public Double getRuecklaufIstM2() throws IOException {
        return NumberConverter.convertShortBytesToDouble(communicator.sendAndReceive(is, os, (short) 0x02, new short[]{0x08, 0x0a}), 10.0d);
    }

    public Integer getSolarLeistung() throws IOException {
        return NumberConverter.convertIntBytesToInt(communicator.sendAndReceive(is, os, (short) 0x04, new short[]{0x65, 0x60}));
    }

    public Integer getSolarStunden() throws IOException {
        return NumberConverter.convertShortBytesToInt(communicator.sendAndReceive(is, os, (short) 0x02, new short[]{0x65, 0x68}));
    }

    public Boolean getSparbetrieb() throws IOException {
        return NumberConverter.convertByteToBoolean(communicator.sendAndReceive(is, os, (short) 0x01, new short[]{0x23, 0x02}));
    }

    public boolean setSparBetrieb(boolean partyBetrieb) throws IOException {
        if (partyBetrieb) {
            communicator.sendAndReceive(is, os, SendMode.Write, (short) 0x01, new short[]{0x23, 0x02, 0x01});
        } else {
            communicator.sendAndReceive(is, os, SendMode.Write, (short) 0x01, new short[]{0x23, 0x02, 0x00});
        }
        return true;
    }

    public Boolean getStatusHeizkreisPumpe() throws IOException {
        return NumberConverter.convertByteToBoolean(communicator.sendAndReceive(is, os, (short) 0x01, new short[]{0x29, 0x06}));
    }

    public Boolean getStatusSolarpumpe() throws IOException {
        return NumberConverter.convertByteToBoolean(communicator.sendAndReceive(is, os, (short) 0x01, new short[]{0x65, 0x52}));
    }

    public Boolean getStatusSpeicherladePumpe() throws IOException {
        return NumberConverter.convertByteToBoolean(communicator.sendAndReceive(is, os, (short) 0x01, new short[]{0x08, 0x45}));
    }

    public Boolean getStatusWarmwasserSolar() throws IOException {
        return NumberConverter.convertByteToBoolean(communicator.sendAndReceive(is, os, (short) 0x01, new short[]{0x65, 0x51}));
    }

    public Boolean getStatusZirkulationspumpe() throws IOException {
        return NumberConverter.convertByteToBoolean(communicator.sendAndReceive(is, os, (short) 0x01, new short[]{0x08, 0x46}));
    }

    public Double getTemperaturSpeicherUnten() throws IOException {
        return NumberConverter.convertShortBytesToDouble(communicator.sendAndReceive(is, os, (short) 0x02, new short[]{0x65, 0x66}), 10.0d);
    }

    public Double getVorlaufIst() throws IOException {
        return NumberConverter.convertShortBytesToDouble(communicator.sendAndReceive(is, os, (short) 0x02, new short[]{0x29, 0x00}), 10.0d);
    }

    public Double getVorlaufIstM2() throws IOException {
        return NumberConverter.convertShortBytesToDouble(communicator.sendAndReceive(is, os, (short) 0x02, new short[]{0x08, 0x0c}), 10.0d);
    }

    public Double getVorlaufSollM1() throws IOException {
        return NumberConverter.convertShortBytesToDouble(communicator.sendAndReceive(is, os, (short) 0x02, new short[]{0x25, 0x44}), 10.0d);
    }

    public Double getWarmwasserIst() throws IOException {
        return NumberConverter.convertShortBytesToDouble(communicator.sendAndReceive(is, os, (short) 0x02, new short[]{0x08, 0x04}), 10.0d);
    }

    public Double getWarmwasserSoll() throws IOException {
        return NumberConverter.convertByteToDouble(communicator.sendAndReceive(is, os, (short) 0x02, new short[]{0x63, 0x00}), 1.0d);
    }



    public void endTransmission() throws IOException {
        os.write((byte) 0x04);
        os.flush();
    }

    public boolean initializeTransmission() throws IOException {
        for (int i = 0; i < 50; i++) {
            os.flush();
            os.write((byte) 0x04);
            os.flush();
            LOG.trace("Waiting for 0x05 byte");
            for(int j = 0; j < 20 && is.available() <= 0; j++) {
                sleep(200);
            }

            byte[] bytes = new byte[is.available()];
            is.read(bytes);

            if (bytes != null && bytes.length > 0 && bytes[bytes.length - 1] == 0x05) {
                is.skip(is.available());
                os.write(new byte[]{0x16, 0x00, 0x00});
                os.flush();
                LOG.trace("sending 0x16 0x00 0x00");

                byte resp = (byte) is.read();
                LOG.trace("Received " + String.format("'%02X'", resp));

                if (resp == 0x06) {
                    return true;
                }
            }

            if (LOG.isTraceEnabled() && bytes.length > 0) {
                StringBuilder logBuffer = new StringBuilder();
                logBuffer.append("Byte buffer was: '");
                for (byte b : bytes) {
                    logBuffer.append(String.format("%02X", b));
                }
                logBuffer.append("'");
                LOG.trace(logBuffer.toString());
            }
        }

        return false;
    }

    private void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            LOG.error(ex);
        }
    }




    public SerialPort openPort(final String viessmannDevice) throws IOException, UnsupportedCommOperationException, NoSuchPortException, PortInUseException {

        LOG.debug("Opening port " + viessmannDevice);
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(viessmannDevice);
        LOG.debug("Got port identifier");
        if (portIdentifier.isCurrentlyOwned()) {
            LOG.info("Port " + viessmannDevice + " is currently in use");
        } else {
            LOG.debug("Not owned. Now opening port " + viessmannDevice);
            CommPort commPort = portIdentifier.open(this.getClass().getName(), 2000);
            if (commPort instanceof SerialPort) {
                SerialPort serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(4800, SerialPort.DATABITS_8, SerialPort.STOPBITS_2, SerialPort.PARITY_EVEN);
                serialPort.setDTR(false);
                serialPort.setRTS(false);

                is = serialPort.getInputStream();
                os = serialPort.getOutputStream();
                return serialPort;
            }
            LOG.error(String.format("Port '%s' is not an instance of a Serial Port. Class is %s", viessmannDevice, commPort.getClass().getName()));
        }

        return null;
    }

    public void closePort(SerialPort serialPort) throws IOException {
        if (is != null) {
            is.close();
        }
        if (os != null) {
            os.close();
        }

        if (serialPort != null) {
            serialPort.close();
        }
    }

    public ViessmannData collectHeatingData(final String viessmannDevice) throws IOException, PortInUseException, UnsupportedCommOperationException, NoSuchPortException {
         SerialPort serialPort = null;
        try {
            LOG.debug("Opening port.. ");
            serialPort = openPort(viessmannDevice);



            LOG.debug("Initializing device connection ");

            boolean initOK = initializeTransmission();

            if(!initOK) {
                LOG.warn("Initialization not successful. Cancelling transmission!");
            }

            if(initOK) {
                LOG.debug("Collecting heating data from device ");

                ViessmannData heatingData = new ViessmannData();
                heatingData.setTimestamp(new Date());
                heatingData.setTempAussen(getAussenTemperatur());
                heatingData.setBetriebsArtM1(getBetriebsArt());
                heatingData.setBrennerStarts(getBrennerStarts());
                heatingData.setBrennerStunden1(getBrennerStunden());
                heatingData.setTempKesselIst(getKesseltemperaturIst());
                heatingData.setTempKesselSoll(getKesseltemperaturSoll());
                heatingData.setTempKollektor(getKollektortemperatur());
                heatingData.setLeistung(getLeistung());
                heatingData.setMischerM1(getMischer());
                heatingData.setNeigungM1(getNeigung());
                heatingData.setNiveauM1(getNiveau());
                heatingData.setTempRaumNormalSollM1(getNormaleRaumtemperatur());
                heatingData.setStatusPartyBetriebM1(getPartyBetrieb());
                heatingData.setTempRaumReduziertSollM1(getReduzierteRaumtemperatur());
                heatingData.setTempRuecklaufIstM2(getRuecklaufIstM2());
                heatingData.setSolarLeistung(getSolarLeistung());
                heatingData.setSolarStunden(getSolarStunden());
                heatingData.setStatusSparbetriebM1(getSparbetrieb());
                heatingData.setStatusPumpeM1(getStatusHeizkreisPumpe());
                heatingData.setStatusPumpeSolar(getStatusSolarpumpe());
                heatingData.setStatusSpeicherladepumpe(getStatusSpeicherladePumpe());
                heatingData.setStatusSolarNachladeunterdrueckung(getStatusWarmwasserSolar());
                heatingData.setStatusPumpeZirkulation(getStatusZirkulationspumpe());
                heatingData.setTempPartyM1(getTemperaturPartybetrieb());
                heatingData.setTempSpeicherUnten(getTemperaturSpeicherUnten());
                heatingData.setVerbrauch(getVerbrauch());
                heatingData.setTempVorlaufIstM1(getVorlaufIst());
                heatingData.setTempVorlaufIstM2(getVorlaufIstM2());
                heatingData.setTempVorlaufSollM1(getVorlaufSollM1());
                heatingData.setTempWWIst(getWarmwasserIst());
                heatingData.setTempWWSoll(getWarmwasserSoll());

                LOG.debug("Finished collecting heating data.");
                return heatingData;
            }


        } catch (Throwable e) {
            LOG.error("Error collecting data from device: '" + viessmannDevice + "'", e);
        } finally {
            endTransmission();

            try {
                closePort(serialPort);
            } catch (IOException e) {
                LOG.error("Error closing port: '" + viessmannDevice + "'", e);
            }
        }
        return null;
    }
}