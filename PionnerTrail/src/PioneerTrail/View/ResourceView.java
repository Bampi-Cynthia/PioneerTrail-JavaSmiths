/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PioneerTrail.View;

import PioneerTrail.model.Resource;
import PioneerTrail.control.ResourceControl;

import java.util.Scanner;

/**
 *
 * @author Cynthia
 */
public class ResourceView {
    
    public ResourceView() {
        
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
                + "            Resource Menu          \n"
                + "===============================\n"
                + "D - Display Resource List\n"    
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
            case "D":
               displayResourceList();
                break;
            default:
                System.out.println("Invalid map menu item");
                break;
        }
        return false;
    }

    private void displayResourceList() {
        //Resource[] list = sendList();
    }
}
   

    
    



