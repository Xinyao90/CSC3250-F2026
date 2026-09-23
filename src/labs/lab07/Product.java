package labs.lab07;

public class Product {

    private final String id;
    private final String name;
    private final double price;

    public Product(String id, String name, double price) {

        // System.out.println("1. Product constructor starts");

        if (id == null || id.isBlank() ||
                name == null || name.isBlank()) {

            throw new IllegalArgumentException(
                    "ID and name required");
        }

        if (!Double.isFinite(price) || price < 0) {

            throw new IllegalArgumentException(
                    "Invalid price");
        }

        this.id = id;
        this.name = name;
        this.price = price;

        //System.out.println("2. Product constructor ends");
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

    /*
     * Subclasses may reuse this helper,
     * but clients should not call it directly.
     */
    protected String label() {
        return id + ": " + name;
    }

    public String description() {
        return label();
    }

    /*
     * Subclasses will override this method.
     */
    public String deliveryInstructions() {
        return "Delivery not specified";
    }
}
