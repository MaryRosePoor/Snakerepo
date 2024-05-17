import javax.swing.JFrame;

public class SnakeRunner {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Snake Project");
		SnakePanel canvas = new SnakePanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);

		canvas.animate();
	}
}
