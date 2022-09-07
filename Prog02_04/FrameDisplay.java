
import javax.swing.*;

/**
 * Defines a frame to which a panel with drawings will be added.
 * 
 * @author Prof. Antonio Hernandez
 */
public class FrameDisplay extends JFrame
{
    int WIDTH = 450;
    int HEIGHT = 450;
    
    private GraphDisplay panel;

    public FrameDisplay(int leftX, int topY, int width, int height)
    {
        setTitle("Graph Display");
        setSize(WIDTH, HEIGHT);

        panel = new GraphDisplay(leftX, topY, width, height);
        add(panel);
    }
    
    /**
     * Allows the application to update values of geometric object.
     */
    public void setEllipse(int leftX, int topY, int width, int height)
    {
        panel.setEllipse(leftX, topY, width, height);
    }
    
    /**
     * Repaints the panel. After the application invokes this method, drawings
     * will reflect the most recent information.
     */
    public void repaint()
    {
        panel.repaint();
    }
}
