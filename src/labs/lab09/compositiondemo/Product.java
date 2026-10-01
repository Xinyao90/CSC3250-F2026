package labs.lab09.compositiondemo;
import java.util.Objects;
/** Alternative Product from Lecture 8, not the abstract main-lab Product. */
public class Product {
    private final String id, name;
    private final double price;
    private final DeliveryMethod deliveryMethod;
    public Product(String id, String name, double price, DeliveryMethod deliveryMethod) {
        if (id == null || id.isBlank() || name == null || name.isBlank())
            throw new IllegalArgumentException("ID and name required");
        if (!Double.isFinite(price) || price < 0) throw new IllegalArgumentException("Invalid price");
        this.id = id; this.name = name; this.price = price;
        this.deliveryMethod = Objects.requireNonNull(deliveryMethod, "deliveryMethod");
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String deliveryInstructions() { return deliveryMethod.instructions(); }
}
