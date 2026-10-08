package labs.lab11;
import java.util.Objects;
public class CartItem {
    private final Product product;
    private final int quantity;
    public CartItem(Product product, int quantity) {
        this.product = Objects.requireNonNull(product, "product");
        if (quantity <= 0) { throw new IllegalArgumentException("Quantity must be positive"); }
        this.quantity = quantity;
    }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getLineTotal() { return product.getPrice() * quantity; }
}
