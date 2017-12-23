package com.github.vigeneretable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VigenereTableTest {

    private VigenereTable vTable;

    @BeforeEach
    void setUp() {

        vTable = new VigenereTable(VigenereTable.ALPHABET_LATIN);
    }

    @Test
    void basicEncrypt() {

        String plainText = "this is a message";
        String cipherText = "";
        String key = "wut";

        cipherText = vTable.encrypt(plainText, key);
        assertEquals("pbbo cl w gxomtcy", cipherText);
    }

    @Test
    void basicDecrypt() {

        String plainText = "";
        String cipherText = "pbbo cl w gxomtcy";
        String key = "wut";

        plainText = vTable.decrypt(cipherText, key);
        assertEquals("this is a message", plainText);
    }

    @Test
    void basicGenerateTable() {

        ArrayList<ArrayList<SimpleEntry<Character, Boolean>>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(
            new SimpleEntry<>('a', true), new SimpleEntry<>('b', true), new SimpleEntry<>('c', true))));
        expected.add(new ArrayList<>(Arrays.asList(
            new SimpleEntry<>('b', true), new SimpleEntry<>('c', true), new SimpleEntry<>('a', true))));
        expected.add(new ArrayList<>(Arrays.asList(
            new SimpleEntry<>('c', true), new SimpleEntry<>('a', true), new SimpleEntry<>('b', true))));

        ArrayList<ArrayList<SimpleEntry<Character, Boolean>>> actual;
        actual = VigenereTable.generateTable("abc");

        assertEquals(expected, actual);
    }
}