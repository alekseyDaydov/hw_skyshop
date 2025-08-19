package org.skypro.skyshop.product;

public class Product {
    private String name;
    private int amount;

    public Product(String name, int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Цена товара не может быть меньше нуля");
        }
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "<" + name + "> : <" + amount + ">";
    }
}
