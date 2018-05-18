/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pionnertrail;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Isaias
 */
public class Location implements Serializable{
    //atributes
    private int column;
    private int row;
    private String visited;
    //relationships between classes
    private Wagon wagon;
    private Scene scene;
    private Map map;
    // default constructor
    public Location(){
    }
    // setter and getter

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

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    
    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getVisited() {
        return visited;
    }

    public void setVisited(String visited) {
        this.visited = visited;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.column;
        hash = 43 * hash + this.row;
        hash = 43 * hash + Objects.hashCode(this.visited);
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
        final Location other = (Location) obj;
        if (this.column != other.column) {
            return false;
        }
        if (this.row != other.row) {
            return false;
        }
        if (!Objects.equals(this.visited, other.visited)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "column=" + column + ", row=" + row + ", visited=" + visited + '}';
    }
    
}
