package lecture21;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class PancakeHouseMenu implements Menu {
    private final List<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item) {
        items.add(Objects.requireNonNull(item, "item"));
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return items.iterator();
    }
}
