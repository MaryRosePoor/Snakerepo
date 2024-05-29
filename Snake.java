import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import java.awt.event.KeyEvent;

public class Snake {
    List<List<Integer>> snakeLocation;
	char snakeDirection;
	int unit, dimension;

    public Snake(int unit, int dimension) {
		this.unit = unit;
		this.dimension = dimension;
        //Initializing snakeLocation
		snakeLocation = new ArrayList<>();
		for (int i=((dimension/2)/unit); i<((dimension/2)/unit + 10); i++) {
			snakeLocation.add(List.of(i, ((dimension/2)/unit)));
		}
		//System.out.println("starting location: " + snakeLocation.get(0));
		snakeDirection = 'l';
    }

    public void draw(Graphics g) {
        g.setColor(Color.green);
        for (int i = 0; i < snakeLocation.size()-1; i++) {
            g.fillRect(snakeLocation.get(i).get(0) * unit, snakeLocation.get(i).get(1) * unit, unit, unit);
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
	
	public boolean checkLoseCollision() {
		//Edge collision
		if (snakeLocation.get(0).get(0) < 0 || snakeLocation.get(0).get(0) >= dimension/unit) {
			return true;
		} else if (snakeLocation.get(0).get(1) < 0 || snakeLocation.get(0).get(1) >= dimension/unit) {
			return true;
		}

		//Snake collision
		for (int i=1; i<snakeLocation.size()-1; i++) {
			if (snakeLocation.get(i).equals(snakeLocation.get(0))) {
				return true;
			}
		}
		return false;
	}

	public boolean checkAppleCollision(List appleLocation) {
		if (snakeLocation.get(0).equals(appleLocation)) {
			return true;
		} else {
			return false;
		}
	}

    public void move(boolean grow) {
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
        if (!grow) {
			snakeLocation.remove(snakeLocation.size()-1);
		} 
    }
}