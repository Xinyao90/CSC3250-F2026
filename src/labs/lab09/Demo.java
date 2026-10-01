package labs.lab09;
import java.util.Locale;
public class Demo {
    public static void main(String[] args) {
        Product notebook = new PhysicalProduct("P100", "Notebook", 20.0);
        Product guide = new DigitalProduct("D200", "Java Guide", 15.0, "guide.pdf");
        Catalog catalog = new Catalog();
        ShoppingCart cart = new ShoppingCart();
        catalog.addProduct(notebook); catalog.addProduct(guide);
        cart.addProduct(notebook, 2); cart.addProduct(guide, 3);
        System.out.printf(Locale.US, "Before workshop: %.2f%n", cart.getSubtotal());
        Product workshop = new WorkshopProduct("W300", "Java Workshop", 30.0, "Room A");
        catalog.addProduct(workshop); cart.addProduct(workshop, 1);
        CheckoutService service = new CheckoutService();
        System.out.println("CATALOG");
        for (Product product : catalog.getProducts())
            System.out.println(service.deliveryLine(product));
        System.out.println("CHECKOUT");
        for (String line : service.deliveryLines(cart)) System.out.println(line);
        System.out.printf(Locale.US, "Subtotal: %.2f%n", cart.getSubtotal());
    }
}
