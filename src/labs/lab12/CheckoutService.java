package labs.lab12;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
public class CheckoutService {
    private final ReceiptPrinter printer;
    public CheckoutService(ReceiptPrinter printer) {
        this.printer = Objects.requireNonNull(printer, "printer");
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
        printer.print(renderReceipt(cart));
    }
}
