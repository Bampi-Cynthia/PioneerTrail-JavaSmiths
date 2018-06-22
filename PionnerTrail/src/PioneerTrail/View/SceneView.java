package PioneerTrail.View;

import PioneerTrail.model.Actor;
import PioneerTrail.model.Question;
import PioneerTrail.model.Resource;
import PioneerTrail.model.Scene;
import java.util.ArrayList;
import pionnertrail.PioneerTrail;
/**
 * @author Elías
 */
public class SceneView extends View {

    private Scene scene;

    public SceneView() {
    
    }
    public SceneView(Scene scene) {
        this.scene = scene;
        promptMessage = getSceneMenu();
    }
    private String getSceneMenu(){
    String menuString = "Scene does not exist";
    if(scene != null){
       menuString = "Welcome to " + scene.getName() + "\n";
       menuString += "Scene symbol = " + scene.getSymbol() + "\n";
       menuString += scene.getDescription() + "\n";
       ArrayList<Question> questions = scene.getQuestions();
       ArrayList<Actor> actors = scene.getActors();
       ArrayList<Resource> resources = scene.getResources();
       if(resources.size() > 0){
           Resource resource = resources.get(0);
           menuString += "P - pick up " + resource.getName() + "\n";
       }
       menuString += "Q - quit \n";
    }
    
    return menuString;
}
    @Override
    public boolean doAction(String inputs) {
       if(scene == null){
           return true;
       }
       inputs.toUpperCase();
       switch(inputs){
           case "P":
               if(scene.getResources().size() > 0){
                   PioneerTrail.getCurrentGame().getResources().add(scene.getResources().get(0));
                   scene.getResources().remove(scene.getResources().get(0));
                   scene.getResources().clear();
               }
               break;
           case "Q":
               return true;
       }
       promptMessage = getSceneMenu();
        return false;
    }
}

