
import java.util.Scanner;
import javax.swing.*;

/**
 * Illustrates drawing an object. The object info is entered manually and
 * the object is painted, then the information is updated, and the object is
 * painted again.
 * 
 * @author Prof. Antonio Hernandez
 */
public class Prog02_04
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter ellipse description: ");
        int leftX = in.nextInt();
        int topY = in.nextInt();
        int width = in.nextInt();
        int height = in.nextInt();
        
        FrameDisplay frame = new FrameDisplay(leftX, topY, width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        System.out.print("Enter ellipse description: ");
        leftX = in.nextInt();
        topY = in.nextInt();
        width = in.nextInt();
        height = in.nextInt();
        
        frame.setEllipse(leftX, topY, width, height);
        frame.repaint();
    }
}
