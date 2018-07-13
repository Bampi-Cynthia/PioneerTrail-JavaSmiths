package PioneerTrail.View;

import PioneerTrail.control.GameControl;
import PioneerTrail.exceptions.GameControlException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Elías
 */
class RestartGameView extends View {

    public RestartGameView() {

        super("Enter the game file");
    }

    @Override
    public boolean doAction(String inputs) {
        try {
            GameControl.getSavedGame(inputs);
            GameMenuView gameMenuView = new GameMenuView();
            gameMenuView.display();
            return true;
        } catch (GameControlException ex) {
            Logger.getLogger(RestartGameView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
