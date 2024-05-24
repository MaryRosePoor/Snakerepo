import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.floor;

public class Apple {
	List<Integer> appleLocation;
	int unit;
	
	public Apple(List snakeLocation) {
		appleLocation = new ArrayList<>();
		unit = 15;
		boolean loop = true;
		while (loop) {
			loop = false;
			//Pick random location for apple
			for (int i=0; i<2; i++) {
			appleLocation.add((int)floor(Math.random()*(500/unit-1)));
			}	
			
			//Check if apple location overlaps with the snake
			for (int i=0; i<snakeLocation.size()-1; i++) {
				if (snakeLocation.get(i).equals(appleLocation)) {
					System.out.println("overlap");
					loop = true;
				}
			}
			
		}
		System.out.println(appleLocation);			
	}

	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(appleLocation.get(0)*unit, appleLocation.get(1)*unit, unit, unit);
	}

	public List getAppleLocation() {
		return appleLocation;
	}
}