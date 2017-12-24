package com.github.vigeneretable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VigenereTableTest {

    private VigenereTable vTable;

    @BeforeEach
    void setUp() {

        vTable = new VigenereTable(VigenereTable.ALPHABET_LATIN);
    }

    @Test
    void constructWithNonUniqueAlphabetShouldThrowInvalidArgumentException() {

        assertThrows(IllegalArgumentException.class, ()-> {
            new VigenereTable("nonuniquealphabet");
        });
    }

    @Test
    void basicEncrypt() {

        String plainText = "this is a message";
        String cipherText;
        String key = "wut";

        cipherText = vTable.encrypt(plainText, key);
        assertEquals("pbbo cl w gxomtcy", cipherText);
    }

    @Test
    void basicDecrypt() {

        String plainText;
        String cipherText = "pbbo cl w gxomtcy";
        String key = "wut";

        plainText = vTable.decrypt(cipherText, key);
        assertEquals("this is a message", plainText);
    }

    @Test
    void encryptNonAlphabetCharactersShouldNotChange() {

        String plainText = "ÖÄå* this is a message";
        String cipherText;
        String key = "wut";

        cipherText = vTable.encrypt(plainText, key);
        assertEquals("ÖÄå* pbbo cl w gxomtcy", cipherText);
    }

    @Test
    void encryptByIndicesOnlyAlphabetCharacters() {

        int beginIndex = 4;
        int endIndex = 8;
        String plainText = "justanothermessage";
        String cipherText = "folpugknaalfamlwax";
        String key = "wut";

        String actual = vTable.encrypt(plainText, key, beginIndex, endIndex);
        String expected = cipherText.substring(beginIndex, endIndex);
        assertEquals(expected, actual);
    }

    @Test
    void decryptByIndicesOnlyAlphabetCharacters() {

        int beginIndex = 5;
        int endIndex = 12;
        String plainText = "justanothermessage";
        String cipherText = "folpugknaalfamlwax";
        String key = "wut";

        String actual = vTable.decrypt(cipherText, key, beginIndex, endIndex);
        String expected = plainText.substring(beginIndex, endIndex);
        assertEquals(expected, actual);
    }

    @Test
    void encryptByIndicesStringWithNonAlphabetCharacters() {

        int beginIndex = 4;
        int endIndex = 8;
        String plainText = "just another message";
        String cipherText = "folp ugknaal famlwax";
        String key = "wut";

        String actual = vTable.encrypt(plainText, key, beginIndex, endIndex);
        String expected = cipherText.substring(beginIndex, endIndex);
        assertEquals(expected, actual);
    }

    @Test
    void decryptByIndicesStringWithNonAlphabetCharacters() {

        int beginIndex = 5;
        int endIndex = 12;
        String plainText = "just another message";
        String cipherText = "folp ugknaal famlwax";
        String key = "wut";

        String actual = vTable.decrypt(cipherText, key, beginIndex, endIndex);
        String expected = plainText.substring(beginIndex, endIndex);
        assertEquals(expected, actual);
    }

    @Test
    void encryptByIndicesLongSequenceOfNonAlphabetCharacters() {

        int beginIndex = 3;
        int endIndex = 16;
        String plainText = "LOO&&ng   mes sa ge 234234822374";
        String cipherText = "LOO&&ja   fam lw ax 234234822374";
        String key = "wut";

        String actual = vTable.encrypt(plainText, key, beginIndex, endIndex);
        String expected = cipherText.substring(beginIndex, endIndex);
        assertEquals(expected, actual);
    }

    @Test
    void decryptNonAlphabetCharactersShouldNotChange() {

        String plainText;
        String cipherText = "_268 pbbo cl w gxomtcy &&";
        String key = "wut";

        plainText = vTable.decrypt(cipherText, key);
        assertEquals("_268 this is a message &&", plainText);
    }

    @Test
    void encryptWithEmptyKey() {

        String plainText = "this here is a message";
        String cipherText;
        String key = "";

        cipherText = vTable.encrypt(plainText, key);
        assertEquals(plainText, cipherText);
    }

    @Test
    void decryptWithEmptyKey() {

        String plainText;
        String cipherText = "this here is a message";
        String key = "";

        plainText = vTable.decrypt(cipherText, key);
        assertEquals(cipherText, plainText);
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
