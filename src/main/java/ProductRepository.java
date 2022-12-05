public class ProductRepository {
    private Product[] products = new Product[0];

    public Product[] findAll() {
        return products;
    }


    public void saveProduct(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] findById(int id) {
        Product[] tmp = new Product[1];

        for (Product product : products) {
            if (product.getId() == id) {
                tmp[0] = product;
                return tmp;
            }
        }
        return null;
    }

    public Product[] removeById(int id) {
        if (findById(id) == null) {
            return new Product[0];
        }

        Product[] tmp = new Product[products.length - 1];
        int index = 0;

        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
        return products;
    }

}
