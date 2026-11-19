package factory.lecture20;

public final class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if ("cheese".equals(type)) {
            return new CheesePizza(new ChicagoPizzaIngredientFactory());
        }
        throw new IllegalArgumentException("Unsupported pizza type: " + type);
    }
}
