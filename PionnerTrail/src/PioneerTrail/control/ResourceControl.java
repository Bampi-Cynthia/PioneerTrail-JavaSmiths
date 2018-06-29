
package PioneerTrail.control;

import PioneerTrail.model.ItemType;
import PioneerTrail.model.Resource;
import java.util.ArrayList;

/**
 * @author Cynthia
 */
public class ResourceControl {
    public static ArrayList<Resource> createResourceList(){
    System.out.println("You have called the createResourceList method");
    
    ArrayList<Resource> resources = new ArrayList<Resource>();  
    
    Resource resource = new Resource(ItemType.food, 10,"flour",5);
    resources.add(resource);
    
    resource = new Resource(ItemType.tools,1,"hammer",2);
    resources.add(resource);
    
    resource = new Resource(ItemType.parts,1,"Wagon Wheel",10);
    resources.add(resource);
    
    return resources;
    }

}

   