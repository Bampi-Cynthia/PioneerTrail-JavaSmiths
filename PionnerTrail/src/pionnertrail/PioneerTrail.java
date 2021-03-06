package pionnertrail;

import PioneerTrail.View.StartProgramView;
import PioneerTrail.model.Actor;
import PioneerTrail.model.Game;
import PioneerTrail.model.Location;
import PioneerTrail.model.Map;
import PioneerTrail.model.Player;
import PioneerTrail.model.Question;
import PioneerTrail.model.Resource;
import PioneerTrail.model.Scene;
import PioneerTrail.model.Wagon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tcbam_000
 */
public class PioneerTrail {
    //attributes

    private static Game currentGame = null;
    private static Player player = null;
    private static Wagon wagon = null;

    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        PioneerTrail.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        PioneerTrail.inFile = inFile;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        PioneerTrail.currentGame = currentGame;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        PioneerTrail.logFile = logFile;
    }

    public static Player getPlayer() {
        return player;
    }
        
    public static void setPlayer(Player player) {
        PioneerTrail.player = player;
    }

    public static Wagon getWagon() {
        return wagon;
    }

    public static void setWagon(Wagon wagon) {
        PioneerTrail.wagon = wagon;
    }
    
    private static PrintWriter logFile = null;

    //MAIN METHOD OF THE MAIN CLASS
    public static void main(String[] args) {

        try {
            //open character steam files for end user input and output
            PioneerTrail.inFile = new BufferedReader(new InputStreamReader(System.in));

            PioneerTrail.outFile = new PrintWriter(System.out, true);
            logFile = new PrintWriter("logFile.txt");
            //FROM THE VIEW LAYER
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.display();
            return;
            
        } catch (Throwable e) {
            System.out.println("Exception: " + e.toString()
                    + "\nCause: " + e.getCause()
                    + "\nMessage: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (PioneerTrail.inFile != null) {
                    PioneerTrail.inFile.close();
                }
                if (PioneerTrail.outFile != null) {
                    PioneerTrail.outFile.close();
                }
                if (logFile != null) {
                    logFile.close();
                }
            } catch (IOException ex) {
                System.out.println("Error closing files");
                return;
            }
        }
    }

    public static void cynthia_test() {
        String[] testArray = {"test0", "test1"};

        //Wagon test
        Wagon wagonOne = new Wagon();
        wagonOne.setIntegrityLabel("test");
        wagonOne.setWheelsCount(4);

        System.out.println(wagonOne.getIntegrityLabel());

        System.out.println(wagonOne.getIntegrity());
        System.out.println(wagonOne.getWheelsCount());
        System.out.println(wagonOne.getCapacity());

        System.out.println(wagonOne.toString());

        //Reource test
        Resource resourceOne = new Resource();
        //resourceOne.setInventoryType(testArray);
        resourceOne.setQuantity(20);
        resourceOne.setName("Brad");
        //resourceOne.setRequireAmount(8);
        resourceOne.setWeight(80);

        System.out.println(resourceOne.getInventoryType());
        System.out.println(resourceOne.getQuantity());
        System.out.println(resourceOne.getName());
        //System.out.println(resourceOne.getRequireAmount());
        System.out.println(resourceOne.getWeight());

        System.out.println(resourceOne.toString());

        //Player test
        Player playerOne = new Player();
        playerOne.setName("Pedro");
        playerOne.setBestScore(250);
        playerOne.setTotalDistTraveled(645);
        playerOne.setHealth(70);

        System.out.println(playerOne.getName());
        System.out.println(playerOne.getBestScore());
        System.out.println(playerOne.getTotalDistTraveled());
        System.out.println(playerOne.getHealth());

        System.out.println(playerOne.toString());

        //Scene test
        Scene sceneOne = new Scene();
        sceneOne.setDescription("What a lovely place");
        sceneOne.setSymbol("**");
        sceneOne.setName("Sugar Creek");

        System.out.println(sceneOne.getDescription());
        System.out.println(sceneOne.getSymbol());
        System.out.println(sceneOne.getName());

        System.out.println(sceneOne.toString());

        //Location test
        Location locationOne = new Location();
        locationOne.setColumn(4);
        locationOne.setRow(2);
        locationOne.setVisited(true);

        System.out.println(locationOne.getColumn());
        System.out.println(locationOne.getRow());
        System.out.println(locationOne.isVisited());

        System.out.println(locationOne.toString());

        //Map test
        Map mapOne = new Map();
        mapOne.setCoordinates(2, 0);
        mapOne.setRowCount(3);
        mapOne.setColumnCount(2);

        System.out.println(mapOne.getCoordinates());
        System.out.println(mapOne.getRowCount());
        System.out.println(mapOne.getColumnCount());

        System.out.println(mapOne.toString());

        //Question test
        Question questionOne = new Question();
        questionOne.setQuestion("lolo?");
        questionOne.setCorrectAnswer("ARRR!!!!");
        questionOne.setAnswer1("puede ser");
        questionOne.setAnswer2("sin duda");
        questionOne.setAnswer3("no");
        questionOne.setAnswer4("hay lindo tiempo hoy, no?");

        System.out.println(questionOne.toString());

        //Team member test function here
        //Actor test
        //Don't know why the "name" in "setname" doesn't start in capital letter, like this "setName"
        Actor.Father.setHealth(7);
        Actor.Mother.setHealth(9);
        Actor.John.setHealth(5);
        Actor.Maria.setHunger(3);
        Actor.Jimmy.setHunger(0);

        System.out.println(Actor.Father.getHealth());
        System.out.println(Actor.Mother.getHealth());
        System.out.println(Actor.John.getHealth());
        System.out.println(Actor.Maria.getHunger());
        System.out.println(Actor.Jimmy.getHunger());

        //Game test
        Game gameOne = new Game();
        gameOne.setTotalTime(60);
        gameOne.setMilesTraveled(460);

        System.out.println(gameOne.getTotalTime());
        System.out.println(gameOne.getMilesTraveled());

        System.out.println(gameOne.toString());
    }
}
