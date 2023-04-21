package docrob.cag.mygame.screens;

import docrob.cag.framework.menu.MenuItemMethod;
import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.state.Game;
import docrob.cag.framework.utils.ConsoleColors;
import docrob.cag.mygame.MyGame;

public class WestScreen extends Screen {
    @Override
    public void setup() {
        super.setup();
        menu.addItem("Go east", new EntranceScreen());
        menu.addItem("Smite the goblin", attackGoblin, true);
    }

    @Override
    protected void show() {
        System.out.println(ConsoleColors.ANSI_CLEAR);
        System.out.println("You are in the west part of the maze." +
                "\nFrom here, you can go east to return to the entrance.");

        if(MyGame.getGoblin().isAlive()) {
            System.out.println("\nThere is a goblin here. " + MyGame.getGoblin().toString());
            menu.getChoiceFromLabel("Smite the goblin").setHidden(false);
        } else {
            // goblin is not alive so hide the menu choice, just in case it was unhidden previously
            menu.getChoiceFromLabel("Smite the goblin").setHidden(true);
        }
        super.show();

    }

    private MenuItemMethod attackGoblin = () -> {
        if(Game.getInstance().getRandomInt(1, 100) <= 75) {
            System.out.println("You attack the goblin and HIT!");
            MyGame.getGoblin().setHealth(MyGame.getGoblin().getHealth() - 5);
            if(!MyGame.getGoblin().isAlive()) {
                System.out.println("The goblin has died.");
            }
        } else {
            System.out.println("You attack the goblin and MISS!");
        }
    };
}
