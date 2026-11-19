package factory.lecture20;

/** Creator: owns the ordering workflow and calls a factory method. */
public abstract class PizzaStore {
    /** final is a teaching choice that keeps the shared sequence fixed. */
    public final Pizza orderPizza(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Pizza type must not be null.");
        }
        Pizza pizza = createPizza(type);
        if (pizza == null) {
            throw new IllegalStateException("createPizza must return a Pizza.");
        }
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    /** Returns an unprepared pizza, or rejects an unsupported type. */
    protected abstract Pizza createPizza(String type);
}
