package labs.lab11;
public class Demo {
    public static void main(String[] args) {
        ShoppingCart cart = SampleStore.mixedCart();
        ReceiptPrinter console = new ConsoleReceiptPrinter();
        new CheckoutService(console).printReceipt(cart);
        RecordingReceiptPrinter record = new RecordingReceiptPrinter();
        new CheckoutService(record).printReceipt(cart);
        System.out.println("Recorded receipts: " + record.getReceipts().size());
    }
}
