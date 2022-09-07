
import java.util.Scanner;
import javax.swing.*;

/**
 * Illustrates drawing an object whose info has been entered manually.
 * 
 * @author Prof. Antonio Hernandez
 */
public class Prog02_03
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
    }
}
