import java.awt.Color;

/**
 * The MyHat class is a graphics component that draws a simple bowler hat.
 * @author Evan L. Douglass
 * @version LA 6: Snowman's Hat
 * <br> Grade at check
 */
public class MyHat extends NscComponent {
    
    // peices of the hat
    private NscEllipse brim;
    private NscEllipse body;
    private NscRectangle band;
    
    /**
     * Default constructor for MyHat. Places the hat at location (10, 10)
     */
    public MyHat() {
        this(10, 10);
    }
    
    /**
     * The main constructor for MyHat. Creates a graphics component and
     * draws a bowler hat within it.
     * @param x The x-coordinate of the component
     * @param y The y-coordinate of the component
     */
    public MyHat(int x, int y) {
        
        // create component of size 60 x 30
        super(x, y, 60, 30);
        
        // create peices of the hat
        brim = new NscEllipse(0, 15, 60, 15);
        brim.setBackground(Color.GRAY);
        brim.setFilled(true);
        brim.setForeground(Color.GRAY);
        
        body = new NscEllipse(10, 0, 40, 30);
        body.setBackground(Color.GRAY);
        body.setFilled(true);
        body.setForeground(Color.GRAY);
        
        band = new NscRectangle(-5, 18, 50, 5);
        band.setBackground(Color.BLACK);
        band.setFilled(true);
        
        // add hat peices to component
        add(brim);
        body.add(band);
        add(body);
    }
}