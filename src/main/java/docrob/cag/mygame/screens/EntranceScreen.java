package docrob.cag.mygame.screens;

import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenManager;
import docrob.cag.framework.state.Game;
import docrob.cag.framework.utils.ConsoleColors;
import docrob.cag.mygame.MyGame;

public class EntranceScreen extends Screen {
    public EntranceScreen() {
    }

    @Override
    public void setup() {
        super.setup();
        menu.addItem("Run away!!", new MainScreen());
        menu.addItem("Go west", new LumpyRoom());
        menu.addItem("Go east", new MistyRoom());
    }

    @Override
    protected void show() {
        System.out.println(ConsoleColors.ANSI_CLEAR);
        System.out.println("You are at the entrance to a scary dungeon." +
                "\nFrom here, you can go west or east.");

        if(MyGame.getPlayer().hasWinningItem()) {
            System.out.println("\nHey, you made it back with the most powerful object in the Universe!" +
                    "\nCongrats!!" +
                    "\n\n");

            Game.getInstance().getInput().getString("Press Enter to head into the victory room.");

            ScreenManager.addScreen(new VictoryRoom());
            exit();
            return;
        }
        super.show();

    }
}
