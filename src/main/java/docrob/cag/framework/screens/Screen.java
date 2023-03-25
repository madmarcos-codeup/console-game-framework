package docrob.cag.framework.screens;

import docrob.cag.framework.menu.Menu;
import docrob.cag.framework.menu.MenuChoice;
import docrob.cag.framework.menu.MenuItem;
import docrob.cag.framework.menu.NavMenuItem;
import docrob.cag.framework.state.Game;
import lombok.*;

@Getter
@Setter
public abstract class Screen {

    protected Menu menu;

    protected ScreenState screenState;

    protected boolean showMenuEachIteration;

    public Screen() {
        menu = new Menu();
        screenState = ScreenState.ReadyToQueue;
        showMenuEachIteration = true;
    }

    public void exit() {
        if(screenState != ScreenState.Exited) {
            screenState = ScreenState.ReadyToExit;
        }
    }

    // override to have a screen reset its stuff on a cache hit
    public void reset() {
    }

    // override to setup a screen's stuff on the first cache write
    public void setup() {
    }

    public void go() {
        System.out.println(this.getClass().getSimpleName() + " has started");
        show();
        handleInput();
    }

    protected void show() {
        System.out.println();
        for (MenuItem item : menu.getItems()) {
            if(!item.isHidden()) {
                System.out.println(item);
            }
        }
    }

    protected void handleInput() {
        while(screenState == ScreenState.Showing) {
            MenuItem selected = menu.getSelectedItemFromUser(Game.getInstance().getInput());

            if(selected.isHidden()) {
                System.out.println("That was not a valid choice!");
                continue;
            }

            selected.doIt();
            // if selected item was a nav menu item then this screen will exit to move to the next screen
            if(selected instanceof NavMenuItem) {
                this.exit();
            }

            if(showMenuEachIteration) {
                show();
            }

        }
    }

//    public void setupMenu() {
////        System.out.println("screen setup for " + this.getClass().getSimpleName());
//    }
//
//    // easy to use function that both shows and handles
//    public MenuChoice go() {
//        show();
//        return handleUser();
//    }
//
//    public MenuChoice go(boolean showMenuEachIteration) {
//        show();
//        return handleUser(showMenuEachIteration);
//    }
//
//    // show() is responsible for displaying the screen info
//    public void show() {
//        System.out.println();
//        for (MenuChoice choice : menu.getChoices()) {
//            if(!choice.isHidden()) {
//                System.out.println(choice);
//            }
//        }
//    }
//
//    // handleUser is responsible for responding to user interaction
//    public MenuChoice handleUser() {
//        MenuChoice choice = null;
//
//        // loop while user does not choose an action that changes screen flow
//        while(!readyToExit) {
//
//            choice = menu.getChoiceFromUser(Game.getInstance().getInput());
//
//            if(choice.isHidden()) {
//                System.out.println("That was not a valid choice!");
//                continue;
//            }
//
//            // process user's choice
//            choice.doAction();
//
//            // if user quits then break
//            if(readyToExit || choice.getAction() instanceof FlowAction) {
//                break;
//            }
//
//            if(showMenuEachIteration) {
//                show();
//            }
//        }
//
//        return choice;
//    }
//
//    public MenuChoice handleUser(boolean showMenuEachIteration) {
//        this.showMenuEachIteration = showMenuEachIteration;
//        return handleUser();
//    }
//
//    public boolean isReadyToExit() {
//        return readyToExit;
//    }
//
//    public void setReadyToExit(boolean readyToExit) {
//        this.readyToExit = readyToExit;
//    }
//
//    public Menu getMenu() {
//        return menu;
//    }
//
//    public void setMenu(Menu menu) {
//        this.menu = menu;
//    }
}
