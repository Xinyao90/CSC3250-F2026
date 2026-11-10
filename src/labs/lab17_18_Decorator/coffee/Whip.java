package coffee;

public class Whip extends CondimentDecorator {
    public Whip(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        // TODO: Delegate to beverage.getDescription(), then append ", Whip".
        return "TODO Whip";
    }

    @Override
    public double cost() {
        // TODO: Delegate to beverage.cost(), then add 0.10.
        return 0.0;
    }
}
