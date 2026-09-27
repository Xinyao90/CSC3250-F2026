package lab08.composition;

public class Lab08Demo {
    public static void main(String[] args) {
        Product notebook = new Product(
                "P100",
                "Notebook",
                20.0,
                new ShippingDelivery()
        );

        Product guide = new Product(
                "D200",
                "Java Guide",
                15.0,
                new DownloadDelivery("guide.pdf")
        );

        System.out.println(notebook.getName() + ": " + notebook.deliveryInstructions());
        System.out.println(guide.getName() + ": " + guide.deliveryInstructions());

        CartItem notebookItem = new CartItem(notebook, 2);
        CartItem guideItem = new CartItem(guide, 3);

        System.out.println("Notebook line total: $" + notebookItem.getLineTotal());
        System.out.println("Guide line total: $" + guideItem.getLineTotal());

        // TODO 5:
        // After PickupDelivery is implemented, create another Product named
        // "Pickup Notebook" with price 20.0 and PickupDelivery("Student Center").
        // Print its deliveryInstructions().
    }
}
