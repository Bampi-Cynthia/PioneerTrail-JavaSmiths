
package PioneerTrail.control;

import PioneerTrail.exceptions.GameControlException;
import PioneerTrail.model.Game;
import PioneerTrail.model.Map;
import PioneerTrail.model.Player;
import PioneerTrail.model.Resource;
import PioneerTrail.model.Wagon;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
        Wagon wagon = new Wagon();
        wagon.setCapacity(500);
        wagon.setCurrentWeight(50);
        wagon.setIntegrity(100);
        wagon.setIntegrityLabel("Perfect!");
        wagon.setWheelsCount(5);
        game.setWagon(wagon);
        game.setPlayer(player);// save player in game.
        PioneerTrail.setCurrentGame(game);
        //reference to the setResources method
        game.setResources(ResourceControl.createResourceList());        
        //reference to the createMap method.
        game.setMap(MapControl.createMap(5, 5));
       
    }
    public static void saveGame(Game game, String fileName) throws GameControlException{
        
          try(FileOutputStream fops = new FileOutputStream(fileName)) {
           ObjectOutputStream output = new ObjectOutputStream(fops);
           
           output.writeObject(game); //write the game object out to file
       }
       catch(Exception e) {
           throw new GameControlException(e.getMessage());
       }
    }
    
  public static void getSavedGame(String filePath) 
                       throws GameControlException {
       Game game = null;
       try( FileInputStream fips = new FileInputStream(filePath)) {
           ObjectInputStream input = new ObjectInputStream(fips);
           
           game = (Game) input.readObject();//read the game object from file
       }
       catch (Exception e) {
           throw new GameControlException(e.getMessage());
       }
       //close the output file
       PioneerTrail.setCurrentGame(game);//save Game
       }

}

        