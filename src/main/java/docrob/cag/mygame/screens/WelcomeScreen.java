package docrob.cag.mygame.screens;

import docrob.cag.framework.menu.MenuChoice;
import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenBuilder;
import docrob.cag.framework.state.Game;
import docrob.cag.framework.utils.Input;

public class WelcomeScreen extends Screen {

    public WelcomeScreen() {
        super();
    }

    @Override
    public void show() {
        System.out.print("""
    Welcome to a maze game!
    
    Press Enter to continue.
    """);
    }

    @Override
    public MenuChoice handleUser() {
        // wait for user to press enter
        Game.getInstance().getInput().getString();

        MenuChoice choice = new MenuChoice("", ScreenBuilder.buildScreen(new MainScreen()));
        choice.doAction();
        return choice;
    }
}
