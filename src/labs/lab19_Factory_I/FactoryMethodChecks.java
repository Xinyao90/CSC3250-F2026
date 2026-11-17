package factory.lecture19;

import java.util.Arrays;
import java.util.List;

/** Visible behavior checks, identical in the starter and instructor package. */
public final class FactoryMethodChecks {
    private static int passed;
    private static int failed;

    private FactoryMethodChecks() { }

    public static void main(String[] args) {
        check("NY store selects its cheese product", () -> {
            Pizza pizza = new NYPizzaStore().orderPizza(new String("cheese"));
            expect(pizza instanceof NYStyleCheesePizza, "Expected NYStyleCheesePizza");
            equal("NY Style Cheese Pizza", pizza.getName());
        });
        check("NY store selects its veggie product", () -> {
            expect(new NYPizzaStore().orderPizza("veggie") instanceof NYStyleVeggiePizza,
                    "Expected NYStyleVeggiePizza");
        });
        check("NY ordering runs each step once in sequence", () -> {
            equal(diagonalSteps(), new NYPizzaStore().orderPizza("cheese").getSteps());
        });
        check("Chicago store selects its cheese product", () -> {
            Pizza pizza = new ChicagoPizzaStore().orderPizza(new String("cheese"));
            expect(pizza instanceof ChicagoStyleCheesePizza, "Expected ChicagoStyleCheesePizza");
            equal("Chicago Style Cheese Pizza", pizza.getName());
        });
        check("Chicago store selects its veggie product", () -> {
            expect(new ChicagoPizzaStore().orderPizza("veggie") instanceof ChicagoStyleVeggiePizza,
                    "Expected ChicagoStyleVeggiePizza");
        });
        check("Chicago cheese dispatches cut to its override", () -> {
            Pizza pizza = new ChicagoStyleCheesePizza();
            pizza.cut();
            equal(Arrays.asList("cut: square slices"), pizza.getSteps());
        });
        check("Chicago veggie retains the inherited cut", () -> {
            equal(diagonalSteps(), new ChicagoPizzaStore().orderPizza("veggie").getSteps());
        });
        check("Chicago cheese uses the shared workflow once", () -> {
            equal(Arrays.asList("prepare", "bake", "cut: square slices", "box"),
                    new ChicagoPizzaStore().orderPizza("cheese").getSteps());
        });
        check("Each order creates a new product object", () -> {
            PizzaStore store = new ChicagoPizzaStore();
            Pizza first = store.orderPizza("veggie");
            Pizza second = store.orderPizza("veggie");
            expect(first != second, "Two orders must return two pizza objects");
        });
        check("NY store rejects unsupported types", () -> {
            rejects(() -> new NYPizzaStore().orderPizza("clam"));
            rejects(() -> new NYPizzaStore().orderPizza("CHEESE"));
        });
        check("Chicago store rejects unsupported types", () -> {
            rejects(() -> new ChicagoPizzaStore().orderPizza("clam"));
            rejects(() -> new ChicagoPizzaStore().orderPizza(""));
        });
        check("Both stores reject null input", () -> {
            rejects(() -> new NYPizzaStore().orderPizza(null));
            rejects(() -> new ChicagoPizzaStore().orderPizza(null));
        });
        System.out.println("Result: " + passed + " passed, " + failed + " failed.");
        if (failed > 0) {
            System.exit(1);
        }
    }

    private static List<String> diagonalSteps() {
        return Arrays.asList("prepare", "bake", "cut: diagonal slices", "box");
    }

    private static void check(String description, Runnable test) {
        try {
            test.run();
            passed++;
            System.out.println("PASS: " + description);
        } catch (RuntimeException | AssertionError error) {
            failed++;
            System.out.println("FAIL: " + description + " -- "
                    + error.getClass().getSimpleName() + ": " + error.getMessage());
        }
    }

    private static void expect(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void equal(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("Expected " + expected + ", got " + actual);
        }
    }

    private static void rejects(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException expected) {
            return;
        }
        throw new AssertionError("Expected IllegalArgumentException");
    }
}
