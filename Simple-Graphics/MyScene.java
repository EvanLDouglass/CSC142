// Allow short name access to java.awt.Color
import java.awt.Color;

/**
 * This is the shell for assignment: MyScene.
 * This program draws a simple scene using additional
 * classes that the student creates.
 * 
 * @author Dan Jinguji 
 * @version Programming Assignment: MyScene
 */
public class MyScene extends NscWindow {
    
    // instance variables
    private MyHouse house;
    private MyHouse orangeHouse;
    private MyHouse grayHouse;

    private MyTree greenTree;
    private MyTree yellowTree;
    private MyTree redTree;
    
    /**
     * Constructor for objects of class MyScene
     */
    public MyScene() {
        // Specify the constructor for the superclass
        super(10, 10, 400, 300);
        // set characteristics for the object
        setTitle("My Scene");
        
        // Draw the sky
        getContentPane().setBackground(new Color(0x00, 0xCC, 0xFF));
        
        // Draw some grass
        NscRectangle grass = new NscRectangle(0, 100, 400, 200);
        grass.setBackground(new Color(0x00, 0x99, 0x00));
        grass.setFilled(true);
        add(grass);
        
        // draw houses
        house = new MyHouse(100, 50);
        add(house);
        orangeHouse = new MyHouse(225, 100, Color.orange);
        add(orangeHouse);
        grayHouse = new MyHouse(0, 125, Color.gray);
        add(grayHouse);

        // draw trees
        greenTree = new MyTree(300, 105);
        add(greenTree);
        yellowTree = new MyTree(125, 125, Color.yellow);
        add(yellowTree);
        redTree = new MyTree(0, 0, Color.red);
        add(redTree);
        
        // request a rerendering of the window
        repaint();
    }
    
    /**
     * Alter the scene, by changing color
     */
    public void change1() {
        // change the color of the houses
        house.setColor(Color.red);
        orangeHouse.setColor(Color.cyan);
        grayHouse.setColor(Color.magenta);

        // change the color of the trees
        greenTree.setColor(Color.pink);
        yellowTree.setColor(Color.white);
        redTree.setColor(Color.black);

        // request a rerendering of the window
        repaint();
    }
    
    /**
     * Alter the scene, by changing location
     */
    public void change2() {
        // change the location of the houses
        house.setLocation(50, 125);
        orangeHouse.setLocation(200, 100);
        grayHouse.setLocation(250, 150);

        // change the location of the trees
        greenTree.setLocation(170, 30);
        yellowTree.setLocation(0, 30);
        redTree.setLocation(340, 30);

        // request a rerendering of the window
        repaint();
    }
    
    /**
     * Alter the scene, by changing size
     */
    public void change3() {
        // change the size of the house
        house.setSize(80, 60);
        // request a rerendering of the window
        repaint();
    }
    
    /**
     * Alter the scene, restoring original settings
     */
    public void reset() {
        // reset the initial values for the houses
        house.setLocation(100, 50);
        house.setColor(Color.blue);
        house.setSize(120, 90);
        
        orangeHouse.setLocation(225, 100);
        orangeHouse.setColor(Color.orange);
        
        grayHouse.setLocation(0, 125);
        grayHouse.setColor(Color.gray);

        // reset the initial values for the trees
        greenTree.setLocation(300, 105);
        greenTree.setColor(new Color(0, 100, 0));

        yellowTree.setLocation(125, 125);
        yellowTree.setColor(Color.yellow);

        redTree.setLocation(0, 0);
        redTree.setColor(Color.red);
        
        // request a rerendering of the window
        repaint();
    }
    
    /**
     * The application method, to test your code
     *
     * @param args The command-line arguments
     */
    public static void main(String[] args) {
        
        // declare a MyScene reference
        MyScene aScene;
        // instantiate MyScene
        aScene = new MyScene();
        // pause
        javax.swing.JOptionPane.showMessageDialog(null, "Press OK to continue");
        
        // test setColor
        aScene.change1();
        javax.swing.JOptionPane.showMessageDialog(null, "Press OK to continue");
        
        // test setLocation
        aScene.change2();
        javax.swing.JOptionPane.showMessageDialog(null, "Press OK to continue");
        
        // test setSize
        aScene.change3();
        javax.swing.JOptionPane.showMessageDialog(null, "Press OK to continue");
        
        // reset initial values
        aScene.reset();
    }
    
}
