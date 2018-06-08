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
public class StartProgramView {

    public StartProgramView() {
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
        System.out.println("***Welcome to Pionner Trail***\"\\t\" In this game you will lead a pioneer wagon through the plains of USA in the second half of the XIX century");
        boolean valid = false;
        while (valid == false) {
            System.out.println("Please, enter your name");
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
        System.out.println("***doAction() called ***");
        System.out.println("\tinputs = " + inputs[0]);
        return true;
    }
}
