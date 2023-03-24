package docrob.cag.framework.menu;

import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenManager;
import docrob.cag.framework.screens.ScreenState;
import docrob.cag.framework.state.Game;
import docrob.cag.framework.utils.Input;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Menu {
    private int idCounter = 0;

    private ArrayList<MenuItem> items;

//
//    private ArrayList<MenuChoice> choices;
//
    public Menu() {
//        choices = new ArrayList<>();
        items = new ArrayList<>();
    }

    public void addItem(String label, MenuItemMethod theMethod) {
        MenuItem item = new FunctionMenuItem(idCounter++, label, theMethod);
        items.add(item);
    }

    public void addItem(String label, Screen navToScreen) {

        MenuItem item = new NavMenuItem(idCounter++, label, () -> {
            navToScreen.setScreenState(ScreenState.ReadyToQueue);
            ScreenManager.addScreen(navToScreen);
        });
        items.add(item);
    }
    public MenuItem getSelectedItemFromUser(Input input) {
        int num = Game.getInstance().getInput().getInt("Enter your choice: ");
        // check if num is a valid menu choice
        for (MenuItem item : items) {
            if(item.getId() == num) {
                return item;
            }
        }

        // did not select a valid choice num so do again
        System.out.print("That was not a valid choice!\n");
        return getSelectedItemFromUser(input);
    }

//
//    public Menu(int idStartingVal) {
//        this();
//        idCounter = idStartingVal;
//    }
//
//    public void addChoice(String label) {
//        MenuChoice choice = new MenuChoice(label);
//        choice.setId(idCounter++);
//        choices.add(choice);
//    }
//
//    public void addChoice(String label, MenuAction action) {
//        addChoice(label);
//        MenuChoice choice = getChoiceFromLabel(label);
//        choice.setAction(action);
//    }
//
//    public void addChoice(String label, MenuAction action, boolean hidden) {
//        addChoice(label);
//        MenuChoice choice = getChoiceFromLabel(label);
//        choice.setAction(action);
//        choice.setHidden(hidden);
//    }
//
//    public void addChoice(String label, int myIntVal) {
//        addChoice(label);
//        MenuChoice choice = getChoiceFromLabel(label);
//        choice.setMyIntVal(myIntVal);
//    }
//
//    public MenuChoice getChoiceFromLabel(String label) {
//        for (MenuChoice choice : choices) {
//            if(choice.getLabel().equals(label)) {
//                return choice;
//            }
//        }
//        throw new MenuException("Invalid menu choice requested: " + label);
//    }
//
//    // accessors
//
//    public ArrayList<MenuChoice> getChoices() {
//        return choices;
//    }
//
//    public MenuChoice getChoiceFromUser(Input input) {
//        int num = Game.getInstance().getInput().getInt("Enter your choice: ");
//        // check if num is a valid menu choice
//        for (MenuChoice choice : choices) {
//            if(choice.getId() == num) {
//                return choice;
//            }
//        }
//
//        // did not select a valid choice num so do again
//        System.out.print("That was not a valid choice!\n");
//        return getChoiceFromUser(input);
//    }
}
