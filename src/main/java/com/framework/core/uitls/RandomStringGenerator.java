package com.framework.core.uitls;

import java.util.concurrent.ThreadLocalRandom;

public class RandomStringGenerator {

    private static final char[] PRINTABLE_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ012345679"
            .toCharArray();

    public static String getNewString(int length) {
        final byte[] random = getNewStringAsBytes(length);
        return convertBytesToString(random);
    }

    private static byte[] getNewStringAsBytes(int length) {
        final byte[] random = new byte[length];
        ThreadLocalRandom.current().nextBytes(random);
        return random;
    }

    private static String convertBytesToString(final byte[] random) {
        final char[] output = new char[random.length];
        for (int i = 0; i < random.length; i++) {
            final int index = Math.abs(random[i] % PRINTABLE_CHARACTERS.length);
            output[i] = PRINTABLE_CHARACTERS[index];
        }
        return new String(output);
    }

    public static void main(String[] args) {
    }
}
