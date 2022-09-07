
import javax.swing.*;

/**
 * Defines a frame to which a panel with drawings will be added.
 * 
 * @author Prof. Antonio Hernandez
 */
public class FrameDisplay extends JFrame
{
    int WIDTH = 430;
    int HEIGHT = 350;

    public FrameDisplay()
    {
        setTitle("Hello, Computational Geometers!");
        setSize(WIDTH, HEIGHT);

        GraphDisplay panel = new GraphDisplay();
        add(panel);
    }
}
