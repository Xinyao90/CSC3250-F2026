// CSC-3250 classroom adaptation of the SimUDuck / Weather-O-Rama examples.
// Conceptual source: Freeman & Robson, Head First Design Patterns, 2nd ed.
// Original classroom scaffolding and visible checks; no external libraries required.
public class StrategyChecks {
    private static class CountingFlight implements FlyBehavior {
        int calls;
        public void fly() { calls++; }
    }
    private static class CountingSound implements QuackBehavior {
        int calls;
        public void quack() { calls++; }
    }
    public static void main(String[] args) {
        Duck first = new ModelDuck();
        Duck identity = first;
        CountingFlight oldFlight = new CountingFlight();
        CountingFlight newFlight = new CountingFlight();
        CountingSound sound = new CountingSound();
        first.setFlyBehavior(oldFlight);
        first.setQuackBehavior(sound);
        first.performFly();
        CheckSupport.check(oldFlight.calls == 1, "performFly delegates exactly once");
        first.performQuack();
        CheckSupport.check(sound.calls == 1, "performQuack delegates exactly once");
        first.setFlyBehavior(newFlight);
        CheckSupport.check(newFlight.calls == 0, "a setter configures without executing flight");
        first.performFly();
        CheckSupport.check(oldFlight.calls == 1 && newFlight.calls == 1, "replacement reaches only the new strategy");
        CheckSupport.check(first == identity, "context identity is preserved");
        first.performQuack();
        CheckSupport.check(sound.calls == 2, "flight replacement preserves sound");
        Duck second = new ModelDuck();
        CountingFlight shared = new CountingFlight();
        first.setFlyBehavior(shared);
        second.setFlyBehavior(shared);
        first.setFlyBehavior(newFlight);
        second.performFly();
        CheckSupport.check(shared.calls == 1, "replacing one context reference leaves the other unchanged");
        boolean rejectedFlight = false, rejectedSound = false;
        try { first.setFlyBehavior(null); } catch (IllegalArgumentException e) { rejectedFlight = true; }
        try { first.setQuackBehavior(null); } catch (IllegalArgumentException e) { rejectedSound = true; }
        CheckSupport.check(rejectedFlight && rejectedSound, "classroom setters reject missing collaborators");
        CheckSupport.check(CheckSupport.capture(new Runnable() {
            public void run() { Duck d = new MallardDuck(); d.performFly(); d.performQuack(); }
        }).equals("Flying with wings\nQuack"), "MallardDuck has correct defaults");
        CheckSupport.check(CheckSupport.capture(new Runnable() {
            public void run() { Duck d = new RubberDuck(); d.performFly(); d.performQuack(); }
        }).equals("No flight\nSqueak"), "RubberDuck has correct defaults");
        CheckSupport.check(CheckSupport.capture(new Runnable() {
            public void run() { Duck d = new DecoyDuck(); d.performFly(); d.performQuack(); }
        }).equals("No flight\nSilence"), "DecoyDuck has correct defaults");
        CheckSupport.check(CheckSupport.capture(new Runnable() {
            public void run() { Duck d = new ModelDuck(); d.performFly(); d.performQuack(); }
        }).equals("No flight\nQuack"), "ModelDuck has correct defaults");
        CheckSupport.finish();
    }
}
