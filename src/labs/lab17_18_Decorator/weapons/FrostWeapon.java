package weapons;

public class FrostWeapon extends WeaponDecorator {
    public FrostWeapon(Weapon weapon) {
        super(weapon);
    }

    @Override
    public int damage() {
        // TODO: Delegate to weapon.damage(), then add 2.
        return 0;
    }

    @Override
    public String description() {
        // TODO: Delegate to weapon.description(), then append ", Frost".
        return "TODO Frost";
    }
}
