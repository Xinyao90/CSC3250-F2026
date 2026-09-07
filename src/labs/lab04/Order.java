package labs.lab04;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<OrderItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        if (item == null) {
            throw new IllegalArgumentException(
                    "Order item cannot be null."
            );
        }

        items.add(item);
    }

    public List<OrderItem> getItems() {
        return List.copyOf(items);
    }

    public double getSubtotal() {
        // TODO 2: Ask each OrderItem for its line total and add the results.
        return 0.0;
    }
}
