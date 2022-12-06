import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    ProductRepository repo = new ProductRepository();
    Manager manager = new Manager(repo);

    Product product = new Product(1, "Вещь", 1000);
    Book book = new Book(2, "Книга", 2000, "Автор");
    Smartphone smartphone = new Smartphone(3, "Смартфон", 10_000, "Samsung");
    Smartphone smartphone2 = new Smartphone(4, "Смартфон", 11_000, "Samsung");

    @BeforeEach
    public void setUd() {
        manager.saveProduct(product);
        manager.saveProduct(book);
        manager.saveProduct(smartphone);
    }

    @Test
    public void testSearchBy() {

        Product[] expected = {smartphone};
        Product[] actual = manager.searchBy("Смартфон");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchBTwoSameProduct() {
        manager.saveProduct(smartphone2);

        Product[] expected = {smartphone, smartphone2};
        Product[] actual = manager.searchBy("Смартфон");
<<<<<<< HEAD

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByBook() {

        Product[] expected = {book};
        Product[] actual = manager.searchBy("Книга");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByFaild() {

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("5454");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByAuothor() {

        Product[] expected = {book};
        Product[] actual = manager.searchBy("Автор");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByManufacturer() {

        Product[] expected = {smartphone};
        Product[] actual = manager.searchBy("Samsung");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testRemoveById() {

        Product[] expected = {product, smartphone};
        Product[] actual = manager.removeById(2);
=======
>>>>>>> 5336ad8d90d1c729b1d7560f65305a6b2d6acace

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
<<<<<<< HEAD
=======
    public void testSearchByFaild() {

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("5454");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveById() {

        Product[] expected = {product, smartphone};
        Product[] actual = manager.removeById(2);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
>>>>>>> 5336ad8d90d1c729b1d7560f65305a6b2d6acace
    public void testRemoveByIdFail() {

        manager.removeById(4);

<<<<<<< HEAD
        Product[] expected = manager.findAll();
        Product[] actual = {product, book, smartphone};
=======
        Product[] expected = {product, book, smartphone};
        Product[] actual = manager.findAll();
>>>>>>> 5336ad8d90d1c729b1d7560f65305a6b2d6acace

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testFindById() {


        Product[] expected = {book};
        Product[] actual = manager.findById(2);

        Assertions.assertArrayEquals(expected, actual);
    }


}
