package homework.hw01.inventory.service;

import homework.hw01.inventory.model.InventoryItem;
import homework.hw01.inventory.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a warehouse that owns and manages its inventory items.
 *
 * HW1 design focus:
 * - The internal inventory list must remain private.
 * - Warehouse.addProduct(...) creates InventoryItem objects.
 * - Outside code should not directly modify the inventory list.
 */
public class Warehouse {

    private String name;
    private List<InventoryItem> inventory;

    /**
     * TODO 1:
     * - save the warehouse name;
     * - initialize inventory as an empty ArrayList.
     */
    public Warehouse(String name) {
        // TODO
    }

    /**
     * TODO 2: Return the warehouse name.
     */
    public String getName() {
        return null; // TODO
    }

    /**
     * Returns a read-only view of the inventory.
     *
     * TODO 3: Do NOT return the mutable list directly.
     * You may use Collections.unmodifiableList(inventory).
     */
    public List<InventoryItem> getInventory() {
        return Collections.emptyList(); // TODO: replace with a protected/read-only view.
    }

    /**
     * Adds a new product to this warehouse.
     *
     * Contract:
     * - product cannot be null;
     * - quantity cannot be negative;
     * - reorderLevel cannot be negative;
     * - the same productId cannot be added twice;
     * - Warehouse must create the InventoryItem internally;
     * - return true when added, otherwise return false.
     */
    public boolean addProduct(Product product, int quantity, int reorderLevel) {
        // TODO:
        // 1. Validate the arguments.
        // 2. Use findItem(product.getProductId()) to check for duplicates.
        // 3. Create a new InventoryItem.
        // 4. Add it to inventory.
        // 5. Return true if successful.
        return false;
    }

    /**
     * Finds an inventory item by product ID.
     *
     * Contract:
     * - return the matching InventoryItem when found;
     * - return null when no match exists.
     */
    public InventoryItem findItem(String productId) {
        // TODO: loop through inventory and compare product IDs.
        return null;
    }

    /**
     * Adds stock to an existing product.
     *
     * Contract:
     * - if productId does not exist, return false;
     * - otherwise delegate the work to InventoryItem.addStock(amount).
     */
    public boolean addStock(String productId, int amount) {
        // TODO: find the item and delegate.
        return false;
    }

    /**
     * Removes stock from an existing product.
     *
     * Contract:
     * - if productId does not exist, return false;
     * - otherwise delegate the work to InventoryItem.removeStock(amount).
     */
    public boolean removeStock(String productId, int amount) {
        // TODO: find the item and delegate.
        return false;
    }

    /**
     * Displays each product in the warehouse.
     *
     * Minimum information to print for each item:
     * - product ID
     * - product name
     * - quantity
     * - reorder level
     * - whether reorder is needed
     */
    public void displayInventory() {
        // TODO: loop through inventory and print the required information.
    }
}
