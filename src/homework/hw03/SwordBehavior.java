package homework.hw03;

/** Supplied concrete Strategy and concrete Decorator component. Do not edit. */
public class SwordBehavior implements WeaponBehavior {
    @Override
    public int damage() { return 10; }

    @Override
    public String description() { return "Sword"; }
}
