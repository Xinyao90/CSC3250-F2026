package homework.hw01.inventory.app;

import homework.hw01.inventory.model.Product;
import homework.hw01.inventory.model.Supplier;
import homework.hw01.inventory.service.Warehouse;

/**
 * Driver program for Homework 1.
 *
 * Complete the TODOs below using the exact scenario in the assignment.
 * This makes your program easy to test and compare with the expected results.
 */
public class InventoryDemo {

    public static void main(String[] args) {

        // TODO 1: Create two Supplier objects.
        // Suggested IDs: S001 and S002.

        // TODO 2: Create these three Product objects:
        // P100 - Laptop   - 999.99
        // P200 - Mouse    - 24.99
        // P300 - Keyboard - 49.99
        // Associate each product with one of the suppliers.

        // TODO 3: Create one Warehouse named "Main Warehouse".

        // TODO 4: Add the products using these initial values:
        // Laptop:   quantity 10, reorder level 3
        // Mouse:    quantity 20, reorder level 5
        // Keyboard: quantity 8,  reorder level 4

        // TODO 5: Perform these stock operations:
        // - add 5 laptops
        // - remove 3 mice
        // - remove 5 keyboards

        // TODO 6: Demonstrate one invalid operation:
        // - try to remove 100 laptops
        // Print whether the operation succeeded or failed.

        // TODO 7: Display the final inventory.
        // Expected final quantities:
        // Laptop = 15, Mouse = 17, Keyboard = 3
        // Keyboard should report that reorder is needed.

        System.out.println("HW1 starter: complete the TODOs in InventoryDemo and the other classes.");
    }
}
