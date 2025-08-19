package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] productBasket = new Product[5];

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
        int result = 0;
        for (int i = 0; i < productBasket.length && productBasket[i] != null; i++) {
            result += productBasket[i].getAmount();
        }
        return result;
    }

    public void printProductBasket() {
        int result = 0;
        for (int i = 0; i < productBasket.length && productBasket[i] != null; i++) {
            System.out.println(productBasket[i]);
            result += productBasket[i].getAmount();
        }
        if (result != 0) {
            System.out.println("Итого: <" + result + ">");
        } else {
            System.out.println("В корзине пусто");
        }
    }

    public boolean isCheckProductBasket(Product product) {
        for (int i = 0; i < productBasket.length && productBasket[i] != null; i++) {
            if (productBasket[i].getName() == product.getName()) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i <= productBasket.length && productBasket[i] != null; i++) {
            productBasket[i] = null;
        }
    }
}