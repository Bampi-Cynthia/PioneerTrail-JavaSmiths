
package PioneerTrail.model;
import java.io.Serializable;

/**
 * @author Isaias
 */

public enum Actor implements Serializable{

    Father("Johnson", "The father of the family, and leader of the Wagon", 5, 0),
    Mother("Ms. Johnson", "The mother of the family, and Queen of the Wagon", 5, 0),
    John("John", "The firstborn of the Jhonson family, and his brother's hero", 5, 0),
    Maria("Maria", "The second child of the Jhonson family, and princess of the Wagon", 5, 0),
    Jimmy("Jimmy","The last child of the Johnson family, he likes to play", 5, 1);

    private final String name;
    private final String description;
    private int health;
    private int hunger;

Actor(String name, String description, int health, int hunger){
this.name = name;
this.description = description;
this.health = health;
this.hunger = hunger;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    @Override
    public String toString() {
        return "Actor{" + "name=" + name + ", description=" + description + ", health=" + health + ", hunger=" + hunger + '}';
    }

}
    
