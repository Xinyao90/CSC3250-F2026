package labs.lab09;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class ShoppingCart {
    private final List<CartItem> items = new ArrayList<>();
    public void addProduct(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }
    public double getSubtotal() {
        double subtotal = 0.0;
        for (CartItem item : items) subtotal += item.getLineTotal();
        return subtotal;
    }
    /** New Week 5 read-only view for checkout processing (not a deep copy). */
    public List<CartItem> getItems() { return Collections.unmodifiableList(items); }
}
