package docrob.cag.framework.screens;

import docrob.cag.framework.menu.FlowAction;
import docrob.cag.framework.menu.Menu;
import docrob.cag.framework.menu.MenuChoice;
import docrob.cag.framework.state.Game;

public abstract class Screen {
    private boolean showMenuEachIteration = true;

    // a screen can use this to exit the input handler
    // screens can use this to transfer flow outside of FlowActions (e.g., the player dies)
    private boolean readyToExit = false;

    protected Menu menu;

    public Screen() {
        menu = new Menu();
    }

    public void setupMenu() {
//        System.out.println("screen setup for " + this.getClass().getSimpleName());
    }

    // easy to use function that both shows and handles
    public MenuChoice go() {
        show();
        return handleUser();
    }

    public MenuChoice go(boolean showMenuEachIteration) {
        show();
        return handleUser(showMenuEachIteration);
    }

    // show() is responsible for displaying the screen info
    public void show() {
        System.out.println();
        for (MenuChoice choice : menu.getChoices()) {
            if(!choice.isHidden()) {
                System.out.println(choice);
            }
        }
    }

    // handleUser is responsible for responding to user interaction
    public MenuChoice handleUser() {
        MenuChoice choice;

        // loop while user does not choose an action that changes screen flow
        while(true) {

            choice = menu.getChoiceFromUser(Game.getInstance().getInput());

            if(choice.isHidden()) {
                System.out.println("That was not a valid choice!");
                continue;
            }

            // process user's choice
            choice.doAction();

            // if user quits then break
            if(readyToExit || choice.getAction() instanceof FlowAction) {
                break;
            }

            if(showMenuEachIteration) {
                show();
            }
        }

        return choice;
    }

    public MenuChoice handleUser(boolean showMenuEachIteration) {
        this.showMenuEachIteration = showMenuEachIteration;
        return handleUser();
    }

    public boolean isReadyToExit() {
        return readyToExit;
    }

    public void setReadyToExit(boolean readyToExit) {
        this.readyToExit = readyToExit;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
