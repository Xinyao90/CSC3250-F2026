package labs.lab08.inheritance;

public abstract class Product {
    private final String id;
    private final String name;
    private final double price;

    public Product(String id, String name, double price) {
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

    public abstract String deliveryInstructions();
}
