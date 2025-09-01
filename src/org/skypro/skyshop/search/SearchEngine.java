package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchEngine {
    private final Set<Searchable> searchablesSet = new HashSet<>();
    private Searchable element;

    public TreeSet<Searchable> search(String findText) {
        return searchablesSet.stream()
                .filter(Objects::nonNull)
                .filter(element -> element.searchTerm().contains(findText))
                .collect(Collectors.toCollection(() -> {
                    return new TreeSet<Searchable>(
                            (Searchable o1, Searchable o2) -> {
                                return Integer.compare(o2.getName().length(), o1.getName().length()) == 0 ?
                                        o1.getName().compareTo(o2.getName()) :
                                        Integer.compare(o2.getName().length(), o1.getName().length());
                            });
                }));
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