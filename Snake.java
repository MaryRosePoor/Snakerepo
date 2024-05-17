import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Snake {
    List<List<Integer>> snakeLocation;
    //List<List<Character>> board = new ArrayList<>();
	char snakeDirection;

    public Snake() {
        snakeLocation = new ArrayList<>();
        snakeLocation.add((List.of(20, 20)));
        snakeLocation.add((List.of(21, 20)));
        snakeLocation.add((List.of(22, 20)));
		
		snakeDirection = 'l';

        //List.of(List.of(20, 20),List.of(21, 20), List.of(22, 20));
       // ArrayList<List<Integer>> snakeLocation1=)
       // snake.setSnakeLocation()
        //this.snakeLocation = snakeLocation;
    }



    public void draw(Graphics g) {
        //int[][] snake = {{20, 20}, {21, 20}, {22, 20}};
        /*
        char[] templist[50];

        for (int i = 0; i < 50; i++) {
            templist[i] = "_";
        }
        for (int i = 0; i < 50; i++) {
            board[i] = templist[];
        }
        */

        g.setColor(Color.green);
        for (int i = 0; i < snakeLocation.size()-1; i++) {
            g.fillRect(snakeLocation.get(i).get(0) * 10, snakeLocation.get(i).get(1) * 10, 10, 10);
        }
    }
	
	public void turn(KeyEvent e) {
		
		if ((e.getKeyCode() == 40) && (snakeDirection != 'u')) {
			snakeDirection = 'd';
		} else if ((e.getKeyCode() == 38) && (snakeDirection != 'd')) {
			snakeDirection = 'u';
		} else if ((e.getKeyCode() == 37) && (snakeDirection != 'r')) {
			snakeDirection = 'l';
		} else if ((e.getKeyCode() == 39) && (snakeDirection != 'l')) {
			snakeDirection = 'r';
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
		
        snakeLocation.add(0, List.of(snakeLocation.get(0).get(0) + dx, snakeLocation.get(0).get(1) + dy));
        snakeLocation.remove(snakeLocation.size()-1);
    }
}