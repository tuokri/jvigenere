package com.github.util;

import java.math.BigInteger;

public class StringUtils {

    private StringUtils() {

    }

    public static String shift(String string, int offset) {

        if (string.length() == 0) {
            return string;
        }

        String result;

        // Optimize away multiple shift "rounds".
        offset = offset % string.length();

        if (offset == 0 || offset == string.length()) {
            result = string;

        } else if (offset > 0) {

            result = string.substring(string.length() - offset)
                + string.substring(0, string.length() - offset);

        } else {

            result = string.substring(-offset) + string.substring(0, -offset);
        }

        return result;
    }

    public static boolean isAllUnique(String s) {

        // Lé magic.
        // Assume amount of possible characters for now.
        if (s.length() > 32768) {
            return false;
        }

        BigInteger checker = BigInteger.ZERO;
        for (int i = 0; i < s.length(); i++) {

            int val = s.charAt(i);

            if (checker.testBit(val)) {
                return false;

            }

            checker = checker.setBit(val);
        }

        return true;
    }

    public static boolean containsAll(String allowed, String toCheck) {

        for (char c : toCheck.toCharArray()) {

            if (allowed.indexOf(c) == -1) {

                return false;
            }
        }

        return true;
    }
}
