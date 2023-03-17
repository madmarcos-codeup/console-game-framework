package docrob.cag.mygame.screens;

import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenBuilder;

public class HouseEntrance extends Screen {
    public HouseEntrance() {
        super();
    }

    @Override
    public void show() {
        System.out.println("You enter the spooky old house. A dark corridor leads north and a creaky staircase leads up. The front door is to the south.");
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
