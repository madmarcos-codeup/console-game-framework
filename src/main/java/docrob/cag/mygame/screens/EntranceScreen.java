package docrob.cag.mygame.screens;

import docrob.cag.framework.menu.MenuItemMethod;
import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.utils.ConsoleColors;

public class EntranceScreen extends Screen {
    @Override
    public void setup() {
        super.setup();
        menu.addItem("Run away!!", new MainScreen());
        menu.addItem("Go west", westStub);
        menu.addItem("Go east", new EastScreen());
    }

    @Override
    protected void show() {
        System.out.println(ConsoleColors.ANSI_CLEAR);
        System.out.println("You are at the entrance to a scary maze." +
                "\nFrom here, you can run out of the maze, go west, or go east.");

        super.show();

    }

    private MenuItemMethod westStub = () -> {
        System.out.println("TODO: go west");
    };
}
