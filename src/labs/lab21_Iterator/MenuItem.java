package lecture21;

import java.util.Locale;
import java.util.Objects;

/** One item; immutable so the lab can focus on traversal. */
public class MenuItem {
    private final String name;
    private final String description;
    private final boolean vegetarian;
    private final double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = Objects.requireNonNull(name, "name");
        this.description = Objects.requireNonNull(description, "description");
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public boolean isVegetarian() { return vegetarian; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format(Locale.ROOT, "%s%s, $%.2f -- %s",
                name, vegetarian ? " (v)" : "", price, description);
    }
}
