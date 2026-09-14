package homework.hw01.inventory.model;

/**
 * Represents a product sold or stored by the warehouse.
 *
 * A Product refers to a Supplier. The Supplier can exist independently
 * of this Product, so this relationship is used as the aggregation /
 * association example in HW1.
 */
public class Product {

    private String productId;
    private String name;
    private double price;
    private Supplier supplier;

    /**
     * TODO 1: Initialize all fields.
     */
    public Product(String productId, String name, double price, Supplier supplier) {
        // TODO: initialize productId, name, price, and supplier.
    }

    /**
     * TODO 2: Return the product ID.
     */
    public String getProductId() {
        return null; // TODO
    }

    /**
     * TODO 3: Return the product name.
     */
    public String getName() {
        return null; // TODO
    }

    /**
     * TODO 4: Return the product price.
     */
    public double getPrice() {
        return 0.0; // TODO
    }

    /**
     * TODO 5: Return the Supplier object associated with this product.
     */
    public Supplier getSupplier() {
        return null; // TODO
    }
}
