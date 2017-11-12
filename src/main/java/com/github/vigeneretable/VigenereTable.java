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

    public String toCipherText(String plainText, String key) {

        if(!StringUtils.containsAll(alphabet, key)) {
            throw new IllegalArgumentException("Key cannot contain non-alphabet characters");
        }

        StringBuilder cipher = new StringBuilder();
        char char_key;
        int col_key = 0;
        int row_plain = 0;
        int k = 0;

        for(char char_plain : plainText.toCharArray()) {

            char_key = key.charAt(k);
            k = (k + 1) % key.length();
            col_key = alphabet.indexOf(char_key);
            row_plain = alphabet.indexOf(char_plain);
            cipher.append(table.get(row_plain).charAt(col_key));
        }

        return cipher.toString();
    }

    public String toPlainText(String cipherText, String key) {

        return "";
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
