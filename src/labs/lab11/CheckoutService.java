package labs.lab11;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
public class CheckoutService {
    // TODO 1: change this field to the ReceiptPrinter abstraction.
    // This deliberately coupled starter still chooses console internally.
    private final ConsoleReceiptPrinter printer;
    public CheckoutService(ReceiptPrinter printer) {
        // TODO 2: reject null and store the supplied reference, not a new console.
        this.printer = new ConsoleReceiptPrinter();
    }
    // Existing product processing responsibilities stay here.
    public String deliveryLine(Product product) {
        Objects.requireNonNull(product, "product");
        return product.getName() + " -> " + product.deliveryInstructions();
    }
    public List<String> deliveryLines(ShoppingCart cart) {
        Objects.requireNonNull(cart, "cart");
        List<String> lines = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            lines.add(deliveryLine(product));
        }
        return lines;
    }
    /** New receipt formatting; uses LF between lines and has no trailing LF.
     * Empty cart: exactly "Subtotal: 0.00". Double is kept for course continuity.
     */
    public String renderReceipt(ShoppingCart cart) {
        List<String> lines = deliveryLines(cart);
        lines.add(String.format(Locale.ROOT, "Subtotal: %.2f", cart.getSubtotal()));
        return String.join("\n", lines);
    }
    /** Send one complete receipt once; do not print inside the product loop. */
    public void printReceipt(ShoppingCart cart) {
        // TODO 3: render once and call the stored printer once with the complete text.
        throw new UnsupportedOperationException("TODO: printReceipt");
    }
}
