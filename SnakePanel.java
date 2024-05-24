import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class SnakePanel extends JPanel implements KeyListener{
    Snake snake;
	Apple apple;
	int speed, unit = 15, dimension = 500;
	
	public SnakePanel() {
		addKeyListener(this);
		snake = new Snake(unit, dimension);
		apple = new Apple(snake.snakeLocation, unit, dimension);
	}

    public void startGame() {
        snake = new Snake(unit, dimension);
        apple = new Apple(snake.snakeLocation, unit, dimension);
		speed = 180;

        animate();
    }
	
    public Dimension getPreferredSize() {
        return new Dimension(dimension, dimension);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, dimension, dimension);
        apple.draw(g);
		snake.draw(g);
    }

	public void keyPressed(KeyEvent e) {
		snake.turn(e);
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	
	public int checkSpeed(int speed) {
		if ((snake.snakeLocation.size()-10)%5 == 0) {
			return (speed - 20);
			
		} else {return speed;}
	}

    public void animate() {
        while (true) {
            if (snake.checkLoseCollision()) {
                startGame();
            } else if (snake.checkAppleCollision(apple.getAppleLocation())) {
                apple = new Apple(snake.snakeLocation, unit, dimension);
				snake.move(true);
				speed = checkSpeed(speed);
				
				System.out.println("speed: " + (speed));
				System.out.println("size: " + (snake.snakeLocation.size()));
				
			} else {snake.move(false);}
			
            try {
                Thread.sleep(speed);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
			
            repaint();
        }
    }
}
