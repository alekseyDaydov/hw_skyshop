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

    public double getPriceBasket() {
        double price = 0;
        for (int i = 0; i < productBasket.length; i++) {
            if (productBasket[i] != null) {
                price += (double) productBasket[i].getPrice();
            }
        }
        return price;
    }

    public void printProductBasket() {
        double price = 0;
        int countSpecial = 0;
        for (Product product : productBasket) { // i = 0; i < productBasket.length; i++) {
            if (product != null) {
                System.out.println(product);
                price += (double) product.getPrice();
                if (product.isSpecial()) {
                    countSpecial++;
                }
            }
        }
        if (price != 0) {
            System.out.println("Итого: <" + price + ">");
            System.out.println("Специальных товаров: <" + countSpecial + ">");
        } else {
            System.out.println("В корзине пусто");
        }
    }

    public boolean isCheckProductBasket(Product product) {
        for (int i = 0; i < productBasket.length; i++) {
            if (productBasket[i] != null && productBasket[i].getName().equals(product.getName())) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        Arrays.fill(productBasket, null);
    }
}