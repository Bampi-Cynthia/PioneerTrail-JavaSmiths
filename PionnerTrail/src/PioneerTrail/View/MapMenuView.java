package PioneerTrail.View;

import java.util.Scanner;
import PioneerTrail.control.MapControl;

/**
 *
 * @author Cynthia
 */
public class MapMenuView {
    
public MapMenuView() {
 }

    public void display() {
        boolean endOfView = false;
        String[] inputs;
        do {
            inputs = this.getInputs();
            if (inputs[0] == null || inputs[0].length() < 1 || inputs[0].toUpperCase().equals("Q")) {
                return;
            }

            endOfView = doAction(inputs);
        } while (endOfView != true);

    }
    
       private String[] getInputs() {
        Scanner scan;
        scan = new Scanner(System.in);

        String[] inputs = new String[1];
        System.out.println(
                "===============================\n"
                + "            Map Menu          \n"
                + "===============================\n"
                + "C - What is the goal of the game?\n"
                + "M - How to move\n"
                + "Q - Quit");

        boolean valid = false;
        while (valid == false) {
            System.out.println("Please, enter your choice");
            inputs[0] = scan.nextLine();
            inputs[0] = inputs[0].trim();
            if (inputs[0].length() < 1) {
                System.out.println("You must enter a non-blank value");
                continue;
            }
            valid = true;
        }
        return inputs;

    }

    private boolean doAction(String[] inputs) {

        String menuItem = inputs[0].toUpperCase();
        switch (menuItem) {
            case "C":
                getCurrentLocation();
                break;
            case "M":
                moveToNewLocation();
                break;
            case "Q":
                return true;
            default:
                System.out.println("Invalid map menu item");
                break;
        }
        return false;
    }

    private void getCurrentLocation() {
        MapControl. getCurrentLoction();
    }

    private void moveToNewLocation() {
        
    }
    
    
}
