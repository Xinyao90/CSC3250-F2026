package coffee;

import java.util.Objects;

/** A wrapper is a Beverage and stores a reference to another Beverage. */
public abstract class CondimentDecorator extends Beverage {
    protected final Beverage beverage;

    protected CondimentDecorator(Beverage beverage) {
        this.beverage = Objects.requireNonNull(beverage, "beverage");
    }
}
