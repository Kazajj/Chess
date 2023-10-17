package chess.chess;

import chess.chess.controller.Controller;
import chess.chess.element.GameListener;
import chess.chess.graphic.ScreenView;
import chess.chess.model.ModelGame;

public class ChessApplication {

	public static void main(String[] args) {
//		int x = 20, y = 20, bombs = 50;

		ModelGame modelGame = new ModelGame();
		Controller controller = new Controller(modelGame);
		GameListener listener = new ScreenView(controller);
		controller.setListener(listener);

		controller.generatePlate();
	}

}
