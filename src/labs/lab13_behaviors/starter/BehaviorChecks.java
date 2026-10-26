// CSC-3250 classroom adaptation of the SimUDuck / Weather-O-Rama examples.
// Conceptual source: Freeman & Robson, Head First Design Patterns, 2nd ed.
// Original classroom scaffolding and visible checks; no external libraries required.
public class BehaviorChecks {
    public static void main(String[] args) {
        CheckSupport.check(CheckSupport.capture(new Runnable() {
            public void run() { new FlyWithWings().fly(); }
        }).equals("Flying with wings"), "FlyWithWings implements the required behavior");
        CheckSupport.check(CheckSupport.capture(new Runnable() {
            public void run() { new FlyNoWay().fly(); }
        }).equals("No flight"), "FlyNoWay implements the required behavior");
        CheckSupport.check(CheckSupport.capture(new Runnable() {
            public void run() { new Quack().quack(); }
        }).equals("Quack"), "Quack implements the required behavior");
        CheckSupport.check(CheckSupport.capture(new Runnable() {
            public void run() { new Squeak().quack(); }
        }).equals("Squeak"), "Squeak implements the required behavior");
        CheckSupport.check(CheckSupport.capture(new Runnable() {
            public void run() { new MuteQuack().quack(); }
        }).equals("Silence"), "MuteQuack implements the required behavior");
        FlyBehavior first = new FlyWithWings();
        FlyBehavior second = first;
        CheckSupport.check(first == second, "assignment shares an existing reference");
        second = new FlyNoWay();
        CheckSupport.check(first != second, "reassignment changes only the second reference");
        CheckSupport.finish();
    }
}
