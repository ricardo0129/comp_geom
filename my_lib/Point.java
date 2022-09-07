import javax.swing.*;
import java.util.Scanner;
import java.awt.Graphics;
public class Point {
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
		System.out.println("CREATED");
	}
	void draw(Graphics g){
		System.out.println("A");
		g.setColor(Color.BLACK);
		g.drawOval(100,100,200,200);
	}
}
