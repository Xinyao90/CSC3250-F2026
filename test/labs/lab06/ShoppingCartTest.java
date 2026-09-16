package labs.lab06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    @Test
    public void testProductStoresData() {

        Product product =
                new Product(
                        "P1",
                        "Keyboard",
                        40.00
                );

        assertEquals(
                "P1",
                product.getId()
        );

        assertEquals(
                "Keyboard",
                product.getName()
        );

        assertEquals(
                40.00,
                product.getPrice(),
                0.001
        );
    }


    @Test
    public void testCatalogAddsAndFindsProduct() {

        Product keyboard =
                new Product(
                        "P1",
                        "Keyboard",
                        40.00
                );

        Catalog catalog =
                new Catalog();

        catalog.addProduct(keyboard);

        Product result =
                catalog.findProduct("P1");

        assertSame(
                keyboard,
                result
        );
    }


    @Test
    public void testCatalogReturnsNullWhenNotFound() {

        Catalog catalog =
                new Catalog();

        Product result =
                catalog.findProduct("UNKNOWN");

        assertNull(result);
    }


    @Test
    public void testCartItemLineTotal() {

        Product keyboard =
                new Product(
                        "P1",
                        "Keyboard",
                        40.00
                );

        CartItem item =
                new CartItem(
                        keyboard,
                        2
                );

        assertEquals(
                80.00,
                item.getLineTotal(),
                0.001
        );
    }


    @Test
    public void testShoppingCartSubtotal() {

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

        ShoppingCart cart =
                new ShoppingCart();

        cart.addProduct(
                keyboard,
                2
        );

        cart.addProduct(
                mouse,
                1
        );

        assertEquals(
                100.00,
                cart.getSubtotal(),
                0.001
        );
    }


    @Test
    public void testEmptyCartSubtotal() {

        ShoppingCart cart =
                new ShoppingCart();

        assertEquals(
                0.0,
                cart.getSubtotal(),
                0.001
        );
    }


    @Test
    public void testCheckoutService() {

        Product keyboard =
                new Product(
                        "P1",
                        "Keyboard",
                        40.00
                );

        ShoppingCart cart =
                new ShoppingCart();

        cart.addProduct(
                keyboard,
                2
        );

        CheckoutService service =
                new CheckoutService();

        assertEquals(
                80.00,
                service.checkout(cart),
                0.001
        );
    }


    @Test
    public void testInvalidQuantity() {

        Product keyboard =
                new Product(
                        "P1",
                        "Keyboard",
                        40.00
                );

        ShoppingCart cart =
                new ShoppingCart();

        assertThrows(
                IllegalArgumentException.class,
                () -> cart.addProduct(
                        keyboard,
                        0
                )
        );
    }
}