package labs.lab11;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
/** Lecture 9 baseline. ItemCatalog<T> in Lab 12 is a separate new component. */
public class Catalog {
    private final List<Product> products = new ArrayList<>();
    public void addProduct(Product product) { products.add(Objects.requireNonNull(product, "product")); }
    public List<Product> getProducts() { return Collections.unmodifiableList(products); }
}
