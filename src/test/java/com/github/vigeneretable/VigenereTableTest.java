package com.github.vigeneretable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VigenereTableTest {

    private VigenereTable vTable;

    @BeforeEach
    void setUp() {

        vTable = new VigenereTable("abcdefghijklmnopqrstuvwxyz");
    }

    @Test
    void encrypt() {

        String plainText = "this is a message";
        String cipherText = "";
        String key = "wut";

        cipherText = vTable.encrypt(plainText, key);
        assertEquals("pbbo cl w gxomtcy", cipherText);
    }

    @Test
    void decrypt() {

        String plainText = "";
        String cipherText = "pbbo cl w gxomtcy";
        String key = "wut";

        plainText = vTable.decrypt(cipherText, key);
        assertEquals("this is a message", plainText);
    }
}