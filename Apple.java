import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

public class Apple {
	List<Integer> appleLocation;
	
	public Apple() {
		appleLocation = new ArrayList<>();
		for (int i=0; i<2; i++) {
			appleLocation.add((int)round(Math.random()*50));
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