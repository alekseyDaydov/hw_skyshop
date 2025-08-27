package org.skypro.skyshop.product;

import java.util.Objects;

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
        return super.toString() + "<" + price + ">";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SimpleProduct that = (SimpleProduct) o;
        return price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price);
    }
}
