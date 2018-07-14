package PioneerTrail.View;

import PioneerTrail.control.WagonControl;
import PioneerTrail.exceptions.WagonControlException;
import PioneerTrail.model.Resource;
import PioneerTrail.model.Wagon;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import pionnertrail.PioneerTrail;

/**
 * @author Cynthia
 */
public class ResourceView extends View {

    public ResourceView() {
        super("\n===============================\n"
                + "            Resource Menu      \n"
                + "===============================\n"
                + "D - Display Resource List\n"
                + "P - Print Report\n"
                + "Q - Quit \n"
                + "Please, make your choice");
       // promptMessage = getResourceListString();
    }

    @Override
    public boolean doAction(String inputs) {
        inputs = inputs.toUpperCase();
        switch (inputs) {
            case "D":
                viewInventoryReport();
                break;

            case "P":
                printInventoryReport();
                break;

            default:
                ErrorView.display(this.getClass().getName(), "Invalid selection. Please, try again");
        }
        return false;

    }

    public boolean selectResource(String inputs) {
        ArrayList<Resource> resources = PioneerTrail.getCurrentGame().getResources();
        int selection = Integer.parseInt(inputs);
        if (selection < 0 || selection >= resources.size()) {
            ErrorView.display(this.getClass().getName(), "Select between the menu choices");
            return false;
        }

        System.out.println("Name: " + resources.get(selection).getName());
        System.out.println("Type: " + resources.get(selection).getInventoryType());
        System.out.println("Quantity: " + resources.get(selection).getQuantity());
        System.out.println("Weight: " + resources.get(selection).getWeight());
        String answer = this.getInput("Do you want to add this to your Wagon?(y/n)");
        if (answer.equalsIgnoreCase(answer)) {
            if (addToWagon(resources.get(selection))) {
                promptMessage = getResourceListString();
            }
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
            ErrorView.display(this.getClass().getName(), "Unable to add resource");
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

    public void viewInventoryReport() {
        ArrayList<Resource> resources = PioneerTrail.getCurrentGame().getResources();
        //print title and column headings
        System.out.println("\n\n                Inventory Report       ");
        System.out.printf("\n%15s%10s%10s%10s", "Name", "Type", "Quantity", "Weight");
        System.out.printf("\n%15s%10s%10s%10s", "----", "----", "--------", "------");
        //print the name, type, quantity, and weight of each item
        for (Resource resource : resources) {
            System.out.printf("\n%15s%10s%10d%10d", resource.getName(),
                    resource.getInventoryType(),
                    resource.getQuantity(),
                    resource.getWeight()
            );
        }
    }

    public void printInventoryReport() {
        //create BufferedReader object for input file
        ArrayList<Resource> resources = PioneerTrail.getCurrentGame().getResources();
        String outputLocation = getInput("Enter a file name: ");
        try (PrintWriter out = new PrintWriter(outputLocation)) {
            //print title and column headings
            out.println("\r\n                       Inventory Report        ");
            out.printf("\r\n%15s%10s%10s%10s", "Name", "Type", "Quantity", "Weight");
            out.printf("\r\n%15s%10s%10s%10s", "----", "----", "--------", "------");
            //print the name, type, quantity, and weight of each item
            for (Resource resource : resources) {
                out.printf("\r\n%15s%10s%10d%10d", resource.getName(),
                        resource.getInventoryType(),
                        resource.getQuantity(),
                        resource.getWeight()
                );
            }
            if(outputLocation != null){
                System.out.println("You saved the Inventory Report with success!");
            }
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }
    }
}
