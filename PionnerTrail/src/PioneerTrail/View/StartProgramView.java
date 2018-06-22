package PioneerTrail.View;

import PioneerTrail.control.GameControl; // experimenting
import PioneerTrail.model.Player; // experimenting

/**
 * @author Elías
 */
public class StartProgramView extends View {

    public StartProgramView() {
        super("***Welcome to Pionner Trail***\n"
            + "***In this game you will lead a pioneer wagon***\n"
            + "***through the plains of USA in the second half of the XIX Century*** \n"
            + "***Please, enter your name: \n");
    }

    @Override
    public boolean doAction(String inputs) {
        String playersName = inputs;
        Player player = GameControl.savePlayer(playersName);
        //System.out.println("***\"Save game is not implemented yet.\"***");
        System.out.println(
                  "===============================\n "
                + "Welcome to the game " + playersName.toUpperCase()
                + "\n We hope you have a lot of fun!\n"
                + "===============================\n"
        );
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.display();
        return true;
    }
}
