package labs.lab07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    void physicalProductInheritsProductData() {

        Product product =
                new PhysicalProduct(
                        "P100",
                        "Notebook",
                        20.00
                );

        assertEquals("P100", product.getId());
        assertEquals("Notebook", product.getName());
        assertEquals(20.00, product.getPrice(), 0.001);
    }

    @Test
    void digitalProductInheritsProductData() {

        Product product =
                new DigitalProduct(
                        "D200",
                        "Java Guide",
                        15.00,
                        "guide.pdf"
                );

        assertEquals("D200", product.getId());
        assertEquals("Java Guide", product.getName());
        assertEquals(15.00, product.getPrice(), 0.001);
    }

    @Test
    void physicalProductOverridesDeliveryInstructions() {

        Product product =
                new PhysicalProduct(
                        "P100",
                        "Notebook",
                        20.00
                );

        assertEquals(
                "Ship to address",
                product.deliveryInstructions()
        );
    }

    @Test
    void digitalProductOverridesDeliveryInstructions() {

        Product product =
                new DigitalProduct(
                        "D200",
                        "Java Guide",
                        15.00,
                        "guide.pdf"
                );

        assertEquals(
                "Download guide.pdf",
                product.deliveryInstructions()
        );
    }

    @Test
    void physicalDescriptionReusesProductDescription() {

        Product product =
                new PhysicalProduct(
                        "P100",
                        "Notebook",
                        20.00
                );

        assertEquals(
                "P100: Notebook [physical]",
                product.description()
        );
    }

    @Test
    void digitalDescriptionReusesProductDescription() {

        Product product =
                new DigitalProduct(
                        "D200",
                        "Java Guide",
                        15.00,
                        "guide.pdf"
                );

        assertEquals(
                "D200: Java Guide [digital]",
                product.description()
        );
    }

    @Test
    void physicalProductWorksInsideCartItem() {

        Product notebook =
                new PhysicalProduct(
                        "P100",
                        "Notebook",
                        20.00
                );

        CartItem item =
                new CartItem(notebook, 2);

        assertEquals(
                40.00,
                item.getLineTotal(),
                0.001
        );
    }

    @Test
    void digitalProductWorksInsideCartItem() {

        Product guide =
                new DigitalProduct(
                        "D200",
                        "Java Guide",
                        15.00,
                        "guide.pdf"
                );

        CartItem item =
                new CartItem(guide, 3);

        assertEquals(
                45.00,
                item.getLineTotal(),
                0.001
        );
    }

    @Test
    void blankProductNameIsRejected() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new PhysicalProduct(
                        "P100",
                        "   ",
                        20.00
                )
        );
    }

    @Test
    void negativePriceIsRejected() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new PhysicalProduct(
                        "P100",
                        "Notebook",
                        -1.00
                )
        );
    }

    @Test
    void blankDownloadFileIsRejected() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new DigitalProduct(
                        "D200",
                        "Java Guide",
                        15.00,
                        "   "
                )
        );
    }
}
