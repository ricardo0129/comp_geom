
import java.awt.Color;
import javax.swing.*;

/**
 * Defines a frame to which a panel with drawings will be added.
 * 
 * @author Prof. Antonio Hernandez
 */
public class FrameDisplay extends JFrame
{
    int WIDTH = 400;
    int HEIGHT = 400;
    
    private GraphDisplay panel;

    public FrameDisplay(GeometricObject[] g)
    {
        setTitle("Graph Display");
        setSize(WIDTH, HEIGHT);

        panel = new GraphDisplay(WIDTH, HEIGHT, g);
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEtchedBorder());
        
        add(panel);
        
        pack(); //sizes the frame so that the panel is at, or above,
                //the preferred size
    }

}
