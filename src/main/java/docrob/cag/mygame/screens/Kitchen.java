package docrob.cag.mygame.screens;

import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenBuilder;

public class Kitchen extends Screen {
    public Kitchen() {
        super();
    }


    @Override
    public void show() {
        System.out.println("You are in the kitchen. Cobwebs and rusty old cooking implements adorn the walls. There is a corridor heading south.");
        super.show();
    }

    @Override
    public void setupMenu() {
        super.setupMenu();
        menu.addChoice("Go south down the corridor", ScreenBuilder.buildScreen(new HouseEntrance()));
    }

}
