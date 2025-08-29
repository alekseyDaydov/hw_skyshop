package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> productBasket = new HashMap<>();

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Передано пустое значение");
        }
//        получить имя продукта
        List<Product> productList = new ArrayList<>();
//        смотрим есть ли такой ключ продукта в MAP
        if (productBasket.containsKey(product.getName())) {
//            получить список по имени продуктов
            productList = productBasket.get(product.getName());
//            добавить в список по имени
            productList.add(product);
        } else {
            productList.add(product);
        }
        productBasket.put(product.getName(), productList);
    }

    public double getPriceBasket() {
        double price = 0;
        List<Product> productList;
        for (Map.Entry<String, List<Product>> element : productBasket.entrySet()) {
            productList = element.getValue();
            for (Product product : productList) {
                if (productBasket != null) {
                    price += (double) product.getPrice();
                }
            }
        }
        return price;
    }

    public void printProductBasket() {
        double price = 0;
        int countSpecial = 0;
        List<Product> productList;
        for (Map.Entry<String, List<Product>> element : productBasket.entrySet()) {
            System.out.println("Ключ: " + element.getKey());
            productList = element.getValue();
            System.out.println("Значение: ");
            for (Product product : productList) {
                if (product != null) {
                    System.out.println(product);
                    price += (double) product.getPrice();
                    if (product.isSpecial()) {
                        countSpecial++;
                    }
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
        for (Map.Entry<String, List<Product>> element : productBasket.entrySet()) {
            if (element.getKey().equals(product.getName())) {
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
        for (Map.Entry<String, List<Product>> element : productBasket.entrySet()) {
            if (element.getKey().contains(findNameProduct)) {
                Iterator iterator = element.getValue().iterator();
                while (iterator.hasNext()) {
                    deleteList.add((Product) iterator.next());
                }
            }
        }

        for (Product pr : deleteList) {
            productBasket.remove(pr.getName());
        }
        return deleteList;
    }
}