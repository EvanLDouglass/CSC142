import java.awt.*;

/**
 * A simple class to used to draw some simple graphics. It's 
 * an exercise designed to increase familiarity with the 
 * DrawingPanel class.
 * @author Evan L. Douglass
 * @version LA 13: DrawingPanel
 * <br>Grade at check
 */
public class LA13 {
    
    /**
     * Draws a traffic light in a new window.
     */
    public void trafficLight() {
        
        // init graphics window
        DrawingPanel win = new DrawingPanel(130, 290);
        Graphics g = win.getGraphics();
        win.setTitle("Traffic Light");
        
        // create background
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(20, 20, 90, 250);
        g.setColor(Color.BLACK);
        g.drawRect(20, 20, 90, 250);
        
        // draw lights
        oneLight(30, 30, Color.RED, g);
        oneLight(30, 110, Color.YELLOW, g);
        oneLight(30, 190, new Color(0, 127, 0), g);
    }
    
    /**
     * Draws some shapes in a new window.
     */
    public void shapes() {
        
        // init graphics window
        DrawingPanel win = new DrawingPanel(250, 250);
        Graphics g = win.getGraphics();
        win.setTitle("Nested Shapes");
        
        // draw shapes
        g.setColor(Color.GREEN);
        g.fillRect(25, 25, 200, 200);
        
        g.setColor(Color.MAGENTA);
        g.fillOval(25, 25, 200, 200);
        
        g.setColor(Color.CYAN);
        int[] xs = {25, 125, 225, 125};
        int[] ys = {125, 25, 125, 225};
        g.fillPolygon(xs, ys, 4);
        
        // draw borders
        g.setColor(Color.BLACK);
        g.drawRect(25, 25, 200, 200);
        g.drawOval(25, 25, 200, 200);
        g.drawPolygon(xs, ys, 4);
    }
    
    /**
     * A helper function to draw the lights in the traffic 
     * light. 
     * @param x The x-coordinate
     * @param y The y-coordinate
     * @param c The color of the light
     * @param g The Graphics object used for the traffic light
     */
    private void oneLight(int x, int y, Color c, Graphics g) {
        g.setColor(c);
        g.fillOval(x, y, 70, 70);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, 70, 70);
    }
    
    /**
     * The application method
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        
        LA13 x = new LA13();
        x.trafficLight();
        x.shapes();
        
    }
}