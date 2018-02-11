/**
 * This class represents a 2D isosceles triangle.
 * 
 * @author Evan L. Douglass
 * @version PA5: Shape Hierarchy
 * <br>Grade at challenge
 */
public class MyIsoscelesTriangle extends MyTriangle {
    
    /**
     * Constructor for the class.
     * 
     * @param h The height of the triangle.
     * @param b The base length of the triangle.
     */
    public MyIsoscelesTriangle(int h, int b) {
        super(h, b);
    }
    
    /**
     * Calculates the perimeter of the triangle
     * 
     * @return The perimeter of the triangle
     */
    public double getPerimeter() {        
        // find hypotenuse of sub-right-triangle
        double hyp = Math.sqrt((0.25 * width * width) + (height * height));        
        return 2 * hyp + width;
    }
    
    /**
     * Gets the name of the shape
     * 
     * @return The name of the shape ("isosceles triangle")
     */
    public String getName() {
        return "isosceles triangle";
    }
}