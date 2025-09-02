package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        return productBasket.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printProductBasket() {
        if (productBasket.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        productBasket.forEach((key, list) -> {
            System.out.println("key: " + key + " value: " + list);
        });

        System.out.println("Итого: <" + getPriceBasket() + ">");
        System.out.println("Специальных товаров: <" + getSpecialCount() + ">");

    }

    private long getSpecialCount() {
        return productBasket.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();

    }

    public boolean isCheckProductBasket(Product product) {
        return productBasket.values().stream()
                .flatMap(Collection::stream)
                .map(Product::getName)
                .anyMatch(name -> name.equals(product.getName()));
    }

    public void clearBasket() {
        productBasket.clear();
    }

    public List<Product> deleteProductByName(String findNameProduct) {
        List<Product> deleteList;
        deleteList = productBasket.values().stream()
                .flatMap(List::stream)
                .filter(product -> product.getName().equals(findNameProduct))
                .collect(Collectors.toList());

        for (Product pr : deleteList) {
            productBasket.remove(pr.getName());
        }
        return deleteList;
    }
}