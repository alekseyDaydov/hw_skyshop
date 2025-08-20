package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] productBasket = new Product[5];

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Передано пустое значение");
        }
        boolean isAddProduct = true;
        for (int i = 0; i < productBasket.length && isAddProduct; i++) {
            if (productBasket[i] == null) {
                productBasket[i] = product;
                isAddProduct = false;
            }
        }
        if (isAddProduct) {
            System.out.println("Невозможно добавить продукт " + product.getName());
        }
    }

    public int getAmountBasket() {
        int price = 0;
        for (int i = 0; i < productBasket.length; i++) {
            if (productBasket[i] != null) {
                price += productBasket[i].getAmount();
            }
        }
        return price;
    }

    public void printProductBasket() {
        int price = 0;
        for (int i = 0; i < productBasket.length; i++) {
            if (productBasket[i] != null) {
                System.out.println(productBasket[i]);
                price += productBasket[i].getAmount();
            }
        }
        if (price != 0) {
            System.out.println("Итого: <" + price + ">");
        } else {
            System.out.println("В корзине пусто");
        }
    }

    public boolean isCheckProductBasket(Product product) {
        for (int i = 0; i < productBasket.length && productBasket[i] != null; i++) {
            if (productBasket[i].getName().equals(product.getName())) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        Arrays.fill(productBasket, null);
    }
}