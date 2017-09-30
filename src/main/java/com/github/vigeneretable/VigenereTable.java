package com.github.vigeneretable;

import java.util.ArrayList;

public class VigenereTable {

    private String alphabet;
    private ArrayList<String> table;

    public VigenereTable() {
        this.alphabet = "";
        this.table = generateTable(this.alphabet);
    }

    public VigenereTable(String alphabet) {
        this.alphabet = "";
        this.table = generateTable(alphabet);
    }

    public ArrayList<String> generateTable(String alphabet) {

        ArrayList<String> newTable = new ArrayList<String>(alphabet.length());

        for(int i = 0; i < alphabet.length(); i++) {

            // TODO: Refactor.
            String shifted = alphabet.substring(alphabet.length() - i) + alphabet.substring(0, alphabet.length() - i);
            newTable.add(shifted);
        }

        return newTable;
    }

    public String getAlphabet() {

        return alphabet;
    }

    public ArrayList<String> getTable() {

        return table;
    }

    public void setAlphabet(String alphabet) {

        this.alphabet = alphabet;
    }

    public void setTable(ArrayList<String> table) {

        this.table = table;
    }

    public String toString() {

        return table.toString();
    }
}
