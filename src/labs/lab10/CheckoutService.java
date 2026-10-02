package labs.lab10;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/** Coordinates delivery output. Does not own product state or cart arithmetic. */
public class CheckoutService {
    /** Non-null Product; one meaningful instruction line for that product. */
    public String deliveryLine(Product product) {
        Objects.requireNonNull(product, "product");
        return product.getName() + " -> " + product.deliveryInstructions();
    }
    /** Non-null cart; one output line per CartItem, in cart order. */
    public List<String> deliveryLines(ShoppingCart cart) {
        Objects.requireNonNull(cart, "cart");
        List<String> lines = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            lines.add(deliveryLine(product));
        }
        return lines;
    }
}
