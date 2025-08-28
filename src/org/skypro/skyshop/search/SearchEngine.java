package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchEngine {
    private int countElement;
    private final List<Searchable> searchables = new ArrayList<>();

    public SearchEngine(int countElement) {
        this.countElement = countElement;
    }

    public List<Searchable> search(String findText) {
        List<Searchable> searchResult = new ArrayList<>();
        for (Searchable element : searchables) {
            if (element != null && element.searchTerm().contains(findText)) {
                searchResult.add(element);
            }
        }
        return searchResult;
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Searchable getSearchTerm(String findText) throws BestResultNotFound {
        int countMax = 0;
        int indexMax = 0;
        Iterator iterator = searchables.iterator();
        while (iterator.hasNext()) {
            Searchable searchable = (Searchable) iterator.next();
            int count = countMatches(searchable, findText);
            if (count > countMax) {
                countMax = count;
                indexMax = searchables.indexOf(searchable);
            }
        }
        if (countMax == 0) {
            throw new BestResultNotFound("Запрос: " + findText + " - не нашлось подходящей строки");
        }
        return searchables.get(indexMax);
    }

    private int countMatches(Searchable searchable, String findText) {
        int indexString;
        int count = 0;
        if (searchable != null) {
            String text = searchable.searchTerm();
            int indexSubString = text.indexOf(findText);
            while (indexSubString != -1) {
                count++;
                indexString = indexSubString + findText.length();
                indexSubString = text.indexOf(findText, indexString);
            }
        }
        return count;
    }
}
