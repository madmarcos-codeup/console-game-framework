package docrob.cag.mygame.screens;

import docrob.cag.framework.menu.FlowAction;
import docrob.cag.framework.menu.MenuAction;
import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenBuilder;
import docrob.cag.framework.screens.ScreenManager;
import docrob.cag.framework.state.Game;
import docrob.cag.framework.utils.ConsoleColors;
import docrob.cag.mygame.MyGame;
import docrob.cag.mygame.characters.Player;

public class MainScreen extends Screen {
    private final String START_LABEL = "Start the adventure";
    public MainScreen() {
        super();
    }

    @Override
    public void resetScreen() {
        // hide dungeon start screen if you have not made a player
        if(MyGame.getPlayer() == null) {
            menu.getChoiceFromLabel(START_LABEL).setHidden(true);
        }
    }

    @Override
    public void setupMenu() {
        super.setupMenu();
        menu.addChoice("Exit", ScreenManager.EXIT_APPLICATION_ACTION);
        menu.addChoice("Enter player name", createPlayer);
        menu.addChoice(START_LABEL, ScreenBuilder.makeFlowActionForScreen(new HouseEntrance()), true);
    }

    @Override
    public void show() {
        Player player = Game.getInstance().getStateItem("player", Player.class);
        String playerInfo = "";
        if(player != null) {
            playerInfo = "\tPlayer: " + player.getName();
        }
        System.out.println(ConsoleColors.ANSI_CLEAR + "\nMain Menu" + playerInfo);

        super.show();
    }

    private MenuAction createPlayer = () -> {
        String name = Game.getInstance().getInput().getString("\nEnter your name: ");
        Player player = new Player(name, false);
        Game.getInstance().addStateItem("player", player);

        System.out.println("Resetting game...");
        ScreenBuilder.emptyCache();

        // as soon we create a player, show the start adventure choice
        menu.getChoiceFromLabel(START_LABEL).setHidden(false);
    };

//    private FlowAction startGame = () -> {
//        ScreenBuilder.emptyCache();
//        ScreenManager.createNextScreen(new HouseEntrance());
//    };

}