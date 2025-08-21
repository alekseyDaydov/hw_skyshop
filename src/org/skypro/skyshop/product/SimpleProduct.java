package org.skypro.skyshop.product;

public class SimpleProduct extends Product{
//    private int price;
    public SimpleProduct(String name, int amount) {
        super(name, amount);
    }
    @Override
    public double getPrice() {
        return 0;
    }

}
