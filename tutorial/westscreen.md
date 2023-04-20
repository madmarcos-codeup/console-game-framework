# Creating the West screen

In this screen, the player will fight with a monster (a goblin). The goblin does not provide much of a challenge. If the player defeats the goblin, the player receives the treasure needed to win the game. If the player is particularly unlucky, then the player dies.

First, let's make the basic WestScreen class, plug it into the game, and test it. 

Copy `EastScreen.java` and name it `WestScreen.java`, and modify it appropriately. Here is a basic `WestScreen`.

`WestScreen.java`

```java

```

Also, make the following change to `EntraceScreen`. Change:

```java
menu.addItem("Go west", westStub);
```

to 

```java
menu.addItem("Go west", new WestScreen());
```

and remove the 