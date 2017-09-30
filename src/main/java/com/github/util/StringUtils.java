package com.github.util;

public class StringUtils {

    public static String shift(String string, int offset) {

        if(string.length() == 0) {

            return string;
        }

        String result = null;
        offset = offset % string.length();

        if(offset == 0 || offset == string.length()) {

            result = string;

        } else if(offset > 0) {

            result = string.substring(string.length() - offset)
                    + string.substring(0, string.length() - offset);

        } else if(offset < 0) {

            result = string.substring(-offset) + string.substring(0, -offset);

        }

        return result;
    }

    public static boolean isAllUnique(String s) {

        return true;
    }
}
