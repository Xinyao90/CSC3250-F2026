package homework.hw03;

/** Immutable result of ONE attack. Supplied; do not edit. */
public final class AttackEvent {
    private final String characterName;
    private final String weaponDescription;
    private final int damage;

    public AttackEvent(String characterName, String weaponDescription, int damage) {
        this.characterName = characterName;
        this.weaponDescription = weaponDescription;
        this.damage = damage;
    }

    public String getCharacterName() { return characterName; }
    public String getWeaponDescription() { return weaponDescription; }
    public int getDamage() { return damage; }

    @Override
    public String toString() {
        return characterName + ": " + weaponDescription + " -> " + damage;
    }
}
