/**
 * This class represents a 2D circle.
 * 
 * @author Evan L. Douglass
 * @version PA5: Shape Hierarchy
 * <br>Grade at challenge
 */
public class MyCircle extends MyEllipse {
    
    /**
     * Constructor for MyCircle.
     * 
     * @param diameter The diameter of the circle.
     */
    public MyCircle(int diameter) {
        super(diameter, diameter);
    }
    
    /**
     * Gives the name of the shape.
     * 
     * @return The name of the shape ("circle")
     */
    public String getName() {
        return "circle";
    }
}