package labs.lab07;

public class CartItem {

    private final Product product;
    private final int quantity;

    public CartItem(Product product, int quantity) {

        if (product == null) {
            throw new IllegalArgumentException(
                    "Product is required"
            );
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be positive"
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

    /*
     * DO NOT MODIFY THIS METHOD.
     *
     * CartItem works with Product.
     * It should not care whether the product
     * is physical or digital.
     */
    public double getLineTotal() {
        return product.getPrice() * quantity;
    }
}
