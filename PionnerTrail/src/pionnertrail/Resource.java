/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pionnertrail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Cynthia Bampi
 */
public class Resource implements Serializable {
    
    private String[] inventoryType;
    private int quantity;
    private int requireAmount;
    private String name;
    private int weight;
//relationships with other classes
    private Wagon wagon;
    private ArrayList<Scene>scenes = new ArrayList<Scene>();
// default constructor
    public Resource(){
}

    public String[] getInventoryType() {
        return inventoryType;
    }

    public Wagon getWagon() {
        return wagon;
    }

    public void setWagon(Wagon wagon) {
        this.wagon = wagon;
    }

    public ArrayList<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(ArrayList<Scene> scenes) {
        this.scenes = scenes;
    }

    public void setInventoryType(String[] inventoryType) {
        this.inventoryType = inventoryType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRequireAmount() {
        return requireAmount;
    }

    public void setRequireAmount(int requireAmount) {
        this.requireAmount = requireAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Arrays.deepHashCode(this.inventoryType);
        hash = 89 * hash + this.quantity;
        hash = 89 * hash + this.requireAmount;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + this.weight;
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
        final Resource other = (Resource) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (this.requireAmount != other.requireAmount) {
            return false;
        }
        if (this.weight != other.weight) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Arrays.deepEquals(this.inventoryType, other.inventoryType);
    }

    @Override
    public String toString() {
        return "Resource{" + "inventoryType=" + inventoryType + ", quantity=" + quantity + ", requireAmount=" + requireAmount + ", name=" + name + ", weight=" + weight + '}';
    }
    
}
