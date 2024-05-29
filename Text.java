import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Text {
	String words = "";
	
	public void write(Graphics g) {
		Font font = new Font("Arial", Font.BOLD, 18);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString(words, 280, 280);
	}
	
	public void setWords(String words) {
		this.words = words;
	}
}