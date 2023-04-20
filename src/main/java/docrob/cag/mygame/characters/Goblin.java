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
