package lecture21;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/** Run this supplied program. You do not need to write JUnit tests. */
public class PublicChecks {
    private static int passed;
    private static int failed;

    public static void main(String[] args) {
        check("hasNext sees the first item", () -> {
            require(MenuDemo.dinnerMenu().createIterator().hasNext(), "expected true");
        });
        check("repeated hasNext does not move the cursor", () -> {
            Iterator<MenuItem> it = MenuDemo.dinnerMenu().createIterator();
            require(it.hasNext() && it.hasNext(), "both calls should be true");
            equal("Tomato soup", it.next().getName());
        });
        check("next returns each item in order", () -> {
            equal(List.of("Tomato soup", "Chicken sandwich"), names(MenuDemo.dinnerMenu()));
        });
        check("capacity is not the number of items", () -> {
            DinerMenu menu = new DinerMenu(12);
            menu.addItem(item("Only item"));
            equal(List.of("Only item"), names(menu));
        });
        check("an empty menu has no next item", () -> {
            require(!new DinerMenu().createIterator().hasNext(), "expected false");
        });
        check("next on an empty menu throws NoSuchElementException", () -> {
            expect(NoSuchElementException.class, () -> new DinerMenu().createIterator().next());
        });
        check("next after exhaustion throws NoSuchElementException", () -> {
            Iterator<MenuItem> it = MenuDemo.dinnerMenu().createIterator();
            it.next();
            it.next();
            require(!it.hasNext(), "iterator should be exhausted");
            expect(NoSuchElementException.class, it::next);
        });
        check("next does not require an earlier hasNext call", () -> {
            Iterator<MenuItem> it = MenuDemo.dinnerMenu().createIterator();
            equal("Tomato soup", it.next().getName());
        });
        check("two traversals have independent cursors", () -> {
            DinerMenu menu = MenuDemo.dinnerMenu();
            Iterator<MenuItem> first = menu.createIterator();
            Iterator<MenuItem> second = menu.createIterator();
            first.next();
            equal("Tomato soup", second.next().getName());
            equal("Chicken sandwich", first.next().getName());
        });
        check("a new traversal starts at the first item", () -> {
            DinerMenu menu = MenuDemo.dinnerMenu();
            names(menu);
            equal("Tomato soup", menu.createIterator().next().getName());
        });
        check("Waitress prints both menu implementations", () -> {
            String output = capture(new Waitress(List.of(MenuDemo.breakfastMenu(), MenuDemo.dinnerMenu())));
            equal(List.of(
                "Pancake breakfast (v), $5.50 -- Pancakes with berries",
                "Garden omelet (v), $6.25 -- Eggs with garden vegetables",
                "Tomato soup (v), $4.75 -- Tomatoes and basil",
                "Chicken sandwich, $7.25 -- Grilled chicken on bread"), output.lines().toList());
        });
        check("Waitress handles an empty menu between populated menus", () -> {
            String output = capture(new Waitress(List.of(MenuDemo.breakfastMenu(), new DinerMenu(), MenuDemo.dinnerMenu())));
            equal(4L, output.lines().count());
        });
        check("CafeMenu integrates without another Waitress branch", () -> {
            String output = capture(new Waitress(List.of(MenuDemo.breakfastMenu(), MenuDemo.dinnerMenu(), MenuDemo.cafeMenu())));
            equal(6L, output.lines().count());
            require(output.contains("Veggie wrap") && output.contains("Espresso"), "missing cafe items");
        });
        check("enhanced for uses a fresh iterator", () -> {
            List<String> found = new ArrayList<>();
            for (MenuItem item : MenuDemo.dinnerMenu()) { found.add(item.getName()); }
            equal(List.of("Tomato soup", "Chicken sandwich"), found);
        });
        check("the custom iterator declares remove unsupported", () -> {
            Iterator<MenuItem> it = MenuDemo.dinnerMenu().createIterator();
            it.next();
            expect(UnsupportedOperationException.class, it::remove);
        });
        System.out.printf("%n%d passed, %d failed%n", passed, failed);
        if (failed != 0) { System.exit(1); }
    }

    private static MenuItem item(String name) { return new MenuItem(name, "sample", true, 1.00); }

    private static List<String> names(Menu menu) {
        List<String> result = new ArrayList<>();
        Iterator<MenuItem> it = menu.createIterator();
        while (it.hasNext()) { result.add(it.next().getName()); }
        return result;
    }

    private static String capture(Waitress waitress) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try (PrintStream out = new PrintStream(bytes, true, StandardCharsets.UTF_8)) {
            waitress.printMenu(out);
        }
        return bytes.toString(StandardCharsets.UTF_8);
    }

    private static void check(String name, Runnable action) {
        try {
            action.run();
            passed++;
            System.out.println("PASS: " + name);
        } catch (Throwable error) {
            failed++;
            System.out.println("FAIL: " + name + " [" + error.getClass().getSimpleName() + ": " + error.getMessage() + "]");
        }
    }

    private static void require(boolean value, String message) {
        if (!value) { throw new AssertionError(message); }
    }

    private static void equal(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("expected " + expected + ", got " + actual);
        }
    }

    private static void expect(Class<? extends Throwable> type, Runnable action) {
        try {
            action.run();
        } catch (Throwable error) {
            if (type.isInstance(error)) { return; }
            throw new AssertionError("expected " + type.getSimpleName() + ", got " + error, error);
        }
        throw new AssertionError("expected " + type.getSimpleName());
    }
}
