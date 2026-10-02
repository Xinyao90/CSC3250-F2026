package labs.lab10;
/** Week 4 abstract baseline, with the Week 5 behavioral contract made explicit.
 * A valid Product has nonblank identity/name and a finite nonnegative price.
 * deliveryInstructions() must normally return useful, non-null, nonblank text
 * immediately after valid construction, with no subtype-specific setup.
 * The query must not change the product's ID, name, or price.
 */
public abstract class Product {
    private final String id;
    private final String name;
    private final double price;
    protected Product(String id, String name, double price) {
        if (id == null || id.isBlank() || name == null || name.isBlank())
            throw new IllegalArgumentException("ID and name required");
        if (!Double.isFinite(price) || price < 0)
            throw new IllegalArgumentException("Invalid price");
        this.id = id; this.name = name; this.price = price;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    protected String label() { return id + ": " + name; }
    public String description() { return label(); }
    public abstract String deliveryInstructions();
}
