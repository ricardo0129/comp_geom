import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;


public class Assignment1{
  public static void main(String[] args){
    new Assignment1();
  }
  public Assignment1(){
    //Replace with file name
    Scanner user_in = new Scanner(System.in);
    System.out.println("Enter File Name (file must be in this folder)");
    String name = user_in.next();
    File input = new File(name);
    Scanner in = null;
    try
    {
        in = new Scanner(input);
    }
    catch(FileNotFoundException e)
    {
        System.out.println("File not found!");
    }
    int n = in.nextInt();
    Point[] g = new Point[n];
    for(int i=0;i<n;i++){
      g[i] = new Point(in.nextInt(),in.nextInt());
    }
    FrameDisplay frame = new FrameDisplay(g);
    Algorithms st = new Algorithms();
    int[] A = new int[2];
    st.closestPair(g,A);

    //set the closest point to a new color teal 
    g[A[0]].setInteriorColor(new Color(0,128,128,128));
    g[A[1]].setInteriorColor(new Color(0,128,128,128));
    frame.repaint();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
