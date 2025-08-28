package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private final Map<String, Searchable> searchablesMap = new TreeMap<>();

    public List<Searchable> search(String findText) {
        List<Searchable> searchResult = new ArrayList<>();
        for (Map.Entry<String, Searchable> element : searchablesMap.entrySet()) {
            if (element.getValue() != null && element.getValue().searchTerm().contains(findText)) {
                searchResult.add(element.getValue());
            }
        }
        return searchResult;
    }

    public void add(Searchable searchable) {
        if (searchable == null) {
            throw new IllegalArgumentException("Введено пустое значение");
        }
        searchablesMap.put(searchable.getName(), searchable);
    }

    public Searchable getSearchTerm(String findText) throws BestResultNotFound {
        int countMax = 0;
        String nameMax = null;
        for (Map.Entry<String, Searchable> element : searchablesMap.entrySet()) {
            int count = countMatches(element.getValue(), findText);
            if (count > countMax) {
                countMax = count;
                nameMax = element.getKey();
            }
        }
        if (countMax == 0) {
            throw new BestResultNotFound("Запрос: " + findText + " - не нашлось подходящей строки");
        }
        return searchablesMap.get(nameMax);
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
