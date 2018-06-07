/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PioneerTrail.control;

import PioneerTrail.model.Game;
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
        //Individual assignment - Elías Monzón
        public static int calculateFoodAmount(int actorsAlive, int currentFoodAmount, int maxFoodAmount, int actorFoodConsumption){
            
            if(actorsAlive == 0){
                return -1;
            }
            if(currentFoodAmount > maxFoodAmount){
                return -2;
            }
            if(currentFoodAmount < 0){
                return -3;
            }
            if(actorFoodConsumption * actorsAlive > currentFoodAmount){
                return -4;
            }
            
            return (currentFoodAmount - actorFoodConsumption * actorsAlive);
}
        //Individual assignment - Isaias Monzon
        public static int calculateWagonCurrentIntegrity(Wagon wagon, Game game, int maxIntegrity){
        if (wagon.getIntegrity()< 0 || wagon.getIntegrity() > 100){
            return -1;
        }
        if (game.getMilesTraveled() < 0){
            return -2;
        }
        if (game.getMilesTraveled() / 10 > wagon.getIntegrity()){
            return -3;
        }
        if (maxIntegrity < wagon.getIntegrity()){
            return -4;
        }
        return (wagon.getIntegrity() - game.getMilesTraveled() / 10);
        
        }
}
        