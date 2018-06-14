
package PioneerTrail.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Isaias
 */

//This class will be a normal Class by now
public class Actor implements Serializable{

    private String name;
    private int health;
    private int hunger;
    //relationships between classes
    private ArrayList<Player> players = new ArrayList<Player>();
    private Game game;
    private Wagon wagon;
    private Scene scene;
    // default constructor
    public Actor(){
    }
    // setter and getter

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Wagon getWagon() {
        return wagon;
    }

    public void setWagon(Wagon wagon) {
        this.wagon = wagon;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
    
    public void setname(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
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
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + this.health;
        hash = 29 * hash + this.hunger;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Actor other = (Actor) obj;
        if (this.health != other.health) {
            return false;
        }
        if (this.hunger != other.hunger) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Actor{" + "name=" + name + ", health=" + health + ", hunger=" + hunger + '}';
    }
    
}
    
