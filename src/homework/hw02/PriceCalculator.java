package homework.hw02;

import java.util.List;

/** Student file 2 of 2. No instance or static fields are needed. */
public class PriceCalculator {
    /**
     * Return the sum of getPurchasePrice() for EVERY list entry.
     * Return 0.0 for an empty list. Keep the list and objects unchanged.
     * The same object occurring twice counts twice; do not remove duplicates.
     * Each call starts a new total. Do not round the numerical result.
     *
     * Assume items is non-null, contains no null elements, and contains valid
     * Priceable objects whose total fits in a finite double.
     * Null handling and overflow handling are outside this assignment.
     *
     * Keep this exact generic method signature. No casts, raw types,
     * instanceof, getClass(), or type/name-based branches.
     */
    public <T extends Priceable> double total(List<T> items) {
        // TODO 3: Start a local sum, visit each item, ask the item for its
        // purchase price, add that value, and return the completed sum.
        // Hint: T is a type that promises the Priceable operation.
        throw new UnsupportedOperationException("TODO: total the purchase prices");
    }
}
