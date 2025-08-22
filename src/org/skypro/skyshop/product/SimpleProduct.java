package org.skypro.skyshop.product;

public class SimpleProduct extends Product{
    private int price;
    public SimpleProduct(String name, int amount) {
        super(name);
        this.price = amount;
    }
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + ">:<" + price + ">";
    }
}
