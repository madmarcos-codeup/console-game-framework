package docrob.cag.mygame.screens;

import docrob.cag.framework.menu.MenuItemMethod;
import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.state.Game;

public class MainScreen extends Screen {
    public MainScreen() {
        menu.addItem("Exit", exitProgram);
//        menu.addItem("Thing 1", new LeftScreen());
//        menu.addItem("Thing 2", new RightScreen());
    }

    @Override
    protected void show() {
        System.out.println("Main Screen");
        super.show();
    }

    private MenuItemMethod exitProgram = () -> {
        System.out.println("yo");
    };
}
