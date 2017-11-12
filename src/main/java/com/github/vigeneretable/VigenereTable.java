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

    public String toCipherText(String plainText) {

        return "";
    }

    public String toPlainText(String cipherText) {

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
