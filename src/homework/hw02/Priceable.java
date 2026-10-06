package homework.hw02;

/**
 * A capability shared by products and other objects that have a purchase price.
 * For a valid object, return a finite, nonnegative price without changing state.
 * Repeated calls on an unchanged object return the same value.
 * Supplied file: do not edit.
 */
public interface Priceable {
    double getPurchasePrice();
}
