package org.skypro.skyshop.search;

import java.util.Comparator;

public class SortNameComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        int compareInteger = Integer.compare(o2.getName().length(), o1.getName().length());
        if (compareInteger == 0) {
            return compareTo(o1, o2);
        }
        return compareInteger;
    }

    public int compareTo(Searchable o1, Searchable o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
