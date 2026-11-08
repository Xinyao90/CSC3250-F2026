package homework.hw03;

/** Supplied demonstration. Run after completing the three student files. */
public class GameDemo {
    public static void main(String[] args) {
        GameCharacter queen = new GameCharacter("Queen", new SwordBehavior());
        CombatLog log = new CombatLog();
        queen.registerObserver(log);

        System.out.println(queen.attack());
        queen.setWeaponBehavior(new BowBehavior());
        System.out.println(queen.attack());
        queen.setWeaponBehavior(new PowerWeapon(new FireWeapon(new SwordBehavior())));
        System.out.println(queen.attack());
        System.out.println("Logged attacks: " + log.getUpdateCount());

        queen.removeObserver(log);
        System.out.println(queen.attack());
        System.out.println("Logged attacks after removal: " + log.getUpdateCount());
    }
}
