package factory.lecture19;

/** Finished example of a concrete creator. */
public final class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if ("cheese".equals(type)) {
            return new NYStyleCheesePizza();
        }
        if ("veggie".equals(type)) {
            return new NYStyleVeggiePizza();
        }
        throw new IllegalArgumentException("Unsupported pizza type: " + type);
    }
}
