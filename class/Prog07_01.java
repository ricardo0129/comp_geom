
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

/**
 * Illustrating the point location problem. A set of 6 rectangles is read from
 * a text file and displayed. When cursor hovers over the application window,
 * if it goes over a rectangle, shape of cursor changes to a pointing hand.
 * 
 * @author Antonio Hernandez
 */
public class Prog07_01
{
    public static void main(String[] args)
    {
        new Prog07_01();
    }
    
    public Prog07_01()
    {    
        GeometricObject[] g;
        
        //reads rectangles info from input file
        File input = new File("Prog07_01 input file.txt");

        Scanner in = null;
        try
        {
            in = new Scanner(input);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found!");
        }

        int rectNumber;
        int ctr = 0; //rectangles read so far
        
        rectNumber = in.nextInt(); //reads number of rectangles (first line in file)
        g = new GeometricObject[rectNumber];

        //reads info of rectangles
        for(int i=0; i<rectNumber; i++)
        {
            double x1 = in.nextDouble();
            double y1 = in.nextDouble();
            Point p1 = new Point(x1, y1);

            double x2 = in.nextDouble();
            double y2 = in.nextDouble();
            Point p2 = new Point(x2, y2);

            Rectangle rect = new Rectangle(p1, p2);
            rect.setInteriorColor(new Color(0, 128, 128, 128));

            g[ctr++] = rect;
        }
        
        in.close();
        FrameDisplay frame = new FrameDisplay(g);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
