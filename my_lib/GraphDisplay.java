import java.util.Scanner;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;

public class GraphDisplay extends JPanel{
	ArrayList<Point> events;
	public GraphDisplay(){
		events = new ArrayList<Point>();
		events.add(new Point(3,3));
	}
	public void paint(Graphics g){
		for(Object i: events){
			System.out.println("EVENT LOOP");
			i.draw(g);
		}
		g.drawOval(10,10,40,40);
	}

}
