package homework.hw04;

import java.util.Arrays;

/** Supplied integration demonstration; run after completing the student files. */
public class MenuDemo {
    public static void main(String[] args) {
        MenuCreator cafeCreator = new CafeMenuCreator();
        MenuCreator dinerCreator = new DinerMenuCreator();
        Menu cafe = cafeCreator.buildMenu("Cafe Menu", Arrays.asList("drink", "main"));
        Menu diner = dinerCreator.buildMenu("Diner Menu", Arrays.asList("drink", "main"));

        Menu campus = new Menu("Campus Menu");
        campus.add(cafe);
        campus.add(diner);

        System.out.println(campus.getName() + " items: " + campus.getItemCount());
        System.out.println(campus.getName() + " vegetarian items: " + campus.getVegetarianCount());
        System.out.println("Direct children of " + campus.getName() + ":");
        for (MenuComponent child : campus) {
            System.out.println(child.getName() + " (items=" + child.getItemCount()
                    + ", vegetarian=" + child.getVegetarianCount() + ")");
        }
    }
}
