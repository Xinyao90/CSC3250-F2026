package homework.hw03;

import java.util.Objects;

/** Supplied decorator base. One wrapper holds one component reference. */
public abstract class WeaponDecorator implements WeaponBehavior {
    protected final WeaponBehavior wrapped;

    protected WeaponDecorator(WeaponBehavior wrapped) {
        this.wrapped = Objects.requireNonNull(wrapped, "wrapped weapon");
    }
}
