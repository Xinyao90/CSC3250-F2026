package labs.lab11;
/** A narrow output role required by checkout; it does not compute prices.
 * Contract for these classroom implementations: print accepts a nonnull receipt,
 * delivers its exact text once to the implementation's destination, and returns
 * normally in the normal operating environment. It may append a display newline.
 * A null receipt is rejected with NullPointerException.
 * No actual payment, network delivery, or physical printer is involved.
 */
public interface ReceiptPrinter {
    void print(String receipt);
}
