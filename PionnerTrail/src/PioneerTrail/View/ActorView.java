package PioneerTrail.View;

import PioneerTrail.model.Actor;

/*
 * @author Cynthia
 */
public class ActorView extends View {

    public ActorView() {
        promptMessage = getActorString();
    }

    private String getActorString() {
        String myActors = "===============================\n"
                + "            Actor Menu          \n"
                + "===============================\n ";
        int count = 1;
        for (Actor actor : Actor.values()) {
            myActors += count + " - " + actor.getName() + " \n ";
            count++;
        }
        myActors += "E - Exit\n"
                + "Please, make your choice\n";
        return myActors;
    }

    @Override
    public boolean doAction(String inputs) {
        try {
            int selection = Integer.parseInt(inputs);
            if (selection > 0 && selection <= Actor.values().length) {
                viewActor(selection - 1);
            }
        } catch (NumberFormatException nf) {
            ErrorView.display(this.getClass().getName(), "You need to enter a valid number");
        }

        return false;
    }

    private void viewActor(int selection) {
        Actor actor = Actor.values()[selection];

        System.out.println("name = " + actor.getName());
        System.out.println("description = " + actor.getDescription());
        System.out.println("health = " + actor.getHealth());
        System.out.println("hunger = " + actor.getHunger());
    }

}
