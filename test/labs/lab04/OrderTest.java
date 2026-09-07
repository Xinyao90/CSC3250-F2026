package labs.lab04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderTest {

    @Test
    void subtotalAddsAllLineTotals() {
        Order order = new Order();
        order.addItem(new OrderItem("Notebook", 4.50, 2));
        order.addItem(new OrderItem("Pen", 1.25, 3));

        assertEquals(12.75, order.getSubtotal(), 0.001);
    }

    @Test
    void returnedListCannotModifyTheOrder() {
        Order order = new Order();
        order.addItem(new OrderItem("Pen", 1.25, 3));

        assertThrows(
                UnsupportedOperationException.class,
                () -> order.getItems().clear()
        );

        assertEquals(1, order.getItems().size());
    }
}
