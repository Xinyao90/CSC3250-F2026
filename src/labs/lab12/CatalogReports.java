package labs.lab12;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public final class CatalogReports {
    private CatalogReports() { }
    /** Sum one unit price per element, not ShoppingCart's quantity-based subtotal.
     * Requires a nonnull iterable with nonnull Product elements. Empty sum is 0.0.
     * Uses the course's double arithmetic; no monetary rounding is performed.
     */
    public static <T extends Product> double totalUnitPrice(Iterable<T> products) {
        Objects.requireNonNull(products, "products");
        // TODO 4: add one getPrice() value per element, rejecting null elements.
        // Keep this generic method signature. Do not add cart quantities.
        throw new UnsupportedOperationException("TODO: totalUnitPrice");
    }
    /** A second, read-oriented signature: accepts Product elements or a subtype. */
    public static List<String> names(Iterable<? extends Product> products) {
        Objects.requireNonNull(products, "products");
        List<String> result = new ArrayList<>();
        for (Product p : products) { result.add(Objects.requireNonNull(p, "product").getName()); }
        return result;
    }
}
