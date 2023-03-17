package docrob.cag.mygame.screens;

import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenBuilder;

public class HouseEntrance extends Screen {
    public HouseEntrance() {
        super();
    }

    @Override
    public void setupMenu() {
        super.setupMenu();
        menu.addChoice("Run Away!!", ScreenBuilder.buildScreen(new MainScreen()));
    }
}
