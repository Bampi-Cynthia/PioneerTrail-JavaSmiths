
package PioneerTrail.control;

import PioneerTrail.model.Game;
import PioneerTrail.model.Map;
import PioneerTrail.model.Player;
import PioneerTrail.model.Resource;
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
    public static void createNewGame(Player player){
        
        if(player == null)
            return;
        
        Game game = new Game();
        game.setPlayer(player);// save player in game.
        PioneerTrail.setCurrentGame(game);
        //reference to the setResources method
        game.setResources(ResourceControl.createResourceList());        
        //reference to the createMap method.
        game.setMap(MapControl.createMap(5, 5));
       
    }


}

        