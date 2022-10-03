
import java.awt.Color;
import java.util.Random;
import javax.swing.*;

/**
 * Tests the LineSegment class. 5 line segments with endpoints in 
 * rectangle [0, 350) x [0, 350) are instantiated and displayed.
 * 
 * @author Antonio Hernandez
 */
public class Prog04_03
{
    public static void main(String[] args)
    {
        new Prog04_03();
    }
    
    public Prog04_03()
    {      
        //rectangle dimensions
        int rectangleWidth = 350;
        int rectangleHeight = 350;
        
        //defining array of 15 geometric objects to store 5 line segments and
        //their endpoints
        int numberOfLineSegments = 5;
        GeometricObject[] g = new GeometricObject[3*numberOfLineSegments];
        
        //defining random line segments in rectangle [0, 350) x [0, 350) 
        //and storing them in array of geometric objects
        Random rnd = new Random(42);
        double x, y;
        for(int i=0; i<3*numberOfLineSegments; i+=3)
        {
            //definition of p, random point in [0, 350) x [0, 350)
            x = rnd.nextInt(rectangleWidth);
            y = rnd.nextInt(rectangleHeight);
            Point p = new Point(x, y);
            p.setInteriorColor(Color.CYAN);

            //definition of q, random point in [0, 350) x [0, 350)
            x = rnd.nextInt(rectangleWidth);
            y = rnd.nextInt(rectangleHeight);
            Point q = new Point(x, y);
            q.setInteriorColor(Color.CYAN);

            //definition of line segment l
            LineSegment l = new LineSegment(p, q);
            l.setBoundaryColor(Color.BLUE);
            System.out.println(l.length()+" "+l.isVertical()+" "+l.isHorizontal());
            
            //storing line segment and endpoints in array g
            g[i] = l;
            g[i+1] = p;
            g[i+2] = q;
        }
        
        //graphing
        FrameDisplay frame = new FrameDisplay(g);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
