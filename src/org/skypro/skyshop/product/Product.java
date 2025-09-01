package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    protected final String TERM_PRODUCT = "PRODUCT";
    private final String name;

    public Product(String name) {
        if (("null" == name) || name.isBlank()) {
            throw new IllegalArgumentException("Поле Имя не может быть пустым");
        }
        this.name = name;
    }

    public abstract boolean isSpecial();

    public abstract int getPrice();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String searchTerm() {
        return getName();
    }

    @Override
    public String getContent() {
        return TERM_PRODUCT;
    }

    @Override
    public String toString() {
        return "<" + name + ">:";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        Searchable product = (Searchable) other;
        return Objects.equals(name, product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

}