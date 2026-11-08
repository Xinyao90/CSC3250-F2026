package homework.hw03;

/** A concrete Decorator. Complete only the two TODO methods. */
public class PowerWeapon extends WeaponDecorator {
    // Supplied constructor. Keep it unchanged.
    public PowerWeapon(WeaponBehavior wrapped) {
        super(wrapped);
    }

    @Override
    public int damage() {
        // TODO 7: Call wrapped.damage() once and return the adjusted value.
        throw new UnsupportedOperationException("TODO 7: decorated damage");
    }

    @Override
    public String description() {
        // TODO 8: Preserve the wrapped description, then append " x2".
        throw new UnsupportedOperationException("TODO 8: decorated description");
    }
}
