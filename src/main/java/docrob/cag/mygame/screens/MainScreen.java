package docrob.cag.mygame.screens;

import docrob.cag.framework.menu.MenuAction;
import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenBuilder;
import docrob.cag.framework.screens.ScreenManager;
import docrob.cag.framework.state.Game;
import docrob.cag.mygame.characters.Player;

public class MainScreen extends Screen {
    private final String START_LABEL = "Start the adventure";
    public MainScreen() {
        super();
    }

    @Override
    public void setupMenu() {
        super.setupMenu();
        menu.addChoice("Exit", ScreenManager.EXIT_APPLICATION_ACTION);
        menu.addChoice("Enter player name", createPlayer);
//        menu.addChoice("Who am I?", viewPlayer);
        menu.addChoice(START_LABEL, ScreenBuilder.buildScreen(new HouseEntrance()), true);
    }

    @Override
    public void show() {
        Player player = Game.getInstance().getStateItem("player", Player.class);
        String playerInfo = "";
        if(player != null) {
            playerInfo = "\tPlayer: " + player.getName();
        }
        System.out.println("\nMain Menu" + playerInfo);
        super.show();
    }

    private MenuAction createPlayer = () -> {
        String name = Game.getInstance().getInput().getString("\nEnter your name: ");
        Player player = new Player(name);
        Game.getInstance().addStateItem("player", player);
        menu.getChoiceFromLabel(START_LABEL).setHidden(false);
    };

    private MenuAction viewPlayer = () -> {
        Player player = Game.getInstance().getStateItem("player", Player.class);
        if(player == null) {
            System.out.println("No player has been created!");
            return;
        }
        System.out.println("Player name: " + player.getName());
    };

}