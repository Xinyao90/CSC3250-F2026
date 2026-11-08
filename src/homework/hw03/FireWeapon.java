package homework.hw03;

/** A concrete Decorator. Complete only the two TODO methods. */
public class FireWeapon extends WeaponDecorator {
    // Supplied constructor. Keep it unchanged.
    public FireWeapon(WeaponBehavior wrapped) {
        super(wrapped);
    }

    @Override
    public int damage() {
        // TODO 5: Call wrapped.damage() once and return the adjusted value.
        throw new UnsupportedOperationException("TODO 5: decorated damage");
    }

    @Override
    public String description() {
        // TODO 6: Preserve the wrapped description, then append " + fire".
        throw new UnsupportedOperationException("TODO 6: decorated description");
    }
}
