package tp4.exo2.simple;

public class Main {
    public static void main(String[] args) {
        GameCharacter goblin = new GameCharacter("Goblin", 80, 15);
        Warrior knight = new Warrior("Knight", 120, 25, 30, 10);

        System.out.println(goblin);
        System.out.println(knight);

        knight.specialAttack(goblin);
        System.out.println(goblin);

        knight.defend();
        System.out.println(knight);
    }
}
