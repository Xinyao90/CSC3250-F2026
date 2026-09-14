package homework.hw01.inventory.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Public HW1 tests. Students and the instructor use this same test suite.
 */
class InventoryItemTest {

    private Product product;
    private InventoryItem item;

    @BeforeEach
    void setUp() {
        Supplier supplier = new Supplier("S01", "TechSource", "sales@techsource.com");
        product = new Product("P100", "Laptop", 899.99, supplier);
        item = new InventoryItem(product, 10, 3);
    }

    @Test
    void constructorAndGettersStoreInventoryInformation() {
        assertSame(product, item.getProduct());
        assertEquals(10, item.getQuantity());
        assertEquals(3, item.getReorderLevel());
    }

    @Test
    void allInstanceFieldsArePrivate() {
        for (Field field : InventoryItem.class.getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers())) {
                assertTrue(Modifier.isPrivate(field.getModifiers()),
                        "InventoryItem." + field.getName() + " should be private.");
            }
        }
    }

    @Test
    void addStockWithPositiveAmountIncreasesQuantity() {
        assertTrue(item.addStock(5));
        assertEquals(15, item.getQuantity());
    }

    @Test
    void addStockRejectsZeroOrNegativeAmountsAndDoesNotChangeState() {
        int before = item.getQuantity();

        assertFalse(item.addStock(0));
        assertEquals(before, item.getQuantity());

        assertFalse(item.addStock(-2));
        assertEquals(before, item.getQuantity());
    }

    @Test
    void removeStockWithValidAmountDecreasesQuantity() {
        assertTrue(item.removeStock(4));
        assertEquals(6, item.getQuantity());
    }

    @Test
    void removeStockRejectsInvalidAmountsAndDoesNotChangeState() {
        int before = item.getQuantity();

        assertFalse(item.removeStock(-1));
        assertEquals(before, item.getQuantity());

        assertFalse(item.removeStock(0));
        assertEquals(before, item.getQuantity());

        assertFalse(item.removeStock(11));
        assertEquals(before, item.getQuantity());
    }

    @Test
    void removeExactlyAllStockIsAllowed() {
        assertTrue(item.removeStock(10));
        assertEquals(0, item.getQuantity());
        assertTrue(item.needsReorder());
    }

    @Test
    void repeatedValidUpdatesAccumulateCorrectly() {
        assertTrue(item.addStock(5));
        assertTrue(item.addStock(2));
        assertTrue(item.removeStock(4));
        assertEquals(13, item.getQuantity());
    }

    @Test
    void needsReorderUsesLessThanOrEqualRule() {
        InventoryItem aboveLevel = new InventoryItem(product, 4, 3);
        InventoryItem equalLevel = new InventoryItem(product, 3, 3);
        InventoryItem belowLevel = new InventoryItem(product, 2, 3);

        assertFalse(aboveLevel.needsReorder());
        assertTrue(equalLevel.needsReorder());
        assertTrue(belowLevel.needsReorder());
    }
}
