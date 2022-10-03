import javax.swing.*;

public class FrameDisplay extends JFrame {
		int WIDTH = 400;
		int HEIGHT = 400;

		private GraphDisplay panel;

		public FrameDisplay(GeometricObject[] g) {
			setTitle("Graph Display");
			setSize(WIDTH, HEIGHT);

			panel = new GraphDisplay(WIDTH, HEIGHT, g);
			add(panel);
			pack();
		}

		public void repaint() {
			panel.repaint();
		}
}
