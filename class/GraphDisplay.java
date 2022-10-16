
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;

/**
 * Defines the panel the drawings will be made in.
 * 
 * @author Prof. Antonio Hernandez
 */
public class GraphDisplay extends JPanel implements MouseMotionListener,MouseListener
{
    //geometric objects that are painted on this panel
    GeometricObject[] gArray;
    Point click;
    Rectangle r;
    /**
     * Parameterized constructor.
     * 
     * @param frameWidth width of panel
     * @param frameHeight height of panel
     * @param g array of geometric objects
     */
    public GraphDisplay(int frameWidth, int frameHeight, GeometricObject[] g)
    {
        this.gArray = g;
        
        Dimension d = new Dimension(frameWidth, frameHeight);
        setPreferredSize(d); //sets the preferred size of this panel
        
        addMouseMotionListener(this);
    }

    public void mouseDragged(MouseEvent e){
        int x = e.getPoint().x;
        int y = e.getPoint().y;
        Vector trans = new Vector(x-click.getX(),y-click.getY());
        r.translate(trans);
        System.out.println(trans.getX());
        System.out.println(trans.getY());
    

    public void mouseMoved(MouseEvent e)
    {
        //is current mouse location inside a rectangle?
        int x = e.getPoint().x;
        int y = e.getPoint().y;
        Point p = new Point(e.getPoint().x, e.getPoint().y);
        click = p;
        
        Rectangle[] rArray = new Rectangle[gArray.length];
        for (int i = 0; i<rArray.length; i++)
        {
            rArray[i] = (Rectangle)gArray[i];
        }
        int idx = Algorithms.isPointInSet(rArray, p);
        if (idx==-1){
            setCursor(Cursor.getDefaultCursor());
        }
        else{
            rArray[idx].setInteriorColor(Color.red);
            System.out.println(idx);
            r = (Rectangle)rArray[idx];
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

    }

    public void mouseClicked(MouseEvent e)
    {
        int x = e.getPoint().x;
        int y = e.getPoint().y;
        System.out.println("HE");
    }
    
    /**
     * Paints this panel; the system invokes it every time
     * it deems necessary to redraw the panel.
     */
    public void paint(Graphics g)
    {        
        super.paint(g); //clears window
        
        //draws geometric objects
        for (GeometricObject e:gArray)
        {
            e.draw(g); //invokes object's draw method through polymorphism
        }
    }
}
