package homework.hw02;

/**
 * Shared product identity and ORIGINAL price; not a complete pricing behavior.
 * This is a separate, simplified HW2 model, not your HW1 Product class.
 * Supplier and warehouse operations are intentionally outside HW2.
 * Supplied file: do not edit.
 */
public abstract class Product implements Priceable {
    private final String productId;
    private final String name;
    private final double price;

    protected Product(String productId, String name, double price) {
        if (productId == null || productId.trim().isEmpty()) {
            throw new IllegalArgumentException("Product ID must not be blank.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name must not be blank.");
        }
        if (!Double.isFinite(price) || price < 0.0) {
            throw new IllegalArgumentException("Price must be finite and nonnegative.");
        }
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public final String getProductId() { return productId; }
    public final String getName() { return name; }

    /** Returns the original stored price, NOT a discounted purchase price. */
    public final double getPrice() { return price; }

    /** Each concrete subtype supplies its purchase-price calculation. */
    @Override
    public abstract double getPurchasePrice();
}
