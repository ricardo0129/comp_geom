import java.awt.Graphics;

public class Rectangle extends GeometricObject{
  private Point begin,end;

  public Rectangle(){
    begin = new Point(0,0);
    end = new Point(1,1);
  }
  public Rectangle(Point b, Point e){
    begin = new Point(b.getX(),b.getY());
    end = new Point(e.getX(),e.getY());
  }
  @Override
  public void draw(Graphics g){
    int x = (int)smallestX();
    int y = (int)smallestY();
    int w = (int)width();
    int h = (int)height();
    g.setColor(getInteriorColor());
    g.fillRect(x,y,w,h);
    g.setColor(getBoundaryColor());
    g.drawRect(x,y,w,h);
  }
  public Point getBegin(){
    return new Point(begin.getX(),begin.getY());
  }
  public Point getEnd(){
    return new Point(end.getX(),end.getY());
  }
  public double greatestX(){
    return Math.max(begin.getX(),end.getX());
  }
  public double greatestY(){
    return Math.max(begin.getY(),end.getY());
  }
  public double height(){
    return Math.abs(begin.getY()-end.getY());
  }
  public double width(){
    return Math.abs(begin.getX()-end.getX());
  }
  public void setBegin(Point p){
    begin = new Point(p.getX(),p.getY());
  }
  public void setEnd(Point p){
    end = new Point(p.getX(),p.getY());
  }
  public double smallestX(){
    return Math.min(begin.getX(),end.getX());
  }
  public double smallestY(){
    return Math.min(begin.getY(),end.getY());
  }
  @Override
  public String toString(){
    String str = "RECTANGLE "+super.toString()+"\n";
    str += begin+"\n"+end;
    return str;
  }
  public void translate(Vector v){
    begin.translate(v);
    end.translate(v);
  }
  public void rotate(double angle){
    begin.rotate(angle);
    end.rotate(angle);
  }


}
