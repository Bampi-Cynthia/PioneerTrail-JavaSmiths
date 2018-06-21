/*
 * VIEW INTERFACE CLASS
 */
package PioneerTrail.View;

/**
 * @author Elías
 */
public interface ViewInterface {
    public void display();
    public String getInputs();
    public String getInput(String promptMessage);
    public boolean doAction(String inputs);
}
