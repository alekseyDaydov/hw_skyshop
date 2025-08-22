package org.skypro.skyshop.product;

public abstract class Product {
    private String name;

    public Product(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Поле Имя не может быть пустым");
        }
        this.name = name;
    }

    public abstract boolean isSpecial();

    public abstract double getPrice();

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "<" + name + ">:";
    }
}