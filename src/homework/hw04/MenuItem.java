package homework.hw04;

import java.util.Objects;

/** Immutable leaf in the Composite, and product base for Factory Method. */
public abstract class MenuItem implements MenuComponent {
    private final String name;
    private final boolean vegetarian;

    protected MenuItem(String name, boolean vegetarian) {
        this.name = Objects.requireNonNull(name, "name");
        this.vegetarian = vegetarian;
    }

    @Override
    public final String getName() { return name; }

    @Override
    public final int getItemCount() { return 1; }

    @Override
    public final int getVegetarianCount() { return vegetarian ? 1 : 0; }

    public final boolean isVegetarian() { return vegetarian; }
}
