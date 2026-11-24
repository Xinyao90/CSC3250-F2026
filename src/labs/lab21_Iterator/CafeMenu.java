package lecture21;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Extension: the textbook uses a HashMap. LinkedHashMap gives this lab a
 * predictable insertion order. The Waitress still sees only an iterator.
 */
public class CafeMenu implements Menu {
    private final Map<String, MenuItem> items = new LinkedHashMap<>();

    public void addItem(MenuItem item) {
        Objects.requireNonNull(item, "item");
        items.put(item.getName(), item);
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return items.values().iterator();
    }
}
