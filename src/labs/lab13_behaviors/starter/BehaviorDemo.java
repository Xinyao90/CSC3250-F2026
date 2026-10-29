// CSC-3250 classroom adaptation of the SimUDuck / Weather-O-Rama examples.
// Conceptual source: Freeman & Robson, Head First Design Patterns, 2nd ed.
// Original classroom scaffolding and visible checks; no external libraries required.
public class BehaviorDemo {
    public static void main(String[] args) {
        FlyBehavior[] flights = {new FlyWithWings(), new FlyNoWay()};
        for (FlyBehavior flight : flights) flight.fly();
        QuackBehavior[] sounds = {new Quack(), new Squeak(), new MuteQuack()};
        for (QuackBehavior sound : sounds) sound.quack();
        System.out.println("-- Reference reassignment --");

        FlyBehavior first = new FlyWithWings();
        FlyBehavior second = first;
        second = new FlyNoWay();
        first.fly();
        second.fly();
    }
}
