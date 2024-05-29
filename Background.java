import java.awt.Graphics;
import java.awt.Color;

public class Background {
	int unit, dimension;
	
	public Background(int unit, int dimension) {
		this.unit = unit;
		this.dimension = dimension;
	}
	public void draw(Graphics g) {
		g.setColor(Color.black);
        g.fillRect(0, 0, dimension, dimension);
		/*
		//Grid
		g.setColor(Color.gray);
		for (int i=0; i<=dimension; i+=unit) {
			g.drawLine(i, 0, i, dimension);
		}
		for (int i=0; i<=dimension; i+=unit) {
			g.drawLine(0, i, dimension, i);
		}
		*/
	}
}