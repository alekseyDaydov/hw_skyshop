package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        Product sausage = new SimpleProduct("Колбаса", 20);
        Product bread = new SimpleProduct("Хлеб", 6);
        Product meat = new SimpleProduct("Мясо", 70);
        Product beer = new SimpleProduct("Пиво", 30);
        Product tomatoes = new SimpleProduct("Помидоры", 12);
        Product potato = new SimpleProduct("Картофель", 45);

        System.out.println("Добавление продукта в корзину");
        System.out.println("vasyBasket");
        ProductBasket vasyBasket = new ProductBasket();
        vasyBasket.addProduct(sausage);
        vasyBasket.addProduct(bread);
        vasyBasket.addProduct(meat);

        System.out.println("Печать содержимого корзины с несколькими товарами");
        vasyBasket.printProductBasket();

        System.out.println("Добавление продукта в заполненную корзину, в которой нет свободного места");
        System.out.println("petyBasket");
        ProductBasket petyBasket = new ProductBasket();
        petyBasket.addProduct(sausage);
        petyBasket.addProduct(beer);
        petyBasket.addProduct(tomatoes);
        petyBasket.addProduct(potato);
        petyBasket.addProduct(sausage);
        petyBasket.addProduct(potato);
        System.out.println("Печать содержимого корзины с несколькими товарами");
        petyBasket.printProductBasket();

        System.out.println("Получение стоимости корзины с несколькими товарами");
        System.out.println(petyBasket.getAmountBasket());
        System.out.println(vasyBasket.getAmountBasket());

        System.out.println("Поиск товара, который есть в корзине");
        System.out.println(petyBasket.isCheckProductBasket(potato));

        System.out.println("Поиск товара, который нет в корзине");
        System.out.println(vasyBasket.isCheckProductBasket(potato));

        System.out.println("Очистка корзины");
        vasyBasket.clearBasket();
        vasyBasket.printProductBasket();

        System.out.println("Получение стоимости пустой корзины");
        System.out.println(vasyBasket.getAmountBasket());

        System.out.println("Поиск товара по имени в пустой корзине");
        System.out.println(vasyBasket.isCheckProductBasket(sausage));
    }
}