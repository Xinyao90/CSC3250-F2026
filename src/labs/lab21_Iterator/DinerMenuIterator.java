package lecture21;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Traverses items[0] through items[count - 1]. The menu keeps that prefix full.
 * Each iterator owns its position; count is captured when the iterator is made.
 * Lab rule: do not change a menu while traversing it.
 */
public class DinerMenuIterator implements Iterator<MenuItem> {
    private final MenuItem[] items;
    private final int count;
    private int position;

    public DinerMenuIterator(MenuItem[] items, int count) {
        this.items = Objects.requireNonNull(items, "items");
        if (count < 0 || count > items.length) {
            throw new IllegalArgumentException("count must fit the array");
        }
        this.count = count;
    }

    @Override
    public boolean hasNext() {
        // TODO 1: report whether another populated array element remains.
        // Do not advance position here.
        throw new UnsupportedOperationException("TODO 1: hasNext");
    }

    @Override
    public MenuItem next() {
        // TODO 2: throw NoSuchElementException if exhausted.
        // Otherwise return the current item and advance exactly once.
        throw new UnsupportedOperationException("TODO 2: next");
    }

    // Iterator's default remove() throws UnsupportedOperationException.
}
