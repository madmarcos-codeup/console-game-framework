package docrob.cag.mygame.screens;

import docrob.cag.framework.menu.MenuItemMethod;
import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.utils.ConsoleColors;

public class EastScreen extends Screen {
    @Override
    public void setup() {
        super.setup();
        menu.addItem("Go west", new EntranceScreen());
        menu.addItem("Go north", new NorthScreen());
    }

    @Override
    protected void show() {
        System.out.println(ConsoleColors.ANSI_CLEAR);
        System.out.println("You are in the east part of the maze." +
                "\nFrom here, you can go west to return to the entrance, or go north.");

        super.show();

    }

    private MenuItemMethod northStub = () -> {
        System.out.println("TODO: go north");
    };
}