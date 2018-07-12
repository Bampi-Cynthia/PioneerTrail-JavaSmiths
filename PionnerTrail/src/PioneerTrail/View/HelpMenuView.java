
package PioneerTrail.View;

import java.util.Scanner;

/*
 * @author Cynthia
 */
public class HelpMenuView extends View{

    public HelpMenuView() {
   super(
           "===============================\n"
         + "            Help Menu          \n"
         + "===============================\n"
         + "G - What is the goal of the game?\n"
         + "M - How to move\n"
         + "E - Estimate the number of resources\n"
         + "H - Harvest resources\n"
         + "Q - Quit\n" 
         + "Please, Make a choice:\n");
    }
    

    
//    public void display() {
//        boolean endOfView = false;
//        String inputs;
//        do {
//            inputs = this.getInputs();
//            if (inputs == null || inputs.length() < 1 || inputs.toUpperCase().equals("Q")) {
//                return;
//            }
//
//            endOfView = doAction(inputs);
//        } while (endOfView != true);
//
//    }

//    private String[] getInputs() {
//        Scanner scan;
//        scan = new Scanner(System.in);
//
//        String[] inputs = new String[1];
//        System.out.println(
//                "===============================\n"
//                + "            Help Menu          \n"
//                + "===============================\n"
//                + "G - What is the goal of the game?\n"
//                + "M - How to move\n"
//                + "E - Estimate the number of resources\n"
//                + "H - Harvest resources\n"
//                + "Q - Quit\n");
//    }
        
//      boolean valid = false;
//        while (valid == false) {
//            System.out.println("Please, enter your choice");
//            inputs = scan.nextLine();
//            inputs = inputs.trim();
//            if (inputs.length() < 1) {
//                System.out.println("You must enter a non-blank value");
//                continue;
//            }
//            valid = true;
//        }
//      return inputs;
//
//  }
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
            case "E":
                estimateResources();
                break;
            case "H":
                harvestResources();
            case "Q":
                return true;
            default:
                ErrorView.display(this.getClass().getName(), "Select between the menu choices");
                break;
        }
        return false;
    }

    private void description() {
        System.out.println("Description selected");
    }

    private void howToMove() {
        System.out.println("Just move it!!");
    }

    private void estimateResources() {
        System.out.println("Count them with an abacus");
    }

    private void harvestResources() {
        System.out.println("In some locations, you will be able to harvest resources of any kind");
    }
}
