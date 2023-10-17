package chess.chess.objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Box {

    private int		value;
    private int		x, y;
    private boolean	checked, flag;

    public Box(int x, int y) {
        checked = false;
        flag = false;
        value = 0;
        this.x = x;
        this.y = y;
    }

}
