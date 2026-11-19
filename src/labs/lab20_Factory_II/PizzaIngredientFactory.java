package factory.lecture20;

/** Abstract Factory: the operations that every regional family supplies. */
public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
}
