package homework.hw01.inventory.model;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Public HW1 tests. Students and the instructor use this same test suite.
 */
class ProductTest {

    @Test
    void constructorAndGettersStoreProductInformation() {
        Supplier supplier = new Supplier("S01", "TechSource", "sales@techsource.com");
        Product product = new Product("P100", "Laptop", 899.99, supplier);

        assertEquals("P100", product.getProductId());
        assertEquals("Laptop", product.getName());
        assertEquals(899.99, product.getPrice(), 0.001);
        assertSame(supplier, product.getSupplier());
    }

    @Test
    void allInstanceFieldsArePrivate() {
        for (Field field : Product.class.getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers())) {
                assertTrue(Modifier.isPrivate(field.getModifiers()),
                        "Product." + field.getName() + " should be private.");
            }
        }
    }
}
