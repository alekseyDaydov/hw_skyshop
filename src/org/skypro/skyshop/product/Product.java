package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    protected final String TERM_PRODUCT = "PRODUCT";
    private String name;

    public Product(String name) {
        if (("null" == name) || name.isBlank()) {
            throw new IllegalArgumentException("Поле Имя не может быть пустым");
        }
        this.name = name;
    }

    public abstract boolean isSpecial();

    public abstract double getPrice();

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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}