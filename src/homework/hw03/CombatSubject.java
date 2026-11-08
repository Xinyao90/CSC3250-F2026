package homework.hw03;

/** A publisher with explicit observer registration. Do not edit. */
public interface CombatSubject {
    void registerObserver(CombatObserver observer);
    void removeObserver(CombatObserver observer);
}
