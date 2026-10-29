// CSC-3250 classroom adaptation of the SimUDuck / Weather-O-Rama examples.
// Conceptual source: Freeman & Robson, Head First Design Patterns, 2nd ed.
// Original classroom scaffolding and visible checks; no external libraries required.
package labs.lab14_simuduck.starter;

public class FlyWithWings implements FlyBehavior {
    @Override public void fly() {
        System.out.println("Flying with wings");
    }
}
