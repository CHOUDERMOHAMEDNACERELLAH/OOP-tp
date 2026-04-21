package tp4.exo2.simple;

public class Warrior extends GameCharacter {
    private int armor;
    private int rageLevel;

    public Warrior(String name, int health, int power, int armor, int rageLevel) {
        super(name, health, power);
        this.armor = armor;
        this.rageLevel = rageLevel;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getRageLevel() {
        return rageLevel;
    }

    public void setRageLevel(int rageLevel) {
        this.rageLevel = rageLevel;
    }

    public void specialAttack(GameCharacter target) {
        int damage = getPower() + rageLevel;
        int newHealth = target.getHealth() - damage;
        target.setHealth(newHealth < 0 ? 0 : newHealth);
        System.out.println(getName() + " special attacks " + target.getName() + " for " + damage + " damage!");
    }

    public void defend() {
        int block = armor / 2;
        setHealth(getHealth() + block);
        System.out.println(getName() + " defends and recovers " + block + " HP. Health: " + getHealth());
    }

    public String toString() {
        return "Warrior [name=" + getName() + ", health=" + getHealth() + ", power=" + getPower()
                + ", armor=" + armor + ", rageLevel=" + rageLevel + "]";
    }
}
