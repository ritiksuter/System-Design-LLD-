class Character implements Cloneable {
    public String name;
    public int health;
    public int attackPower;
    public int level;

    public Character(String name, int health, int attackPower, int level) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.level = level;
    }

    @Override
    public Character clone() throws CloneNotSupportedException  {
        return (Character) super.clone();
    }

    public void showCharacterInfo() {
        System.out.println("Character [Name=" + name + ", Health=" + health + ", AttackPower=" + attackPower + ", Level=" + level + "]");
    }
}

public class PrototypePattern {
    public static void main(String[] args) {
        
    }
}