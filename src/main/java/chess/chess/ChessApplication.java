package chess.chess;

import chess.chess.controller.Controller;
import chess.chess.element.GameListener;
import chess.chess.graphic.ScreenView;
import chess.chess.model.ModelGame;

import javax.swing.*;

public class ChessApplication {

	public static void main(String[] args) {
		ModelGame modelGame = new ModelGame();
		Controller controller = new Controller(modelGame);
		GameListener listener = new ScreenView(controller);
		controller.setListener(listener);

		SwingUtilities.invokeLater(controller::generatePlate);
	}

}
