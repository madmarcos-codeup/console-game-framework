package docrob.cag.mygame.screens;

import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.utils.ConsoleColors;

public class LumpyRoom extends Screen {
    public LumpyRoom() {
    }

    @Override
    public void setup() {
        super.setup();
        menu.addItem("Go east", new EntranceScreen());
        menu.addItem("Go south", new TreasureRoom());
    }

    @Override
    protected void show() {
        System.out.println(ConsoleColors.ANSI_CLEAR);
        System.out.println("This room is kind of lumpy." +
            "\nYou can go back the way you came (east), or go south to the treasure room.");

        super.show();
    }
}
