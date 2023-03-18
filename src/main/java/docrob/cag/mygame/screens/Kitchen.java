package docrob.cag.mygame.screens;

import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenBuilder;
import docrob.cag.framework.utils.ConsoleColors;

public class Kitchen extends Screen {
    public Kitchen() {
        super();
    }


    @Override
    public void show() {
        System.out.println(ConsoleColors.ANSI_CLEAR +
                "You are in the kitchen. Cobwebs and rusty old cooking implements adorn the walls." +
                "\n\nThere is a corridor heading south.");
        super.show();
    }

    @Override
    public void setupMenu() {
        super.setupMenu();
        menu.addChoice("Go south down the corridor", ScreenBuilder.buildScreen(new HouseEntrance()));
    }

}
