package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int baseAmount;
    private int discount;

    public DiscountedProduct(String name, int baseAmount, int discount) {
        super(name);
        this.baseAmount = baseAmount;
        this.discount = discount;
    }

    @Override
    public double getPrice() {
        return baseAmount - baseAmount * discount / (double) 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "<" + getPrice() +"> (<" + discount +">%)" ;
    }
}
