package PioneerTrail.View;

import PioneerTrail.control.GameControl; // experimenting
import PioneerTrail.exceptions.GameControlException;
import PioneerTrail.model.Player; // experimenting
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            Player player = GameControl.savePlayer(playersName);
        } catch (GameControlException ex) {
            Logger.getLogger(StartProgramView.class.getName()).log(Level.SEVERE, null, ex);
        }
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
