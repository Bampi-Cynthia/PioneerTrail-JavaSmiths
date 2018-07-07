package PioneerTrail.View;

import PioneerTrail.model.Actor;
import PioneerTrail.model.ItemType;
import PioneerTrail.model.Resource;
import PioneerTrail.model.Scene;
import PioneerTrail.View.ActorView;
import PioneerTrail.control.WagonControl;
import PioneerTrail.exceptions.WagonControlException;
import PioneerTrail.model.Wagon;
import java.util.ArrayList;
import pionnertrail.PioneerTrail;

/**
 * @author Elías and Cynthia
 */
class GameMenuView extends View {

    public GameMenuView() {
        super("===============================\n"
                + "            Game Menu          \n"
                + "===============================\n"
                + "V - View Map\n"
                + "R - View Resources\n"
                + "A - View Actors\n"
                + "T - Test Wagon Weight\n"
                + "S - View Scene\n"
                + "H - Get help on how to play the game\n"
                + "E - Exit\n"
                + "Please, make your choice");
    }

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
            case "T":
                testWagonWeight();
                break;
            case "S":
                viewScene();
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
        ActorView actorView = new ActorView();
        actorView.display();
    }

    private void viewScene() {
        Scene scene = new Scene();
        scene.setName("Navoo");
        scene.setSymbol("NA");
        scene.setDescription("This is a beautifull town with a temple in construction");
        Resource resource = new Resource();
        resource.setName("knife");
        resource.setInventoryType(ItemType.weapon);
        resource.setQuantity(1);
        resource.setWeight(3);
        scene.setResource(resource);
        SceneView sceneView = new SceneView(scene);
        sceneView.display();
    }

    private void testWagonWeight() {
        Wagon wagon = PioneerTrail.getCurrentGame().getWagon();
        ArrayList<Resource> resources = PioneerTrail.getCurrentGame().getResources();
        Resource resource = resources.get(0);
        int result = 0;
        try {
            result = WagonControl.calculateWagonCurrentWeight(wagon, resource);
        } catch (WagonControlException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Unable to add resource");
            result = -1;
            //Logger.getLogger(WagonControlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result >= 0) {
            System.out.println("Wagon weight = " + wagon.getCurrentWeight());
            System.out.println("You can add " + resource.getName() + "with a weight of " + resource.getWeight() * resource.getQuantity());
        }
    }
}
