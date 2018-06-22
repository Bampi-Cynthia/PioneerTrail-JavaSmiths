
package PioneerTrail.View;

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
    }

}