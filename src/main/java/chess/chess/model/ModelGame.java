package chess.chess.model;

import chess.chess.objects.Box;
import lombok.Data;

@Data
public class ModelGame {

    private int			x, y, bombs;
//    private GameState	state;
    private Box[][]		boxes;

//    public ModelGame() {
//        state = GameState.WAITING;
//    }

    public void generatePlate() {
        final int GRID_SIZE = 8;
        boxes = new Box[GRID_SIZE][GRID_SIZE];
        for (int x = 0; x < GRID_SIZE; x++) {
            for (int y = 0; y < GRID_SIZE; y++) {
                boxes[x][y] = new Box(x, y);
            }
        }
    }

    public Box getBox(int x, int y) {
        return boxes[x][y];
    }

}
