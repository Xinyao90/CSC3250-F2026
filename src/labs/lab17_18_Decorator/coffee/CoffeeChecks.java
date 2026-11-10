package coffee;

import support.VisibleChecks;

/** Identical visible checks in the student and instructor packages. */
public class CoffeeChecks {
    public static void main(String[] args) {
        VisibleChecks checks = new VisibleChecks("Coffee");
        checks.expectDouble("Espresso base price", new Espresso().cost(), 1.99);
        checks.expectText("House Blend description", new HouseBlend().getDescription(), "House Blend");
        checks.expectDouble("Dark Roast base price", new DarkRoast().cost(), 0.99);
        checks.expectDouble("Mocha adds to Espresso", new Mocha(new Espresso()).cost(), 2.19);
        checks.expectText("Mocha keeps the base description", new Mocha(new Espresso()).getDescription(), "Espresso, Mocha");
        checks.expectDouble("Whip adds to Espresso", new Whip(new Espresso()).cost(), 2.09);
        checks.expectText("Whip keeps the base description", new Whip(new Espresso()).getDescription(), "Espresso, Whip");
        checks.expectDouble("Soy adds to House Blend", new Soy(new HouseBlend()).cost(), 1.04);
        checks.expectText("Soy keeps the base description", new Soy(new HouseBlend()).getDescription(), "House Blend, Soy");

        Beverage base = new DarkRoast();
        Beverage originalAlias = base;
        Beverage drink = new Whip(new Mocha(new Mocha(base)));
        checks.expectDouble("Two Mochas and Whip accumulate", drink.cost(), 1.49);
        checks.expectText("Nested descriptions accumulate", drink.getDescription(), "Dark Roast, Mocha, Mocha, Whip");
        checks.expectDouble("Repeated Whip is allowed", new Whip(new Whip(new HouseBlend())).cost(), 1.09);
        checks.expectDouble("The original base keeps its price", base.cost(), 0.99);
        checks.expectTrue("The outer wrapper is a distinct object", drink != base);
        checks.expectTrue("The old alias still refers to the base", originalAlias == base);

        Beverage special = new Beverage() {
            @Override
            public String getDescription() { return "Special"; }
            @Override
            public double cost() { return 7.25; }
        };
        checks.expectDouble("Mocha accepts any Beverage", new Mocha(special).cost(), 7.45);
        checks.expectDouble("Whip accepts any Beverage", new Whip(special).cost(), 7.35);
        checks.expectDouble("Soy accepts any Beverage", new Soy(special).cost(), 7.40);
        checks.expectText("Whip delegates a custom description", new Whip(special).getDescription(), "Special, Whip");
        checks.expectText("Soy delegates a custom description", new Soy(special).getDescription(), "Special, Soy");
        checks.finish();
    }
}
