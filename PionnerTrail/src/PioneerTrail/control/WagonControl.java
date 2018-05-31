/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PioneerTrail.control;

import PioneerTrail.model.Resource;
import PioneerTrail.model.Wagon;

/**
 *
 * @author Elías
 */
public class WagonControl {
    
    public static int addtoWagon(Wagon wagon, Resource resource){
        
        if(wagon.getCurrentWeight() >= wagon.getCapacity()){
        return -1;
        }
        if(resource.getQuantity() < 1){
        return -2;
        }
        if(resource.getWeight() < 1){
        return -3;
        }
        if(resource.getQuantity() * resource.getWeight() + wagon.getCurrentWeight() >= wagon.getCapacity()){
        return -4;
        }
        return (resource.getQuantity() * resource.getWeight() + wagon.getCurrentWeight());
    }
    
}
