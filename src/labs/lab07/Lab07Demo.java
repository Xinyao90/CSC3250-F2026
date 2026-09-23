package labs.lab07;
import java.util.List;

public class Lab07Demo {

    public static void main(String[] args) {

        /*
         * TODO 1:
         *
         * Create:
         *
         * PhysicalProduct
         *   id: P100
         *   name: Notebook
         *   price: 20.00
         *
         * DigitalProduct
         *   id: D200
         *   name: Java Guide
         *   price: 15.00
         *   file: guide.pdf
         */

        Product notebook =
                new PhysicalProduct(
                        "P100",
                        "Notebook",
                        20.00
                );

        Product guide =
                new DigitalProduct(
                        "D200",
                        "Java Guide",
                        15.00,
                        "guide.pdf"
                );

        /*
         * Notice:
         *
         * The variables above have type Product,
         * even though the actual objects are
         * PhysicalProduct and DigitalProduct.
         */

        List<Product> products =
                List.of(notebook, guide);

        System.out.println("Products");
        System.out.println("--------");

        for (Product product : products) {

            /*
             * TODO 2:
             * Print:
             *
             * description()
             * deliveryInstructions()
             */

            System.out.println(product.description());
            System.out.println(
                    product.deliveryInstructions()
            );

            System.out.println();
        }

        /*
         * Existing CartItem code should work with
         * BOTH subclasses without modification.
         */

        CartItem notebookItem =
                new CartItem(notebook, 2);

        CartItem guideItem =
                new CartItem(guide, 3);

        System.out.println("Cart");
        System.out.println("----");

        System.out.println(
                "Notebook line total: "
                        + notebookItem.getLineTotal()
        );

        System.out.println(
                "Guide line total: "
                        + guideItem.getLineTotal()
        );
    }
}
