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

    public Player(String name) {
        this.name = name;
        health = 10;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if(health < 0) {
            health = 0;
        }
    }
}