package labs.lab06;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private List<Product> products;

    public Catalog() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {

        if (product == null) {
            throw new IllegalArgumentException(
                    "Product cannot be null."
            );
        }

        // TODO 1:
        // Add the existing Product object
        // to the catalog.
    }


    public Product findProduct(String id) {

        // TODO 2:
        // Loop through the products.
        //
        // If a product has the matching id,
        // return that Product object.
        //
        // If no matching product is found,
        // return null.

        return null;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
}