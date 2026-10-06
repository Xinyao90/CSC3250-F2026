package homework.hw02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Published checks shared by the JUnit adapter and command-line runner.
 * Students and instructor receive an identical copy. Do not edit.
 * Assertion helpers at the bottom throw AssertionError when a check fails.
 */
final class Hw2Checks {
    private static final double EPSILON = 1.0e-9;
    private Hw2Checks() { }

    static void a01ConstructorStoresValues() {
        DiscountedProduct p = new DiscountedProduct("P200", "Headphones", 80.0, 0.25);
        text("P200", p.getProductId(), "Product ID");
        text("Headphones", p.getName(), "Product name");
        number(80.0, p.getPrice(), "Original price");
        number(0.25, p.getDiscountRate(), "Stored discount rate");
    }

    static void a02QuarterDiscountWorksThroughParent() {
        Product p = new DiscountedProduct("P200", "Headphones", 80.0, 0.25);
        number(60.0, p.getPurchasePrice(), "Purchase price through a Product reference");
    }

    static void a03FractionalPriceIsNotRounded() {
        DiscountedProduct p = new DiscountedProduct("P300", "Cable", 19.99, 0.15);
        number(16.9915, p.getPurchasePrice(), "Keep the unrounded double result");
    }

    static void a04ZeroDiscountKeepsFullPrice() {
        DiscountedProduct p = new DiscountedProduct("P400", "Case", 29.95, 0.0);
        number(29.95, p.getPurchasePrice(), "Zero discount");
    }

    static void a05FullDiscountIsFree() {
        DiscountedProduct p = new DiscountedProduct("P500", "Sample", 45.0, 1.0);
        number(0.0, p.getPurchasePrice(), "A rate of 1.0 is valid");
    }

    static void a06ZeroOriginalPriceIsAllowed() {
        DiscountedProduct p = new DiscountedProduct("P600", "Sticker", 0.0, 0.4);
        number(0.0, p.getPurchasePrice(), "Zero original price");
    }

    static void a07NegativeRateIsRejected() {
        illegalArgument(() -> new DiscountedProduct("P1", "Item", 10.0, -0.01),
                "A negative rate must be rejected");
    }

    static void a08RateAboveOneIsRejected() {
        illegalArgument(() -> new DiscountedProduct("P1", "Item", 10.0, 1.01),
                "A rate greater than 1.0 must be rejected");
    }

    static void a09NonFiniteRatesAreRejected() {
        illegalArgument(() -> new DiscountedProduct("P1", "Item", 10.0, Double.NaN),
                "NaN must be rejected");
        illegalArgument(() -> new DiscountedProduct("P1", "Item", 10.0, Double.POSITIVE_INFINITY),
                "Positive infinity must be rejected");
        illegalArgument(() -> new DiscountedProduct("P1", "Item", 10.0, Double.NEGATIVE_INFINITY),
                "Negative infinity must be rejected");
    }

    static void a10ProductsKeepIndependentDiscounts() {
        DiscountedProduct first = new DiscountedProduct("P1", "First", 150.0, 0.10);
        DiscountedProduct second = new DiscountedProduct("P2", "Second", 150.0, 0.40);
        number(135.0, first.getPurchasePrice(), "First product purchase price");
        number(90.0, second.getPurchasePrice(), "Second product purchase price");
        number(0.10, first.getDiscountRate(), "First product rate remains independent");
    }

    static void b01TotalsAProductList() {
        List<Product> items = Arrays.<Product>asList(
                new RegularProduct("P1", "Keyboard", 100.0),
                new DiscountedProduct("P2", "Headphones", 80.0, 0.25));
        number(160.0, new PriceCalculator().total(items), "List<Product>");
    }

    static void b02TotalsADiscountedProductList() {
        List<DiscountedProduct> items = Arrays.asList(
                new DiscountedProduct("P1", "Cable", 20.0, 0.10),
                new DiscountedProduct("P2", "Case", 50.0, 0.20));
        number(58.0, new PriceCalculator().total(items), "List<DiscountedProduct>");
    }

    static void b03TotalsAMixedPriceableList() {
        List<Priceable> items = Arrays.<Priceable>asList(
                new RegularProduct("P1", "Keyboard", 100.0),
                new DiscountedProduct("P2", "Headphones", 80.0, 0.25),
                new ServiceFee("Gift wrapping", 5.0));
        number(165.0, new PriceCalculator().total(items), "Mixed List<Priceable>");
    }

    static void b04TotalsAServiceFeeList() {
        List<ServiceFee> items = Arrays.asList(
                new ServiceFee("Wrapping", 3.5), new ServiceFee("Setup", 6.25));
        number(9.75, new PriceCalculator().total(items), "List<ServiceFee>");
    }

    static void b05EmptyListReturnsZero() {
        List<Priceable> items = new ArrayList<>();
        number(0.0, new PriceCalculator().total(items), "Empty list");
    }

    static void b06CountsEveryEntryWithoutRounding() {
        ServiceFee repeated = new ServiceFee("Processing", 0.125);
        List<Priceable> items = Arrays.<Priceable>asList(
                repeated, repeated, new ServiceFee("Setup", 1.337));
        number(1.587, new PriceCalculator().total(items),
                "Every occurrence counts; do not round prices or total");
    }

    static void c01RepeatedPriceCallsPreserveOriginal() {
        DiscountedProduct p = new DiscountedProduct("P1", "Headphones", 80.0, 0.25);
        for (int i = 0; i < 3; i++) {
            number(60.0, p.getPurchasePrice(), "Repeated purchase price");
            number(80.0, p.getPrice(), "Original price after purchase-price call");
            number(0.25, p.getDiscountRate(), "Discount rate after purchase-price call");
        }
    }

    static void c02TotalPreservesListSizeOrderAndReferences() {
        ServiceFee first = new ServiceFee("First", 8.0);
        ServiceFee second = new ServiceFee("Second", 2.0);
        ServiceFee third = new ServiceFee("Third", 5.0);
        List<ServiceFee> items = new ArrayList<>(Arrays.asList(first, second, third));
        number(15.0, new PriceCalculator().total(items), "Total");
        condition(items.size() == 3, "List size must stay 3");
        condition(items.get(0) == first && items.get(1) == second && items.get(2) == third,
                "List order and object references must remain unchanged");
    }

    static void c03TotalPreservesObjectValues() {
        DiscountedProduct product = new DiscountedProduct("P1", "Headphones", 80.0, 0.25);
        ServiceFee fee = new ServiceFee("Gift wrapping", 5.0);
        List<Priceable> items = Arrays.<Priceable>asList(product, fee);
        number(65.0, new PriceCalculator().total(items), "Total");
        number(80.0, product.getPrice(), "Original price after total");
        number(0.25, product.getDiscountRate(), "Discount rate after total");
        number(60.0, product.getPurchasePrice(), "Purchase price after total");
        number(5.0, fee.getPurchasePrice(), "Fee after total");
    }

    static void c04CalculatorStartsFreshOnEveryCall() {
        PriceCalculator calculator = new PriceCalculator();
        List<ServiceFee> first = Arrays.asList(new ServiceFee("One", 4.0));
        List<ServiceFee> second = Arrays.asList(new ServiceFee("Two", 7.0));
        List<ServiceFee> empty = new ArrayList<>();
        number(4.0, calculator.total(first), "First call");
        number(7.0, calculator.total(second), "Second call must not include first call");
        number(0.0, calculator.total(empty), "Empty call after nonempty calls");
        number(4.0, calculator.total(first), "Repeated first list");
    }

    static void c05AcceptsAnUnmodifiableList() {
        List<ServiceFee> items = Collections.unmodifiableList(Arrays.asList(
                new ServiceFee("Wrapping", 2.0), new ServiceFee("Setup", 3.0)));
        number(5.0, new PriceCalculator().total(items), "Read-only input list");
    }

    private static void number(double expected, double actual, String message) {
        if (!Double.isFinite(actual) || Math.abs(expected - actual) > EPSILON) {
            throw new AssertionError(message + ": expected " + expected + ", actual " + actual);
        }
    }

    private static void text(String expected, String actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + ": expected " + expected + ", actual " + actual);
        }
    }

    private static void condition(boolean holds, String message) {
        if (!holds) { throw new AssertionError(message); }
    }

    private static void illegalArgument(Runnable action, String message) {
        try {
            action.run();
        } catch (IllegalArgumentException expected) {
            return;
        } catch (Throwable other) {
            throw new AssertionError(message + ": expected IllegalArgumentException, got "
                    + other.getClass().getSimpleName(), other);
        }
        throw new AssertionError(message + ": expected IllegalArgumentException, but none was thrown");
    }
}
