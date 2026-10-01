package labs.lab09;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class CheckoutService {
    public String deliveryLine(Product product) {
        Objects.requireNonNull(product, "product");
        // TODO 4: Return name + " -> " + the product's deliveryInstructions().
        // Use only Product's API. Do not inspect the concrete subtype.
        return "";
    }
    public List<String> deliveryLines(ShoppingCart cart) {
        Objects.requireNonNull(cart, "cart");
        List<String> lines = new ArrayList<>();
        // TODO 5: For each CartItem in cart.getItems(), obtain its Product
        // and add deliveryLine(product) to lines. One line per CartItem.
        return lines;
    }
}
