/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PioneerTrail.control;

import PioneerTrail.model.Resource;

/**
 * @author Cynthia
 */
public class ResourceControl {
    
    Resource test0 = new Resource("food",10,"flour",5);
    Resource test1 = new Resource("tool",1,"hammer",2);
    Resource test2 = new Resource("part",1,"Wagon Wheel",10);
    
    Resource[] resourcelist = {test0, test1, test2};
    
    public Resource[] sendList(){
        return resourcelist;
    }
}

   