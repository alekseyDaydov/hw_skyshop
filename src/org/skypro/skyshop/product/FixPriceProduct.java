package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE_PRODUCT = 100;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public double getPrice() {
        return FIX_PRICE_PRODUCT;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "Фиксированная цена <" + FIX_PRICE_PRODUCT + ">";
    }
}
