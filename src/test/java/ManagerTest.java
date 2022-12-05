import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    ProductRepository repo = new ProductRepository();
    Manager manager = new Manager(repo);

    Product product = new Product(1, "Вещь", 1000);
    Book book = new Book(2, "Книга", 2000, "Автор");
    Smartphone smartphone = new Smartphone(3, "Смартфон", 10_000, "Samsung");

    @BeforeEach
    public void setUd() {
        manager.saveProduct(product);
        manager.saveProduct(book);
        manager.saveProduct(smartphone);
    }

    @Test
    public void testSearchBy() {

        Product[] expected = manager.searchBy("Смартфон");
        Product[] actual = {smartphone};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByBook() {

        Product[] expected = manager.searchBy("Книга");
        Product[] actual = {book};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByFaild() {

        Product[] expected = manager.searchBy("5454");
        Product[] actual = new Product[1];

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByAuothor() {

        Product[] expected = manager.searchBy("Автор");
        Product[] actual = {book};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByManufacturer() {

        Product[] expected = manager.searchBy("Samsung");
        Product[] actual = {smartphone};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testRemoveById() {

        Product[] expected = manager.removeById(2);
        Product[] actual = {product, smartphone};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveByIdFail() {

        manager.removeById(4);

        Product[] expected = {product, book, smartphone};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testFindById() {


        Product[] expected = {book};
        Product[] actual = manager.findById(2);

        Assertions.assertArrayEquals(expected, actual);
    }


}
