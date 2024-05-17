import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Snake {
    List<List<Integer>> snakeLocation;
    //List<List<Character>> board;
	char snakeDirection;

    public Snake() {
        //Initializing snakeLocation
		snakeLocation = new ArrayList<>();
		for (int i=20; i<30; i++) {
			snakeLocation.add(List.of(i, 20));
		}
		
		/*
		//Initializing board
		board = new ArrayList<>();
		List<Character> templist = new ArrayList<>();
		for (int i=0; i<50; i++) {
			templist.add('_');
		}
		for (int i=0; i<50; i++) {
			board.add(templist);
		}
		*/

		snakeDirection = 'l';
    }

    public void draw(Graphics g) {
        g.setColor(Color.green);
        for (int i = 0; i < snakeLocation.size()-1; i++) {
            g.fillRect(snakeLocation.get(i).get(0) * 10, snakeLocation.get(i).get(1) * 10, 10, 10);
        }
    }
	
	public void turn(KeyEvent e) {
		if ((e.getKeyCode() == 40) && (snakeDirection != 'd')) {
			snakeDirection = 'u';
		} else if ((e.getKeyCode() == 38) && (snakeDirection != 'u')) {
			snakeDirection = 'd';
		} else if ((e.getKeyCode() == 37) && (snakeDirection != 'r')) {
			snakeDirection = 'l';
		} else if ((e.getKeyCode() == 39) && (snakeDirection != 'l')) {
			snakeDirection = 'r';
		}
	}
	
	public void checkCollision() {
		//Edge collision
		if (snakeLocation.get(0).get(0) < 0 || snakeLocation.get(0).get(0) >50) {
			System.out.println("off screen");
			System.exit(0);
		}
		if (snakeLocation.get(0).get(1) < 0 || snakeLocation.get(0).get(1) >50) {
			System.out.println("off screen");
			System.exit(0);
		}
		
		//Snake collision
		for (int i=1; i<snakeLocation.size()-1; i++) {
			if (snakeLocation.get(i).equals(snakeLocation.get(0))){
				System.out.println("touching");
				System.exit(0);
			}
		}	
	}

    public void move() {
		int dx = 0, dy = 0;
		if (snakeDirection == 'u') {
			dy = 1;
		} else if (snakeDirection == 'd') {
			dy = -1;
		} else if (snakeDirection == 'r') {
			dx = 1;
		} else if (snakeDirection == 'l') {
			dx = -1;
		}
		
		checkCollision();
        snakeLocation.add(0, List.of(snakeLocation.get(0).get(0) + dx, snakeLocation.get(0).get(1) + dy));
        snakeLocation.remove(snakeLocation.size()-1);
    }
}