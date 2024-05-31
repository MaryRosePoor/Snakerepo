import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Text {
	String words = "";
	int x, y;
	
	public Text(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void write(Graphics g) {
		Font font = new Font("Arial", Font.BOLD, 18);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString(words, x, y);
	}
	
	public void setWords(String words) {
		this.words = words;
	}
}