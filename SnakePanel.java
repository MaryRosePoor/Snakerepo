import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

public class SnakePanel extends JPanel {
    Snake snake = new Snake();


    public Dimension getPreferredSize() {
        return new Dimension(500, 500);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, 500, 500);
        snake.draw(g);
    }

    public void animate() {
        while (true) {
            snake.move();

            try {
                Thread.sleep(150);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }



            repaint();
        }
    }
}
