package docrob.cag.mygame.screens;

import docrob.cag.framework.menu.MenuChoice;
import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenBuilder;
import docrob.cag.framework.state.Game;
import docrob.cag.framework.utils.ConsoleColors;

public class WinScreen extends Screen {

    public WinScreen() {
        super();
    }

    @Override
    public void show() {
        System.out.print(ConsoleColors.ANSI_CLEAR + ConsoleColors.ANSI_YELLOW + "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
    "\nX                                      X" +
    "\nX" + ConsoleColors.ANSI_RESET + "      A FABULOUS Victory Screen     " + ConsoleColors.ANSI_YELLOW + " X" +
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
