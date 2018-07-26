package PioneerTrail.View;

import java.util.Scanner;

/*
 * @author Cynthia
 */
public class HelpMenuView extends View {

    public HelpMenuView() {
        super(
                "===============================\n"
                + "            Help Menu          \n"
                + "===============================\n"
                + "G - What is the goal of the game?\n"
                + "M - How to move\n"
                + "R - Estimate the number of resources\n"
                + "H - Harvest resources\n"
                + "E - Exit\n"
                + "Please, Make a choice:\n");
    }

    @Override
    public boolean doAction(String inputs) {

        String menuItem = inputs.toUpperCase();
        switch (menuItem) {
            case "G":
                description();
                break;
            case "M":
                howToMove();
                break;
            case "R":
                estimateResources();
                break;
            case "H":
                harvestResources();
            case "E":
                return true;
            default:
                ErrorView.display(this.getClass().getName(), "Select between the menu choices");
                break;
        }
        return false;
    }

    private void description() {
        System.out.println("In this game you will drive a Pioneer Wagon through the plains of USA, moving through a map, and harvesting resources in different scenes.");
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

    private void howToMove() {
        System.out.println("You will be albe to move in the map to a new Location!!");
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

    private void estimateResources() {
        System.out.println("Count them with an abacus");
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

    private void harvestResources() {
        System.out.println("In some locations, you will be able to harvest resources of any kind");
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }
}
