
import javax.swing.*;
import java.awt.*;

/**
 * Defines a panel the drawings will be made in.
 * 
 * @author Prof. Antonio Hernandez
 */
public class GraphDisplay extends JPanel
{
    //ellipse parameters
    private int leftX;
    private int topY;
    private int width;
    private int height;
    
    /**
     * Default constructor.
     */
    public GraphDisplay()
    {
        setEllipse(100, 100, 50, 50);
    }

    /**
     * Parameterized constructor.
     */
    public GraphDisplay(int leftX, int topY, int width, int height)
    {
        setEllipse(leftX, topY, width, height);
    }
    
    /**
     * Ellipse mutator.
     */
    public void setEllipse(int leftX, int topY, int width, int height)
    {
        this.leftX = leftX;
        this.topY = topY;
        this.width = width;
        this.height = height;        
    }
    
    /**
     * Paints this panel; the system invokes it every time
     * it deems necessary to redraw the panel.
     */
    public void paint(Graphics g)
    {        
        //draw ellipse
        g.setColor(Color.ORANGE);
        g.fillOval(leftX, topY, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(leftX, topY, width, height);
    }
}
