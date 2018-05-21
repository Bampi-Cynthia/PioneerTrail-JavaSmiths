
package pionnertrail;

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

   
    public static void main(String[] args) {
         cynthia_test();
    }
    
    public static void cynthia_test(){
        String[] testArray = {"test0","test1"};
        
        //Wagon test
        Wagon wagonOne = new Wagon();
        wagonOne.setIntegrity("test");
        wagonOne.setWheelsCount(4);
        wagonOne.setCapacity(150);
        
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
    }
    
    //Team member test function here
    
}
