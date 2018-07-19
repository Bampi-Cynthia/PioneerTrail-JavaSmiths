/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PioneerTrail.View;

import PioneerTrail.model.Actor;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * @author Cynthia
 */
public class ActorReportView extends View {

    public ActorReportView() {
        super("===============================\n"
                + "            Actor Report Menu           \n"
                + "===============================\n "
                + "V - View Actor List\n"
                + "P - Print Actor List\n"
                +"E - Exit\n"
        );

    }

    private String getActorListString() {
        String myActors = "===============================\r\n"
                + String.format("%-12s%10s%10s\r\n", "Name", "Health", "Hunger")
                + "===============================\r\n ";
        int count = 1;
        for (Actor actor : Actor.values()) {
            myActors += String.format("%-12s%10d%10d\r\n", actor.getName(), actor.getHealth(), actor.getHunger());
            //count + " - " + actor.getName() + " \r\n ";
            count++;
        }

        return myActors;
    }

    @Override
    public boolean doAction(String inputs) {
        inputs = inputs.toUpperCase();
        switch (inputs) {
            case "V":
                viewReport();
                break;
            case "P":
                printReport();
                break;
            default:
                System.out.println("invalid choice, try again!");
        }

        return false;
    }

    

    private void viewReport() {
       System.out.println(getActorListString());
    }

    private void printReport() {
        String filename = getInput("Enter the File Name");
        try(PrintWriter out=new PrintWriter(filename)){
            out.println(getActorListString());
            System.out.println("Report saved");
        }
        catch (IOException ex){
            ErrorView.display(this.getClass().getName(),"Error:"+ ex.getMessage());
        }
            
    }

}
