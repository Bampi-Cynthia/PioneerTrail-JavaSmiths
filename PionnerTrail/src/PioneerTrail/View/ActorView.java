/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PioneerTrail.View;
import PioneerTrail.model.Actor;
/**
 *
 * @author Cynthia
 */
public class ActorView extends View{

    public ActorView() {
      promptMessage = getActorString();
    }
    private String getActorString() {
        String myActors = "===============================\n" 
            + "            Actor Menu          \n"
           +"===============================\n ";
        int count = 1;
        for (Actor actor: Actor.values()){
        myActors+=count + " - " + actor.getName() + " \n ";
        count ++; 
        }
        myActors += "E - Exit\n"
            + "Please, make your choice\n";
        return myActors;
    }
    @Override
    public boolean doAction(String inputs) {

       int selection = Integer.parseInt(inputs);
        if (selection > 0 && selection <= Actor.values().length){
            viewActor(selection - 1);
        }
        
        return false;
    }

    private void viewActor(int selection) {
        Actor actor = Actor.values()[selection];
    
     System.out.println("name = "+actor.getName());
     System.out.println("description = "+actor.getDescription());
     System.out.println("health = "+actor.getHealth());
     System.out.println("hunger = "+actor.getHunger());
    }

}
