package labs.lab12;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
/** PUBLIC grading tests: same suite supplied to students and instructor. */
class Lab12Test {
    private <T> List<T> collect(Iterable<T> source) {
        List<T> result = new ArrayList<>();
        for (T item : source) { result.add(item); }
        return result;
    }
    private ItemCatalog<Product> products() {
        ItemCatalog<Product> result = new ItemCatalog<>();
        for (Product p : SampleStore.products()) { result.add(p); }
        return result;
    }
    @Test void newCatalogIsEmpty() { assertEquals(0, new ItemCatalog<String>().size()); }
    @Test void addStoresInOrderAndGetIsTyped() {
        ItemCatalog<String> c = new ItemCatalog<>(); c.add("A"); c.add("B");
        String first = c.get(0);
        assertEquals("A", first); assertEquals("B", c.get(1)); assertEquals(2, c.size());
    }
    @Test void duplicatesAreRetained() {
        ItemCatalog<String> c = new ItemCatalog<>(); c.add("A"); c.add("A");
        assertEquals(List.of("A", "A"), collect(c));
    }
    @Test void nullIsRejectedWithoutChangingSize() {
        ItemCatalog<String> c = new ItemCatalog<>();
        assertThrows(NullPointerException.class, () -> c.add(null)); assertEquals(0, c.size());
    }
    @Test void invalidIndexesAreRejected() {
        ItemCatalog<String> c = new ItemCatalog<>(); c.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> c.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> c.get(1));
    }
    @Test void enhancedForPreservesOrder() {
        ItemCatalog<String> c = new ItemCatalog<>(); c.add("A"); c.add("B"); c.add("C");
        assertEquals(List.of("A", "B", "C"), collect(c));
    }
    @Test void emptyIteratorHasNoNext() { assertFalse(new ItemCatalog<String>().iterator().hasNext()); }
    @Test void emptyIteratorNextThrowsCorrectException() {
        assertThrows(NoSuchElementException.class, () -> new ItemCatalog<String>().iterator().next());
    }
    @Test void repeatedHasNextDoesNotAdvance() {
        ItemCatalog<String> c = new ItemCatalog<>(); c.add("A"); Iterator<String> it = c.iterator();
        assertTrue(it.hasNext()); assertTrue(it.hasNext()); assertEquals("A", it.next()); assertFalse(it.hasNext());
    }
    @Test void nextWorksWithoutPriorHasNext() {
        ItemCatalog<String> c = new ItemCatalog<>(); c.add("A");
        assertEquals("A", c.iterator().next());
    }
    @Test void exhaustedNextAlwaysThrows() {
        ItemCatalog<String> c = new ItemCatalog<>(); c.add("A"); Iterator<String> it = c.iterator();
        assertEquals("A", it.next());
        assertThrows(NoSuchElementException.class, it::next);
        assertThrows(NoSuchElementException.class, it::next);
    }
    @Test void iteratorsHaveIndependentCursors() {
        ItemCatalog<String> c = new ItemCatalog<>(); c.add("A"); c.add("B");
        Iterator<String> a = c.iterator(), b = c.iterator();
        assertNotSame(a, b); assertEquals("A", a.next()); assertEquals("B", a.next());
        assertEquals("A", b.next());
    }
    @Test void repeatedTraversalRestarts() {
        ItemCatalog<String> c = new ItemCatalog<>(); c.add("A"); c.add("B");
        assertEquals(List.of("A", "B"), collect(c)); assertEquals(List.of("A", "B"), collect(c));
    }
    @Test void nestedLoopsVisitAllPairs() {
        ItemCatalog<String> c = new ItemCatalog<>(); c.add("A"); c.add("B"); int count = 0;
        for (String outer : c) { for (String inner : c) { count++; } }
        assertEquals(4, count);
    }
    @Test void oldSnapshotDoesNotSeeLaterAppend() {
        ItemCatalog<String> c = new ItemCatalog<>(); c.add("A"); Iterator<String> old = c.iterator(); c.add("B");
        assertEquals("A", old.next()); assertFalse(old.hasNext());
        assertEquals(List.of("A", "B"), collect(c));
    }
    @Test void iteratorRemoveIsUnsupported() {
        ItemCatalog<String> c = new ItemCatalog<>(); c.add("A"); Iterator<String> it = c.iterator(); it.next();
        assertThrows(UnsupportedOperationException.class, it::remove); assertEquals(1, c.size());
    }
    @Test void snapshotCopiesReferencesNotObjects() {
        ItemCatalog<StringBuilder> c = new ItemCatalog<>(); StringBuilder value = new StringBuilder("A");
        c.add(value); Iterator<StringBuilder> old = c.iterator(); value.append("B");
        assertSame(value, old.next()); assertEquals("AB", c.get(0).toString());
    }
    @Test void productCatalogKeepsExistingDeliveryDispatch() {
        CheckoutService s = new CheckoutService(new RecordingReceiptPrinter()); List<String> lines = new ArrayList<>();
        for (Product p : products()) { lines.add(s.deliveryLine(p)); }
        assertEquals(List.of("Notebook -> Ship to address", "Java Guide -> Download guide.pdf",
            "Java Workshop -> Attend in Room A"), lines);
    }
    @Test void boundedReportSumsUnitsNotCartQuantities() {
        assertEquals(65.0, CatalogReports.totalUnitPrice(products()), 0.0001);
        assertEquals(115.0, SampleStore.mixedCart().getSubtotal(), 0.0001);
    }
    @Test void boundedReportAcceptsDigitalOnlyCatalog() {
        ItemCatalog<DigitalProduct> c = new ItemCatalog<>();
        c.add(new DigitalProduct("D1", "Guide", 15.0, "g.pdf"));
        assertEquals(15.0, CatalogReports.totalUnitPrice(c), 0.0001);
        assertEquals(List.of("Guide"), CatalogReports.names(c));
    }
    @Test void boundedReportAcceptsJavaListAndEmptyInput() {
        assertEquals(65.0, CatalogReports.totalUnitPrice(SampleStore.products()), 0.0001);
        assertEquals(0.0, CatalogReports.totalUnitPrice(new ArrayList<Product>()), 0.0001);
    }
    @Test void boundedReportRejectsNullSourceAndElement() {
        assertThrows(NullPointerException.class, () -> CatalogReports.totalUnitPrice(null));
        assertThrows(NullPointerException.class,
            () -> CatalogReports.totalUnitPrice(Arrays.asList((Product) null)));
    }
    @Test void collectionComparisonRetainsOrRemovesDuplicatesAsPromised() {
        List<String> values = List.of("A", "A", "B");
        assertEquals(3, new ArrayList<>(values).size());
        assertEquals(List.of("A", "B"), new ArrayList<>(new LinkedHashSet<>(values)));
    }
    @Test void carriedCheckoutStillUsesInjectedPrinter() {
        RecordingReceiptPrinter p = new RecordingReceiptPrinter();
        new CheckoutService(p).printReceipt(SampleStore.mixedCart());
        assertEquals(1, p.getReceipts().size()); assertTrue(p.getReceipts().get(0).endsWith("Subtotal: 115.00"));
    }
}
