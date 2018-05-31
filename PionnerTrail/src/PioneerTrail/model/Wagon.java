/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PioneerTrail.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Cynthia
 */
public class Wagon implements Serializable {
    //attributes
    private String integrity;
    private int wheelsCount;
    private int capacity;
    private int currentWeight; //I added this new attribute, and created getter and setter for it.

    //default constructor
    public Wagon(){   
        
}
     
    public String getIntegrity() {
        return integrity;
    }

    public void setIntegrity(String integrity) {
        this.integrity = integrity;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public void setWheelsCount(int wheelsCount) {
        this.wheelsCount = wheelsCount;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.integrity);
        hash = 19 * hash + this.wheelsCount;
        hash = 19 * hash + this.capacity;
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
        final Wagon other = (Wagon) obj;
        if (this.wheelsCount != other.wheelsCount) {
            return false;
        }
        if (this.capacity != other.capacity) {
            return false;
        }
        if (!Objects.equals(this.integrity, other.integrity)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Wagon{" + "integrity=" + integrity + ", wheelsCount=" + wheelsCount + ", capacity=" + capacity + '}';
    }
     
}