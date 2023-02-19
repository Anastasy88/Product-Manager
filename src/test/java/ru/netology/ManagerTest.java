package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    @Test
    public void testAddBook() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Галлант", 700, "Виктория Шваб");
        Book book2 = new Book(2, "Бюро слухов", 900, " Дженни Оффилл");
        Book book3 = new Book(3, "Стрижи", 600, "Фернандо Арамбуру");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenOneProductIsFoundBook() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Галлант", 700, "Виктория Шваб");
        Book book2 = new Book(2, "Бюро слухов", 900, " Дженни Оффилл");
        Book book3 = new Book(3, "Стрижи", 600, "Фернандо Арамбуру");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Бюро");
        Product[] expected = {book2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenMultipleProductsAreFoundBook() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Галлант", 700, "Виктория Шваб");
        Book book2 = new Book(2, "Бюро слухов", 900, " Дженни Оффилл");
        Book book3 = new Book(3, "Стрижи", 600, "Фернандо Арамбуру");
        Book book4 = new Book(4, "Стрижи улетают на юг", 800, "Фернандо Арамбуру");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] actual = manager.searchBy("Стрижи");
        Product[] expected = {book3, book4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenBook() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Галлант", 700, "Виктория Шваб");
        Book book2 = new Book(2, "Бюро слухов", 900, " Дженни Оффилл");
        Book book3 = new Book(3, "Стрижи", 600, "Фернандо Арамбуру");
        Book book4 = new Book(4, "Стрижи улетают на юг", 800, "Фернандо Арамбуру");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] actual = manager.searchBy("Осень");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddSmartphone() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Smartphone smartphone1 = new Smartphone(5, "iPhone", 150_000, "Apple");
        Smartphone smartphone2 = new Smartphone(6, "Honor", 40_000, "Huawei");
        Smartphone smartphone3 = new Smartphone(7, "Realme", 23_000, "Oppo");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = repo.findAll();
        Product[] expected = {smartphone1, smartphone2, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenOneProductIsFoundSmartphone() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Smartphone smartphone1 = new Smartphone(5, "iPhone", 150_000, "Apple");
        Smartphone smartphone2 = new Smartphone(6, "Honor", 40_000, "Huawei");
        Smartphone smartphone3 = new Smartphone(7, "Realme", 23_000, "Oppo");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("Honor");
        Product[] expected = {smartphone2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenMultipleProductsAreFoundSmartphone() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Smartphone smartphone1 = new Smartphone(5, "iPhone", 150_000, "Apple");
        Smartphone smartphone2 = new Smartphone(6, "Honor", 40_000, "Huawei");
        Smartphone smartphone3 = new Smartphone(7, "Realme", 23_000, "Oppo");
        Smartphone smartphone4 = new Smartphone(5, "iPhone 14 PRO", 150_000, "Apple");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        Product[] actual = manager.searchBy("iPhone");
        Product[] expected = {smartphone1, smartphone4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenSmartphone() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Smartphone smartphone1 = new Smartphone(5, "iPhone", 150_000, "Apple");
        Smartphone smartphone2 = new Smartphone(6, "Honor", 40_000, "Huawei");
        Smartphone smartphone3 = new Smartphone(7, "Realme", 23_000, "Oppo");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}