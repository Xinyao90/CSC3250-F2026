package lecture21;

import java.util.Iterator;
import java.util.Objects;

public class DinerMenu implements Menu {
    private final MenuItem[] items;
    private int count;

    public DinerMenu() {
        this(6);
    }

    public DinerMenu(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must be nonnegative");
        }
        items = new MenuItem[capacity];
    }

    public void addItem(MenuItem item) {
        Objects.requireNonNull(item, "item");
        if (count == items.length) {
            throw new IllegalStateException("menu is full");
        }
        items[count++] = item;
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        // TODO 3: create a new iterator for this array's populated prefix.
        throw new UnsupportedOperationException("TODO 3: createIterator");
    }
}
