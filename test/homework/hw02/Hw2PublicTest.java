package homework.hw02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The one public JUnit 5 suite for both students and instructor. Do not edit.
 * Each test invokes a published check in Hw2Checks. The command-line runner
 * invokes those same checks, not a different or hidden test suite.
 */
@DisplayName("HW2 public tests - automated portion: 80 points")
class Hw2PublicTest {
    @Test
    @DisplayName("A01 [4 points] Constructor stores ID, name, original price, and rate")
    void a01ConstructorStoresValues() {
        Hw2Checks.a01ConstructorStoresValues();
    }

    @Test
    @DisplayName("A02 [4 points] 25% discount through a Product reference")
    void a02QuarterDiscountWorksThroughParent() {
        Hw2Checks.a02QuarterDiscountWorksThroughParent();
    }

    @Test
    @DisplayName("A03 [4 points] Fractional price without rounding")
    void a03FractionalPriceIsNotRounded() {
        Hw2Checks.a03FractionalPriceIsNotRounded();
    }

    @Test
    @DisplayName("A04 [4 points] Zero discount")
    void a04ZeroDiscountKeepsFullPrice() {
        Hw2Checks.a04ZeroDiscountKeepsFullPrice();
    }

    @Test
    @DisplayName("A05 [4 points] 100% discount")
    void a05FullDiscountIsFree() {
        Hw2Checks.a05FullDiscountIsFree();
    }

    @Test
    @DisplayName("A06 [4 points] Zero original price")
    void a06ZeroOriginalPriceIsAllowed() {
        Hw2Checks.a06ZeroOriginalPriceIsAllowed();
    }

    @Test
    @DisplayName("A07 [4 points] Reject a negative rate")
    void a07NegativeRateIsRejected() {
        Hw2Checks.a07NegativeRateIsRejected();
    }

    @Test
    @DisplayName("A08 [4 points] Reject a rate above 1.0")
    void a08RateAboveOneIsRejected() {
        Hw2Checks.a08RateAboveOneIsRejected();
    }

    @Test
    @DisplayName("A09 [4 points] Reject NaN and both infinities")
    void a09NonFiniteRatesAreRejected() {
        Hw2Checks.a09NonFiniteRatesAreRejected();
    }

    @Test
    @DisplayName("A10 [4 points] Independent product discounts")
    void a10ProductsKeepIndependentDiscounts() {
        Hw2Checks.a10ProductsKeepIndependentDiscounts();
    }

    @Test
    @DisplayName("B01 [5 points] Total List<Product>")
    void b01TotalsAProductList() {
        Hw2Checks.b01TotalsAProductList();
    }

    @Test
    @DisplayName("B02 [5 points] Total List<DiscountedProduct>")
    void b02TotalsADiscountedProductList() {
        Hw2Checks.b02TotalsADiscountedProductList();
    }

    @Test
    @DisplayName("B03 [5 points] Total mixed List<Priceable>")
    void b03TotalsAMixedPriceableList() {
        Hw2Checks.b03TotalsAMixedPriceableList();
    }

    @Test
    @DisplayName("B04 [5 points] Total List<ServiceFee>")
    void b04TotalsAServiceFeeList() {
        Hw2Checks.b04TotalsAServiceFeeList();
    }

    @Test
    @DisplayName("B05 [5 points] Empty list returns zero")
    void b05EmptyListReturnsZero() {
        Hw2Checks.b05EmptyListReturnsZero();
    }

    @Test
    @DisplayName("B06 [5 points] Count repeated entries and keep numerical precision")
    void b06CountsEveryEntryWithoutRounding() {
        Hw2Checks.b06CountsEveryEntryWithoutRounding();
    }

    @Test
    @DisplayName("C01 [2 points] Repeated purchase-price calls preserve original values")
    void c01RepeatedPriceCallsPreserveOriginal() {
        Hw2Checks.c01RepeatedPriceCallsPreserveOriginal();
    }

    @Test
    @DisplayName("C02 [2 points] Preserve list size, order, and references")
    void c02TotalPreservesListSizeOrderAndReferences() {
        Hw2Checks.c02TotalPreservesListSizeOrderAndReferences();
    }

    @Test
    @DisplayName("C03 [2 points] Preserve object values after totaling")
    void c03TotalPreservesObjectValues() {
        Hw2Checks.c03TotalPreservesObjectValues();
    }

    @Test
    @DisplayName("C04 [2 points] Fresh sum on every calculator call")
    void c04CalculatorStartsFreshOnEveryCall() {
        Hw2Checks.c04CalculatorStartsFreshOnEveryCall();
    }

    @Test
    @DisplayName("C05 [2 points] Accept a read-only list")
    void c05AcceptsAnUnmodifiableList() {
        Hw2Checks.c05AcceptsAnUnmodifiableList();
    }

}
