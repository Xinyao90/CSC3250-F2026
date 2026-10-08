package labs.lab11;
import java.util.List;
/** The same three sample products and cart quantities used in Lectures 9 and 10. */
public final class SampleStore {
    private SampleStore() { }
    public static List<Product> products() {
        return List.of(new PhysicalProduct("P100", "Notebook", 20.0),
            new DigitalProduct("D200", "Java Guide", 15.0, "guide.pdf"),
            new WorkshopProduct("W300", "Java Workshop", 30.0, "Room A"));
    }
    public static ShoppingCart mixedCart() {
        List<Product> products = products();
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(products.get(0), 2);
        cart.addProduct(products.get(1), 3);
        cart.addProduct(products.get(2), 1);
        return cart;
    }
}
