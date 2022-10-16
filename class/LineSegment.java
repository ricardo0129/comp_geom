
import java.awt.Graphics;

/**
 * This class represents a line segment given by end points;
 * end points might be equal.
 */
public class LineSegment extends GeometricObject
{

    //begin and end are the end points of line segment; no guaranties on order
    private Point begin;
    private Point end;

    /**
     * Instantiates a LineSegment object with endpoints (0, 0) and (1, 1).
     */
    public LineSegment()
    {
        begin = new Point(0, 0);
        end = new Point(1, 1);
    }

    /**
     * Instantiates a LineSegment object with endpoints b and e.
     */
    public LineSegment(Point b, Point e)
    {
        begin = b;
        end = e;
    }

    /**
     * Draws this line segment.
     * 
     * @param g graphic context 
     */
    @Override
    public void draw(Graphics g)
    {
        //line segment is drawn by using its boundary color, not its interior
        //color (width of line=0)
        
        g.setColor(getBoundaryColor());
        g.drawLine((int)begin.getX(), (int)begin.getY(),
                   (int)end.getX(), (int)end.getY());
    }

    /**
     * Returns the "begin" point of this line segment.
     * 
     * @return the "begin" point of this line segment
     */
    public Point getBegin()
    {
        return begin;
    }

    /**
     * Sets the "begin" point of this line segment.
     * 
     * @param b new "begin" point
     */
    public void setBegin(Point b)
    {
        begin = b;
    }

    /**
     * Returns the "end" point of this line segment.
     * 
     * @return the "end" point of this line segment
     */
    public Point getEnd()
    {
        return end;
    }

    /**
     * Sets the "end" point of this line segment.
     * 
     * @param e new "end" point
     */
    public void setEnd(Point e)
    {
        end = e;
    }

    /**
     * Determines the greatest x.
     *
     * @return the greatest x
     */
    public double greatestX()
    {
        return begin.getX() > end.getX() ? begin.getX() : end.getX();
    }

    /**
     * Determines the greatest y.
     *
     * @return the greatest y
     */
    public double greatestY()
    {
        return begin.getY() > end.getY() ? begin.getY() : end.getY();
    }

    /**
     * Determines the smallest x.
     *
     * @return the smallest x
     */
    public double smallestX()
    {
        return begin.getX() < end.getX() ? begin.getX() : end.getX();
    }

    /**
     * Determines the smallest y.
     *
     * @return the smallest y
     */
    public double smallestY()
    {
        return begin.getY() < end.getY() ? begin.getY() : end.getY();
    }

    /**
     * Constructs a String description of this line segment.
     * 
     * @return String containing a description of this line segment
     */

    public boolean isHorizontal(){
        return begin.getY()==end.getY();
    }
    public boolean isVertical(){
        return begin.getX()==end.getX();
    }
    public double length(){
        return begin.distance(end);
    }
    @Override
    public String toString()
    {
        String str = "LINE_SEGMENT " + super.toString() + "\n";
        str += begin + "\n" + end;

        return str;
    }

    /**
     * Translates this line segment by given vector.
     *
     * @param v given vector
     */
    public void translate(Vector v)
    {
        begin.translate(v);
        end.translate(v);
    }

}
