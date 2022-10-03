import javax.swing.*;
import java.awt.*;
/*
 * @Code inspired by Antonio Hernandez
 */
abstract public class GeometricObject{
  private Color boundaryColor,interiorColor;
  public GeometricObject(){
    interiorColor = Color.white;
    boundaryColor = Color.black;
  }
  public GeometricObject(Color iC, Color bC){
    interiorColor = iC;
    boundaryColor = bC;
  }
  abstract public void draw(Graphics g);
  public Color getBoundaryColor(){
    return boundaryColor;
  }
  public Color getInteriorColor(){
    return interiorColor;
  }
  public void setBoundaryColor(Color boundaryColor){
    this.boundaryColor = boundaryColor;
  }
  public void setInteriorColor(){
    this.interiorColor = interiorColor;
  }
  @Override
  public String toString(){
    String str;
    str = "Boundary ("+boundaryColor.getRed()+", "+
    boundaryColor.getGreen() +", "+ boundaryColor.getBlue()+", "+
    boundaryColor.getAlpha()+") "+
    "INTERIOR ("+interiorColor.getRed()+", "+
    interiorColor.getGreen() +", "+ interiorColor.getBlue()+", "+
    interiorColor.getAlpha()+") ";
    return str;
  }
}
