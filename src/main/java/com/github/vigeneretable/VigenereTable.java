package com.github.vigeneretable;

import com.github.util.StringUtils;

import java.util.ArrayList;

public class VigenereTable {

    private final String alphabet;
    private final ArrayList<String> table;

    public VigenereTable() {

        this.alphabet = "";
        this.table = generateTable(this.alphabet);
    }

    public VigenereTable(String alphabet) throws IllegalArgumentException {

        if(!StringUtils.isAllUnique(alphabet)) {
            throw new IllegalArgumentException("Alphabet cannot contain duplicate characters");
        }

        this.alphabet = alphabet;
        this.table = generateTable(alphabet);
    }

    public ArrayList<String> generateTable(String alphabet) {

        ArrayList<String> newTable = new ArrayList<String>(alphabet.length());

        for(int i = 0; i < alphabet.length(); i++) {
            String shifted = StringUtils.shift(alphabet, -i);
            newTable.add(shifted);
        }

        return newTable;
    }

    public String encrypt(String plainText, String key) throws IllegalArgumentException {

        if(!StringUtils.containsAll(alphabet, key)) {
            throw new IllegalArgumentException("Key cannot contain non-alphabet characters");
        }

        StringBuilder cipherText = new StringBuilder();
        char keyChar;
        int keyCol = 0;
        int plainTextRow = 0;
        int keyIndex = 0;

        for(char plainChar : plainText.toCharArray()) {

            if(plainChar == ' ') {

                cipherText.append(plainChar);

            } else {

                keyChar = key.charAt(keyIndex);
                keyIndex = (keyIndex + 1) % key.length();
                keyCol = alphabet.indexOf(keyChar);
                plainTextRow = alphabet.indexOf(plainChar);
                cipherText.append(table.get(plainTextRow).charAt(keyCol));

            }
        }

        return cipherText.toString();
    }

    public String decrypt(String cipherText, String key) throws IllegalArgumentException {

        if(!StringUtils.containsAll(alphabet, key)) {
            throw new IllegalArgumentException("Key cannot contain non-alphabet characters");
        }

        StringBuilder plainText = new StringBuilder();
        char keyChar;
        int keyCol = 0;
        int plainTextRow = 0;
        int keyIndex = 0;

        for(char cipherChar : cipherText.toCharArray()) {

            if(cipherChar == ' ') {

                plainText.append(cipherChar);

            } else {

            keyChar = key.charAt(keyIndex);
            keyIndex = (keyIndex + 1) % key.length();
            keyCol = alphabet.indexOf(keyChar);

            plainTextRow = 0;
            for(String row : table) {

                if(row.charAt(keyCol) == cipherChar) {
                    break;
                }

                plainTextRow++;
            }

            plainText.append(alphabet.charAt(plainTextRow));

            }
        }

        return plainText.toString();
    }

    public String getAlphabet() {

        return alphabet;
    }

    public ArrayList<String> getTable() {

        return table;
    }

    public String toString() {

        return table.toString();
    }
}
