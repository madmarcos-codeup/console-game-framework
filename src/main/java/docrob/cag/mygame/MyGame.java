package docrob.cag.mygame;

import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenBuilder;
import docrob.cag.framework.screens.ScreenManager;
import docrob.cag.mygame.screens.WelcomeScreen;

public class MyGame {
    public static void main(String[] args) {
        // show welcome
        Screen screen = new WelcomeScreen();
        ScreenBuilder.buildScreen(screen);
        ScreenManager.setNextScreen(screen);
        // screen manager is now the main screen loop
        // when a menu action that leads to another screen is chosen:
        // the old screen sets that new screen as the next screen and the old screen returns
        // then the screen manager loads the new screen
        ScreenManager.start();

        // when the screen manager returns, the app is ready to quit
        // i.e., the user has exited from the main screen
        System.out.println("Bye");


    }
}
