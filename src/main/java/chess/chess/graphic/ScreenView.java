package chess.chess.graphic;

import chess.chess.controller.Controller;
import chess.chess.element.GameButton;
import chess.chess.element.GameListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ScreenView implements MouseListener, GameListener {

    private JPanel panel;
    private JTextField status;
    private JTextField bombs;
    private JFrame frame;
    private GameButton[][] buttons;
    private final Controller controller;

    public ScreenView(Controller controller) {
        this.controller = controller;
    }

    public void generateGamePanel() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setLocation(0, 0);
        panel.setPreferredSize(new Dimension(50 * controller.getGRID_SIZE(), 50 * controller.getGRID_SIZE()));
        panel.setVisible(true);

        generatePlate();
//        generateStatus();

        frame.add(panel);
        frame.pack();

        frame.repaint();
    }

    public void generatePlate() {
        int colorCounter = 0;
        buttons = new GameButton[controller.getGRID_SIZE()][controller.getGRID_SIZE()];
        for (int i = 0; i < controller.getGRID_SIZE(); i++) {
            for (int j = 0; j < controller.getGRID_SIZE(); j++) {
                buttons[i][j] = new GameButton();
                buttons[i][j].setCoordinateXandY(i, j);
                buttons[i][j].setLocation(50 * i, 50 * j);
                buttons[i][j].setVisible(true);
                buttons[i][j].addMouseListener(this);
                if ((colorCounter % 2 == 0)) {
                    buttons[i][j].setBackground(Color.WHITE);
                } else {
                    buttons[i][j].setBackground(Color.BLACK);
                }
                panel.add(buttons[i][j]);
                colorCounter++;
            }
            colorCounter++;
        }
    }

    @Override
    public void updateGraphic() {
//        if (controller.isGameOver() || controller.isWin()) {
//            gameoverGraphics();
//            return;
//        }
        for (int i = 0; i < controller.getGRID_SIZE(); i++) {
            for (int j = 0; j < controller.getGRID_SIZE(); j++) {
//                if (controller.getBox(i, j).isFlag()) {
//                    buttons[i][j].setBackground(Color.CYAN);
//                } else {
//                    buttons[i][j].setBackground(Color.LIGHT_GRAY);
//                    isChecked(i, j);
//            }
            }
        }
//        status.setText(REMAINING_BOMBS + Integer.toString(controller.getStatusBombs()));
        frame.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        GameButton gameButton = (GameButton) e.getSource();
        int x = gameButton.getX();
        int y = gameButton.getY();

        if (SwingUtilities.isLeftMouseButton(e)) {
            controller.onLeftClick(x, y);

        }

//        if (SwingUtilities.isRightMouseButton(e)) {
//            controller.onRightClick(x, y);
//        }
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
