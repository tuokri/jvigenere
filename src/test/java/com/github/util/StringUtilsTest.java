package com.github.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilsTest {

    @Test
    void shiftByPositiveOffset() {

        String result = StringUtils.shift("teststring", 2);
        assertEquals("ngteststri", result);
    }

    @Test
    void shifByNegativeOffset() {

        String result = StringUtils.shift("teststring", -2);
        assertEquals("ststringte", result);
    }

    @Test
    void shifByPositiveOffsetGreaterThanStringLength() {

        String result = StringUtils.shift("teststring", 13);
        assertEquals("ingteststr", result);
    }


    @Test
    void shifByNegativeOffsetGreaterThanStringLength() {

        String result = StringUtils.shift("teststring", -13);
        assertEquals("tstringtes", result);
    }

    @Test
    void shiftEmptyStringByOneShouldReturnEmptyString() {

        String result = StringUtils.shift("", 1);
        assertEquals("", result);
    }

    @Test
    void shiftEmptyStringByMinusOneShouldReturnEmptyString() {

        String result = StringUtils.shift("", -1);
        assertEquals("", result);
    }

    @Test
    void shiftByStringLengthShouldReturnOriginal() {

        String result = StringUtils.shift("teststring", 10);
        assertEquals("teststring", result);
    }

    @Test
    void shiftByZeroShouldReturnOriginal() {

        String result = StringUtils.shift("teststring", 0);
        assertEquals("teststring", result);
    }

    @Test
    void isAllUnique() {

    }
}