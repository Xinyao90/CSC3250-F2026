package labs.lab12;
import java.util.Iterator;
import java.util.Locale;
public class Demo {
    public static void main(String[] args) {
        ItemCatalog<Product> catalog = new ItemCatalog<>();
        for (Product p : SampleStore.products()) { catalog.add(p); }
        CheckoutService service = new CheckoutService(new ConsoleReceiptPrinter());
        for (Product p : catalog) { System.out.println(service.deliveryLine(p)); }
        System.out.printf(Locale.ROOT, "Catalog unit-price sum: %.2f%n",
            CatalogReports.totalUnitPrice(catalog));
        System.out.printf(Locale.ROOT, "Cart subtotal (with quantities): %.2f%n",
            SampleStore.mixedCart().getSubtotal());
        ItemCatalog<String> labels = new ItemCatalog<>();
        labels.add("A");
        Iterator<String> old = labels.iterator();
        labels.add("B");
        System.out.print("Old snapshot:");
        while (old.hasNext()) { System.out.print(" " + old.next()); }
        System.out.print("\nNew traversal:");
        for (String label : labels) { System.out.print(" " + label); }
        System.out.println();
    }
}
