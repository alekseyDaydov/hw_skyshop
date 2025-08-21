package org.skypro.skyshop.product;

public class FixPriceProduct {
    private static final int FIX_PRICE = 100;

    private int name;

    public FixPriceProduct(int name) {
        this.name = name;
    }
    public double getPrice() {
        return FIX_PRICE;
    }
}
