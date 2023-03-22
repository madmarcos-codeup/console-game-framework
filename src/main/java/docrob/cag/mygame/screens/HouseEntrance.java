package docrob.cag.mygame.screens;

import docrob.cag.framework.menu.MenuChoice;
import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenBuilder;
import docrob.cag.framework.screens.ScreenManager;
import docrob.cag.framework.state.Game;
import docrob.cag.framework.utils.ConsoleColors;
import docrob.cag.mygame.MyGame;
import docrob.cag.mygame.characters.Player;

public class HouseEntrance extends Screen {
    public HouseEntrance() {
        super();
    }

    @Override
    public void show() {
        Player player = Game.getInstance().getStateItem("player", Player.class);
        System.out.println(ConsoleColors.ANSI_CLEAR + player.getName() + " has entered " + ConsoleColors.ANSI_RED + "THE SPOOKY HAUS!" + ConsoleColors.ANSI_RESET +
                "\n\nFind the most powerful object in the Universe and return here to win this stupid game." +
                "\n\nA dark corridor leads north and a creaky staircase leads up." +
                "\nThe front door is to the south.");
        super.show();

        if(MyGame.getPlayer().hasWinningItem()) {
            System.out.println("\n\nDespite all odds, you have found the most powerful object in the Universe." +
                "\nPress Enter to see a fabulous victory screen!");
            Game.getInstance().getInput().getString();

//            MenuChoice choice = new MenuChoice("", ScreenBuilder.makeFlowActionForScreen(new WinScreen()));
//            choice.doAction();

            ScreenManager.createNextScreen(new WinScreen());
            this.setReadyToExit(true);
        }
    }

    @Override
    public void setupMenu() {
        super.setupMenu();
        menu.addChoice("Run Away (out the front door)!!", ScreenBuilder.makeFlowActionForScreen(new MainScreen()));
        menu.addChoice("Head down the corridor", ScreenBuilder.makeFlowActionForScreen(new Kitchen()));
        menu.addChoice("Walk up the stairs", ScreenBuilder.makeFlowActionForScreen(new SecondFloorLanding()));
    }

}
