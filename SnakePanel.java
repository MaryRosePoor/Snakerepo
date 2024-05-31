import javax.swing.JPanel;
import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;	

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class SnakePanel extends JPanel implements KeyListener{
    Background background;
	Snake snake;
	Apple apple;
	Text scoretext, highscoretext;
	int speed, unit = 20, dimension = unit*33, highscore = 0;
	boolean paused;
	
	public Dimension getPreferredSize() {
        return new Dimension(dimension, dimension);

    }
	
	public SnakePanel() {
		addKeyListener(this);
		background  = new Background(unit, dimension);
		snake = new Snake(unit, dimension);
		apple = new Apple(snake.snakeLocation, unit, dimension);
		scoretext = new Text((dimension/2)-50, (dimension/2)-30);
		highscoretext = new Text((dimension/2)-75, (dimension/2)-50);
		paused = true;
	}

    public void startGame() {
		if ((snake.snakeLocation.size()-10) > highscore) {
			highscore = snake.snakeLocation.size()-10;
		}
		
        showText();

		snake = new Snake(unit, dimension);
        apple = new Apple(snake.snakeLocation, unit, dimension);
		speed = 180;
		
		paused = true;
		while (paused) {
			System.out.print("");
		}
		
		animate();
    }
	 
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        background.draw(g);
        apple.draw(g);
		snake.draw(g);
		scoretext.write(g);	
		highscoretext.write(g);	
    }

	public void keyPressed(KeyEvent e) {
		snake.turn(e);
		paused = false;
		//System.out.println("key pressed");
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	
	public int checkSpeed(int speed) {
		if ((snake.snakeLocation.size()-10)%5 == 0) {
			return (speed - 10);
			
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
				
				//System.out.println("speed: " + (speed));
				//System.out.println("size: " + (snake.snakeLocation.size()));
				
			} else {snake.move(false);}
			
            try {
                Thread.sleep(speed);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
			
			scoretext.setWords("");
			highscoretext.setWords("");
			
            repaint();
        }
    }
	
	public void showText() {
		scoretext.setWords("Score: " + (snake.snakeLocation.size()-10));
		highscoretext.setWords("High Score: " + highscore);
		
		repaint();
	}
}
