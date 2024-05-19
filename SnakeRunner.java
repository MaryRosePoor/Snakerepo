import javax.swing.JFrame;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class SnakeRunner {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Snake Project");
		SnakePanel canvas = new SnakePanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
		
		canvas.setFocusable(true);
		canvas.requestFocusInWindow();

		canvas.startGame();
	}
}
