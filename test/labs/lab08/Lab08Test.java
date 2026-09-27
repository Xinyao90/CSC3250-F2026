package labs.lab08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Lab08Test {

    @Test
    void inheritanceAndCompositionProduceSameShippingMessage() {
        labs.lab08.inheritance.Product inheritanceProduct =
                new labs.lab08.inheritance.PhysicalProduct("P100", "Notebook", 20.0);

        labs.lab08.composition.Product compositionProduct =
                new labs.lab08.composition.Product(
                        "P100",
                        "Notebook",
                        20.0,
                        new labs.lab08.composition.ShippingDelivery()
                );

        assertEquals(inheritanceProduct.getId(), compositionProduct.getId());
        assertEquals(inheritanceProduct.getName(), compositionProduct.getName());
        assertEquals(inheritanceProduct.getPrice(), compositionProduct.getPrice(), 0.001);
        assertEquals(inheritanceProduct.deliveryInstructions(),
                compositionProduct.deliveryInstructions());
    }

    @Test
    void inheritanceAndCompositionProduceSameDownloadMessage() {
        labs.lab08.inheritance.Product inheritanceProduct =
                new labs.lab08.inheritance.DigitalProduct(
                        "D200", "Java Guide", 15.0, "guide.pdf");

        labs.lab08.composition.Product compositionProduct =
                new labs.lab08.composition.Product(
                        "D200",
                        "Java Guide",
                        15.0,
                        new labs.lab08.composition.DownloadDelivery("guide.pdf")
                );

        assertEquals(inheritanceProduct.getId(), compositionProduct.getId());
        assertEquals(inheritanceProduct.getName(), compositionProduct.getName());
        assertEquals(inheritanceProduct.getPrice(), compositionProduct.getPrice(), 0.001);
        assertEquals(inheritanceProduct.deliveryInstructions(),
                compositionProduct.deliveryInstructions());
    }

    @Test
    void cartItemLineTotalsStillMatch() {
        labs.lab08.inheritance.Product inheritedNotebook =
                new labs.lab08.inheritance.PhysicalProduct("P100", "Notebook", 20.0);
        labs.lab08.inheritance.Product inheritedGuide =
                new labs.lab08.inheritance.DigitalProduct(
                        "D200", "Java Guide", 15.0, "guide.pdf");

        labs.lab08.composition.Product composedNotebook =
                new labs.lab08.composition.Product(
                        "P100", "Notebook", 20.0,
                        new labs.lab08.composition.ShippingDelivery());
        labs.lab08.composition.Product composedGuide =
                new labs.lab08.composition.Product(
                        "D200", "Java Guide", 15.0,
                        new labs.lab08.composition.DownloadDelivery("guide.pdf"));

        assertEquals(40.0,
                new labs.lab08.inheritance.CartItem(inheritedNotebook, 2).getLineTotal(),
                0.001);
        assertEquals(45.0,
                new labs.lab08.inheritance.CartItem(inheritedGuide, 3).getLineTotal(),
                0.001);
        assertEquals(40.0,
                new labs.lab08.composition.CartItem(composedNotebook, 2).getLineTotal(),
                0.001);
        assertEquals(45.0,
                new labs.lab08.composition.CartItem(composedGuide, 3).getLineTotal(),
                0.001);
    }

    @Test
    void pickupDeliveryWorksWithoutChangingProduct() {
        labs.lab08.composition.Product pickupNotebook =
                new labs.lab08.composition.Product(
                        "P300",
                        "Pickup Notebook",
                        20.0,
                        new labs.lab08.composition.PickupDelivery("Student Center")
                );

        assertEquals("Pick up at Student Center",
                pickupNotebook.deliveryInstructions());
    }

    @Test
    void downloadDeliveryRejectsBlankFilename() {
        assertThrows(IllegalArgumentException.class,
                () -> new labs.lab08.composition.DownloadDelivery("   "));
    }

    @Test
    void pickupDeliveryRejectsBlankLocation() {
        assertThrows(IllegalArgumentException.class,
                () -> new labs.lab08.composition.PickupDelivery(""));
    }

    @Test
    void productRejectsMissingDeliveryMethod() {
        assertThrows(NullPointerException.class,
                () -> new labs.lab08.composition.Product(
                        "P100", "Notebook", 20.0, null));
    }
}
