package docrob.cag.mygame.screens;

import docrob.cag.framework.menu.MenuItemMethod;
import docrob.cag.framework.screens.Resettable;
import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenManager;
import docrob.cag.framework.state.Game;
import docrob.cag.framework.utils.ConsoleColors;
import docrob.cag.mygame.MyGame;

public class EntranceScreen extends Screen implements Resettable {
    @Override
    public void setup() {
        super.setup();
        menu.addItem("Run away!!", new MainScreen());
        menu.addItem("Go west", new WestScreen());
        menu.addItem("Go east", new EastScreen());
        menu.addItem("Win the game", winTheGame, true);
    }

    @Override
    protected void show() {
        System.out.println(ConsoleColors.ANSI_CLEAR);
        System.out.println("You are at the entrance to a scary maze." +
                "\nFrom here, you can run out of the maze, go west, or go east.");

        // if player has the winning game item, then show the menu
        // else hide it in case they have come back after previously winning
        if(MyGame.getPlayer().hasCrown()) {
            menu.getItemFromLabel("Win the game").setHidden(false);
        } else {
            menu.getItemFromLabel("Win the game").setHidden(true);
        }

        super.show();

    }

    private MenuItemMethod winTheGame = () -> {
        Game.getInstance().getInput().getString("You won the game! Yay...\n\nPress Enter to continue.");

        ScreenManager.addScreen(new MainScreen());
        setReadyToExit();
    };
}
