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