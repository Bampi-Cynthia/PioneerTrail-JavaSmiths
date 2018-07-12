/*
 * SUPER CLASS VIEW
 */
package PioneerTrail.View;

import java.io.BufferedReader;
import java.io.PrintWriter;
import pionnertrail.PioneerTrail;

/**
 * @author Elías
 */
public abstract class View implements ViewInterface {

    protected String promptMessage;

    protected final BufferedReader keyboard = PioneerTrail.getInFile();
    protected final PrintWriter console = PioneerTrail.getOutFile();

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

    public String getInput(String prompt) {
        boolean valid = false;
        String selection = null;
        try {
            //while a valid name has not been retrieved
            while (!valid) {
            
            selection = this.keyboard.readLine();
            selection = selection.trim();
            if(prompt != null){
            this.console.println(promptMessage);
            }
            if (selection.length() < 1) { //blank value entered
                ErrorView.display(this.getClass().getName(), "You must enter a valid name");
                continue;
            }
            break;
            }
        } catch (Exception e) {
            System.out.println("Error readin input: " + e.getMessage());
        }
        return selection;//return the name
    }
//        String input = "";
//        boolean valid = false;
//        while (valid == false) {
//            System.out.println(promptMessage);
//            input = scan.nextLine();
//            input = input.trim();
//            if (input.length() < 1) {
//                System.out.println("You must enter a non-blank value");
//                continue;
//            }
//            valid = true;
//        }
//        return input;
  }
