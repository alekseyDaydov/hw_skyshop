package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {
        Product sausage = new SimpleProduct("Колбаса", 20);
        Product bread = new SimpleProduct("Хлеб", 6);
        Product meat = new FixPriceProduct("Мясо");
        Product beer = new FixPriceProduct("Пиво");
        Product tomatoes = new DiscountedProduct("Помидоры", 12, 50);
        Product potato = new DiscountedProduct("Картофель", 45, 10);
        Product vegetableFirst = new DiscountedProduct("овощь", 45, 10);
        Product vegetableSecond = new DiscountedProduct("овощь", 45, 10);

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
        System.out.println(petyBasket.getPriceBasket());
        System.out.println(vasyBasket.getPriceBasket());

        System.out.println("Поиск товара, который есть в корзине");
        System.out.println(petyBasket.isCheckProductBasket(potato));

        System.out.println("Поиск товара, который нет в корзине");
        System.out.println(vasyBasket.isCheckProductBasket(potato));

        System.out.println("Очистка корзины");
        vasyBasket.clearBasket();
        vasyBasket.printProductBasket();

        System.out.println("Получение стоимости пустой корзины");
        System.out.println(vasyBasket.getPriceBasket());

        System.out.println("Поиск товара по имени в пустой корзине");
        System.out.println(vasyBasket.isCheckProductBasket(sausage));


        SearchEngine searchEngine = new SearchEngine(15);
        Searchable tomatoesTheBest = new Article("Томаты", "Помидоры лучшие овощи");
        Article potatoTheBest = new Article("Картофель", "Картофель хороший овощь");
        Article beerArticle = new Article("Пиво", "Напиток, но не овощь");
        Article earth = new Article("Земля", "На планете Земля растут овощи");

        System.out.println("Вывод поискового массива");
        searchEngine.add(beer);
        searchEngine.add(tomatoes);
        searchEngine.add(potato);
        searchEngine.add(tomatoesTheBest);
        searchEngine.add(potatoTheBest);
        searchEngine.add(beerArticle);
        searchEngine.add(earth);
        searchEngine.add(vegetableFirst);
        searchEngine.add(vegetableSecond);

        Searchable[] searchPotato = searchEngine.search("овощ");
        System.out.println("Результат поиска potato");
        for (Searchable searchable : searchPotato) {
            if (searchable != null) {
                System.out.println(searchable.getStringRepresentation());
            }
        }
        try {
            Product sausageError = new SimpleProduct("Колбаса", -8);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getStackTrace());
        }

        try {
            Product breadError = new SimpleProduct("null", 6);
        } catch (IllegalArgumentException e) {
            System.out.println(e.fillInStackTrace());
        }

        try {
            Product vegetableError = new DiscountedProduct("овощь", 0, 100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
//        Product vegetableError = new DiscountedProduct("овощь", 1, 100);
    }
}