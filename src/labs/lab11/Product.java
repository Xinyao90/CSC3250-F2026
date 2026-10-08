package labs.lab11;
/** Course baseline: identity, price, and delivery contract from Lectures 7-10. */
public abstract class Product {
    private final String id;
    private final String name;
    private final double price;
    protected Product(String id, String name, double price) {
        if (id == null || id.isBlank() || name == null || name.isBlank()) {
            throw new IllegalArgumentException("ID and name required");
        }
        if (!Double.isFinite(price) || price < 0) {
            throw new IllegalArgumentException("Invalid price");
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    protected String label() { return id + ": " + name; }
    public String description() { return label(); }
    /** Returns useful, nonnull, nonblank instructions without extra setup or state changes. */
    public abstract String deliveryInstructions();
}
