package docrob.cag.mygame;

import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenManager;
import docrob.cag.framework.state.Game;
import docrob.cag.mygame.characters.Goblin;
import docrob.cag.mygame.characters.Player;
import docrob.cag.mygame.screens.WelcomeScreen;

public class MyGame {
    public static void main(String[] args) {
        // show welcome
        Screen screen = new WelcomeScreen();
        ScreenManager.addScreen(screen);
        ScreenManager.start();

        // when the screen manager returns, the app is ready to quit
        // i.e., the user has exited from the main screen
        System.out.println("Bye");

    }

    public static Player getPlayer() {
        return Game.getInstance().getStateItem("player", Player.class);
    }

    public static void killPlayer() {
        System.out.println("Removing player " + getPlayer().getName() + "...");
        Game.getInstance().removeStateItem("player");
        ScreenManager.emptyCache();
    }

    public static void initGame() {
        // reset menus for all resettable screens
        ScreenManager.resetScreens();
        // place a new goblin in the game
        Game.getInstance().addStateItem("goblin", new Goblin());
        // take the treasure from the player if he/she has it
        getPlayer().setHasCrown(false);
    }

    public static Goblin getGoblin() {
        return Game.getInstance().getStateItem("goblin", Goblin.class);
    }

}
