package homework.hw04;

import java.util.List;
import java.util.Objects;

/** The creator supplies a shared workflow that calls an overridable factory. */
public abstract class MenuCreator {
    public abstract MenuItem createItem(String code);

    /** Build a fresh menu by requesting one fresh product per code, in order. */
    public final Menu buildMenu(String name, List<String> codes) {
        Objects.requireNonNull(codes, "codes");
        Menu menu = new Menu(name);
        for (String code : codes) {
            menu.add(this.createItem(code));
        }
        return menu;
    }
}
