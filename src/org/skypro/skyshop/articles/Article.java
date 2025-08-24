package org.skypro.skyshop.articles;

import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable {
    private static String TERM_ARTICLE = "ARTICLE";
    private String title;
    private String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return  title + '\n' + text ;
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String getContent() {
        return TERM_ARTICLE;
    }

    @Override
    public String getName() {
        return getTitle();
    }
}
