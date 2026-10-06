package homework.hw02;

import java.util.Locale;

/**
 * Optional dependency-free runner for the SAME public checks as Hw2PublicTest.
 * No JUnit installation is needed to run this class. Do not edit.
 */
public final class Hw2CheckRunner {
    private Hw2CheckRunner() { }

    private static final class Check {
        private final String id;
        private final String label;
        private final int points;
        private final Runnable action;
        private Check(String id, String label, int points, Runnable action) {
            this.id = id;
            this.label = label;
            this.points = points;
            this.action = action;
        }
    }

    public static void main(String[] args) {
        Check[] checks = {
            new Check("A01", "Constructor stores ID, name, original price, and rate", 4, Hw2Checks::a01ConstructorStoresValues),
            new Check("A02", "25% discount through a Product reference", 4, Hw2Checks::a02QuarterDiscountWorksThroughParent),
            new Check("A03", "Fractional price without rounding", 4, Hw2Checks::a03FractionalPriceIsNotRounded),
            new Check("A04", "Zero discount", 4, Hw2Checks::a04ZeroDiscountKeepsFullPrice),
            new Check("A05", "100% discount", 4, Hw2Checks::a05FullDiscountIsFree),
            new Check("A06", "Zero original price", 4, Hw2Checks::a06ZeroOriginalPriceIsAllowed),
            new Check("A07", "Reject a negative rate", 4, Hw2Checks::a07NegativeRateIsRejected),
            new Check("A08", "Reject a rate above 1.0", 4, Hw2Checks::a08RateAboveOneIsRejected),
            new Check("A09", "Reject NaN and both infinities", 4, Hw2Checks::a09NonFiniteRatesAreRejected),
            new Check("A10", "Independent product discounts", 4, Hw2Checks::a10ProductsKeepIndependentDiscounts),
            new Check("B01", "Total List<Product>", 5, Hw2Checks::b01TotalsAProductList),
            new Check("B02", "Total List<DiscountedProduct>", 5, Hw2Checks::b02TotalsADiscountedProductList),
            new Check("B03", "Total mixed List<Priceable>", 5, Hw2Checks::b03TotalsAMixedPriceableList),
            new Check("B04", "Total List<ServiceFee>", 5, Hw2Checks::b04TotalsAServiceFeeList),
            new Check("B05", "Empty list returns zero", 5, Hw2Checks::b05EmptyListReturnsZero),
            new Check("B06", "Count repeated entries and keep numerical precision", 5, Hw2Checks::b06CountsEveryEntryWithoutRounding),
            new Check("C01", "Repeated purchase-price calls preserve original values", 2, Hw2Checks::c01RepeatedPriceCallsPreserveOriginal),
            new Check("C02", "Preserve list size, order, and references", 2, Hw2Checks::c02TotalPreservesListSizeOrderAndReferences),
            new Check("C03", "Preserve object values after totaling", 2, Hw2Checks::c03TotalPreservesObjectValues),
            new Check("C04", "Fresh sum on every calculator call", 2, Hw2Checks::c04CalculatorStartsFreshOnEveryCall),
            new Check("C05", "Accept a read-only list", 2, Hw2Checks::c05AcceptsAnUnmodifiableList)
        };
        int passed = 0;
        int earned = 0;
        int possible = 0;
        System.out.println("CSC 3250 HW2 - published checks (same checks as JUnit)");
        System.out.println("----------------------------------------------------");
        for (Check check : checks) {
            possible += check.points;
            try {
                check.action.run();
                passed++;
                earned += check.points;
                System.out.printf(Locale.US, "PASS %s [%d/%d] %s%n",
                        check.id, check.points, check.points, check.label);
            } catch (Throwable failure) {
                System.out.printf(Locale.US, "FAIL %s [0/%d] %s%n",
                        check.id, check.points, check.label);
                System.out.println("     " + failure.getClass().getSimpleName() + ": " + failure.getMessage());
            }
        }
        System.out.println("----------------------------------------------------");
        System.out.printf(Locale.US, "Public checks passed: %d/%d%n", passed, checks.length);
        System.out.printf(Locale.US, "Automated subtotal: %d/%d%n", earned, possible);
        System.out.println("Remaining: design review 10 points + README explanations 10 points.");
        System.out.println("The automated subtotal is not the complete homework grade.");
        if (passed != checks.length) { System.exit(1); }
    }
}
