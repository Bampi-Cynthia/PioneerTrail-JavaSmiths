/*
SAVE GAME VIEW CLASS
 */
package PioneerTrail.View;

import PioneerTrail.control.GameControl;
import PioneerTrail.exceptions.GameControlException;
import PioneerTrail.model.Game;
import pionnertrail.PioneerTrail;

/**
 * @author Elías
 */
public class SaveGameView extends View {

    public SaveGameView() {
        super("Enter the name of you file");
    }

    @Override
    public boolean doAction(String inputs) {
        String filePath = inputs;
        Game game = PioneerTrail.getCurrentGame();
        try {
            GameControl.saveGame(game, filePath);
        } catch (GameControlException ge) {
            ErrorView.display(this.getClass().getName(), ge.getMessage() + ". Unable to save the game into " + filePath);
            return false;
        }

        console.println("You saved the game");
        return true;
    }
}
