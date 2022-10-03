import javax.swing.*;
import java.awt.*;

public class Assignment1{
  public static void main(String[] args){
    new Assignment1();
  }
  public Assignment1(){
    GeometricObject[] g = new GeometricObject[1];
    
    //definition of first rectangle
    Point rect2 = new Point(150, 100);
    
    g[0] = rect2;

    //drawing
    FrameDisplay frame = new FrameDisplay(g);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
