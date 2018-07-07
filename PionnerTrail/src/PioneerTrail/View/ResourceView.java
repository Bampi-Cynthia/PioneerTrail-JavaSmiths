package PioneerTrail.View;

import PioneerTrail.control.WagonControl;
import PioneerTrail.exceptions.WagonControlException;
import PioneerTrail.model.Resource;
import PioneerTrail.model.Wagon;
import java.util.ArrayList;
import pionnertrail.PioneerTrail;

/**
 * @author Cynthia
 */
public class ResourceView extends View {
    
    public ResourceView() {
//        super("===============================\n"
//            + "            Resource Menu      \n"
//            + "===============================\n"
//            + "D - Display Resource List\n"    
//            + "Q - Quit \n"
//            + "Please, make your choice");
        promptMessage = getResourceListString();
    }
    
    @Override
    public boolean doAction(String inputs) {
        ArrayList<Resource> resources = PioneerTrail.getCurrentGame().getResources();
        int selection = Integer.parseInt(inputs);
        if (selection < 0 || selection >= resources.size()) {
            System.out.println("Invalid choice");
            return false;
        }
        
        System.out.println("Name: " + resources.get(selection).getName());
        System.out.println("Type: " + resources.get(selection).getInventoryType());
        System.out.println("Quantity: " + resources.get(selection).getQuantity());
        System.out.println("Weight: " + resources.get(selection).getWeight());
        String answer = this.getInput("Do you want to add this to your Wagon?(y/n)");
        if (answer.equalsIgnoreCase(answer)) {
            if(addToWagon(resources.get(selection)))
                  promptMessage = getResourceListString();
        }
        return false;
    }
    
    private String getResourceListString() {
        String returnString = "";
        int maxWeight = 0;
        ArrayList<Resource> resources = PioneerTrail.getCurrentGame().getResources();
        for (int i = 0; i < resources.size(); i++) {
            returnString += "\n" + i + " - " + resources.get(i).getName();
            maxWeight = Integer.max(maxWeight, resources.get(i).getWeight());

//             resources.get(i).toString() + "\n";
        }
        returnString += "\n The heaviest Item weighs:" + maxWeight;
        returnString += "\n\n Select an Item (E to Exit)";
        return returnString;
    }

    private boolean addToWagon(Resource resource) {
        Wagon wagon = PioneerTrail.getCurrentGame().getWagon();
        int result = 0;
        try {
            result = WagonControl.calculateWagonCurrentWeight(wagon, resource);
        } catch (WagonControlException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Unable to add resource");
            return false;
            //Logger.getLogger(WagonControlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result >= 0) {
            System.out.println("Wagon weight = " + wagon.getCurrentWeight());
            System.out.println("You can add " + resource.getName() + "with a weight of " + resource.getWeight() * resource.getQuantity());
            ArrayList<Resource> resources = wagon.getResources();
            resources.add(resource);
            PioneerTrail.getCurrentGame().getResources().remove(resource);
            wagon.setCurrentWeight(result);
            return true;
        }
        return false;
    }
}
