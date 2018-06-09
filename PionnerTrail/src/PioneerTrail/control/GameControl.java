/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PioneerTrail.control;

import PioneerTrail.model.Player;
import pionnertrail.PionnerTrail;

/*
 * @author Elías
 */
public class GameControl {
    public static Player savePlayer(String name){
        if(name == null || name.length() < 1){
        return null;
        }
        Player player = new Player();
        player.setName(name);
        PionnerTrail.setPlayer(player); 
        return player;
    }
    public static void createNewGame(Player player){
        System.out.println("***Create New Game called***");}
}
