package org.skypro.skyshop.search;

public interface Searchable {

    String searchTerm();

    String getContent();

    String getName();

    default String getStringRepresentation() {
        return getName() + " - " + getContent();
    }
}
