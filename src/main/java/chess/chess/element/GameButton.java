package chess.chess.element;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class GameButton extends JButton {

    private int x, y;

    public GameButton() {
        this.setSize(50, 50);
        this.setBackground(Color.LIGHT_GRAY);
    }

    public void setCoordinateXandY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
