
package PioneerTrail.View;

import PioneerTrail.control.GameControl;

/**
 * @author Elías
 */

public class MainMenuView extends View{
    
    public MainMenuView(){
        super("===============================\n"
            + "            Main Menu          \n"
            + "===============================\n"
            + "N - Start new game\n"
            + "R - Restart existing game\n"
            + "H - Get help on how to play the game\n"
            + "E - Exit \n"
            + "Please, make a choice: \n");
    }
    
    @Override
    public boolean doAction(String inputs) {

        String menuItem = inputs.toUpperCase();
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
        GameControl.createNewGame();
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display();
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
