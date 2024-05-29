import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Text {
	String words = "";
	int unit, dimension;
	
	public Text(int unit, int dimension) {
		this.unit = unit;
		this.dimension = dimension;
	}
	
	public void write(Graphics g) {
		Font font = new Font("Arial", Font.BOLD, 18);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString(words, (dimension/2)-50, (dimension/2)-50);
	}
	
	public void setWords(String words) {
		this.words = words;
	}
}