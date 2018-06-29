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
        return null;
    }

    public static Scene[] createScenes() {
        return null;
    }

    public static Question[] createQuestions() {
        return null;
    }

    public static void assignQuestionsToScenes(Question[] questions,
Scene[] scenes) {

    }

    public static void assignItemsToScenes(Scene[] scenes) {
        ArrayList<Resource> items = PioneerTrail.getCurrentGame().getResources();
    }

    public static void assignScenesToLocations(Scene[] scenes,
Location[][] locations) {

    }
}
