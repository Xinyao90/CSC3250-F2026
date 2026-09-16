package labs.lab06;

public class CartItem {

    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {

        if (product == null) {
            throw new IllegalArgumentException(
                    "Product cannot be null."
            );
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be greater than zero."
            );
        }

        this.product = product;
        this.quantity = quantity;
    }


    public Product getProduct() {
        return product;
    }


    public int getQuantity() {
        return quantity;
    }


    public double getLineTotal() {

        // TODO 3:
        // Calculate:
        //
        // product price × quantity
        //
        // Hint:
        // Ask Product for its price.

        return 0.0;
    }
}