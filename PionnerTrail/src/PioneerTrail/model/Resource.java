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
    
    private String inventoryType;
    private int quantity;
    private String name;
    private int weight;
//relationships with other classes
  //  private Wagon wagon;//Brother Jones said we can rid of it
  //  private ArrayList<Scene>scenes = new ArrayList<Scene>();//Brother Jones said we can rid of it
// default constructor
    public Resource(String inventoryType, int quantity,String name,int weight ){
        this.inventoryType =  inventoryType;
        this.quantity = quantity;
        this.name = name;
        this.weight = weight;
}

    public Resource() {
    }

    public String getInventoryType() {
        return inventoryType;
    }

//    public Wagon getWagon() {
//        return wagon;
//    }
//
//    public void setWagon(Wagon wagon) {
//        this.wagon = wagon;
//    }
//
//    public ArrayList<Scene> getScenes() {
//        return scenes;
//    }
//
//    public void setScenes(ArrayList<Scene> scenes) {
//        this.scenes = scenes;
//    }

    public void setInventoryType(String inventoryType) {
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
