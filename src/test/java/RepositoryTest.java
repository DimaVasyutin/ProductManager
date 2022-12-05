import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    Product product = new Product(1, "Вещь", 1000);
    Book book = new Book(2, "Книга", 2000, "Автор");
    Smartphone smartphone = new Smartphone(3, "Смартфон", 10_000, "Samsung");

    @Test
    public void testAddAndFindAllProduct() {
        ProductRepository repo = new ProductRepository();

        repo.saveProduct(product);
        repo.saveProduct(book);
        repo.saveProduct(smartphone);

        Product[] expected = {product, book, smartphone};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemovedById() {
        ProductRepository repo = new ProductRepository();

        repo.saveProduct(product);
        repo.saveProduct(book);
        repo.saveProduct(smartphone);
        repo.removeById(2);

        Product[] expected = {product, smartphone};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testRemovedByNoId() {
        ProductRepository repo = new ProductRepository();

        repo.saveProduct(product);
        repo.saveProduct(book);
        repo.saveProduct(smartphone);
        repo.removeById(4);

        Product[] expected = {product, book, smartphone};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetPrice() {

        int expected = 1000;
        int actual = product.getPrice();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetName() {

        String expected = "Вещь";
        String actual = product.getName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetAuthor() {

        String expected = "Автор";
        String actual = book.getAuthor();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetManufacturer() {

        String expected = "Samsung";
        String actual = smartphone.getManufacturer();

        Assertions.assertEquals(expected, actual);
    }


}
