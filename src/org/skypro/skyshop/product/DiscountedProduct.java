package org.skypro.skyshop.product;

import java.util.Objects;

public class DiscountedProduct extends Product {
    private int baseAmount;
    private int discount;

    public DiscountedProduct(String name, int baseAmount, int discount) {
        super(name);
        if (baseAmount < 1) {
            throw new IllegalArgumentException("Цена должна быть больше 0");
        }

        this.baseAmount = baseAmount;
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Некорректное значение.Скидка может быть в интервале от 0 до 100");
        }
        this.discount = discount;

    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public double getPrice() {
        return baseAmount - baseAmount * discount / (double) 100;
    }

    @Override
    public String toString() {
        return super.toString() + "<" + getPrice() + "> (<" + discount + ">%)";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountedProduct that = (DiscountedProduct) o;
        return baseAmount == that.baseAmount && discount == that.discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), baseAmount, discount);
    }
}
