package labs.lab06;

public class ShoppingCartDemo {

    public static void main(String[] args) {

        // Create products

        Product keyboard =
                new Product(
                        "P1",
                        "Keyboard",
                        40.00
                );

        Product mouse =
                new Product(
                        "P2",
                        "Mouse",
                        20.00
                );


        // -------------------------
        // Catalog
        // -------------------------

        Catalog catalog =
                new Catalog();

        catalog.addProduct(keyboard);
        catalog.addProduct(mouse);

        Product found =
                catalog.findProduct("P1");

        System.out.println(
                "Found: " + found.getName()
        );


        // -------------------------
        // Shopping Cart
        // -------------------------

        ShoppingCart cart =
                new ShoppingCart();

        cart.addProduct(keyboard, 2);
        cart.addProduct(mouse, 1);


        // -------------------------
        // Display Cart
        // -------------------------

        for (CartItem item : cart.getItems()) {

            System.out.println(
                    item.getProduct().getName()
                    + " x "
                    + item.getQuantity()
                    + " = $"
                    + item.getLineTotal()
            );
        }


        // -------------------------
        // Subtotal
        // -------------------------

        System.out.println(
                "Subtotal: $"
                + cart.getSubtotal()
        );


        // -------------------------
        // Checkout
        // -------------------------

        CheckoutService service =
                new CheckoutService();

        System.out.println(
                "Checkout total: $"
                + service.checkout(cart)
        );
    }
}