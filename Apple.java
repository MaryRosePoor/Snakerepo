import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

public class Apple {
	List<Integer> appleLocation;
	
	public Apple(List snakeLocation) {
		appleLocation = new ArrayList<>();
		while (true) {
			//Pick random location for apple
			for (int i=0; i<2; i++) {
			appleLocation.add((int)round(Math.random()*50));
			}
			//Check if apple location overlaps with the snake
			for (int i=0; i<snakeLocation.size()-1; i++) {
				if (snakeLocation.get(i).equals(appleLocation)) {
					continue;
				}
			}
			System.out.println(appleLocation);
			break;
		}
		
	}

	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(appleLocation.get(0)*10, appleLocation.get(1)*10, 10, 10);
	}

	public List getAppleLocation() {
		return appleLocation;
	}
}