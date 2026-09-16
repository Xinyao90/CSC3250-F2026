package labs.lab06;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<CartItem> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }


    public void addProduct(Product product, int quantity) {

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

        // TODO 4:
        // Create a new CartItem using:
        //
        // product
        // quantity
        //
        // Then add the CartItem to items.
        //
        // Question:
        // Why does ShoppingCart create CartItem?
    }


    public double getSubtotal() {

        double subtotal = 0.0;

        // TODO 5:
        // Loop through all CartItems.
        //
        // Ask each CartItem for its line total.
        //
        // Add each line total to subtotal.

        return subtotal;
    }


    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}