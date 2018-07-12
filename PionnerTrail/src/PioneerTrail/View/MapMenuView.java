package PioneerTrail.View;

import PioneerTrail.model.Game;
import PioneerTrail.model.Location;
import PioneerTrail.model.Map;
import pionnertrail.PioneerTrail;

/**
 * @author Cynthia
 */
public class MapMenuView extends View {

    public MapMenuView() {
        super("===============================\n"
                + "            Map Menu          \n"
                + "===============================\n"
                + "D - Display Map\n"
                + "M - Move To Next Location\n"
                + "P - Print Report\n"
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
                if(!moveToNewLocation())
                    System.out.println("You have arrived at Zion!!");
                break;
            default:
                ErrorView.display(this.getClass().getName(), "Select between the menu choices");
                break;
        }
        return false;
    }

//THIS METHOD DISPLAY THE MAP TO THE USER
    private void displayMap() {
        System.out.println(
                "****************************\n"
                + "******BEHOLD THE MAP!*******\n"
                + "****************************"
        );
        String leftIndicator;
        String rightIndicator;
        Game game = PioneerTrail.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        Location[][] locations = map.getLocations(); // retreive the locations from map
        // Build the heading of the map
        System.out.print("  |");
        for (int column = 0; column < locations[0].length; column++) {
            // print col numbers to side of map
            System.out.print("  " + column + " |");
        }
        // Now build the map.  For each row, show the column information
        System.out.println();
        for (int row = 0; row < locations.length; row++) {
            System.out.print(row + " "); // print row numbers to side of map
            for (int column = 0; column < locations[row].length; column++) {
                // set default indicators as blanks
                leftIndicator = " ";
                rightIndicator = " ";
                if (locations[row][column] == map.getCurrentLocation()) {
                    // Set star indicators to show this is the current location.
                    leftIndicator = "*";
                    rightIndicator = "*";
                } else if (locations[row][column].isVisited()) {
                    // Set < > indicators to show this location has been visited.
                    leftIndicator = ">"; // can be stars or whatever these are indicators showing visited
                    rightIndicator = "<"; // same as above
                }
                System.out.print("|"); // start map with a |
                if (locations[row][column].getScene() == null) {
                    // No scene assigned here so use ?? for the symbol
                    System.out.print(leftIndicator + "??" + rightIndicator);
                } else {
                    System.out.print(leftIndicator
                            + locations[row][column].getScene().getSymbol()
                            + rightIndicator);
                }
            }
            System.out.println("|");
        }
    }

    private boolean moveToNewLocation() {
//        MoveLocationView movemenu = new MoveLocationView();
//        movemenu.display();
        Game game = PioneerTrail.getCurrentGame(); // retreive the game
        Map map = game.getMap();
        int currentRow = map.getCurrentRow();
        int currentColumn = map.getCurrentColumn();

        if (currentColumn < map.getColumnCount() - 1) {
            currentColumn++;
        } else {
            if (currentRow < map.getRowCount() - 1) {
                currentRow++;
                currentColumn = 0;
            } else {
                return false;
            }

        }
        map.getCurrentLocation().setVisited(true);
        map.setCurrentRow(currentRow);
        map.setCurrentColumn(currentColumn);
        displayMap();
        return true;
    }
}
