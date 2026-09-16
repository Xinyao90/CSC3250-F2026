package labs.lab06;

public class Product {

    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException(
                    "Product id cannot be empty."
            );
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Product name cannot be empty."
            );
        }

        if (price < 0) {
            throw new IllegalArgumentException(
                    "Price cannot be negative."
            );
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
}