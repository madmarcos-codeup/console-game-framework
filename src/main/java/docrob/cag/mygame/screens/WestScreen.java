package docrob.cag.mygame.screens;

import docrob.cag.framework.menu.MenuItemMethod;
import docrob.cag.framework.screens.Resettable;
import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenManager;
import docrob.cag.framework.state.Game;
import docrob.cag.framework.utils.ConsoleColors;
import docrob.cag.mygame.MyGame;

public class WestScreen extends Screen implements Resettable {
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
            menu.getItemFromLabel("Smite the goblin").setHidden(false);
        }
        super.show();

    }

    private MenuItemMethod attackGoblin = () -> {
        if(Game.getInstance().getRandomInt(1, 100) <= 75) {
            hitGoblin();
        } else {
            hitByGoblin();
        }
    };

    private void hitByGoblin() {
        System.out.println("You attack the goblin and MISS! The goblin punches you.");
        MyGame.getPlayer().takeDamage(5);
        if(!MyGame.getPlayer().isAlive()) {
            Game.getInstance().getInput().getString("You have died.\nPress Enter to continue.");
            MyGame.killPlayer();
            ScreenManager.addScreen(new MainScreen());
            setReadyToExit();
            return;
        }
        Game.getInstance().getInput().getString("Press Enter to continue.");
    }

    private void hitGoblin() {
        System.out.println("You attack the goblin and HIT!");
        MyGame.getGoblin().setHealth(MyGame.getGoblin().getHealth() - 5);
        if(!MyGame.getGoblin().isAlive()) {
            System.out.println("The goblin has died.");
            if(!MyGame.getPlayer().hasCrown()) {
                System.out.println("You retrieve THE Gaudy Crown of Victory from the goblin's twitching corpse.");
                MyGame.getPlayer().setHasCrown(true);
                // goblin is not alive so hide the menu choice
                menu.getItemFromLabel("Smite the goblin").setHidden(true);
            }
        }
        Game.getInstance().getInput().getString("Press Enter to continue.");
    }
}
