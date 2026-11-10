package weapons;

public class CharacterDemo {
    public static void main(String[] args) {
        Weapon sword = new Sword();
        GameCharacter king = new GameCharacter("King", sword);
        System.out.println(king.attack());

        king.setWeapon(new FlamingWeapon(new SharpenedWeapon(sword)));
        System.out.println(king.attack());

        GameCharacter queen = new GameCharacter("Queen", new FrostWeapon(sword));
        System.out.println(queen.attack());
    }
}
