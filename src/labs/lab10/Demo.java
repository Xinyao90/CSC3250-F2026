package labs.lab10;
import labs.lab10.candidates.CandidateDigitalProduct;
import labs.lab10.candidates.CandidateWorkshopProduct;
import java.util.Locale;
public class Demo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new PhysicalProduct("P100", "Notebook", 20.0), 2);
        cart.addProduct(new CandidateDigitalProduct("D200", "Java Guide", 15.0, "guide.pdf"), 3);
        cart.addProduct(new CandidateWorkshopProduct("W300", "Java Workshop", 30.0, "Room A"), 1);
        for (String line : new CheckoutService().deliveryLines(cart)) System.out.println(line);
        System.out.printf(Locale.US, "Subtotal: %.2f%n", cart.getSubtotal());
    }
}
