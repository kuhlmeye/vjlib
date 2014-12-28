package net.kuhlmeyer.vjlib;

import java.io.IOException;

/**
 * Created by christof on 28.12.14.
 */
public class NumberConverter {


    public static Double convertShortBytesToDouble(short[] input, double div) {
        return checkSize(input, 2) ? convertShortBytesToInt(input) / div : null;
    }

    public static Integer convertShortBytesToInt(short[] input) {
        return checkSize(input, 2) ? Integer.valueOf((short) reverseAndCombine(input)) : null;
    }

    public static Integer convertIntBytesToInt(short[] input) {
        return checkSize(input, 4) ? Integer.valueOf(reverseAndCombine(input)) : null;
    }

    public static Double convertIntBytesToDouble(short[] input, double div) {
        return checkSize(input, 4) ? convertIntBytesToInt(input) / div : null;
    }

    public static Boolean convertByteToBoolean(short[] input) throws IOException {
        return checkSize(input, 1) ? Double.valueOf(1d).equals(convertByteToDouble(input, 1.0d)) : null;
    }

    public static Double convertByteToDouble(short[] input, double div) {
        return checkSize(input, 1) ? input[0] / div : null;
    }

    private static boolean checkSize(short[] input, int minSize) {
        return !(input == null || input.length < minSize);
    }

    private static int reverseAndCombine(short[] input) {
        int result = input[input.length - 1];
        for(int i = input.length - 2; i >= 0; i--) {
            result = (result << 8) + input[i];
        }
        return result;
    }
}
