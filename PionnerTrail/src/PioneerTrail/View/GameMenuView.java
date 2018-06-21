
package PioneerTrail.View;
import PioneerTrail.model.Actor;

/**
 * @author Elías
 */
class GameMenuView extends View{

    public GameMenuView() {
        super(
                  "===============================\n"
                + "            Game Menu          \n"
                + "===============================\n"
                + "V - View Map\n"
                + "R - View Resources\n"
                + "A - View Actors\n"        
                + "H - Get help on how to play the game\n"
                + "E - Exit\n"
                + "Please, make your choice");
    }
    
//    public void display() {
//        boolean endOfView = false;
//        String[] inputs;
//        do {
//            inputs = this.getInputs();
//            if (inputs[0] == null || inputs[0].length() < 1 || inputs[0].toUpperCase().equals("Q")) {
//                return;
//            }
//
//            endOfView = doAction(inputs);
//        } while (endOfView != true);
//
//    }
//
//    private String[] getInputs() {
//        Scanner scan;
//        scan = new Scanner(System.in);
//
//        String[] inputs = new String[1];
//        System.out.println(
//                "===============================\n"
//                + "            Game Menu          \n"
//                + "===============================\n"
//                + "V - View Map\n"
//                + "R - View Resources\n"
//                + "A - View Actors\n"        
//                + "H - Get help on how to play the game\n"
//                + "E - Exit");
//
//        boolean valid = false;
//        while (valid == false) {
//            System.out.println("Please, enter your choice");
//            inputs[0] = scan.nextLine();
//            inputs[0] = inputs[0].trim();
//            if (inputs[0].length() < 1) {
//                System.out.println("You must enter a non-blank value");
//                continue;
//            }
//            valid = true;
//        }
//        return inputs;
//
//    }
    @Override
    public boolean doAction(String inputs) {

        String menuItem = inputs.toUpperCase();
        switch (menuItem) {
            case "V":
                ViewMap();
                break;
            case "R":
                ViewResources();
                break;
            case "H":
                getHelp();
                break;
            case "A":
                ViewActors();
                break;
            case "E":
                return true;
            default:
                System.out.println("Invalid menu item");
                break;
        }
        return false;
    }

    private void ViewMap() {
        MapMenuView mapMenuView = new MapMenuView();
        mapMenuView.display();
    }

    private void ViewResources() {
        ResourceView resourceView = new ResourceView();
        resourceView.display();
    }
    
        private void getHelp() {
        System.out.println("GetHelp selected");
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

    private void ViewActors() {
        for (Actor actor : Actor.values()) {
            System.out.println(actor);
        }
    }
}
