package factory.lecture20;

public final class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        // TODO 20A: return a new ThickCrustDough.
        throw new UnsupportedOperationException("TODO 20A: create Chicago dough");
    }

    @Override
    public Sauce createSauce() {
        // TODO 20B: return a new PlumTomatoSauce.
        throw new UnsupportedOperationException("TODO 20B: create Chicago sauce");
    }

    @Override
    public Cheese createCheese() {
        // TODO 20C: return a new MozzarellaCheese.
        throw new UnsupportedOperationException("TODO 20C: create Chicago cheese");
    }
}
