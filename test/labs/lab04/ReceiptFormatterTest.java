package labs.lab04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReceiptFormatterTest {

    @Test
    void formatsReceiptText() {
        Order order = new Order();
        order.addItem(new OrderItem("Notebook", 4.50, 2));
        order.addItem(new OrderItem("Pen", 1.25, 3));

        ReceiptFormatter formatter =
                new ReceiptFormatter();

        String expected = String.join(
                System.lineSeparator(),
                "CHECKOUT",
                "Notebook x2 = $9.00",
                "Pen x3 = $3.75",
                "Subtotal: $12.75",
                ""
        );

        assertEquals(expected, formatter.format(order));
    }
}
