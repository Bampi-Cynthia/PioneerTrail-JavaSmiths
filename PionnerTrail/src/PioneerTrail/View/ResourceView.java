
package PioneerTrail.View;

import PioneerTrail.control.ResourceControl;
import PioneerTrail.model.Resource;
import java.util.ArrayList;
import pionnertrail.PioneerTrail;
/**
 * @author Cynthia
 */
public class ResourceView extends View{
    
    public ResourceView() {
        super("===============================\n"
            + "            Resource Menu      \n"
            + "===============================\n"
            + "D - Display Resource List\n"    
            + "Q - Quit \n"
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
//       private String[] getInputs() {
//        Scanner scan;
//        scan = new Scanner(System.in);
//
//        String[] inputs = new String[1];
//        System.out.println(
//                "===============================\n"
//                + "            Resource Menu          \n"
//                + "===============================\n"
//                + "D - Display Resource List\n"    
//                + "Q - Quit");
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
            case "D":
               System.out.println(getResourceListString());
                break;
            default:
                System.out.println("Invalid map menu item");
                break;
        }
        return false;
    }

    private String getResourceListString() {
     String returnString = "";
     ArrayList<Resource> resources = PioneerTrail.getCurrentGame().getResources();
     for(int i = 0; i < resources.size(); i++){
     returnString += resources.get(i).toString() + "\n";
     }
     return returnString;
//Resource[] list = sendList();
    }
//    private void buildMenu(){
//    return;
//    }

}