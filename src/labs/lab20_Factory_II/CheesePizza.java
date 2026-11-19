package factory.lecture20;

/** One recipe class can work with either ingredient family. */
public final class CheesePizza extends Pizza {
    private final PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        super("Cheese Pizza");
        if (ingredientFactory == null) {
            throw new IllegalArgumentException("Ingredient factory must not be null.");
        }
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        // TODO 20D: ask ingredientFactory for dough, sauce, and cheese.
        // Store each returned object in the matching inherited field.
        // Then record exactly one step: "prepare".
        // The recipe must work with any PizzaIngredientFactory.
        throw new UnsupportedOperationException("TODO 20D: prepare with the supplied factory");
    }
}
