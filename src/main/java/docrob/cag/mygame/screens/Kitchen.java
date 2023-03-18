package docrob.cag.mygame.screens;

import docrob.cag.framework.menu.MenuAction;
import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenBuilder;
import docrob.cag.framework.state.Game;
import docrob.cag.framework.utils.ConsoleColors;

public class Kitchen extends Screen {
    public Kitchen() {
        super();
    }


    @Override
    public void show() {
        System.out.println(ConsoleColors.ANSI_CLEAR +
                "You are in the kitchen. Cobwebs and rusty old cooking implements adorn the walls." +
                "\n\nThere is a corridor heading south.");
        super.show();
    }

    @Override
    public void setupMenu() {
        super.setupMenu();
        menu.addChoice("Go south down the corridor", ScreenBuilder.buildScreen(new HouseEntrance()));
        menu.addChoice("Search the kitchen", searchKitchen);
    }

    // this is a kitchen-specific action
    private MenuAction searchKitchen = () -> {
        switch (Game.getInstance().getRandomInt(1, 3)) {
            case 1 -> System.out.println("You disturb a spider who was happily minding its own business.");
            case 2 -> System.out.println("The ancient sink gurgles and belches a bothersome brown liquid.");
            case 3 ->
                    System.out.println("You find a bloody knife. No, wait... it's a deteriorated banana peel. Never mind.");
            default ->
                    System.out.println("You find nothing nor should you have seen this message. There must be a bug.");
        }
        Game.getInstance().getInput().getString("\nPress Enter to continue");
    };

}
