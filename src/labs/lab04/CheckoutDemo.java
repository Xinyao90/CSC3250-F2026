package labs.lab04;

public class CheckoutDemo {

    public static void main(String[] args) {
        Order order = new Order();

        order.addItem(
                new OrderItem("Notebook", 4.50, 2)
        );

        order.addItem(
                new OrderItem("Pen", 1.25, 3)
        );

        ReceiptFormatter formatter =
                new ReceiptFormatter();

        System.out.print(formatter.format(order));
    }
}
