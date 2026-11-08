package homework.hw03;

/** Supplied concrete Strategy and concrete Decorator component. Do not edit. */
public class BowBehavior implements WeaponBehavior {
    @Override
    public int damage() { return 6; }

    @Override
    public String description() { return "Bow"; }
}
