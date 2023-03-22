package docrob.cag.mygame.characters;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Player {
    private String name;

    private boolean hasWinningItem;

    public boolean hasWinningItem() {
        return hasWinningItem;
    }
}
