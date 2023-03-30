# A Tutorial for DocRob's Old Fashioned Console Game Dev Framework

A good way to learn how to use a tool is to jump right in and build something [simple] with it. So let's do that.

We will make a little maze game where you try to find the most powerful object in the Universe and return to the room where you started in order to win the game.

## Making your first screen
Let's start with a welcome screen that will output some text, wait for the user to press Enter, and then navigate to the Main menu screen.

The framework sees your game as a sequence of _Screens_. A _screen_ is like a room in a dungeon or house. So a dungeon would be a sequence of screens that the player explores. One screen can have things for the player to do, like search for treasure. It can also have connections to other screens, allowing the player to move from one room to another.

Screens typically:
1. show some descriptive text to the player (e.g., a description of the room that the player entered)
2. present a menu of choices available to the player
3. wait for the user to choose one of the menu items
4. do whatever the choice involves (e.g., randomly determine if the user found some loot, take a swing at a monster, move to another room)

### Writing the code for the Welcome Screen
Screens must extend the `Screen` class.

Next, create a no argument constructor and call `super()` from it. You can add any additional creation code you need in the constructor after the call to super's constructor. 
```java
public WelcomeScreen() {
    super();
}
```

The welcome screen will not have a menu of choices, so we don't have to do anything with that yet. We will discuss menu setup later.

Next, override the `show()` method to display a screen-specific description:
```java
@Override
public void show() {
    System.out.println(ConsoleColors.ANSI_CLEAR);
    System.out.println("This is the Welcome screen!");
}
```

You will most likely always override the `show()` method for each of your screens. The superclass' `show()` is an empty method. 

**TODO:** this should probably be an abstract method in the future.

Note that outputting `ConsoleColors.ANSI_CLEAR` clears the console. Look at the framework's `ConsoleColors` class to see other console control and color constants.

Lastly, override the `handleInput()` method. Unlike `show()`, many of your screens will just use the superclass' definition of `handleInput()`. However, in the welcome screen, we don't want the default behavior. We just want to wait for the user to press the Enter key. And once that happens, we manually move to the Main menu screen.

```java
@Override
protected void handleInput() {
    Game.getInstance().getInput().getString("Press Enter to continue.");

    ScreenManager.addScreen(new MainScreen());
    // since there is no input loop in this screen, this method will exit and the screen manager will move to the MainScreen
}
```

Notice that the `Game` class can provide keyboard interaction functionality for you, or you can make your own if you wish.

The `ScreenManager` class handles all screen-to-screen switching. Normally, you do not need to interact with the `ScreenManager` unless you want to manually cause a screen to move to another screen (which is the case here). Navigation that occurs from selecting a menu option is handled automatically as we shall see in the Main menu screen.

### Starting the game and launching the Welcome Screen

To launch the game and display the Welcome screen, create a class with a `main()` method. Inside the main method, you add the Welcome screen to the `ScreenManager` and then start the `ScreenManager`. When your last screen exits, control will return to the `main()` method just after you called `start()`.

Here is an example of a `main()` that starts the game with our WelcomeScreen class.

```java
public static void main(String[] args) {
    // show welcome
    Screen screen = new WelcomeScreen();
    ScreenManager.addScreen(screen);
    ScreenManager.start();

    // when the screen manager returns, the app is ready to quit
    // i.e., the user has exited from the main screen
    System.out.println("Bye");

}
```
