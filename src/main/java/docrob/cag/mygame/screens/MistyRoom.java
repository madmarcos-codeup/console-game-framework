package docrob.cag.mygame.screens;

import docrob.cag.framework.screens.Screen;

public class MistyRoom extends Screen {
    public MistyRoom() {
    }

    @Override
    public void setup() {
        super.setup();
        menu.addItem("Go west", new EntranceScreen());
        menu.addItem("Go north", new RoomOfDoom());
    }

    @Override
    protected void show() {
        System.out.println("It is misty here. You can go back the way you came (west) or head north.");

        super.show();
    }
}
