package docrob.cag.mygame.screens;

import com.sun.tools.javac.Main;
import docrob.cag.framework.screens.Screen;

public class LeftScreen extends Screen {
    public LeftScreen() {
    }

    @Override
    public void setup() {
        super.setup();
        menu.addItem("Go Back", new MainScreen());
    }

    @Override
    protected void show() {
        System.out.println("You went left. There is nothing to do here,");

        super.show();
    }
}
