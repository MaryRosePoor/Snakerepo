import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

public class SnakePanel extends JPanel {
	int[] snake = {(200, 200), (210, 200), (220, 200)};
	
	
	public Dimension getPreferredSize() {
		return new Dimension(500, 500);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 500,500);
		
		g.setColor(Color.green);
		for (int i=0; i<len(snake); i++) {
			g.fillRect(snake[0][0]*10, snake[0][0]*10, 10, 10);
		}
	}
	
	

}