package homework.hw04;

import java.util.Objects;

/** Concrete creator that chooses this dining location's products. */
public final class DinerMenuCreator extends MenuCreator {
    @Override
    public MenuItem createItem(String code) {
        Objects.requireNonNull(code, "code");
        // TODO 2: Return a new Tea for "drink" or a new ChickenSandwich for "main".
        // Reject every other non-null code with IllegalArgumentException.
        // Codes are case-sensitive; do not cache products.
        throw new UnsupportedOperationException("Complete createItem");
    }
}
