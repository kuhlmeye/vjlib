package net.kuhlmeyer.vjlib;

public enum BetriebsArt {
        Sommerbetrieb((byte) 0x00), DauerndReduziert((byte) 0x01), DauerndNormal((byte) 0x02), NormalReduziert((byte) 0x03), Vier((byte) 0x04), Abschalt((byte) 0x05);

        private byte sendByte;

        private BetriebsArt(byte sendByte) {
            this.sendByte = sendByte;
        }

        byte getSendByte() {
            return sendByte;
        }
    }