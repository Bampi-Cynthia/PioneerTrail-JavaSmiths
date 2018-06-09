/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PioneerTrail.View;

import PioneerTrail.control.GameControl;
import PioneerTrail.model.Game;
import PioneerTrail.model.Player;
import pionnertrail.PionnerTrail;
import java.util.Scanner;

/**
 *
 * @author Elías
 */
class MainMenuView {

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
                + "            Main Menu          \n"
                + "===============================\n"
                + "N - Start new game\n"
                + "R - Restart existing game\n"
                + "H - Get help on how to play the game\n"
                + "E - Exit");

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
            case "N":
                startNewGame();
                break;
            case "R":
                restartGame();
                break;
            case "H":
                getHelp();
                break;
            case "E":
                return true;
            default:
                System.out.println("Invalid menu item");
                break;
        }
        return false;
    }

    private void startNewGame() {
        System.out.println("Start a new Game selected");
        Game game = new Game();
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display();
        GameControl.createNewGame(PionnerTrail.getPlayer());
    }

    private void restartGame() {
        System.out.println("Restart Game selected");
        RestartGameView restartGameView = new RestartGameView();
        restartGameView.display();
    }

    private void getHelp() {
        System.out.println("GetHelp selected");
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }
}
