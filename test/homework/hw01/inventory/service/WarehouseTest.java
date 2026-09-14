package homework.hw01.inventory.service;

import homework.hw01.inventory.model.InventoryItem;
import homework.hw01.inventory.model.Product;
import homework.hw01.inventory.model.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Public HW1 tests. Students and the instructor use this same test suite.
 */
class WarehouseTest {

    private Supplier supplier;
    private Product laptop;
    private Warehouse warehouse;

    @BeforeEach
    void setUp() {
        supplier = new Supplier("S01", "TechSource", "sales@techsource.com");
        laptop = new Product("P100", "Laptop", 899.99, supplier);
        warehouse = new Warehouse("Main Warehouse");
    }

    @Test
    void newWarehouseHasNameAndEmptyInventory() {
        assertEquals("Main Warehouse", warehouse.getName());
        assertTrue(warehouse.getInventory().isEmpty());
    }

    @Test
    void allInstanceFieldsArePrivate() {
        for (Field field : Warehouse.class.getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers())) {
                assertTrue(Modifier.isPrivate(field.getModifiers()),
                        "Warehouse." + field.getName() + " should be private.");
            }
        }
    }

    @Test
    void addProductCreatesInventoryItem() {
        assertTrue(warehouse.addProduct(laptop, 10, 3));

        InventoryItem item = warehouse.findItem("P100");
        assertNotNull(item);
        assertSame(laptop, item.getProduct());
        assertEquals(10, item.getQuantity());
        assertEquals(3, item.getReorderLevel());
    }

    @Test
    void addProductRejectsDuplicateProductId() {
        assertTrue(warehouse.addProduct(laptop, 10, 3));
        assertFalse(warehouse.addProduct(laptop, 20, 5));
        assertEquals(1, warehouse.getInventory().size());
    }

    @Test
    void duplicateCheckUsesProductIdNotObjectIdentity() {
        Product sameIdDifferentObject = new Product("P100", "Different Laptop", 500.00, supplier);

        assertTrue(warehouse.addProduct(laptop, 10, 3));
        assertFalse(warehouse.addProduct(sameIdDifferentObject, 99, 9));
        assertEquals(1, warehouse.getInventory().size());
        assertSame(laptop, warehouse.findItem("P100").getProduct());
    }

    @Test
    void addProductRejectsInvalidArgumentsWithoutChangingInventory() {
        assertFalse(warehouse.addProduct(null, 10, 3));
        assertEquals(0, warehouse.getInventory().size());

        assertFalse(warehouse.addProduct(laptop, -1, 3));
        assertEquals(0, warehouse.getInventory().size());

        assertFalse(warehouse.addProduct(laptop, 10, -1));
        assertEquals(0, warehouse.getInventory().size());
    }

    @Test
    void zeroInitialQuantityAndZeroReorderLevelAreAllowed() {
        assertTrue(warehouse.addProduct(laptop, 0, 0));

        InventoryItem item = warehouse.findItem("P100");
        assertNotNull(item);
        assertEquals(0, item.getQuantity());
        assertEquals(0, item.getReorderLevel());
        assertTrue(item.needsReorder());
    }

    @Test
    void findItemReturnsCorrectObjectAmongSeveralItems() {
        Product mouse = new Product("P200", "Mouse", 19.99, supplier);
        Product keyboard = new Product("P300", "Keyboard", 49.99, supplier);

        warehouse.addProduct(laptop, 10, 3);
        warehouse.addProduct(mouse, 20, 5);
        warehouse.addProduct(keyboard, 8, 4);

        assertSame(laptop, warehouse.findItem("P100").getProduct());
        assertSame(mouse, warehouse.findItem("P200").getProduct());
        assertSame(keyboard, warehouse.findItem("P300").getProduct());
        assertNull(warehouse.findItem("P999"));
    }

    @Test
    void warehouseDelegatesAddAndRemoveStock() {
        warehouse.addProduct(laptop, 10, 3);

        assertTrue(warehouse.addStock("P100", 5));
        assertEquals(15, warehouse.findItem("P100").getQuantity());

        assertTrue(warehouse.removeStock("P100", 4));
        assertEquals(11, warehouse.findItem("P100").getQuantity());
    }

    @Test
    void missingProductCannotBeModified() {
        assertFalse(warehouse.addStock("DOES-NOT-EXIST", 5));
        assertFalse(warehouse.removeStock("DOES-NOT-EXIST", 5));
    }

    @Test
    void invalidStockRequestsDoNotChangeQuantity() {
        warehouse.addProduct(laptop, 10, 3);

        assertFalse(warehouse.addStock("P100", 0));
        assertEquals(10, warehouse.findItem("P100").getQuantity());

        assertFalse(warehouse.addStock("P100", -2));
        assertEquals(10, warehouse.findItem("P100").getQuantity());

        assertFalse(warehouse.removeStock("P100", 11));
        assertEquals(10, warehouse.findItem("P100").getQuantity());
    }

    @Test
    void getInventoryDoesNotAllowOutsideStructuralModification() {
        warehouse.addProduct(laptop, 10, 3);
        List<InventoryItem> inventory = warehouse.getInventory();

        assertThrows(UnsupportedOperationException.class,
                () -> inventory.add(new InventoryItem(laptop, 1, 1)));
        assertThrows(UnsupportedOperationException.class,
                () -> inventory.remove(0));
        assertThrows(UnsupportedOperationException.class,
                inventory::clear);

        assertEquals(1, warehouse.getInventory().size());
    }

    @Test
    void requiredHomeworkScenarioProducesExpectedFinalQuantities() {
        Product mouse = new Product("P200", "Mouse", 19.99, supplier);
        Product keyboard = new Product("P300", "Keyboard", 49.99, supplier);

        assertTrue(warehouse.addProduct(laptop, 10, 3));
        assertTrue(warehouse.addProduct(mouse, 20, 5));
        assertTrue(warehouse.addProduct(keyboard, 8, 4));

        assertTrue(warehouse.addStock("P100", 5));
        assertTrue(warehouse.removeStock("P200", 3));
        assertTrue(warehouse.removeStock("P300", 5));

        assertEquals(15, warehouse.findItem("P100").getQuantity());
        assertEquals(17, warehouse.findItem("P200").getQuantity());
        assertEquals(3, warehouse.findItem("P300").getQuantity());

        assertFalse(warehouse.findItem("P100").needsReorder());
        assertFalse(warehouse.findItem("P200").needsReorder());
        assertTrue(warehouse.findItem("P300").needsReorder());
    }

    @Test
    void displayInventoryIncludesRequiredInformation() {
        warehouse.addProduct(laptop, 3, 3);

        PrintStream originalOut = System.out;
        ByteArrayOutputStream captured = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(captured));
            warehouse.displayInventory();
        } finally {
            System.setOut(originalOut);
        }

        String output = captured.toString().toLowerCase();
        assertTrue(output.contains("p100"), "Output should contain the product ID.");
        assertTrue(output.contains("laptop"), "Output should contain the product name.");
        assertTrue(output.contains("3"), "Output should contain quantity/reorder information.");
        assertTrue(output.contains("true") || output.contains("yes") || output.contains("reorder"),
                "Output should indicate that reorder is needed.");
    }
}
