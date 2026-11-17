package factory.lecture19;

/** Run this after the checks pass. No cast to a concrete pizza is needed. */
public final class FactoryMethodDemo {
    private FactoryMethodDemo() { }

    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza nyPizza = nyStore.orderPizza("cheese");
        Pizza chicagoPizza = chicagoStore.orderPizza("cheese");

        System.out.println(nyPizza.getName());
        System.out.println(nyPizza.getSteps());
        System.out.println(chicagoPizza.getName());
        System.out.println(chicagoPizza.getSteps());
    }
}
