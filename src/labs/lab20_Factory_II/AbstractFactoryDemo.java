package factory.lecture20;

public final class AbstractFactoryDemo {
    private AbstractFactoryDemo() { }

    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();
        show("NY", nyStore.orderPizza("cheese"));
        show("Chicago", chicagoStore.orderPizza("cheese"));
    }

    private static void show(String region, Pizza pizza) {
        System.out.println(region + ": " + pizza.getName());
        System.out.println("  " + pizza.getDough().getName());
        System.out.println("  " + pizza.getSauce().getName());
        System.out.println("  " + pizza.getCheese().getName());
        System.out.println("  " + pizza.getSteps());
    }
}
