package homework.hw04;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/** Traverses immediate children in insertion order using its own position. */
public final class MenuIterator implements Iterator<MenuComponent> {
    private final List<MenuComponent> elements;
    private int position = 0;

    // Supplied fields and constructor. The list is unchanged during traversal.
    public MenuIterator(List<MenuComponent> elements) {
        this.elements = Objects.requireNonNull(elements, "elements");
    }

    @Override
    public boolean hasNext() {
        // TODO 7: Report whether position still identifies an element.
        // Checking must not advance position.
        throw new UnsupportedOperationException("Complete hasNext");
    }

    @Override
    public MenuComponent next() {
        // TODO 8: Throw NoSuchElementException when no element remains.
        // Otherwise return the component at position, then advance once.
        // Return a submenu itself; do not expand it into its leaves.
        throw new UnsupportedOperationException("Complete next");
    }

    // Iterator's default remove() remains unsupported.
}
