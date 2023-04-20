# Creating the maze Entrance screen

This screen is the start of the adventure: the place where the player begins.

The `EntranceScreen` will have east and west paths. It will also have a menu option to return to the main menu screen. The east path will lead to the `RedScreen`. The west path will lead to the `GreenScreen`. Both screens have not been made so we will stub these out. 

We will customize the `show` and `setup` methods.

The `show` method is the description for the entrance. Remember to call `super.show()` if you want the superclass to display the menu items in the screen.
```java
@Override
protected void show() {
    System.out.println(ConsoleColors.ANSI_CLEAR);
    System.out.println("You are at the entrance to a scary maze." +
    "\nFrom here, you can run out of the maze, go west, or go east.");

    super.show();
}
```

In the `setup` method, we will add the 3 menu items:
```java
@Override
public void setup() {
    super.setup();
    menu.addItem("Run away!!", new MainScreen());
    menu.addItem("Go west", westStub);
    menu.addItem("Go east", eastStub);
}
```

Lastly, remove the `startAdventure` method from `MainScreen` and replace the following line in `MainScreen`:
```java
menu.addItem("Start the adventure", startAdventure, true);
```
with
```java
menu.addItem("Start the adventure", new EntranceScreen(), true);
```

Below is the complete `EntranceScreen` class. You should be able to run the game and enter the maze.

`EntranceScreen.java`
```java
package docrob.cag.mygame.screens;

import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenManager;
import docrob.cag.framework.state.Game;
import docrob.cag.framework.utils.ConsoleColors;
import docrob.cag.mygame.MyGame;

public class EntranceScreen extends Screen {
    
    @Override
    public void setup() {
        super.setup();
        menu.addItem("Run away!!", new MainScreen());
        menu.addItem("Go west", westStub);
        menu.addItem("Go east", eastStub);
    }

    @Override
    protected void show() {
        System.out.println(ConsoleColors.ANSI_CLEAR);
        System.out.println("You are at the entrance to a scary maze." +
                "\nFrom here, you can run out of the maze, go west, or go east.");

        super.show();

    }

    private MenuItemMethod westStub = () -> {
        System.out.println("TODO: go west");
    };

    private MenuItemMethod eastStub = () -> {
        System.out.println("TODO: go east");
    };
}
```

[Next: the east screen](eastscreen.md)