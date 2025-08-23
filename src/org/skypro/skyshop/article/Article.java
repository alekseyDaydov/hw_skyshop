package org.skypro.skyshop.article;

import org.skypro.skyshop.Searchable;

public final class Article implements Searchable {
    private static String TERM_ARTICLE = "ARTICLE";
    private String name;
    private String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  name + '\n' + text ;
    }

    @Override
    public String searchTerm(String findText) {
        return toString();
    }

    @Override
    public String getContent() {
        return TERM_ARTICLE;
    }
}
