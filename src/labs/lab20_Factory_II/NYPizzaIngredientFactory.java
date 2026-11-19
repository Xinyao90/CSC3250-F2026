package factory.lecture20;

/** A finished concrete factory for one compatible ingredient family. */
public final class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() { return new ThinCrustDough(); }

    @Override
    public Sauce createSauce() { return new MarinaraSauce(); }

    @Override
    public Cheese createCheese() { return new ReggianoCheese(); }
}
