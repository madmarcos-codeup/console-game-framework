# Creating the West screen

In this screen, the player will fight with a monster (a goblin). The goblin does not provide much of a challenge. If the player defeats the goblin, the player receives the treasure needed to win the game. If the player is particularly unlucky, then the player dies.

First, let's make the basic WestScreen class, plug it into the game, and test it. 

Copy `EastScreen.java` and name it `WestScreen.java`, and modify it appropriately. Here is a basic `WestScreen`.

`WestScreen.java`

```java
package docrob.cag.mygame.screens;

import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.utils.ConsoleColors;

public class WestScreen extends Screen {
    @Override
    public void setup() {
        super.setup();
        menu.addItem("Go east", new EntranceScreen());
    }

    @Override
    protected void show() {
        System.out.println(ConsoleColors.ANSI_CLEAR);
        System.out.println("You are in the west part of the maze." +
                "\nFrom here, you can go east to return to the entrance.");

        super.show();

    }

}
```

Also, make the following change to `EntranceScreen`. Change:

```java
menu.addItem("Go west", westStub);
```

to 

```java
menu.addItem("Go west", new WestScreen());
```

and remove the `westStub` method. Test your changes by running the game. You should be able to go west from the entrance, and 

---

### Making the goblin

Create a Goblin class. Let's think through the specification for the goblin:

- The goblin can take two hits before dying
- The player can take two hits before dying
- It will persist even if you leave the screen
- Once it is dead, it does not return
- If you leave the game (i.e., choose "0" from the entrance) then the goblin will respawn
- If the player attacks the goblin, there is a 75% chance that the player hits the goblin, and a 25% chance that the goblin hits the player
- When the goblin dies, the player will automatically receive the treasure needed to win the game.

The goblin class will be a simple POJO with an int field for its health. It will start with 10 health. If it is hit by the player, its health will drop to 5. If it is hit again, its health drops to 0 and the goblin dies. Put the following class in your `charcters` package.

`Goblin.java`
```java
package docrob.cag.mygame.characters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Goblin {
    private int health;

    public Goblin() {
        health = 10;
    }

    @Override
    public String toString() {
        if(health > 5) {
            return "The goblin looks uninjured.";
        } else {
            return "The goblin looks close to death.";
        }
    }

    public boolean isAlive() {
        return health > 0;
    }
}
```

We need a game reset method that will create a new goblin whenever the player chooses `Start the adventure` from the main menu. In the `MainScreen`, change the `startAdventure` method to this:
```java
private MenuItemMethod startAdventure = () -> {
    MyGame.initGame();
    ScreenManager.addScreen(new EntranceScreen());
    exit();
};
```

and add this code to `MyGame.java`
```java
public static void initGame() {
    Game.getInstance().addStateItem("goblin", new Goblin());
}

public static Goblin getGoblin() {
    return Game.getInstance().getStateItem("goblin", Goblin.class);
}
```

Now, let's reveal the goblin in the `WestScreen`, if it is alive. Change your `show()` method in the `WestScreen` to this:
```java
protected void show() {
    System.out.println(ConsoleColors.ANSI_CLEAR);
    System.out.println("You are in the west part of the maze." +
            "\nFrom here, you can go east to return to the entrance.");

    if(MyGame.getGoblin().isAlive()) {
        System.out.println("\nThere is a goblin here. " + MyGame.getGoblin().toString());
    }
    super.show();

}
```

Run your game and you will see the goblin in the `WestScreen`.

### Attacking the goblin

We need to add a hidden menu option to the `WestScreen` that will unhide IF the goblin is still alive. To do that, we need to change two things: 
1. add a hidden menu option in the `setup()` method for the screen
2. reveal the hidden menu option in the `show()` method IF the goblin is alive

Lastly, we must add a method in `WestScreen` to attack the goblin. The method will have a 75% of hitting the goblin. If the goblin is hit, we will use its getters and setters to adjust its health. We won't bother adjusting our health yet if we are hit.

Below is the modified `WestScreen`:

`WestScreen.java`
```java
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
```
---

### Taking damage and possibly dying

Finally, let's enhance the `Player` object to track health. Just like the goblin, let's start with 10 health, and if the goblin hits us, we will lose 5 health. If the `Player` is hit twice (unlikely, but possible), then the `Player` will die and be sent back to the `MainScreen`.
