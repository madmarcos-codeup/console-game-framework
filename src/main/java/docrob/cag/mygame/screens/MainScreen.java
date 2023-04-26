package docrob.cag.mygame.screens;

import docrob.cag.framework.menu.MenuItemMethod;
import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenManager;
import docrob.cag.framework.state.Game;
import docrob.cag.framework.utils.ConsoleColors;
import docrob.cag.mygame.MyGame;
import docrob.cag.mygame.characters.Player;

public class MainScreen extends Screen {

    public MainScreen() {
    }

    @Override
    public void setup() {
        super.setup();
        menu.addItem("Exit game", exitProgram);
        menu.addItem("Create player", createPlayer);
        menu.addItem("Start the adventure", startAdventure, true);
    }

    @Override
    protected void show() {
        Player player = Game.getInstance().getStateItem("player", Player.class);
        String playerInfo = "";
        if (player != null) {
            playerInfo = "\t\tPlayer: " + player.getName();
        }
        System.out.println(ConsoleColors.ANSI_CLEAR + "\nMain Screen" + playerInfo);

        super.show();
    }

    private MenuItemMethod createPlayer = () -> {
        String name = Game.getInstance().getInput().getString("\nEnter your name: ");
        Player player = new Player(name);
        Game.getInstance().addStateItem("player", player);

        menu.getItemFromLabel("Start the adventure").setHidden(false);
    };

    private MenuItemMethod exitProgram = () -> {
        System.out.println("Exiting main screen...");
        setReadyToExit();
    };

    private MenuItemMethod startAdventure = () -> {
        MyGame.initGame();
        ScreenManager.addScreen(new EntranceScreen());
        setReadyToExit();
    };
}