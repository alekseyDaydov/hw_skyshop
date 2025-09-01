package org.skypro.skyshop.articles;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public final class Article implements Searchable {
    private static String TERM_ARTICLE = "ARTICLE";
    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + '\n' + text;
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

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        Searchable art = (Searchable) other;
        return Objects.equals(title, art.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}
