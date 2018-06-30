package PioneerTrail.control;

import PioneerTrail.model.Location;
import java.awt.Point;
import PioneerTrail.model.Map;
import PioneerTrail.model.Question;
import PioneerTrail.model.Resource;
import PioneerTrail.model.Scene;
import java.util.ArrayList;
import pionnertrail.PioneerTrail;

/**
 *
 * @author Cynthia Bampi
 */
public class MapControl {

    Map map = new Map();

    public String move(Point newCourse) {
        Point currentCoord = map.getCoordinates();

        if (newCourse == currentCoord) {
            return "You are already at this location";
        } else {
            map.setCoordinates(newCourse);
            return "You are now at " + newCourse;
        }
    }

    public Point getCurrentLoction() {
        map.setCoordinates(1, 3); //testing purposes
        return map.getCoordinates();
    }

    public static Map createMap(int noOfRows, int noOfColumns) {
        if (noOfRows <= 0 || noOfColumns <= 0) {
            return null;
        };

        Map map = new Map();
        map.setRowCount(noOfRows);
        map.setColumnCount(noOfColumns);
        Location[][] locations = createLocations(noOfRows, noOfColumns);
        Scene[] scenes = createScenes();
        Question[] questions = createQuestions();
        assignQuestionsToScenes(questions, scenes);
        assignItemsToScenes(scenes);
        assignScenesToLocations(scenes, locations);

        System.out.println("You have called the createMap method");
        return map;
    }

    public static Location[][] createLocations(int noOfRows, int noOfColumns) {
        System.out.println("Create Locations called");

        if (noOfRows < 1 || noOfColumns < 1) {
            return null;
        }
        Location[][] locations = new Location[noOfRows][noOfColumns];
        //NAVIGATE A TWO DIMENSIONAL ARRAY

        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < noOfColumns; col++) {
                locations[row][col] = new Location();
            }
        }   
        //Assign location to the row, and column in array
        //ENDFOR
        //RETURN locations
        //}
        return locations;
    }

    public static Scene[] createScenes() {
        System.out.println("Create Scenes called");
        return null;
    }

    public static Question[] createQuestions() {
        System.out.println("Create Questions called");
        return null;
    }

    public static void assignQuestionsToScenes(Question[] questions,
            Scene[] scenes) {
        System.out.println("Assign Questions to Scenes called");
    }

    public static void assignItemsToScenes(Scene[] scenes) {
        ArrayList<Resource> items = PioneerTrail.getCurrentGame().getResources();
        System.out.println("Assign Items to Scenes called");
    }

    public static void assignScenesToLocations(Scene[] scenes,
            Location[][] locations) {
        System.out.println("Assign Scenes to Locations called");
    }
}
