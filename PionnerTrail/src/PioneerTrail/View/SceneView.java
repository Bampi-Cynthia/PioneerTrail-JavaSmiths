package PioneerTrail.View;

import PioneerTrail.model.Actor;
import PioneerTrail.model.Player;
import PioneerTrail.model.Question;
import PioneerTrail.model.Resource;
import PioneerTrail.model.Scene;
import java.util.ArrayList;
import pionnertrail.PioneerTrail;

/**
 * @author Elías and Cynthia
 */
public class SceneView extends View {

    private Scene scene;

    public SceneView() {
        this.scene = PioneerTrail.getCurrentGame().getMap().getCurrentLocation().getScene();
        promptMessage = getSceneMenu();

    }

    public SceneView(Scene scene) {
        this.scene = scene;
        promptMessage = getSceneMenu();
    }

    private String getSceneMenu() {
        String menuString = "Scene does not exist";
        if (scene != null) {
            menuString = "Welcome to " + scene.getName() + "\n";
            menuString += "Scene symbol = " + scene.getSymbol() + "\n";
            menuString += scene.getDescription() + "\n";
//      ArrayList<Question> questions = scene.getQuestions();
//       ArrayList<Actor> actors = scene.getActors();
//       ArrayList<Resource> resources = scene.getResources();
//       if(resources.size() > 0){
//           Resource resource = resources.get(0);
//           menuString += "P - pick up " + resource.getName() + "\n";
            //    }
            Resource resource = scene.getResource();
            if (resource != null) {
                menuString += "P - pick up " + resource.getName() + "\n";
            }

            Question question = scene.getQuestion();
            if (question != null) {
                menuString += "A - Answer Question: " + question.getQuestion() + "\n";
            }
            menuString += "Q - quit \n";
        }

        return menuString;
    }

    @Override
    public boolean doAction(String inputs) {
        if (scene == null) {
            return true;
        }
        inputs.toUpperCase();
        switch (inputs) {
            case "P":
                if (scene.getResource() != null) {
                    PioneerTrail.getCurrentGame().getResources().add(scene.getResource());
                    scene.setResource(null);
                }
//               if(scene.getResources().size() > 0){
//                   PioneerTrail.getCurrentGame().getResources().add(scene.getResources().get(0));
//                   scene.getResources().remove(scene.getResources().get(0));
//                   scene.getResources().clear();
//               }
                break;
            case "A":
                Player player = PioneerTrail.getPlayer();
                int currentHealth = player.getHealth();
                Question question = scene.getQuestion();
                if (question != null) {
                    String questionMenu = question.getQuestion() + "\n";
                    questionMenu += "   1-" + question.getAnswer1() + "\n";
                    questionMenu += "   2-" + question.getAnswer2() + "\n";
                    questionMenu += "   3-" + question.getAnswer3() + "\n";
                    questionMenu += "   4-" + question.getAnswer4() + "\n";
                    String answer = getInput(questionMenu);
                    int answerInt = Integer.parseInt(answer);
                    if (answerInt == question.getConrrectAnswer()) {
                        System.out.println("Your Answer is Correct!");
                        if(currentHealth < 95){
                            currentHealth += 5;
                        }
                    }
                    else{
                        System.out.println("Incorrect Answer");
                        currentHealth -= 5;
                    }
                    System.out.println("Your current health is " + currentHealth);
                    if(currentHealth <= 0){
                        PioneerTrail.getCurrentGame().setGameOver(true);
                        System.out.println("You died, GAME OVER! =(");
                        return true;
                    }
                }
                break;
            case "Q":
                return true;
        }
        promptMessage = getSceneMenu();
        return false;
    }
}
