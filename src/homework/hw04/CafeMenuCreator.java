package homework.hw04;

import java.util.Objects;

/** Concrete creator that chooses this dining location's products. */
public final class CafeMenuCreator extends MenuCreator {
    @Override
    public MenuItem createItem(String code) {
        Objects.requireNonNull(code, "code");
        // TODO 1: Return a new Coffee for "drink" or a new VeggieSandwich for "main".
        // Reject every other non-null code with IllegalArgumentException.
        // Codes are case-sensitive; do not cache products.
        throw new UnsupportedOperationException("Complete createItem");
    }
}
