package net.kuhlmeyer.vjlib;

enum SendMode {
        Read((short) 0x01), Write((short) 0x02), FunctionCall((short) 0x07);

        private short sendByte;

        private SendMode(short sendByte) {
            this.sendByte = sendByte;
        }

        short getSendByte() {
            return sendByte;
        }
    }