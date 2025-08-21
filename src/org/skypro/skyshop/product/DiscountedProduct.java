package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    private int basePrice;
    private int discount;

    public DiscountedProduct(String name, int amount, int basePrice, int discount) {
        super(name, amount);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public double getPrice() {
        return basePrice - basePrice*discount/(double) 100;
    }
}
