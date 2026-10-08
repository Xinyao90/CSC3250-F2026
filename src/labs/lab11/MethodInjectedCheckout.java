package labs.lab11;
import java.util.Objects;
/** Optional alternative design: no persistent printer field. Not a required lab edit. */
public class MethodInjectedCheckout {
    public void printReceipt(ShoppingCart cart, ReceiptPrinter printer) {
        Objects.requireNonNull(printer, "printer");
        // Reuse the completed formatter for this alternative demonstration.
        CheckoutService formatter = new CheckoutService(printer);
        printer.print(formatter.renderReceipt(cart));
    }
}
