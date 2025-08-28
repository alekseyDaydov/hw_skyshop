package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    //    private final List<Product> productBasket = new LinkedList<Product>();
    private final Map<String, List<Product>> productBasket = new HashMap<>();
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Передано пустое значение");
        }
        productBasket.get(product.getName().contains())
        productBasket.add(product);
    }

    public double getPriceBasket() {
        double price = 0;
        for (Product element : productBasket) {
            if (productBasket != null) {
                price += (double) element.getPrice();
            }
        }
        return price;
    }

    public void printProductBasket() {
        double price = 0;
        int countSpecial = 0;
        for (Product element : productBasket) {
            if (element != null) {
                System.out.println(element);
                price += (double) element.getPrice();
                if (element.isSpecial()) {
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
        for (Product element : productBasket) {
            if (element != null && element.getName().contains(product.getName())) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        productBasket.clear();
    }

    public List<Product> deleteProductByName(String findNameProduct) {
        List<Product> deleteList = new ArrayList<>();
        Iterator iterator = productBasket.iterator();
        while (iterator.hasNext()) {
            Product product = (Product) iterator.next();
            if (product.getName().contains(findNameProduct)) {
                deleteList.add(product);
                iterator.remove();
            }
        }
        return deleteList;
    }
}