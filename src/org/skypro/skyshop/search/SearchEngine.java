package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private final Set<Searchable> searchablesSet = new HashSet<>();

    public TreeSet<Searchable> search(String findText) {
        TreeSet<Searchable> searchResultMap = new TreeSet<>(new SortNameComparator());
        for (Searchable element : searchablesSet) {
            if (element != null && element.searchTerm().contains(findText)) {
                searchResultMap.add(element);
            }
        }
        return searchResultMap;
    }

    public void add(Searchable searchable) {
        searchablesSet.add(searchable);
    }

    public Searchable getSearchTerm(String findText) throws BestResultNotFound {
        int countMax = 0;
        Searchable search = null;
        Iterator iterator = searchablesSet.iterator();
        while (iterator.hasNext()) {
            Searchable searchable = (Searchable) iterator.next();
            int count = countMatches(searchable, findText);
            if (count > countMax) {
                countMax = count;
                search = searchable;
            }
        }
        if (countMax == 0) {
            throw new BestResultNotFound("Запрос: " + findText + " - не нашлось подходящей строки");
        }
        return search;
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

    public void print() {
        System.out.println(searchablesSet);
    }
}