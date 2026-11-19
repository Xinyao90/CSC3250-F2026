package factory.lecture20;

import java.util.Arrays;

/** Visible behavior checks, identical in the starter and instructor package. */
public final class AbstractFactoryChecks {
    private static int passed;
    private static int failed;

    private AbstractFactoryChecks() { }

    public static void main(String[] args) {
        check("NY factory supplies thin crust dough", () -> {
            expect(new NYPizzaIngredientFactory().createDough() instanceof ThinCrustDough,
                    "Expected ThinCrustDough");
        });
        check("NY factory supplies marinara sauce", () -> {
            expect(new NYPizzaIngredientFactory().createSauce() instanceof MarinaraSauce,
                    "Expected MarinaraSauce");
        });
        check("NY factory supplies Reggiano cheese", () -> {
            expect(new NYPizzaIngredientFactory().createCheese() instanceof ReggianoCheese,
                    "Expected ReggianoCheese");
        });
        check("Chicago factory supplies thick crust dough", () -> {
            expect(new ChicagoPizzaIngredientFactory().createDough() instanceof ThickCrustDough,
                    "Expected ThickCrustDough");
        });
        check("Chicago factory supplies plum tomato sauce", () -> {
            expect(new ChicagoPizzaIngredientFactory().createSauce() instanceof PlumTomatoSauce,
                    "Expected PlumTomatoSauce");
        });
        check("Chicago factory supplies mozzarella cheese", () -> {
            expect(new ChicagoPizzaIngredientFactory().createCheese() instanceof MozzarellaCheese,
                    "Expected MozzarellaCheese");
        });
        check("NY order prepares the full NY family", () -> {
            Pizza pizza = new NYPizzaStore().orderPizza(new String("cheese"));
            expect(pizza.getDough() instanceof ThinCrustDough, "Expected NY dough");
            expect(pizza.getSauce() instanceof MarinaraSauce, "Expected NY sauce");
            expect(pizza.getCheese() instanceof ReggianoCheese, "Expected NY cheese");
        });
        check("Chicago order prepares the full Chicago family", () -> {
            Pizza pizza = new ChicagoPizzaStore().orderPizza(new String("cheese"));
            expect(pizza.getDough() instanceof ThickCrustDough, "Expected Chicago dough");
            expect(pizza.getSauce() instanceof PlumTomatoSauce, "Expected Chicago sauce");
            expect(pizza.getCheese() instanceof MozzarellaCheese, "Expected Chicago cheese");
        });
        check("Both stores reuse the CheesePizza recipe class", () -> {
            Pizza nyPizza = new NYPizzaStore().orderPizza("cheese");
            Pizza chicagoPizza = new ChicagoPizzaStore().orderPizza("cheese");
            equal(CheesePizza.class, nyPizza.getClass());
            equal(CheesePizza.class, chicagoPizza.getClass());
        });
        check("Recipe delegates once and retains the returned objects", () -> {
            CountingFactory factory = new CountingFactory();
            CheesePizza pizza = new CheesePizza(factory);
            pizza.prepare();
            equal(1, factory.doughCalls);
            equal(1, factory.sauceCalls);
            equal(1, factory.cheeseCalls);
            expect(pizza.getDough() == factory.dough, "Use the supplied dough object");
            expect(pizza.getSauce() == factory.sauce, "Use the supplied sauce object");
            expect(pizza.getCheese() == factory.cheese, "Use the supplied cheese object");
            equal(Arrays.asList("prepare"), pizza.getSteps());
        });
        check("Shared ordering workflow runs once in sequence", () -> {
            equal(Arrays.asList("prepare", "bake", "cut: diagonal slices", "box"),
                    new ChicagoPizzaStore().orderPizza("cheese").getSteps());
        });
        check("Each order creates a new recipe object", () -> {
            PizzaStore store = new NYPizzaStore();
            expect(store.orderPizza("cheese") != store.orderPizza("cheese"),
                    "Two orders must return two pizza objects");
        });
        check("Both stores reject unsupported pizza types", () -> {
            rejects(() -> new NYPizzaStore().orderPizza("veggie"));
            rejects(() -> new ChicagoPizzaStore().orderPizza("clam"));
            rejects(() -> new NYPizzaStore().orderPizza("CHEESE"));
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

    private static final class CountingFactory implements PizzaIngredientFactory {
        private final Dough dough = new ThinCrustDough();
        private final Sauce sauce = new MarinaraSauce();
        private final Cheese cheese = new ReggianoCheese();
        private int doughCalls;
        private int sauceCalls;
        private int cheeseCalls;

        @Override
        public Dough createDough() { doughCalls++; return dough; }
        @Override
        public Sauce createSauce() { sauceCalls++; return sauce; }
        @Override
        public Cheese createCheese() { cheeseCalls++; return cheese; }
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
