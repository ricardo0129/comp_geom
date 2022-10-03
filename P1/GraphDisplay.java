import javax.swing.*;
import javax.swing.*;
import java.awt.*;

/*
 * @Code inspired by Antonio Hernandez
 */
public class GraphDisplay extends JPanel {
	GeometricObject[] gobj;
	
	public GraphDisplay(int frameWidth, int frameHeight, GeometricObject[] gobj) {
		this.gobj = gobj;

		Dimension d = new Dimension(frameWidth, frameHeight);
		setPreferredSize(d);
	}

	public void paint(Graphics g) {
		super.paint(g);
		for(GeometricObject single_gobj : gobj) single_gobj.draw(g);
	}
}

