/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PioneerTrail.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Isaias
 */
public class Player implements Serializable{
    //class instance variables
    private String name;
    private double bestScore;
    private double totalDistTraveled;
    private int health;
    //relationships between classes
    private ArrayList<Game> games = new ArrayList<Game>();
    private Actor actor;
    // default constructor
    public Player() {
    }
    // setter and getter
    
    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
    
    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBestScore() {
        return bestScore;
    }

    public void setBestScore(double bestScore) {
        this.bestScore = bestScore;
    }

    public double getTotalDistTraveled() {
        return totalDistTraveled;
    }

    public void setTotalDistTraveled(double totalDistTraveled) {
        this.totalDistTraveled = totalDistTraveled;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.name);
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.bestScore) ^ (Double.doubleToLongBits(this.bestScore) >>> 32));
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.totalDistTraveled) ^ (Double.doubleToLongBits(this.totalDistTraveled) >>> 32));
        hash = 43 * hash + this.health;
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
        final Player other = (Player) obj;
        if (Double.doubleToLongBits(this.bestScore) != Double.doubleToLongBits(other.bestScore)) {
            return false;
        }
        if (Double.doubleToLongBits(this.totalDistTraveled) != Double.doubleToLongBits(other.totalDistTraveled)) {
            return false;
        }
        if (this.health != other.health) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", bestScore=" + bestScore + ", totalDistTraveled=" + totalDistTraveled + ", health=" + health + '}';
    }
    
}