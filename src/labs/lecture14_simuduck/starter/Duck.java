// CSC-3250 classroom adaptation of the SimUDuck / Weather-O-Rama examples.
// Conceptual source: Freeman & Robson, Head First Design Patterns, 2nd ed.
// Original classroom scaffolding and visible checks; no external libraries required.
public abstract class Duck {
    // Classroom visibility choice: subclasses initialize their defaults.
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;
    public abstract void display();
    public void swim() { System.out.println("Swimming"); }
    public void performFly() { // TODO: delegate flight
        throw new UnsupportedOperationException("TODO: delegate flight"); }
    public void performQuack() { // TODO: delegate sound
        throw new UnsupportedOperationException("TODO: delegate sound"); }
    public void setFlyBehavior(FlyBehavior behavior) {
        if (behavior == null) throw new IllegalArgumentException("Flight behavior is required");
        // TODO: store the supplied flight reference
        throw new UnsupportedOperationException("TODO: store the supplied flight reference");
    }
    public void setQuackBehavior(QuackBehavior behavior) {
        if (behavior == null) throw new IllegalArgumentException("Sound behavior is required");
        // TODO: store the supplied sound reference
        throw new UnsupportedOperationException("TODO: store the supplied sound reference");
    }
}
