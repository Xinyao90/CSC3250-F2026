package labs.lab12;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/** Compare contracts, not microbenchmark speed. Use String equality deliberately. */
public class CollectionComparisonDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Set<String> set = new LinkedHashSet<>();
        ItemCatalog<String> catalog = new ItemCatalog<>();
        for (String value : List.of("A", "A", "B")) {
            list.add(value); set.add(value); catalog.add(value);
        }
        System.out.println("ArrayList: " + list + ", size=" + list.size());
        System.out.println("LinkedHashSet: " + set + ", size=" + set.size());
        System.out.print("ItemCatalog:");
        for (String value : catalog) { System.out.print(" " + value); }
        System.out.println(", size=" + catalog.size());
    }
}
