
package PioneerTrail.View;

/**
 * @author Cynthia
 */
public class MapMenuView extends View{
    
public MapMenuView() {
    super("===============================\n"
        + "            Map Menu          \n"
        + "===============================\n"
        + "D - Display Map\n"    
        + "M - Move Menu view\n"
        + "Q - Quit\n"
        + "Please, Make a choice:\n");
 }


@Override
    public boolean doAction(String inputs) {

        String menuItem = inputs.toUpperCase();
        switch (menuItem) {
            case "D":
               displayMap(); 
                break;
            case "M":
                moveToNewLocation();
                break;
            default:
                System.out.println("Invalid map menu item");
                break;
        }
        return false;
    }

    private void displayMap() {
       System.out.println("This part will be built along the course ");
    }
    
    private void moveToNewLocation() {
        MoveLocationView movemenu = new MoveLocationView();
        movemenu.display();
    }
}
