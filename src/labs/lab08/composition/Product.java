package labs.lab08.composition;

import java.util.Objects;

public class Product {
    private final String id;
    private final String name;
    private final double price;
    private final DeliveryMethod deliveryMethod;

    public Product(String id, String name, double price, DeliveryMethod deliveryMethod) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Product id cannot be blank.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be blank.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }

        this.id = id;
        this.name = name;
        this.price = price;
        this.deliveryMethod = Objects.requireNonNull(deliveryMethod, "deliveryMethod");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String deliveryInstructions() {
        // TODO 4:
        // Do NOT use instanceof or a switch on delivery type.
        // Delegate this request to deliveryMethod.
        return "";
    }
}
