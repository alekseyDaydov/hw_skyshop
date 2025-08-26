package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

public class SearchEngine {
    private int countElement;
    Searchable[] searchables;

    public SearchEngine(int countElement) {
        this.countElement = countElement;
        searchables = new Searchable[countElement];
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

    public Searchable getSearchTerm(String findText) throws BestResultNotFound {
        int countMax = 0;
        int indexMax = 0;
        for (int i = 0; i < searchables.length; i++) {
            int indexString = 0;
            int count = 0;
            if (searchables[i] != null) {
                String text = searchables[i].searchTerm();
                int indexSubString = text.indexOf(findText);
                while (indexSubString != -1) {
                    count++;
                    indexString = indexSubString + findText.length();
                    indexSubString = text.indexOf(findText, indexString);
                }
            }
            if (count > countMax) {
                countMax = count;
                indexMax = i;
            }
        }
        if (countMax == 0) {
            throw new BestResultNotFound("Запрос: "  + findText + " - не нашлось подходящей строки");
        }
        return searchables[indexMax];
    }
}
