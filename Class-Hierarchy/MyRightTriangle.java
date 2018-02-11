/**
 * This class represents a 2D right triangle.
 * 
 * @author Evan L. Douglass
 * @version PA5: Shape Hierarchy
 * <br>Grade at challenge
 */
public class MyRightTriangle extends MyTriangle {
    
    /**
     * Constructor for the class.
     * 
     * @param leg1 The height of the triangle.
     * @param leg2 The base length of the triangle.
     */
    public MyRightTriangle(int leg1, int leg2) {
        super(leg1, leg2);
    }
    
    /**
     * Gets the perimeter of the triangle.
     * 
     * @return The perimeter of the triangle
     */
    public double getPerimeter() {
        
        // find hypotenuse
        double hyp = Math.sqrt((width * width) + (height * height));
        // add sides together
        return width + height + hyp;
    }
    
    /**
     * Gets the name of the shape
     * 
     * @return The name of the shape ("right triangle")
     */
    public String getName() {
        return "right triangle";
    }
}