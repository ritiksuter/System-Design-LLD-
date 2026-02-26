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


class CharacterFactory {
    private Character prototypeCharacter;

    CharacterFactory() {
        prototypeCharacter = new Character("DefaultName", 100, 50, 1);
    }

    // Create a character by cloning the prototype and changing only the required attributes

    public Character createCharacterWithNewName(String name) throws CloneNotSupportedException {
        Character clonedCharacter = prototypeCharacter.clone();
        clonedCharacter = new Character(name, clonedCharacter.health, clonedCharacter.attackPower, clonedCharacter.level);
        return clonedCharacter;
    }

    public Character createCharacterWithNewLevel(int level) throws CloneNotSupportedException {
        Character clonedCharacter = prototypeCharacter.clone();
        clonedCharacter = new Character(clonedCharacter.name, clonedCharacter.health, clonedCharacter.attackPower, level);
        return clonedCharacter;
    }

    public Character createCharacterWithNewAttackPower(int attackPower) throws CloneNotSupportedException {
        Character clonedCharacter = prototypeCharacter.clone();
        clonedCharacter = new Character(clonedCharacter.name, clonedCharacter.health, attackPower, clonedCharacter.level);
        return clonedCharacter;
    }
}

public class PrototypeWithFactory {
    public static void main(String[] args) throws CloneNotSupportedException {
        CharacterFactory factory = new CharacterFactory();
        Character warrior = factory.createCharacterWithNewName("Warrior");
        Character mage = factory.createCharacterWithNewName("Mage");
        Character knight = factory.createCharacterWithNewLevel(5);

        System.out.println(warrior);
        System.out.println(mage);
        System.out.println(knight);
    }
}