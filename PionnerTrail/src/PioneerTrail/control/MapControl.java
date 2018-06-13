package PioneerTrail.control;
import java.awt.Point;
import PioneerTrail.model.Map;

/**
 *
 * @author Cynthia Bampi
 */
public class MapControl {
    
    Map map = new Map();
    
    public String move( Point newCourse) {
        Point currentCoord = map.getCoordinates();
        
        if(newCourse == currentCoord){
            return "You are already at this location";
        }
        
        else{
            map.setCoordinates(newCourse);
            return "You are now at " + newCourse ;
        }
    }
    public Point getCurrentLoction(){
        map.setCoordinates(1,3); //testing purposes
        return map.getCoordinates();
    }
    
} 
