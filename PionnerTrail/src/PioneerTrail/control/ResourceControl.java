
package PioneerTrail.control;

import PioneerTrail.model.Resource;
import java.util.ArrayList;

/**
 * @author Cynthia
 */
public class ResourceControl {
    public static  ArrayList<Resource> createResourceList(){
    
    ArrayList<Resource> resources = new ArrayList<>();  
    // resource(itemType,quanity,name,weight)
    Resource test0 = new Resource("food",10,"flour",5);
    Resource test1 = new Resource("tool",1,"hammer",2);
    Resource test2 = new Resource("part",1,"Wagon Wheel",10);
    resources.add(test0);
    resources.add(test1);
    resources.add(test2);
    return resources;
    
   // Resource[] resourcelist = {test0, test1, test2};
    }
    
    public static  void sortWeight(){
        ArrayList<Resource> sortedResources = new ArrayList<>();
        sortedResources = createResourceList();
        for (Resource e: sortedResources ) {
            System.out.println( "\n\tName"+ e.getName());
        }
    }
//    public Resource[] sendList(){
//        return resourcelist;
//    }
}

   