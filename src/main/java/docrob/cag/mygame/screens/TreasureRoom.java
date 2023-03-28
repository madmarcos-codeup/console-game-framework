package docrob.cag.mygame.screens;

import docrob.cag.framework.menu.MenuItemMethod;
import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.state.Game;
import docrob.cag.framework.utils.ConsoleColors;
import docrob.cag.mygame.MyGame;

public class TreasureRoom extends Screen {
    public TreasureRoom() {
    }

    @Override
    public void setup() {
        super.setup();
        menu.addItem("Go north", new LumpyRoom());
        menu.addItem("Search the lewt", searchLewt);
    }

    @Override
    protected void show() {
        System.out.println(ConsoleColors.ANSI_CLEAR);
        System.out.println("Wow! It's the treasure room." +
                "\nThere is a pile of treasure on the ground. You can also go back north.");
        super.show();
    }

    private MenuItemMethod searchLewt = () -> {
        if(MyGame.getPlayer().hasWinningItem()) {
            System.out.println("You already found the most powerful object in the Universe. What else could you want?");
        } else {
            searchLewtOneTime();
        }
        Game.getInstance().getInput().getString("Press Enter to continue.");
    };

    private void searchLewtOneTime() {
        int anInt = Game.getInstance().getRandomInt(1, 2);
        switch (anInt) {
            case 1 -> System.out.println("You find... not much.");
            case 2 -> {
                MyGame.getPlayer().setHasWinningItem(true);
                System.out.println("You have found the most powerful object in the Universe.\nYou should probably get out of here before something BAD happens. :)");
            }
        }
    }

}
