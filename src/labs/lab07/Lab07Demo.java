package labs.lab07;

import java.util.List;

public class Lab07Demo {

    public static void main(String[] args) {

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

        List<Product> products =
                List.of(notebook, guide);

        System.out.println("Products");
        System.out.println("--------");

        for (Product product : products) {

            System.out.println(product.description());

            System.out.println(
                    product.deliveryInstructions()
            );

            System.out.println();
        }

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
