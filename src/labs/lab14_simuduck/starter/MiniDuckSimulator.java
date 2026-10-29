// CSC-3250 classroom adaptation of the SimUDuck / Weather-O-Rama examples.
// Conceptual source: Freeman & Robson, Head First Design Patterns, 2nd ed.
// Original classroom scaffolding and visible checks; no external libraries required.
package labs.lab14_simuduck.starter;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck toy = new RubberDuck();
        toy.performQuack();
        toy.performFly();
        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
