package labs.lab09;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
public class Catalog {
    private final List<Product> products = new ArrayList<>();
    public void addProduct(Product product) {
        products.add(Objects.requireNonNull(product, "product"));
    }
    public Product findProduct(String id) {
        for (Product product : products)
            if (product.getId().equals(id)) return product;
        return null;
    }
    /** New Week 5 read-only view of the heterogeneous collection. */
    public List<Product> getProducts() { return Collections.unmodifiableList(products); }
}
