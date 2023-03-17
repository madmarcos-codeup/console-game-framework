package docrob.cag.mygame.screens;

import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenBuilder;
import docrob.cag.framework.state.Game;
import docrob.cag.framework.utils.ConsoleColors;
import docrob.cag.mygame.characters.Player;

public class HouseEntrance extends Screen {
    public HouseEntrance() {
        super();
    }

    @Override
    public void show() {
        Player player = Game.getInstance().getStateItem("player", Player.class);
        System.out.println(ConsoleColors.ANSI_CLEAR + player.getName() + " has entered THE SPOOKY HAUS!" +
                "\n\nA dark corridor leads north and a creaky staircase leads up." +
                "\nThe front door is to the south.");
        super.show();
    }

    @Override
    public void setupMenu() {
        super.setupMenu();
        menu.addChoice("Run Away!!", ScreenBuilder.buildScreen(new MainScreen()));
        menu.addChoice("Head down the corridor", ScreenBuilder.buildScreen(new Kitchen()));
        menu.addChoice("Walk up the stairs", ScreenBuilder.buildScreen(new SecondFloorLanding()));
    }

}
