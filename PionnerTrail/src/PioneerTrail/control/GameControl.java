
package PioneerTrail.control;

import PioneerTrail.model.Game;
import PioneerTrail.model.Player;
import pionnertrail.PioneerTrail;


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
        PioneerTrail.setPlayer(player); 
        return player;
    }
    public static void createNewGame(){
        System.out.println("***Create New Game called***");
        Game game = new Game();
        PioneerTrail.setCurrentGame(game);
    }  
}
