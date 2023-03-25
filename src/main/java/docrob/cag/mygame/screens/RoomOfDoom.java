package docrob.cag.mygame.screens;

import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenManager;
import docrob.cag.framework.state.Game;
import docrob.cag.mygame.MyGame;

public class RoomOfDoom extends Screen {
    public RoomOfDoom() {
    }


    @Override
    protected void show() {
        System.out.println("It is misty and you cannot see very well." +
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
