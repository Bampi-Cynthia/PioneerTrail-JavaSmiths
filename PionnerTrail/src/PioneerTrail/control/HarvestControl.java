/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PioneerTrail.control;

import PioneerTrail.model.Player;

/**
 *
 * @author Cynthia
 */
public class HarvestControl {
 
    public static int calculateWood( Player player, int initialWood, float consumedWood, int maxWood) {
        
        if (initialWood<10) {
            return -1;       
        }
          if (player.getTotalDistTraveled() <2) {
              return -2;
          }  
          if (player.getTotalDistTraveled() > consumedWood * 2){
              return -3;
          }
           if (initialWood > maxWood) {
               return -4;
           } 
        return (int) (initialWood - consumedWood);
        
    }
}
