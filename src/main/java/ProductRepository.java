public class ProductRepository {
    private Product[] products = new Product[0];

    public Product[] findAll() {
        return products;
    }


    public void saveProduct(Product product) {
        if (findById(product.getId()) != null){
            throw new AlreadyExistsException(
                    "Element with id " + product.getId() + " is already add"
            );
        }

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
            throw new NotFoundException(
                "Element with id: " + id + " not found"
            );
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
