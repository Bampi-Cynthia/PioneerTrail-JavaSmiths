package PioneerTrail.View;

import PioneerTrail.model.Resource;
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

}
