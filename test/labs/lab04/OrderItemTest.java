package labs.lab04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderItemTest {

    @Test
    void lineTotalUsesPriceAndQuantity() {
        OrderItem item =
                new OrderItem("Pen", 1.25, 3);

        assertEquals(3.75, item.getLineTotal(), 0.001);
    }

    @Test
    void zeroQuantityIsRejected() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new OrderItem("Pen", 1.25, 0)
        );
    }
}
