package labs.lab11;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
/** PUBLIC grading tests: no hidden cases. Design reasoning is reviewed separately. */
class Lab11Test {
    private static final double EPS = 0.0001;
    private static final String EXPECTED = "Notebook -> Ship to address\n"
        + "Java Guide -> Download guide.pdf\n"
        + "Java Workshop -> Attend in Room A\nSubtotal: 115.00";
    private CheckoutService service() { return new CheckoutService(new RecordingReceiptPrinter()); }
    @Test void mixedDeliveryLinesStayUnchanged() {
        assertEquals(List.of("Notebook -> Ship to address", "Java Guide -> Download guide.pdf",
            "Java Workshop -> Attend in Room A"), service().deliveryLines(SampleStore.mixedCart()));
    }
    @Test void mixedSubtotalStays115() { assertEquals(115.0, SampleStore.mixedCart().getSubtotal(), EPS); }
    @Test void exactReceiptHasNoTrailingNewline() { assertEquals(EXPECTED, service().renderReceipt(SampleStore.mixedCart())); }
    @Test void emptyCartFormatsZeroSubtotal() { assertEquals("Subtotal: 0.00", service().renderReceipt(new ShoppingCart())); }
    @Test void requiredPrinterCannotBeNull() { assertThrows(NullPointerException.class, () -> new CheckoutService(null)); }
    @Test void nullCartIsRejected() { assertThrows(NullPointerException.class, () -> service().printReceipt(null)); }
    @Test void nullProductIsRejected() { assertThrows(NullPointerException.class, () -> service().deliveryLine(null)); }
    @Test void recordingPrinterKeepsExactText() {
        RecordingReceiptPrinter p = new RecordingReceiptPrinter(); p.print("First\nSecond");
        assertEquals(List.of("First\nSecond"), p.getReceipts());
    }
    @Test void recordingPrinterRejectsNull() {
        assertThrows(NullPointerException.class, () -> new RecordingReceiptPrinter().print(null));
    }
    @Test void recordingViewCannotBeCleared() {
        RecordingReceiptPrinter p = new RecordingReceiptPrinter(); p.print("One");
        assertThrows(UnsupportedOperationException.class, () -> p.getReceipts().clear());
    }
    @Test void printSendsOneWholeReceipt() {
        RecordingReceiptPrinter p = new RecordingReceiptPrinter();
        new CheckoutService(p).printReceipt(SampleStore.mixedCart());
        assertEquals(List.of(EXPECTED), p.getReceipts());
    }
    @Test void twoCallsSendTwoReceipts() {
        RecordingReceiptPrinter p = new RecordingReceiptPrinter(); CheckoutService s = new CheckoutService(p);
        s.printReceipt(SampleStore.mixedCart()); s.printReceipt(new ShoppingCart());
        assertEquals(List.of(EXPECTED, "Subtotal: 0.00"), p.getReceipts());
    }
    @Test void suppliedUnknownImplementationIsUsed() {
        CountingPrinter p = new CountingPrinter();
        new CheckoutService(p).printReceipt(SampleStore.mixedCart());
        assertEquals(1, p.calls); assertEquals(EXPECTED, p.last);
    }
    @Test void differentServicesDoNotShareDestinations() {
        RecordingReceiptPrinter a = new RecordingReceiptPrinter();
        RecordingReceiptPrinter b = new RecordingReceiptPrinter();
        new CheckoutService(a).printReceipt(SampleStore.mixedCart());
        new CheckoutService(b).printReceipt(new ShoppingCart());
        assertEquals(List.of(EXPECTED), a.getReceipts());
        assertEquals(List.of("Subtotal: 0.00"), b.getReceipts());
    }
    @Test void deliveryQueriesPreserveProductState() {
        for (Product p : SampleStore.products()) {
            String id = p.getId(), name = p.getName(); double price = p.getPrice();
            String instructions = assertDoesNotThrow(p::deliveryInstructions);
            assertNotNull(instructions); assertFalse(instructions.isBlank());
            assertEquals(id, p.getId()); assertEquals(name, p.getName()); assertEquals(price, p.getPrice(), EPS);
        }
    }
    @Test void cartStillProtectsItsItems() {
        ShoppingCart cart = SampleStore.mixedCart();
        assertThrows(UnsupportedOperationException.class, () -> cart.getItems().clear());
        assertEquals(115.0, cart.getSubtotal(), EPS);
    }
    private static class CountingPrinter implements ReceiptPrinter {
        int calls; String last;
        @Override public void print(String receipt) { calls++; last = receipt; }
    }
}
