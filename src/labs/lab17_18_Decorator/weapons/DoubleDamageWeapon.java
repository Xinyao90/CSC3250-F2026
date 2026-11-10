package weapons;

public class DoubleDamageWeapon extends WeaponDecorator {
    public DoubleDamageWeapon(Weapon weapon) {
        super(weapon);
    }

    @Override
    public int damage() {
        return weapon.damage() * 2;
    }

    @Override
    public String description() {
        return weapon.description() + ", Double Damage";
    }
}
