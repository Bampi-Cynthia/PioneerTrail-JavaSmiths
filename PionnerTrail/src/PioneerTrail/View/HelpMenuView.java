/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PioneerTrail.View;

import java.util.Scanner;

/**
 *
 * @author Elías
 */
class HelpMenuView {

    public HelpMenuView() {
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
                + "            Help Menu          \n"
                + "===============================\n"
                + "G - What is the goal of the game?\n"
                + "M - How to move\n"
                + "E - Estimate the number of resources\n"
                + "H - Harvest resources\n"
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
                System.out.println("Invalid help menu item");
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
