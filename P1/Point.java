import java.awt.*;
/*
 * @Code inspired by Antonio Hernandez
 */
public class Point extends GeometricObject{
  private double x,y;
  public Point(){
    x = y = 0;
  }
  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }
  public double getX(){
    return x;
  }
  public double getY(){
    return y;
  }
  public void setX(double x){
    this.x = x;
  }
  public void setY(double y){
    this.y = y;
  }
  public void translate(Vector v){
    x += v.getX();
    y += v.getY();
  }
  public void rotate(double angle){
    double angleR = Math.toRadians(angle);
    double sine = Math.sin(angleR);
    double cosine = Math.cos(angleR);
    double x1 = x*cosine-y*sine;
    double y1 = x*sine+y*cosine;
    this.x = x1;
    this.y = y1;
  }
  public double distance(Point p){
    return Math.sqrt(Math.pow(x-p.getX(),2)+Math.pow(y-p.getY(),2));
  }
  public String toString(){
		return "POINT (" + x + ", " + y + ") " + super.toString();
  }
	public void draw(Graphics g) {
		int radius = 5;
		g.setColor(getInteriorColor());
		g.fillOval((int)x - radius, (int)y - radius, 2 * radius, 2 * radius);
		g.setColor(getBoundaryColor());
		g.drawOval((int)x - radius, (int)y - radius, 2 * radius, 2 * radius);
	}
}
