package homework.hw03;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Strategy context and Observer subject for this small game. */
public class GameCharacter implements CombatSubject {
    private final String name;
    private WeaponBehavior weapon;
    private final List<CombatObserver> observers = new ArrayList<>();

    // Supplied constructor and getters. Keep them unchanged.
    public GameCharacter(String name, WeaponBehavior weapon) {
        this.name = Objects.requireNonNull(name, "name");
        this.weapon = Objects.requireNonNull(weapon, "weapon");
    }

    public String getName() { return name; }
    public WeaponBehavior getWeaponBehavior() { return weapon; }

    /** Replace the Strategy reference without attacking or notifying observers. */
    public void setWeaponBehavior(WeaponBehavior weapon) {
        Objects.requireNonNull(weapon, "weapon");
        // TODO 1: Store the supplied weapon reference in this character.
        // A parameter and field have the same name; use this.weapon.
        throw new UnsupportedOperationException("TODO 1: replace the strategy");
    }

    /**
     * Ask the current weapon for damage and description exactly once each.
     * Create one new AttackEvent, pass that SAME event to each registered
     * observer exactly once, and return it. Do not print inside this method.
     */
    public AttackEvent attack() {
        // TODO 2: Delegate, build the event, notify subscribers, then return it.
        // Hint: keep the damage and description in local variables.
        // Iterate through observers and call update(event) on each one.
        throw new UnsupportedOperationException("TODO 2: perform one attack");
    }

    /** Register once. Re-registering the same observer does not duplicate it. */
    @Override
    public void registerObserver(CombatObserver observer) {
        Objects.requireNonNull(observer, "observer");
        // TODO 3: Add only if observers does not already contain this observer.
        // Registration itself does not send an event.
        throw new UnsupportedOperationException("TODO 3: register an observer");
    }

    /** Remove if present. Removing a missing observer is harmless. */
    @Override
    public void removeObserver(CombatObserver observer) {
        Objects.requireNonNull(observer, "observer");
        // TODO 4: Remove the supplied observer from observers if present.
        // List.remove handles a missing entry without an error.
        throw new UnsupportedOperationException("TODO 4: remove an observer");
    }
}
