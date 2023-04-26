package docrob.cag.mygame.screens;

import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenManager;
import docrob.cag.framework.state.Game;
import docrob.cag.framework.utils.ConsoleColors;
import docrob.cag.mygame.MyGame;

public class NorthScreen extends Screen {
    @Override
    protected void show() {
        System.out.println(ConsoleColors.ANSI_CLEAR);
        System.out.println("You have entered the north room." +
                "\nYou fall into a pit of spikes and die. Sorry! :(");
        super.show();
    }

    @Override
    protected void handleInput() {
        Game.getInstance().getInput().getString("Press Enter to continue.");

        MyGame.killPlayer();

        ScreenManager.addScreen(new MainScreen());
    }
}