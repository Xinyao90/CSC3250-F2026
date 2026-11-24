package homework.hw04;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The SAME 30 public tests are used by students and the instructor.
 * Each passing test earns 2 implementation points, for 60 points total.
 * Run this entire class. Do not edit the tests or their supplied helpers.
 * Each test creates its own objects; execution order does not matter.
 */
public class Hw4PublicTest {
    /** An extension of the common component abstraction, supplied for testing. */
    private static final class FixedComponent implements MenuComponent {
        private final int itemCount;
        private final int vegetarianCount;

        FixedComponent(int itemCount, int vegetarianCount) {
            this.itemCount = itemCount;
            this.vegetarianCount = vegetarianCount;
        }

        @Override public String getName() { return "Extension component"; }
        @Override public int getItemCount() { return itemCount; }
        @Override public int getVegetarianCount() { return vegetarianCount; }
    }

    // FACTORY METHOD: 10 tests, 20 points. No dependence on Menu.add().
    @Test
    void factory01_cafeDrinkCreatesCoffee() {
        MenuItem item = new CafeMenuCreator().createItem("drink");
        assertEquals(Coffee.class, item.getClass());
        assertEquals("Coffee", item.getName());
        assertEquals(1, item.getItemCount());
        assertEquals(1, item.getVegetarianCount());
        assertTrue(item.isVegetarian());
    }

    @Test
    void factory02_cafeMainCreatesVeggieSandwich() {
        MenuItem item = new CafeMenuCreator().createItem("main");
        assertEquals(VeggieSandwich.class, item.getClass());
        assertEquals("Veggie Sandwich", item.getName());
        assertEquals(1, item.getItemCount());
        assertEquals(1, item.getVegetarianCount());
        assertTrue(item.isVegetarian());
    }

    @Test
    void factory03_dinerDrinkCreatesTea() {
        MenuItem item = new DinerMenuCreator().createItem("drink");
        assertEquals(Tea.class, item.getClass());
        assertEquals("Tea", item.getName());
        assertEquals(1, item.getItemCount());
        assertEquals(1, item.getVegetarianCount());
        assertTrue(item.isVegetarian());
    }

    @Test
    void factory04_dinerMainCreatesChickenSandwich() {
        MenuItem item = new DinerMenuCreator().createItem("main");
        assertEquals(ChickenSandwich.class, item.getClass());
        assertEquals("Chicken Sandwich", item.getName());
        assertEquals(1, item.getItemCount());
        assertEquals(0, item.getVegetarianCount());
        assertFalse(item.isVegetarian());
    }

    @Test
    void factory05_cafeRejectsUnknownCodes() {
        MenuCreator creator = new CafeMenuCreator();
        assertThrows(IllegalArgumentException.class, () -> creator.createItem("dessert"));
        assertThrows(IllegalArgumentException.class, () -> creator.createItem(""));
    }

    @Test
    void factory06_dinerRejectsUnknownCodes() {
        MenuCreator creator = new DinerMenuCreator();
        assertThrows(IllegalArgumentException.class, () -> creator.createItem("dessert"));
        assertThrows(IllegalArgumentException.class, () -> creator.createItem(""));
    }

    @Test
    void factory07_cafeCodesAreCaseSensitive() {
        MenuCreator creator = new CafeMenuCreator();
        assertThrows(IllegalArgumentException.class, () -> creator.createItem("DRINK"));
        assertThrows(IllegalArgumentException.class, () -> creator.createItem("MAIN"));
    }

    @Test
    void factory08_dinerCodesAreCaseSensitive() {
        MenuCreator creator = new DinerMenuCreator();
        assertThrows(IllegalArgumentException.class, () -> creator.createItem("DRINK"));
        assertThrows(IllegalArgumentException.class, () -> creator.createItem("MAIN"));
    }

    @Test
    void factory09_cafeReturnsFreshProductsForRepeatedRequests() {
        MenuCreator creator = new CafeMenuCreator();
        MenuItem firstDrink = creator.createItem("drink");
        MenuItem secondDrink = creator.createItem("drink");
        MenuItem firstMain = creator.createItem("main");
        MenuItem secondMain = creator.createItem("main");
        assertNotSame(firstDrink, secondDrink);
        assertNotSame(firstMain, secondMain);
    }

    @Test
    void factory10_dinerReturnsFreshProductsForRepeatedRequests() {
        MenuCreator creator = new DinerMenuCreator();
        MenuItem firstDrink = creator.createItem("drink");
        MenuItem secondDrink = creator.createItem("drink");
        MenuItem firstMain = creator.createItem("main");
        MenuItem secondMain = creator.createItem("main");
        assertNotSame(firstDrink, secondDrink);
        assertNotSame(firstMain, secondMain);
    }

    // COMPOSITE: 10 tests, 20 points. No factories or MenuIterator required.
    @Test
    void composite01_emptyMenuHasZeroCounts() {
        Menu menu = new Menu("Empty Menu");
        assertEquals(0, menu.getItemCount());
        assertEquals(0, menu.getVegetarianCount());
    }

    @Test
    void composite02_oneNonvegetarianLeafCountsAsOneItem() {
        Menu menu = new Menu("Lunch");
        menu.add(new ChickenSandwich());
        assertEquals(1, menu.getItemCount());
        assertEquals(0, menu.getVegetarianCount());
    }

    @Test
    void composite03_mixedLeavesAndRepeatedReferencesCountPerOccurrence() {
        Menu menu = new Menu("Mixed Menu");
        MenuComponent coffee = new Coffee();
        menu.add(coffee);
        menu.add(new ChickenSandwich());
        menu.add(new VeggieSandwich());
        menu.add(coffee);
        assertEquals(4, menu.getItemCount());
        assertEquals(3, menu.getVegetarianCount());
    }

    @Test
    void composite04_nestedMenusCountTheirDescendants() {
        Menu cafe = new Menu("Cafe");
        cafe.add(new Coffee());
        cafe.add(new VeggieSandwich());
        Menu diner = new Menu("Diner");
        diner.add(new Tea());
        diner.add(new ChickenSandwich());
        Menu lunch = new Menu("Lunch Locations");
        lunch.add(diner);
        lunch.add(new Coffee());
        Menu campus = new Menu("Campus");
        campus.add(cafe);
        campus.add(lunch);
        assertEquals(5, campus.getItemCount());
        assertEquals(4, campus.getVegetarianCount());
    }

    @Test
    void composite05_emptyNestedMenusDoNotCountAsItems() {
        Menu empty = new Menu("Empty");
        empty.add(new Menu("Also Empty"));
        Menu campus = new Menu("Campus");
        campus.add(empty);
        campus.add(new ChickenSandwich());
        assertEquals(1, campus.getItemCount());
        assertEquals(0, campus.getVegetarianCount());
    }

    @Test
    void composite06_menuInstancesHaveSeparateChildLists() {
        Menu first = new Menu("First");
        Menu second = new Menu("Second");
        first.add(new Coffee());
        second.add(new ChickenSandwich());
        assertEquals(1, first.getItemCount());
        assertEquals(1, first.getVegetarianCount());
        assertEquals(1, second.getItemCount());
        assertEquals(0, second.getVegetarianCount());
    }

    @Test
    void composite07_parentCountsReflectLaterSubmenuChanges() {
        Menu submenu = new Menu("Submenu");
        submenu.add(new Coffee());
        Menu parent = new Menu("Parent");
        parent.add(submenu);
        assertEquals(1, parent.getItemCount());
        assertEquals(1, parent.getVegetarianCount());
        submenu.add(new ChickenSandwich());
        assertEquals(2, parent.getItemCount());
        assertEquals(1, parent.getVegetarianCount());
    }

    @Test
    void composite08_repeatedCountCallsDoNotAccumulateState() {
        Menu submenu = new Menu("Submenu");
        submenu.add(new Coffee());
        submenu.add(new ChickenSandwich());
        Menu parent = new Menu("Parent");
        parent.add(submenu);
        for (int i = 0; i < 3; i++) {
            assertEquals(2, parent.getItemCount());
            assertEquals(1, parent.getVegetarianCount());
        }
    }

    @Test
    void composite09_itemCountDelegatesToAnyComponent() {
        Menu menu = new Menu("With Extension");
        menu.add(new FixedComponent(7, 3));
        menu.add(new Coffee());
        assertEquals(8, menu.getItemCount());
    }

    @Test
    void composite10_vegetarianCountDelegatesToAnyComponent() {
        Menu menu = new Menu("With Extension");
        menu.add(new FixedComponent(7, 3));
        menu.add(new ChickenSandwich());
        assertEquals(3, menu.getVegetarianCount());
    }

    // ITERATOR: 10 tests, 20 points. The first nine construct iterators directly.
    @Test
    void iterator01_emptyIteratorHasNoNextElement() {
        MenuIterator iterator = new MenuIterator(Collections.<MenuComponent>emptyList());
        assertFalse(iterator.hasNext());
    }

    @Test
    void iterator02_nextOnAnEmptyIteratorThrowsNoSuchElementException() {
        MenuIterator iterator = new MenuIterator(Collections.<MenuComponent>emptyList());
        assertThrows(NoSuchElementException.class, () -> iterator.next());
    }

    @Test
    void iterator03_singletonReturnsTheSameComponentReference() {
        MenuComponent coffee = new Coffee();
        MenuIterator iterator = new MenuIterator(Collections.singletonList(coffee));
        assertTrue(iterator.hasNext());
        assertSame(coffee, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void iterator04_componentsAppearInInsertionOrder() {
        MenuComponent coffee = new Coffee();
        MenuComponent tea = new Tea();
        MenuComponent chicken = new ChickenSandwich();
        MenuIterator iterator = new MenuIterator(Arrays.asList(coffee, tea, chicken));
        assertTrue(iterator.hasNext());
        assertSame(coffee, iterator.next());
        assertTrue(iterator.hasNext());
        assertSame(tea, iterator.next());
        assertTrue(iterator.hasNext());
        assertSame(chicken, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void iterator05_repeatedHasNextDoesNotAdvanceThePosition() {
        MenuComponent first = new Coffee();
        MenuComponent second = new Tea();
        MenuIterator iterator = new MenuIterator(Arrays.asList(first, second));
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertSame(first, iterator.next());
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertSame(second, iterator.next());
        assertFalse(iterator.hasNext());
        assertFalse(iterator.hasNext());
    }

    @Test
    void iterator06_nextWorksWithoutAPrecedingHasNextCall() {
        MenuComponent first = new Coffee();
        MenuComponent second = new ChickenSandwich();
        MenuIterator iterator = new MenuIterator(Arrays.asList(first, second));
        assertSame(first, iterator.next());
        assertSame(second, iterator.next());
    }

    @Test
    void iterator07_exhaustedNextAlwaysThrowsNoSuchElementException() {
        MenuComponent coffee = new Coffee();
        MenuIterator iterator = new MenuIterator(Collections.singletonList(coffee));
        assertSame(coffee, iterator.next());
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, () -> iterator.next());
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, () -> iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void iterator08_separateIteratorsKeepIndependentPositions() {
        MenuComponent coffee = new Coffee();
        MenuComponent tea = new Tea();
        List<MenuComponent> elements = Arrays.asList(coffee, tea);
        MenuIterator first = new MenuIterator(elements);
        MenuIterator second = new MenuIterator(elements);
        assertSame(coffee, first.next());
        assertSame(tea, first.next());
        assertFalse(first.hasNext());
        assertTrue(second.hasNext());
        assertSame(coffee, second.next());
        assertTrue(second.hasNext());
    }

    @Test
    void iterator09_childMenuIsReturnedAsOneComponent() {
        MenuComponent coffee = new Coffee();
        MenuComponent submenu = new Menu("Submenu");
        MenuComponent chicken = new ChickenSandwich();
        MenuIterator iterator = new MenuIterator(Arrays.asList(coffee, submenu, chicken));
        assertSame(coffee, iterator.next());
        assertSame(submenu, iterator.next());
        assertSame(chicken, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void iterator10_menuReturnsFreshMenuIteratorsWithIndependentTraversal() {
        MenuComponent coffee = new Coffee();
        MenuComponent submenu = new Menu("Submenu");
        Menu menu = new Menu("Parent");
        menu.add(coffee);
        menu.add(submenu);
        Iterator<MenuComponent> first = menu.iterator();
        Iterator<MenuComponent> second = menu.iterator();
        assertEquals(MenuIterator.class, first.getClass());
        assertEquals(MenuIterator.class, second.getClass());
        assertNotSame(first, second);
        assertSame(coffee, first.next());
        assertSame(submenu, first.next());
        assertFalse(first.hasNext());
        assertTrue(second.hasNext());
        assertSame(coffee, second.next());
        assertSame(submenu, second.next());
        assertFalse(second.hasNext());
    }
}
