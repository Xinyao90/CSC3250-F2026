package weapons;

import java.util.Objects;

/** Optional integration: a character delegates to its configured Weapon. */
public class GameCharacter {
    private final String name;
    private Weapon weapon;

    public GameCharacter(String name, Weapon weapon) {
        this.name = Objects.requireNonNull(name, "name");
        setWeapon(weapon);
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = Objects.requireNonNull(weapon, "weapon");
    }

    public String attack() {
        return name + " uses " + weapon.description()
                + " for " + weapon.damage() + " damage";
    }
}
