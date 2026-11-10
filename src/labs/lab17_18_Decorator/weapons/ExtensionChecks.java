package weapons;

import support.VisibleChecks;

/** Optional extension. Complete the core lab before running this suite. */
public class ExtensionChecks {
    public static void main(String[] args) {
        VisibleChecks checks = new VisibleChecks("Optional order extension");
        Weapon doubledAfterFire = new DoubleDamageWeapon(new FlamingWeapon(new Sword()));
        Weapon fireAfterDoubling = new FlamingWeapon(new DoubleDamageWeapon(new Sword()));
        checks.expectInt("Double after adding five", doubledAfterFire.damage(), 30);
        checks.expectInt("Add five after doubling", fireAfterDoubling.damage(), 25);
        checks.expectInt("Two additive enhancements in first order", new FlamingWeapon(new SharpenedWeapon(new Sword())).damage(), 18);
        checks.expectInt("Two additive enhancements in reverse order", new SharpenedWeapon(new FlamingWeapon(new Sword())).damage(), 18);
        checks.expectText("Description records the first order", new FlamingWeapon(new SharpenedWeapon(new Sword())).description(), "Sword, Sharpened, Flaming");
        checks.expectText("Description records the reverse order", new SharpenedWeapon(new FlamingWeapon(new Sword())).description(), "Sword, Flaming, Sharpened");
        checks.finish();
    }
}
