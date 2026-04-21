package tp4.exo2.dev;

public class GameCharacter {
    private String name;
    private int health;
    private int power;

    public GameCharacter(String name, int health, int power) {
        this.name = name;
        this.health = health;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String toString() {
        return "Character | " + name + " | HP: " + health + " | Power: " + power;
    }
}
