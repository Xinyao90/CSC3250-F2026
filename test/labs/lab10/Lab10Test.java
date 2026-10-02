package labs.lab10;
import java.util.List;
import labs.lab10.candidates.CandidateDigitalProduct;
import labs.lab10.candidates.CandidateWorkshopProduct;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Lab10Test {
    @Test
    void originalBaselineIsStillValid() {
        assertContract(new PhysicalProduct("P100", "Notebook", 20.0));
        assertContract(new DigitalProduct("D200", "Java Guide", 15.0, "guide.pdf"));
        assertContract(new WorkshopProduct("W300", "Java Workshop", 30.0, "Room A"));
    }

    @Test
    void candidateDigitalPreservesResultPromise() {
        assertEquals("Download guide.pdf", guide().deliveryInstructions());
    }

    @Test
    void candidateWorkshopNeedsNoExtraSetup() {
        assertEquals("Attend in Room A", assertDoesNotThrow(workshop()::deliveryInstructions));
    }

    @Test
    void candidateDigitalPassesCommonContract() {
        assertContract(guide());
    }

    @Test
    void candidateWorkshopPassesCommonContract() {
        assertContract(workshop());
    }

    @Test
    void candidateConstructorsStillRejectInvalidState() {
        assertThrows(IllegalArgumentException.class, () -> new CandidateDigitalProduct("D", "Guide", 15, ""));
        assertThrows(IllegalArgumentException.class, () -> new CandidateWorkshopProduct("W", "Workshop", 30, null));
        assertThrows(IllegalArgumentException.class, () -> new CandidateWorkshopProduct("W", "Workshop", -1, "A"));
    }

    @Test
    void unchangedSingleProductClientWorks() {
        CheckoutService service = new CheckoutService();
        assertEquals(expectedLines().get(1), service.deliveryLine(guide()));
        assertEquals(expectedLines().get(2), service.deliveryLine(workshop()));
    }

    @Test
    void unchangedMixedClientReturnsEveryLine() {
        assertEquals(expectedLines(), new CheckoutService().deliveryLines(mixedCart()));
    }

    @Test
    void cartArithmeticStillWorks() {
        assertEquals(115.0, mixedCart().getSubtotal(), 0.0001);
    }

    @Test
    void differentRoomIsValidVariation() {
        Product p = new CandidateWorkshopProduct("W2", "Second Workshop", 0.0, "Room B");
        assertEquals("Attend in Room B", p.deliveryInstructions()); assertContract(p);
    }

    @Test
    void differentFileIsValidVariation() {
        Product p = new CandidateDigitalProduct("D2", "Second Guide", 0.0, "notes.pdf");
        assertEquals("Download notes.pdf", p.deliveryInstructions()); assertContract(p);
    }

    @Test
    void emptyClientStillWorks() {
        assertEquals(List.of(), new CheckoutService().deliveryLines(new ShoppingCart()));
    }

    private Product notebook() { return new PhysicalProduct("P100", "Notebook", 20.0); }
    private Product guide() { return new CandidateDigitalProduct("D200", "Java Guide", 15.0, "guide.pdf"); }
    private Product workshop() { return new CandidateWorkshopProduct("W300", "Java Workshop", 30.0, "Room A"); }
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
