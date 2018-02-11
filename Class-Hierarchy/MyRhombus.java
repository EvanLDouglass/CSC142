/**
 * This class represents a 2D rhombus. Assumes all corners are at the midpoint 
 * of the bounding rectangle's borders. Therefore all sides have the same 
 * length.
 * 
 * @author Evan L. Douglass
 * @version PA5: Shape Hierarchy
 * <br>Grade at challenge
 */
public class MyRhombus extends MyShape {
    
    /**
     * Constructor for the class.
     * 
     * @param h The length of one diagonal
     * @param w The length of the other diagonal
     */
    public MyRhombus(int h, int w) {
        super(h, w);
    }
    
    /**
     * Calculates the area of the rhombus.
     * 
     * @return The area of the rhombus.
     */
    public double getArea() {
        return width * height / 2.0;
    }
    
    /**
     * Calculates the perimeter of the rhombus.
     * 
     * @return The perimeter of the rhombus.
     */
    public double getPerimeter() {
        // find length of one side
        double hyp = Math.sqrt((0.25 * width * width) + (0.25 * height * height));
        return 4 * hyp;
    }
    
    /**
     * Gets the name of this shape.
     * 
     * @return The name of the shape ("rhombus")
     */
    public String getName() {
        return "rhombus";
    }
}