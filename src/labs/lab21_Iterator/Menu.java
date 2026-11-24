package lecture21;

import java.util.Iterator;

/** A menu exposes traversal without exposing its storage. */
public interface Menu extends Iterable<MenuItem> {
    Iterator<MenuItem> createIterator();

    // Introduced later in Lecture 21: this bridge enables enhanced for.
    @Override
    default Iterator<MenuItem> iterator() {
        return createIterator();
    }
}
