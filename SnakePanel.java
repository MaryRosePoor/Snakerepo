import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class SnakePanel extends JPanel implements KeyListener{
    Snake snake;
	Apple apple;
	
	public SnakePanel() {
		snake = new Snake();
		setFocusable(true);
		addKeyListener(this);
		
		apple = new Apple();
	}
	
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, 500, 500);
        snake.draw(g);
    }

	public void keyPressed(KeyEvent e) {
		snake.turn(e);
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}

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
