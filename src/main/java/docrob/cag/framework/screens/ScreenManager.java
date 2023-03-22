package docrob.cag.framework.screens;

import docrob.cag.framework.menu.FlowAction;
import docrob.cag.framework.menu.MenuAction;
import docrob.cag.framework.menu.MenuChoice;
import docrob.cag.framework.menu.MenuException;

public class ScreenManager {
    private static Screen nextScreen = null;

    public static final FlowAction EXIT_APPLICATION_ACTION = () -> {
        // empty action function that just indicates the user selected an choice to return the current screen to the caller
    };

    public static final MenuAction NO_ACTION = () -> {
        // empty action function that just indicates the user selected an choice to return the current screen to the caller
    };

    public static void start() {
        MenuChoice choice;
        do {
            if(nextScreen == null) {
                throw new ScreenException("Next screen has not been set!");
            }

            Screen currentScreen = nextScreen;
            nextScreen = null;
            choice = currentScreen.go();
        } while(choice.getAction() != EXIT_APPLICATION_ACTION);
    }

    public static void setNextScreen(Screen nextScreen) {
        ScreenManager.nextScreen = nextScreen;
    }

    // createNextScreen is for when you want to set the next screen but not via a menu choice (i.e., press 3 to go west)
    // e.g., player has died from an action
    public static void createNextScreen(Screen screen) {
        screen = ScreenBuilder.getCachedScreen(screen);
        try {
            screen.resetScreen();
        } catch(MenuException e) {
            // menu option may not yet be created so ignore exception if it happens
        }
        ScreenManager.setNextScreen(screen);
    }
}
