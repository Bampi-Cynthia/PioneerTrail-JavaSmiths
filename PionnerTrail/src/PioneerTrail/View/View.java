/*
 * SUPER CLASS VIEW
 */
package PioneerTrail.View;
import java.util.Scanner;

/**
 * @author Elías
 */
public abstract class View implements ViewInterface {

    protected String promptMessage;

    public View() {
    }

    public View(String menuPrompt) {
        this.promptMessage = menuPrompt;
    }

    @Override
    public void display() {
        boolean endOfView = false;
        String inputs;
        do {
            inputs = this.getInputs();
            if (inputs == null || inputs.length() < 1 || inputs.toUpperCase().equals("E")) {
                return;
            }

            endOfView = doAction(inputs);
        } while (endOfView != true);

    }

    @Override
    public String getInputs() {
        return getInput(promptMessage);
    }

    @Override
    public String getInput(String promptMessage) {
        Scanner scan;
        scan = new Scanner(System.in);
        String input = "";
        boolean valid = false;
        while (valid == false) {
            System.out.println(promptMessage);
            input = scan.nextLine();
            input = input.trim();
            if (input.length() < 1) {
                System.out.println("You must enter a non-blank value");
                continue;
            }
            valid = true;
        }
        return input;
    }
}
