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

/**
 *
 * @author tcbam_000
 */
public class PionnerTrail {
    //attributes
    private static Game currentGame = null;
    private static Player player = null;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        PionnerTrail.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        PionnerTrail.player = player;
    }
    //MAIN METHOD OF THE MAIN CLASS
    public static void main(String[] args) {
        
//FROM THE VIEW LAYER
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.display();
    }
    
    public static void cynthia_test() {
        String[] testArray = {"test0", "test1"};

        //Wagon test
        Wagon wagonOne = new Wagon();
        wagonOne.setIntegrityLabel("test");
        wagonOne.setWheelsCount(4);
        wagonOne.setCapacity(150);
        
        System.out.println(wagonOne.getIntegrityLabel());

        System.out.println(wagonOne.getIntegrity());
        System.out.println(wagonOne.getWheelsCount());
        System.out.println(wagonOne.getCapacity());

        System.out.println(wagonOne.toString());

        //Reource test
        Resource resourceOne = new Resource();
        resourceOne.setInventoryType(testArray);
        resourceOne.setQuantity(20);
        resourceOne.setName("Brad");
        resourceOne.setRequireAmount(8);
        resourceOne.setWeight(80);

        System.out.println(resourceOne.getInventoryType());
        System.out.println(resourceOne.getQuantity());
        System.out.println(resourceOne.getName());
        System.out.println(resourceOne.getRequireAmount());
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
        locationOne.setVisited("Yes");

        System.out.println(locationOne.getColumn());
        System.out.println(locationOne.getRow());
        System.out.println(locationOne.getVisited());

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
        Actor actorOne = new Actor();
        //Don't know why the "name" in "setname" doesn't start in capital letter, like this "setName"
        actorOne.setname("Gordon");
        actorOne.setHealth(86);
        actorOne.setHunger(25);

        System.out.println(actorOne.getName());
        System.out.println(actorOne.getHealth());
        System.out.println(actorOne.getHunger());

        System.out.println(actorOne.toString());

        //Game test
        Game gameOne = new Game();
        gameOne.setTotalTime(60);
        gameOne.setMilesTraveled(460);

        System.out.println(gameOne.getTotalTime());
        System.out.println(gameOne.getMilesTraveled());

        System.out.println(gameOne.toString());
    }
}
