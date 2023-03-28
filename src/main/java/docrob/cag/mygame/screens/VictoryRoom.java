package docrob.cag.mygame.screens;

import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenManager;
import docrob.cag.framework.state.Game;
import docrob.cag.framework.utils.ConsoleColors;
import docrob.cag.mygame.MyGame;

public class VictoryRoom extends Screen {

    public VictoryRoom() {
        super();
    }

    @Override
    public void show() {
        System.out.println(ConsoleColors.ANSI_CLEAR);
        System.out.println("It's the Victory Room.");
    }

    @Override
    protected void handleInput() {
        Game.getInstance().getInput().getString("Press Enter when you have had enough victory.");

        MyGame.getPlayer().setHasWinningItem(false);

        ScreenManager.addScreen(new MainScreen());
        // since there is no input loop in this screen, this method will exit and SM will move to MainScreen
//        this.exit();
    }
}
