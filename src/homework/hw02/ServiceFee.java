package homework.hw02;

/**
 * A charge with a purchase price, but not a product in this model.
 * Supplied file: do not edit.
 */
public class ServiceFee implements Priceable {
    private final String description;
    private final double amount;

    public ServiceFee(String description, double amount) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description must not be blank.");
        }
        if (!Double.isFinite(amount) || amount < 0.0) {
            throw new IllegalArgumentException("Fee must be finite and nonnegative.");
        }
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() { return description; }

    @Override
    public double getPurchasePrice() { return amount; }
}
