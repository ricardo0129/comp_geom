import javax.swing.*;
import java.awt.*;

/**
 * Tests the Rectangle class. 2 overlapping rectangles are instantiated
 * and displayed.
 * 
 * @author Antonio Hernandez
 */
public class Prog04_05
{
    public static void main(String[] args)
    {
        new Prog04_05();
    }
    
    public Prog04_05()
    {        
        GeometricObject[] g = new GeometricObject[6];
        
        //definition of first rectangle
        Point rect1Point1 = new Point(150, 100);
        rect1Point1.setInteriorColor(Color.GREEN);
        
        Point rect1Point2 = new Point(250, 300);
        rect1Point2.setInteriorColor(Color.GREEN);
        
        Rectangle rect1 = new Rectangle(rect1Point1, rect1Point2);
        Color rect1Color = new Color(0, 255, 0, 128);
        rect1.setInteriorColor(rect1Color);
        
        g[0] = rect1;
        g[1] = rect1Point1;
        g[2] = rect1Point2;        

        //definition of second rectangle
        Point rect2Point1 = new Point(300, 150);
        rect2Point1.setInteriorColor(Color.RED);
        
        Point rect2Point2 = new Point(200, 250);
        rect2Point2.setInteriorColor(Color.RED);
        
        Rectangle rect2 = new Rectangle(rect2Point1, rect2Point2);
        Color rect2Color = new Color(255, 0, 0, 128);
        rect2.setInteriorColor(rect2Color);
        
        g[3] = rect2;
        g[4] = rect2Point1;
        g[5] = rect2Point2;


        //drawing
        FrameDisplay frame = new FrameDisplay(g);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
