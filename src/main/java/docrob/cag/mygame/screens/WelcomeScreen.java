package docrob.cag.mygame.screens;

import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenManager;
import docrob.cag.framework.state.Game;

public class WelcomeScreen extends Screen {

    public WelcomeScreen() {
        super();
    }

    @Override
    public void show() {
        System.out.println("Welcome screen");
    }

    @Override
    protected void handleInput() {
        Game.getInstance().getInput().getString("Press Enter to continue.");

        ScreenManager.addScreen(new MainScreen());
        // since there is no input loop in this screen, this method will exit and SM will move to MainScreen
//        this.exit();
    }
}
