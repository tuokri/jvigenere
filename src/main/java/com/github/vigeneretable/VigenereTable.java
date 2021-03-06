package com.github.vigeneretable;

import com.github.util.StringUtils;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

/**
 * VigenereTable class represents a Vigenère table used in
 * encrypting and decrypting Vigenère cipher.
 */
public class VigenereTable {

    public static final String ALPHABET_LATIN = "abcdefghijklmnopqrstuvwxyz";
    public static final String ALPHABET_SCANDINAVIAN = "abcdefghijklmnopqrstuvwxyzåäö";

    private final String alphabet;
    private final ArrayList<ArrayList<SimpleEntry<Character, Boolean>>> table;

    public static ArrayList<ArrayList<SimpleEntry<Character, Boolean>>> generateTable(String alphabet)
        throws IllegalArgumentException {

        if (!StringUtils.isAllUnique(alphabet)) {
            throw new IllegalArgumentException("Alphabet cannot contain duplicate characters");
        }

        ArrayList<ArrayList<SimpleEntry<Character, Boolean>>> newTable = new ArrayList<>(alphabet.length());

        for (int i = 0; i < alphabet.length(); i++) {

            ArrayList<SimpleEntry<Character, Boolean>> newRow = new ArrayList<>(alphabet.length());

            for (int j = 0; j < alphabet.length(); j++) {

                Character c = alphabet.charAt((j + i) % alphabet.length());
                newRow.add(new SimpleEntry<>(c, true));
            }

            newTable.add(newRow);
        }

        return newTable;
    }

    public VigenereTable(String alphabet) throws IllegalArgumentException {

        if (!StringUtils.isAllUnique(alphabet)) {
            throw new IllegalArgumentException("Alphabet cannot contain duplicate characters");
        }

        this.alphabet = alphabet;
        this.table = generateTable(alphabet);
    }

    public String encrypt(String plainText, String key) throws IllegalArgumentException {

        if(key.length() == 0) {

            return plainText;
        }

        if (!StringUtils.containsAll(alphabet, key)) {
            throw new IllegalArgumentException("Key cannot contain non-alphabet characters");
        }

        StringBuilder cipherText = new StringBuilder();
        Character keyChar;
        int keyRow;
        int plainTextCol;
        int keyIndex = 0;

        for (Character plainChar : plainText.toCharArray()) {

            plainTextCol = alphabet.indexOf(plainChar);

            // Ignore non-alphabet characters.
            if (plainTextCol == -1) {

                cipherText.append(plainChar);

            } else {

                keyChar = key.charAt(keyIndex);
                keyIndex = (keyIndex + 1) % key.length();
                keyRow = alphabet.indexOf(keyChar);
                cipherText.append(table.get(keyRow).get(plainTextCol).getKey());

            }
        }

        return cipherText.toString();
    }

    public String encrypt(String plainText, String key, int beginIndex, int endIndex) {

        int keyOffset = beginIndex - countNonAlphabetCharacters(plainText.substring(0, beginIndex));
        key = StringUtils.shift(key, -keyOffset);
        plainText = plainText.substring(beginIndex, endIndex);
        return encrypt(plainText, key);
    }

    public String decrypt(String cipherText, String key) throws IllegalArgumentException {

        if (key.length() == 0) {

            return cipherText;
        }

        if (!StringUtils.containsAll(alphabet, key)) {
            throw new IllegalArgumentException("Key cannot contain non-alphabet characters");
        }

        StringBuilder plainText = new StringBuilder();
        Character keyChar;
        int keyRow;
        int plainTextCol;
        int keyIndex = 0;

        for (Character cipherChar : cipherText.toCharArray()) {

            // Ignore non-alphabet characters.
            if (!alphabet.contains(cipherChar.toString())) {

                plainText.append(cipherChar);

            } else {

                keyChar = key.charAt(keyIndex);
                keyIndex = (keyIndex + 1) % key.length();
                keyRow = alphabet.indexOf(keyChar);
                plainTextCol = 0;

                for (ArrayList<SimpleEntry<Character, Boolean>> row : table) {

                    if (row.get(keyRow).getKey() == cipherChar) {

                        plainText.append(alphabet.charAt(plainTextCol));
                        break;
                    }

                    plainTextCol++;
                }
            }
        }

        return plainText.toString();
    }

    public String decrypt(String cipherText, String key, int beginIndex, int endIndex) {

        int keyOffset = beginIndex - countNonAlphabetCharacters(cipherText.substring(0, beginIndex));
        key = StringUtils.shift(key, -keyOffset);
        cipherText = cipherText.substring(beginIndex, endIndex);
        return decrypt(cipherText, key);
    }

    public int countNonAlphabetCharacters(String string) {

        int c = 0;
        for (int i = 0; i < string.length(); i++) {

            if (alphabet.indexOf(string.charAt(i)) == -1) {

                c++;
            }
        }

        return c;
    }

    public String getAlphabet() {

        return alphabet;
    }

    public ArrayList<ArrayList<SimpleEntry<Character, Boolean>>> getTable() {

        return table;
    }

    @Override
    public String toString() {

        return table.toString();
    }
}
