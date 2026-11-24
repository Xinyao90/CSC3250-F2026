package lecture21;

import java.util.List;

public class MenuDemo {
    public static void main(String[] args) {
        PancakeHouseMenu breakfast = breakfastMenu();
        DinerMenu dinner = dinnerMenu();
        Waitress waitress = new Waitress(List.of(breakfast, dinner));

        System.out.println("ALL ITEMS");
        waitress.printMenu();

        System.out.println();
        System.out.println("THIRD MENU, SAME WAITRESS CLASS");
        Waitress withCafe = new Waitress(List.of(breakfast, dinner, cafeMenu()));
        withCafe.printMenu();

        System.out.println();
        System.out.println("VEGETARIAN ITEMS");
        withCafe.printVegetarianMenu(System.out);
    }

    public static PancakeHouseMenu breakfastMenu() {
        PancakeHouseMenu menu = new PancakeHouseMenu();
        menu.addItem(new MenuItem("Pancake breakfast", "Pancakes with berries", true, 5.50));
        menu.addItem(new MenuItem("Garden omelet", "Eggs with garden vegetables", true, 6.25));
        return menu;
    }

    public static DinerMenu dinnerMenu() {
        DinerMenu menu = new DinerMenu();
        menu.addItem(new MenuItem("Tomato soup", "Tomatoes and basil", true, 4.75));
        menu.addItem(new MenuItem("Chicken sandwich", "Grilled chicken on bread", false, 7.25));
        return menu;
    }

    public static CafeMenu cafeMenu() {
        CafeMenu menu = new CafeMenu();
        menu.addItem(new MenuItem("Veggie wrap", "Vegetables in a tortilla", true, 6.50));
        menu.addItem(new MenuItem("Espresso", "A small coffee", true, 2.50));
        return menu;
    }
}
