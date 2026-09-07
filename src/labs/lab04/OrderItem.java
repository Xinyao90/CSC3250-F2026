package labs.lab04;

public class OrderItem {
    private final String name;
    private final double unitPrice;
    private final int quantity;

    public OrderItem(String name, double unitPrice, int quantity) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Item name cannot be blank."
            );
        }

        if (unitPrice < 0) {
            throw new IllegalArgumentException(
                    "Unit price cannot be negative."
            );
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be greater than zero."
            );
        }

        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getLineTotal() {
        // TODO 1: Return unit price multiplied by quantity.
        return 0.0;
    }
}

