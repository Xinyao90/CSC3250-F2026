package labs.lab11;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class ShoppingCart {
    private final List<CartItem> items = new ArrayList<>();
    public void addProduct(Product product, int quantity) { items.add(new CartItem(product, quantity)); }
    /** A live unmodifiable view, not a snapshot and not a deep copy. */
    public List<CartItem> getItems() { return Collections.unmodifiableList(items); }
    public double getSubtotal() {
        double subtotal = 0.0;
        for (CartItem item : items) { subtotal += item.getLineTotal(); }
        return subtotal;
    }
}
