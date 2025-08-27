package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String name, int amount) {
        super(name);
        if (amount < 1) {
            throw new IllegalArgumentException("Цена должна быть больше 0");
        }
        this.price = amount;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + ">:<" + price + ">";
    }
}
