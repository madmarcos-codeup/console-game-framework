package docrob.cag.framework.screens;

import docrob.cag.framework.menu.FlowAction;
import docrob.cag.framework.menu.MenuAction;
import docrob.cag.framework.menu.MenuChoice;
import docrob.cag.framework.menu.MenuException;

import java.util.ArrayList;
import java.util.List;

public class ScreenManager {
    private static List<Screen> screens = new ArrayList<>();

    private static Screen nextScreen = null;

    public static final FlowAction EXIT_APPLICATION_ACTION = () -> {
        // empty action function that just indicates the user selected an choice to return the current screen to the caller
    };

    public static final MenuAction NO_ACTION = () -> {
        // empty action function that just indicates the user selected a choice to return the current screen to the caller
    };

    public static void addScreen(Screen screen) {
        if(screen.getScreenState() != ScreenState.ReadyToQueue) {
            throw new ScreenException(screen.getClass().getSimpleName() + " status is not ready to queue");
        }

        // find the screen in the cache
        Screen cacheScreen = ScreenCache.getCachedScreen(screen);

        cacheScreen.setScreenState(ScreenState.QueuedToShow);
        pushScreen(cacheScreen);
    }

    public static void start() {
        // loop until we run out of screens
        // or are told to exit the app early?
        while(true) {
            if(screens.size() == 0) {
                break;
            }

            Screen screen = popScreen();
            screen.setScreenState(ScreenState.Showing);

            screen.go();
            screen.setScreenState(ScreenState.Exited);
        }
    }

    private static Screen popScreen() {
        return screens.remove(0);
    }

    private static void pushScreen(Screen screen) {
        screens.add(screen);
    }

    public static void resetGame() {
        ScreenCache.emptyCache();
    }

//    public static void setNextScreen(Screen nextScreen) {
//        ScreenManager.nextScreen = nextScreen;
//    }

    // createNextScreen is for when you want to set the next screen but not via a menu choice (i.e., press 3 to go west)
    // e.g., player has died from an action
//    public static void createNextScreen(Screen screen) {
//        screen = ScreenBuilder.getCachedScreen(screen);
//        try {
//            screen.resetScreen();
//        } catch(MenuException e) {
//            // menu option may not yet be created so ignore exception if it happens
//        }
//        ScreenManager.setNextScreen(screen);
//    }
}
