package chess.chess.controller;

import chess.chess.element.GameListener;
import chess.chess.model.ModelGame;
import chess.chess.objects.Box;
import lombok.Data;

@Data
public class Controller {

    final int GRID_SIZE = 8;
    ModelGame modelGame;
    GameListener listener;

    public Controller(ModelGame modelGame) {
        this.modelGame = modelGame;
        this.listener = null;
    }

    public void generatePlate() {
        modelGame.generatePlate();
        listener.generateGamePanel();
    }

    public Box getBox(int x, int y) {
        return modelGame.getBox(x, y);
    }

    public int getX() {
        return modelGame.getX();
    }

    public int getY() {
        return modelGame.getY();
    }

    public void onClick(int x, int y) {

    }

}
