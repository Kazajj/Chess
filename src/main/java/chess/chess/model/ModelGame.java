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
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                boxes[row][col] = new Box(row, col);
                switch (row) {
                    case 1, 6 -> boxes[row][col].setValue(PiecesEnum.PEDONE.getIntValue());
                    case 0, 7 -> setInitalPiecesValue(boxes[row][col], col);
                }
            }
        }
    }

    private void setInitalPiecesValue(Box box, int col) {
        switch (col) {
            case 0, 7 -> box.setValue(PiecesEnum.TORRE.getIntValue());
            case 1, 6 -> box.setValue(PiecesEnum.CAVALLO.getIntValue());
            case 2, 5 -> box.setValue(PiecesEnum.ALFIERE.getIntValue());
            case 3 -> box.setValue(PiecesEnum.REGINA.getIntValue());
            case 4 -> box.setValue(PiecesEnum.RE.getIntValue());
        }
    }

    public Box getBox(int x, int y) {
        return boxes[x][y];
    }

}
