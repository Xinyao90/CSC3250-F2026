package homework.hw04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/** Composite containing leaf items, other menus, or any MenuComponent. */
public final class Menu implements MenuComponent, Iterable<MenuComponent> {
    private final String name;
    private final List<MenuComponent> children = new ArrayList<>();

    // Supplied constructor, fields, and name getter. Keep them unchanged.
    public Menu(String name) {
        this.name = Objects.requireNonNull(name, "name");
    }

    @Override
    public String getName() { return name; }

    /** Append in insertion order, retaining the supplied reference. */
    public void add(MenuComponent component) {
        Objects.requireNonNull(component, "component");
        // TODO 3: Append this component reference to children.
        // Keep submenus as components; do not clone, flatten, or deduplicate.
        throw new UnsupportedOperationException("Complete add");
    }

    @Override
    public int getItemCount() {
        // TODO 4: Sum child.getItemCount() for all immediate children.
        // Start a local total at zero on every call; empty menus return zero.
        throw new UnsupportedOperationException("Complete getItemCount");
    }

    @Override
    public int getVegetarianCount() {
        // TODO 5: Sum child.getVegetarianCount() through the common interface.
        // Submenus already know how to count their own children.
        throw new UnsupportedOperationException("Complete getVegetarianCount");
    }

    /** Iterate over immediate children only, with a fresh independent cursor. */
    @Override
    public Iterator<MenuComponent> iterator() {
        // TODO 6: Return a NEW MenuIterator over children.
        // Each call needs its own cursor; do not return children.iterator().
        throw new UnsupportedOperationException("Complete iterator");
    }
}
