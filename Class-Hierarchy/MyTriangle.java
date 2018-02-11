/**
 * This class represents a 2D acute triangle. It is a simple 
 * version of the shape in that it is defined only by the 
 * length of its base and height.
 * 
 * @author Evan L. Douglass
 * @version PA5: Shape Hierarchy
 * <br>Grade at challenge
 */
public class MyTriangle extends MyShape {
    
    /**
     * MyTriangle Constructor. Equates the base of the triangle
     * with the width field of the MyShape class. Height is 
     * equivalent to the height field.
     * 
     * @param h The height of the triangle.
     * @param b The length of the base of the triangle.
     */
    public MyTriangle(int h, int b) {
        super(h, b);
    }
    
    /**
     * Calculates the area of the triangle.
     * 
     * @return The area of the triangle as a double.
     */
    public double getArea() {
        return 0.5 * width * height;
    }
    
    /**
     * Override for the MyShape method.
     * 
     * @return The string "triangle".
     */
    public String getName() {
        return "triangle";
    }
}