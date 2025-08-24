package org.skypro.skyshop.search;

public class SearchEngine {
    private int countElement;
    Searchable[] searchables;

    public SearchEngine(int countElement) {
        this.countElement = countElement;
        searchables  = new Searchable[countElement];
    }

    public Searchable[] search(String findText) {
        int count = 1;
        Searchable[] searchResult = new Searchable[countElement];
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] != null && searchables[i].searchTerm().contains(findText)) {
                searchResult[i] = searchables[i];
                count++;
            }
            if (count > 5) {
                break;
            }
        }
        return searchResult;
    }

    public void add(Searchable searchable) {
        boolean isExist = true;
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = searchable;
                isExist = false;
                break;
            }
        }
        if (isExist) {
            throw new IllegalArgumentException("Массив поискового движка заполнен");
        }
    }
}
