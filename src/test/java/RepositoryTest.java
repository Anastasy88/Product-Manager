import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

public class RepositoryTest {

    @Test
    public void testFindAll() {
        Repository repo = new Repository();

        Book book1 = new Book(1, "Галлант", 700, "Виктория Шваб");
        Book book2 = new Book(2, "Бюро слухов", 900, " Дженни Оффилл");
        Book book3 = new Book(3, "Стрижи", 600, "Фернандо Арамбуру");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenIdExistedBook() {
        Repository repo = new Repository();

        Book book1 = new Book(1, "Галлант", 700, "Виктория Шваб");
        Book book2 = new Book(2, "Бюро слухов", 900, " Дженни Оффилл");
        Book book3 = new Book(3, "Стрижи", 600, "Фернандо Арамбуру");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.removeById(3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindAllBoorSmartphone() {
        Repository repo = new Repository();

        Smartphone smartphone1 = new Smartphone(5, "iPhone", 150_000, "Apple");
        Smartphone smartphone2 = new Smartphone(6, "Honor", 40_000, "Huawei");
        Smartphone smartphone3 = new Smartphone(7, "Realme", 23_000, "Oppo");

        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);

        Product[] actual = repo.findAll();
        Product[] expected = {smartphone1, smartphone2, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenIdExistedSmartphone() {
        Repository repo = new Repository();

        Smartphone smartphone1 = new Smartphone(5, "iPhone", 150_000, "Apple");
        Smartphone smartphone2 = new Smartphone(6, "Honor", 40_000, "Huawei");
        Smartphone smartphone3 = new Smartphone(7, "Realme", 23_000, "Oppo");

        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);
        repo.removeById(7);

        Product[] actual = repo.findAll();
        Product[] expected = {smartphone1, smartphone2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenNotIdExistedSmartphone() {
        Repository repo = new Repository();

        Smartphone smartphone1 = new Smartphone(5, "iPhone", 150_000, "Apple");
        Smartphone smartphone2 = new Smartphone(6, "Honor", 40_000, "Huawei");
        Smartphone smartphone3 = new Smartphone(7, "Realme", 23_000, "Oppo");

        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);


        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(9)
        );
    }
}
