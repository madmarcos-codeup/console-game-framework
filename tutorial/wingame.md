# Winning the game

Lastly, let's have a way for the player to win the game. When the goblin is vanquished, the player will receive THE Gaudy Crown of Victory.

On the `Player` side, we can simply use a boolean to represent whether the player has the crown or not. We will add a getter called `hasCrown()` for readability. Lombok will automatically add a getter and setter for us, but the method name for the getter may not be great.

`Player.java`
```java
package docrob.cag.mygame.characters;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Player {
    private String name;

    private int health;

    private boolean hasCrown;

    public Player(String name) {
        this.name = name;
        health = 10;
        hasCrown = false;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public boolean hasCrown() {
        return hasCrown;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if(health < 0) {
            health = 0;
        }
    }
}
```

Next, let's reward the player with the crown when the goblin dies. In `WestScreen`, add a couple of lines to the `attackGoblin()` method.

From this:
```java
...
if(!MyGame.getGoblin().isAlive()) {
    System.out.println("The goblin has died.");
}...
```

to:
```java
...
if(!MyGame.getGoblin().isAlive()) {
    System.out.println("The goblin has died.");
    if(!MyGame.getPlayer().hasCrown()) {
        System.out.println("You retrieve THE Gaudy Crown of Victory from the goblin's twitching corpse.");
        MyGame.getPlayer().setHasCrown(true);
    }
}...
```

Lastly, let's add a hidden menu option to the `EntranceScreen` that reveals itself if the player has the crown. If the player selects the `Win the game` menu option, then we will print a happy message and end the game.

`EntranceScreen.java`

