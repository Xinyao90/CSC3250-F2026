package weapons;

public class WeaponDemo {
    public static void main(String[] args) {
        Weapon base = new Sword();
        Weapon enhanced = new FlamingWeapon(new SharpenedWeapon(base));
        System.out.println(enhanced.description());
        System.out.println("Damage: " + enhanced.damage());
        System.out.println("Original base damage: " + base.damage());

        Weapon chilled = new FrostWeapon(enhanced);
        System.out.println(chilled.description());
        System.out.println("Damage: " + chilled.damage());
    }
}
