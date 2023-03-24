package docrob.cag.framework.screens;

import docrob.cag.framework.menu.MenuChoice;

public class ErrorScreen extends Screen {
    @Override
    public void show() {
        System.out.println("Error!");
    }

//    @Override
//    public MenuChoice handleUser() {
//        return new MenuChoice("", ScreenManager.NO_ACTION);
//    }
}
