package docrob.cag.mygame.screens;

import docrob.cag.framework.menu.MenuChoice;
import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenBuilder;
import docrob.cag.framework.state.Game;
import docrob.cag.framework.utils.ConsoleColors;

public class WelcomeScreen extends Screen {

    public WelcomeScreen() {
        super();
    }

    @Override
    public void show() {
        System.out.print(ConsoleColors.ANSI_CLEAR + ConsoleColors.ANSI_PURPLE + "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
    "\nX                                      X" +
    "\nX" + ConsoleColors.ANSI_RESET + "      Welcome to SPOOKY HAUS!!1!     " + ConsoleColors.ANSI_PURPLE + " X" +
    "\nX                                      X" +
    "\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
    "\n\n" + ConsoleColors.ANSI_RESET + "Press Enter to continue.");
    }

    @Override
    public MenuChoice handleUser() {
        // wait for user to press enter
        Game.getInstance().getInput().getString();

        MenuChoice choice = new MenuChoice("", ScreenBuilder.makeFlowActionForScreen(new MainScreen()));
        choice.doAction();
        return choice;
    }
}
