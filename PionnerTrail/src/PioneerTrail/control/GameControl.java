
package PioneerTrail.control;

import PioneerTrail.exceptions.GameControlException;
import PioneerTrail.exceptions.MapControlException;
import PioneerTrail.model.Game;
import PioneerTrail.model.Map;
import PioneerTrail.model.Player;
import PioneerTrail.model.Resource;
import PioneerTrail.model.Wagon;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import pionnertrail.PioneerTrail;


/*
 * @author Elías
 */
public class GameControl {
    public static Player savePlayer(String name) throws GameControlException {
        if(name == null || name.length() < 1){
        throw new GameControlException("You must provide a name");
        }
        Player player = new Player();
        player.setName(name);
        PioneerTrail.setPlayer(player); 
        return player;
    }
    public static void createNewGame(Player player) throws GameControlException{
        
        if(player == null)
            throw new GameControlException("Error creating the player");
        
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
        try {
            //reference to the createMap method.
            game.setMap(MapControl.createMap(5, 5));
        } catch (MapControlException ex) {
            System.out.println(ex.getMessage());
        }
       
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
       try(FileInputStream fips = new FileInputStream(filePath)) {
           ObjectInputStream input = new ObjectInputStream(fips);
           
           game = (Game) input.readObject();//read the game object from file
       }
       catch (Exception e) {
           throw new GameControlException(e.getMessage());
       }
       //close the output file
       PioneerTrail.setCurrentGame(game);//save Game
 }
  //GETGAME METHOD
  public static Game getGame(Game game, String filePath) throws GameControlException{
    if(filePath == null){
        throw new GameControlException("Invalid file path");
    }
    
     try(FileInputStream fips = new FileInputStream(filePath)) {
           ObjectInputStream input = new ObjectInputStream(fips);
           
           game = (Game) input.readObject();//read the game object from file
       }
       catch (Exception e) {
           throw new GameControlException(e.getMessage());
       }
       //close the o       PioneerTrail.setCurrentGame(game);//save Game
       PioneerTrail.setCurrentGame(game);//save Game
// PioneerTrail.setPlayer(game.getPlayer());
 return game;
  }
}

        