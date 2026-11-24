package lecture21;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

public class Waitress {
    private final List<Menu> menus;

    public Waitress(List<Menu> menus) {
        this.menus = List.copyOf(menus);
    }

    public void printMenu() {
        printMenu(System.out);
    }

    public void printMenu(PrintStream out) {
        for (Menu menu : menus) {
            printMenu(menu.createIterator(), out);
        }
    }

    private void printMenu(Iterator<MenuItem> iterator, PrintStream out) {
        // TODO 4: print each returned MenuItem exactly once using this iterator.
        // out.println(item) uses MenuItem.toString().
        throw new UnsupportedOperationException("TODO 4: printMenu");
    }

    // Optional extension. This uses the Iterable bridge introduced later.
    public void printVegetarianMenu(PrintStream out) {
        for (Menu menu : menus) {
            for (MenuItem item : menu) {
                if (item.isVegetarian()) {
                    out.println(item);
                }
            }
        }
    }
}
