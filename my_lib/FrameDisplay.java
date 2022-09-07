import javax.swing.*;

public class FrameDisplay extends JFrame{
	int WIDTH = 430, HEIGHT = 350;
	private GraphDisplay panel;
	public FrameDisplay(){
		setTitle("Computational Geometry");
		setSize(WIDTH,HEIGHT);
		panel = new GraphDisplay();
		add(panel);
	}
	public void repaint(){
		System.out.println("B");
		panel.repaint();
	}
}
