/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PioneerTrail.model;

import java.io.Serializable;
/**
 * @author Cynthia Bampi
 */
public class Resource implements Serializable {
    
    private ItemType inventoryType;
    private int quantity;
    private String name;
    private int weight;
    
    public Resource(ItemType inventoryType, int quantity, String name, int weight ){
        this.inventoryType =  inventoryType;
        this.quantity = quantity;
        this.name = name;
        this.weight = weight;
}

    public Resource() {
    }

    public ItemType getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(ItemType inventoryType) {
        this.inventoryType = inventoryType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
    public String toString() {
        return "Resource{" + "inventoryType=" + inventoryType + ", quantity=" + quantity  + ", name=" + name + ", weight=" + weight + '}';
    }
    
}
