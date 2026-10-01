package labs.lab09;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Lab09Test {
    @Test
    void week4BaselineRemainsCorrect() {
        assertEquals("Ship to address", notebook().deliveryInstructions());
        assertEquals("Download guide.pdf", guide().deliveryInstructions());
        assertEquals(40.0, new CartItem(notebook(), 2).getLineTotal(), 0.0001);
        assertEquals(45.0, new CartItem(guide(), 3).getLineTotal(), 0.0001);
    }

    @Test
    void workshopUsesSharedState() {
        Product p = workshop();
        assertEquals("W300", p.getId()); assertEquals("Java Workshop", p.getName());
        assertEquals(30.0, p.getPrice(), 0.0001);
    }

    @Test
    void workshopGivesAttendanceInstructions() {
        assertEquals("Attend in Room A", workshop().deliveryInstructions());
    }

    @Test
    void workshopReusesDescription() {
        assertEquals("W300: Java Workshop [workshop]", workshop().description());
    }

    @Test
    void workshopRejectsMissingRoom() {
        assertThrows(IllegalArgumentException.class, () -> new WorkshopProduct("W", "Workshop", 30, null));
        assertThrows(IllegalArgumentException.class, () -> new WorkshopProduct("W", "Workshop", 30, "   "));
    }

    @Test
    void commonConstructorValidationStillApplies() {
        assertThrows(IllegalArgumentException.class, () -> new WorkshopProduct("", "Workshop", 30, "A"));
        assertThrows(IllegalArgumentException.class, () -> new WorkshopProduct("W", "Workshop", -1, "A"));
        assertThrows(IllegalArgumentException.class, () -> new WorkshopProduct("W", "Workshop", Double.NaN, "A"));
    }

    @Test
    void singleProductClientHandlesAllSubtypes() {
        CheckoutService service = new CheckoutService();
        List<Product> products = List.of(notebook(), guide(), workshop());
        for (int i = 0; i < products.size(); i++)
            assertEquals(expectedLines().get(i), service.deliveryLine(products.get(i)));
    }

    @Test
    void catalogKeepsIndependentObjectsInOrder() {
        Catalog c = new Catalog(); Product a = notebook(), b = guide(), w = workshop();
        c.addProduct(a); c.addProduct(b); c.addProduct(w);
        assertEquals(3, c.getProducts().size());
        assertSame(a, c.getProducts().get(0)); assertSame(w, c.findProduct("W300"));
        assertThrows(UnsupportedOperationException.class, () -> c.getProducts().clear());
    }

    @Test
    void mixedCheckoutReturnsAllLines() {
        assertEquals(expectedLines(), new CheckoutService().deliveryLines(mixedCart()));
    }

    @Test
    void mixedSubtotalStays115() {
        assertEquals(115.0, mixedCart().getSubtotal(), 0.0001);
    }

    @Test
    void emptyCartHasNoLinesAndZeroSubtotal() {
        ShoppingCart empty = new ShoppingCart();
        assertEquals(List.of(), new CheckoutService().deliveryLines(empty));
        assertEquals(0.0, empty.getSubtotal(), 0.0001);
    }

    @Test
    void quantityDoesNotDuplicateDeliveryLines() {
        ShoppingCart c = new ShoppingCart(); c.addProduct(workshop(), 3);
        assertEquals(List.of("Java Workshop -> Attend in Room A"), new CheckoutService().deliveryLines(c));
        assertEquals(90.0, c.getSubtotal(), 0.0001);
    }

    @Test
    void allSubtypesPreserveProductContract() {
        for (Product p : List.of(notebook(), guide(), workshop())) assertContract(p);
    }

    @Test
    void cartExposesReadOnlyItems() {
        ShoppingCart c = mixedCart();
        assertEquals(3, c.getItems().size());
        assertThrows(UnsupportedOperationException.class, () -> c.getItems().clear());
    }

    private Product notebook() { return new PhysicalProduct("P100", "Notebook", 20.0); }
    private Product guide() { return new DigitalProduct("D200", "Java Guide", 15.0, "guide.pdf"); }
    private Product workshop() { return new WorkshopProduct("W300", "Java Workshop", 30.0, "Room A"); }
    private ShoppingCart mixedCart() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(notebook(), 2); cart.addProduct(guide(), 3); cart.addProduct(workshop(), 1);
        return cart;
    }
    private List<String> expectedLines() { return List.of(
        "Notebook -> Ship to address", "Java Guide -> Download guide.pdf", "Java Workshop -> Attend in Room A");
    }
    private void assertContract(Product product) {
        String id = product.getId(), name = product.getName();
        double price = product.getPrice();
        assertNotNull(id); assertFalse(id.isBlank());
        assertNotNull(name); assertFalse(name.isBlank());
        assertTrue(Double.isFinite(price)); assertTrue(price >= 0);
        for (int i = 0; i < 2; i++) {
            String instructions = assertDoesNotThrow(product::deliveryInstructions);
            assertNotNull(instructions); assertFalse(instructions.isBlank());
            assertEquals(id, product.getId()); assertEquals(name, product.getName());
            assertEquals(price, product.getPrice(), 0.0001);
        }
    }
}
