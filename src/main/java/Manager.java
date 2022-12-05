public class Manager {
    private ProductRepository repo;

    public Manager(ProductRepository repo) {
        this.repo = repo;
    }

    public void saveProduct(Product product) {
        repo.saveProduct(product);
    }

    public Product[] findById(int id) {
        Product[] tmp = repo.findById(id);
        return tmp;
    }

    public Product[] removeById(int id) {
        Product[] tmp = repo.removeById(id);
        return tmp;
    }

    public Product[] findAll() {
        Product[] tmp = repo.findAll();
        return tmp;
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[1]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repo.findAll()) {
            if (product.matches(text)) {
                result[0] = product;// "добавляем в конец" массива result продукт product
            }
        }
        return result;
    }
}

