package docrob.cag.mygame.screens;

import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenBuilder;
import docrob.cag.framework.utils.ConsoleColors;

public class SecondFloorLanding extends Screen {
    public SecondFloorLanding() {
        super();
    }


    @Override
    public void show() {
        System.out.println(ConsoleColors.ANSI_CLEAR + "You are at the top of the stairs on the second floor. All of the doors on this floor are nailed shut. How sad." +
                "\n\nStairs lead down to the entrance.");
        super.show();
    }

    @Override
    public void setupMenu() {
        super.setupMenu();
        menu.addChoice("Head down the stairs", ScreenBuilder.buildScreen(new HouseEntrance()));
    }

}
