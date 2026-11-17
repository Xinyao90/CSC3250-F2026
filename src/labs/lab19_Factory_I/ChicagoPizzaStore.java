package factory.lecture19;

/** Complete TODO 19A by following the finished NYPizzaStore example. */
public final class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        // TODO 19A: "cheese" -> new ChicagoStyleCheesePizza().
        //           "veggie" -> new ChicagoStyleVeggiePizza().
        //           Any other value -> throw IllegalArgumentException.
        // Return a product here. The inherited orderPizza runs its steps.
        throw new UnsupportedOperationException("TODO 19A: select a Chicago pizza");
    }
}
