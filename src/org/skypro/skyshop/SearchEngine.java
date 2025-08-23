package org.skypro.skyshop;

public class SearchEngine {
    private int countElement;
    private Searchable[] searchables = new Searchable[countElement];

    public SearchEngine(int countElement) {
        this.countElement = countElement;
    }
}
