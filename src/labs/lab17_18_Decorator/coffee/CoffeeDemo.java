package coffee;

import java.util.Locale;

public class CoffeeDemo {
    public static void main(String[] args) {
        Beverage base = new DarkRoast();
        Beverage drink = new Whip(new Mocha(new Mocha(base)));
        System.out.println(drink.getDescription());
        System.out.printf(Locale.US, "Total: $%.2f%n", drink.cost());
        System.out.printf(Locale.US, "Original base: $%.2f%n", base.cost());

        Beverage second = new Soy(new Whip(new HouseBlend()));
        System.out.println(second.getDescription());
        System.out.printf(Locale.US, "Total: $%.2f%n", second.cost());
    }
}
