package chess.chess.graphic;

import chess.chess.controller.Controller;
import chess.chess.element.GameButton;
import chess.chess.element.GameListener;
import chess.chess.model.PiecesEnum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class ScreenView implements GameListener {

    private JPanel panel;
    private JTextField status;
    private JTextField bombs;
    private JFrame frame;
    private GameButton[][] buttons;
    private final Controller controller;
    Map<String, ImageIcon> piecesBlack = new HashMap<>();
    Map<String, ImageIcon> piecesWhite = new HashMap<>();

    public ScreenView(Controller controller) {
        this.controller = controller;
    }

    public void generateGamePanel() {
        frame = new JFrame("Clickable Chessboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        buttons = new GameButton[8][8];
        loadAndResizeImages();
        createChessboard();

        frame.add(createChessboardPanel());
        frame.pack();
        frame.setVisible(true);

        updateGraphic();
    }

    @Override
    public void updateGraphic() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JButton square = buttons[row][col];
                Color currentColor = square.getBackground();
                Color newColor = (currentColor == Color.DARK_GRAY) ? Color.LIGHT_GRAY : Color.DARK_GRAY;
                square.setBackground(newColor);

                switch (row) {
                    case 1 -> square.setIcon(piecesBlack.get(PiecesEnum.PEDONE.getStringValue()));
                    case 0 -> setInitialPieces(square, piecesBlack, col);
                    case 6 -> square.setIcon(piecesWhite.get(PiecesEnum.PEDONE.getStringValue()));
                    case 7 -> setInitialPieces(square, piecesWhite, col);
                }
            }
        }
    }

    private void setInitialPieces(JButton square, Map<String, ImageIcon> pieces, int col) {
        switch (col) {
            case 0, 7 -> square.setIcon(pieces.get(PiecesEnum.TORRE.getStringValue()));
            case 1, 6 -> square.setIcon(pieces.get(PiecesEnum.CAVALLO.getStringValue()));
            case 2, 5 -> square.setIcon(pieces.get(PiecesEnum.ALFIERE.getStringValue()));
            case 3 -> square.setIcon(pieces.get(PiecesEnum.REGINA.getStringValue()));
            case 4 -> square.setIcon(pieces.get(PiecesEnum.RE.getStringValue()));
        }
    }

    private void createChessboard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                GameButton square = new GameButton();
                square.setPreferredSize(new Dimension(80, 80));
                square.setBackground((row + col) % 2 == 0 ? Color.LIGHT_GRAY : Color.DARK_GRAY);
                square.addMouseListener(new SquareClickListener(row, col));
                buttons[row][col] = square;
            }
        }
    }

    private void loadAndResizeImages() {
        String localPath = "C:\\Users\\Enzo\\IdeaProjects\\chess\\src\\main\\resources\\pieces\\";
        String ext = ".png";
        for (PiecesEnum enumValue : PiecesEnum.values()) {
            String piece = enumValue.getStringValue();
            ImageIcon blackOriginal = new ImageIcon(localPath + piece + "Black" + ext);
            ImageIcon blackResized = new ImageIcon(blackOriginal.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
            ImageIcon whiteOriginal = new ImageIcon(localPath + piece + "White" + ext);
            ImageIcon whiteResized = new ImageIcon(whiteOriginal.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
            piecesBlack.put(piece, blackResized);
            piecesWhite.put(piece, whiteResized);
        }
    }

    private JPanel createChessboardPanel() {
        JPanel chessboardPanel = new JPanel(new GridLayout(8, 8));
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                chessboardPanel.add(buttons[row][col]);
            }
        }
        return chessboardPanel;
    }

    private class SquareClickListener implements MouseListener {
        private int row;
        private int col;

        SquareClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // Handle square click here
            System.out.println("Clicked square at row " + row + " and column " + col + ". VALUE = " + String.valueOf(controller.getBox(row, col).getValue()));
            updateGraphic();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}
