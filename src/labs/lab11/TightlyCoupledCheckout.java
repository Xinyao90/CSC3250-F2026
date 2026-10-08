package labs.lab11;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
/** NEW Lecture 11 before-refactoring example. It is not the old Lecture 10 client.
 * Read-only comparison: correct text, but a fixed console destination.
 */
public class TightlyCoupledCheckout {
    private final ConsoleReceiptPrinter printer = new ConsoleReceiptPrinter();
    public void printReceipt(ShoppingCart cart) {
        Objects.requireNonNull(cart, "cart");
        List<String> lines = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();
            lines.add(p.getName() + " -> " + p.deliveryInstructions());
        }
        lines.add(String.format(Locale.ROOT, "Subtotal: %.2f", cart.getSubtotal()));
        printer.print(String.join("\n", lines));
    }
    public static void main(String[] args) {
        new TightlyCoupledCheckout().printReceipt(SampleStore.mixedCart());
    }
}
