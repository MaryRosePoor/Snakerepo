import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class SnakePanel extends JPanel implements KeyListener{
    Snake snake;
	Apple apple;
	
	public SnakePanel() {
		addKeyListener(this);
		
		snake = new Snake();
		apple = new Apple(snake.snakeLocation);
	}

    public void startGame() {
        snake = new Snake();
        apple = new Apple(snake.snakeLocation);

        animate();
    }
	
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, 500, 500);
        snake.draw(g);
        apple.draw(g);
    }

	public void keyPressed(KeyEvent e) {
		snake.turn(e);
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}

    public void animate() {
        while (true) {
            if (snake.checkLoseCollision()) {
                startGame();
            } else if (snake.checkAppleCollision(apple.getAppleLocation())) {
                apple = new Apple(snake.snakeLocation);
				snake.move(true);
				System.out.println(snake.snakeLocation.size());
			} else {snake.move(false);}
			
            try {
                Thread.sleep(140);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
			
            repaint();
        }
    }
}
