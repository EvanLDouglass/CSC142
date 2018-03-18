import java.awt.*;

/**
 * Tiles provides methods to draw various tessellations.
 * @author Evan L. Douglass
 * @version PA11: Tiling
 * <br>Grade at standard
 */
public class Tiles {
    
    // constants
    public static final int WIDTH = 200;
    public static final int HEIGHT = 150;
    
    /**
     * Draws a basket weave pattern in a new window.
     */
    public void basketWeave() {
        
        // init drawing window & graphics
        DrawingPanel win = new DrawingPanel(WIDTH, HEIGHT);
        Graphics g = win.getGraphics();
        win.setTitle("Basket Weave");
        
        // from top left to lower right
        for (int y = -1; y <= HEIGHT; y += 80) {
            for (int x = -1; x <= WIDTH; x += 80) {
                // cycle through weave units
                weaveUnit(x, y, g);
                weaveUnit(x-40, y+40, g);
            }
        }
    }
    
    /**
     * Helper class for the basket weave pattern.
     * @param x The unit x-coordinate
     * @param y The unit y-coordinate
     * @param g The Graphics object for drawing
     */
    private void weaveUnit(int x, int y, Graphics g) {
        
        // make first square
        g.setColor(new Color(255, 201, 14));
        g.fillRect(x, y, 40, 40);
        // make second square
        g.setColor(new Color(185, 122, 87));
        g.fillRect(x+40, y, 40, 40);
        // draw borders
        g.setColor(Color.BLACK);
        g.drawRect(x, y, 40, 40);
        g.drawRect(x+40, y, 40, 40);
        // draw vertical line
        g.drawLine(x+20, y, x+20, y+40);
        // draw horizontal line
        g.drawLine(x+40, y+20, x+80, y+20);
    }
    
    /**
     * Draws a "mediterranean" pattern in a new window.
     */
    public void med1() {
        
        // start window and graphics
        DrawingPanel win = new DrawingPanel(WIDTH, HEIGHT);
        Graphics g = win.getGraphics();
        win.setTitle("Med. 1");
        
        // make background red
        g.setColor(Color.RED);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        // octogon color
        Color oct = new Color(255, 255, 64);
        
        // cycle through tile units
        for (int y = -12; y <= HEIGHT; y += 24) {
            for (int x = -12; x <= WIDTH; x += 24) {
                medUnit(x, y, oct, g);
            }
        }
    }
    
    /**
     * Draws a single octagon for the two mediterranean patterns.
     * @param x The unit x-coordinate
     * @param y The unit y-coordinate
     * @param c The color for the octagon
     * @param g The Graphics object for drawing
     */
    private void medUnit(int x, int y, Color c, Graphics g) {

        // draw octagon in the center
        g.setColor(c);
        int[] xs = {x+7, x+17, x+24, x+24, x+17, x+7, x, x};
        int[] ys = {y, y, y+7, y+17, y+24, y+24, y+17, y+7};
        g.fillPolygon(xs, ys, 8);
        
        g.setColor(Color.BLACK);
        g.drawPolygon(xs, ys, 8);
    }
    
    /**
     * Draws a second mediterranean style pattern in a new window.
     */
    public void med2() {
        
        // start window and graphics
        DrawingPanel win = new DrawingPanel(WIDTH, HEIGHT);
        Graphics g = win.getGraphics();
        win.setTitle("Med. 2");
        
        // set background color
        g.setColor(new Color(0, 112, 192));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        // octagon color
        Color oct = new Color(192, 192, 128);
        
        // cycle through tile units
        for (int y = -12; y <= HEIGHT; y += 34) {
            for (int x = -12; x <= WIDTH; x += 34) {
                medUnit(x, y, oct, g);
                medUnit(x-17, y+17, oct, g);
            }
        }
    }
    
    /**
     * Draws an open basket weave pattern in a new window.
     */
    public void openWeave() {
        
        // set up window and graphics
        DrawingPanel win = new DrawingPanel(WIDTH, HEIGHT);
        Graphics g = win.getGraphics();
        win.setTitle("Open Weave");
        
        // set up colors
        g.setColor(new Color(154, 32, 64));
        Color rect = new Color(204, 136, 204);
        
        // set up background
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        // cycle through units to make pattern
        for (int y = -10; y <= HEIGHT; y += 60) {
            for (int x = -55; x <= WIDTH; x += 60) {
                openUnit(x, y, rect, g);
                openUnit(x+30, y+30, rect, g);
            }
        }
    }
    
    /**
     * Draws a single unit of the open weave pattern.
     * @param x The unit x-coordinate
     * @param y The unit y-coordinate
     * @param c The color for the octagon
     * @param g The Graphics object for drawing
     */
    private void openUnit(int x, int y, Color c, Graphics g) {
        
        g.setColor(c);
        
        // horizontal rectangle
        g.fillRect(x, y, 40, 20);
        // vertical rectangle
        g.fillRect(x+40, y-10, 20, 40);
        
        // outlines
        g.setColor(Color.BLACK);
        g.drawRect(x, y, 40, 20);
        g.drawRect(x+40, y-10, 20, 40);
    }
    
    /**
     * Draws a "pythagorean" tiling pattern in a new window.
     */
    public void pythagorean() {
        
        // set up window and graphics
        DrawingPanel win = new DrawingPanel(WIDTH, HEIGHT);
        Graphics g = win.getGraphics();
        win.setTitle("Pythagorean");
        
        // set up colors and background
        g.setColor(new Color(64, 64, 192));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        Color sq = new Color(136, 204, 204);
        
        // cycle through units to make pattern
        for (int y = -15; y <= HEIGHT; y += 50) {
            for (int x = -85; x <= WIDTH; x += 50) {
                
                // draw squares
                g.setColor(sq);
                g.fillRect(x, y, 20, 20);
                g.fillRect(x+20, y+10, 20, 20);
                g.fillRect(x+40, y+20, 20, 20);
                g.fillRect(x+60, y+30, 20, 20);
                g.fillRect(x+80, y+40, 20, 20);
                
                // draw borders
                g.setColor(Color.BLACK);
                g.drawRect(x, y, 20, 20);
                g.drawRect(x+20, y+10, 20, 20);
                g.drawRect(x+40, y+20, 20, 20);
                g.drawRect(x+60, y+30, 20, 20);
                g.drawRect(x+80, y+40, 20, 20);
            }
        }
    }  
    
    /**
     * The application method. Does not support command line arguments.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        
        Tiles test = new Tiles();
        
        test.basketWeave();
        test.med1();
        test.med2();
        test.openWeave();
        test.pythagorean();
        
    }
}