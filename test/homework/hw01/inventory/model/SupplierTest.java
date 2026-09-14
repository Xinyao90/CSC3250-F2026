package homework.hw01.inventory.model;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Public HW1 tests. Students and the instructor use this same test suite.
 */
class SupplierTest {

    @Test
    void constructorAndGettersStoreSupplierInformation() {
        Supplier supplier = new Supplier("S01", "TechSource", "sales@techsource.com");

        assertEquals("S01", supplier.getSupplierId());
        assertEquals("TechSource", supplier.getName());
        assertEquals("sales@techsource.com", supplier.getEmail());
    }

    @Test
    void allInstanceFieldsArePrivate() {
        for (Field field : Supplier.class.getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers())) {
                assertTrue(Modifier.isPrivate(field.getModifiers()),
                        "Supplier." + field.getName() + " should be private.");
            }
        }
    }
}
