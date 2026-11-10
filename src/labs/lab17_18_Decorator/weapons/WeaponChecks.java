package weapons;

import support.VisibleChecks;

/** Core lab checks. DoubleDamageWeapon belongs to the separate extension. */
public class WeaponChecks {
    public static void main(String[] args) {
        VisibleChecks checks = new VisibleChecks("Weapons");
        checks.expectInt("Sword base damage", new Sword().damage(), 10);
        checks.expectText("Sword base description", new Sword().description(), "Sword");
        checks.expectInt("Sharpened adds three", new SharpenedWeapon(new Sword()).damage(), 13);
        checks.expectText("Sharpened keeps the base description", new SharpenedWeapon(new Sword()).description(), "Sword, Sharpened");
        checks.expectInt("Flaming adds five", new FlamingWeapon(new Sword()).damage(), 15);
        checks.expectText("Flaming keeps the base description", new FlamingWeapon(new Sword()).description(), "Sword, Flaming");
        checks.expectInt("Frost adds two", new FrostWeapon(new Sword()).damage(), 12);
        checks.expectText("Frost keeps the base description", new FrostWeapon(new Sword()).description(), "Sword, Frost");

        Weapon base = new Sword();
        Weapon originalAlias = base;
        Weapon enhanced = new FlamingWeapon(new SharpenedWeapon(base));
        checks.expectInt("Flaming and Sharpened accumulate", enhanced.damage(), 18);
        checks.expectText("Nested descriptions accumulate", enhanced.description(), "Sword, Sharpened, Flaming");
        checks.expectInt("A third enhancement accumulates", new FrostWeapon(enhanced).damage(), 20);
        checks.expectInt("Repeated Flaming is allowed", new FlamingWeapon(new FlamingWeapon(base)).damage(), 20);
        checks.expectInt("The original sword keeps its damage", base.damage(), 10);
        checks.expectInt("A second chain may share the same base", new FrostWeapon(base).damage(), 12);
        checks.expectTrue("The outer wrapper is a distinct object", enhanced != base);
        checks.expectTrue("The old alias still refers to the sword", originalAlias == base);

        Weapon wand = new Weapon() {
            @Override
            public int damage() { return 7; }
            @Override
            public String description() { return "Wand"; }
        };
        checks.expectInt("Flaming accepts any Weapon", new FlamingWeapon(wand).damage(), 12);
        checks.expectInt("Frost accepts any Weapon", new FrostWeapon(wand).damage(), 9);
        checks.expectText("Flaming delegates a custom description", new FlamingWeapon(wand).description(), "Wand, Flaming");
        checks.expectText("Frost delegates a custom description", new FrostWeapon(wand).description(), "Wand, Frost");
        checks.finish();
    }
}
