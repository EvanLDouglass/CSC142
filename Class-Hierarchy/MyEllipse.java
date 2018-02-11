/**
 * This class represents a 2D ellipse shape.
 * 
 * @author Evan L. Douglass
 * @version PA5: Shape Hierarchy
 * <br>Grade at challenge
 */
public class MyEllipse extends MyShape {
    
    /**
     * Constructor for MyEllipse.
     * 
     * @param h The height of the ellipse.
     * @param w The width of the ellipse.
     */
    public MyEllipse(int h, int w) {
        super(h, w);
    }
    
    /**
     * Calculates the area of the ellipse.
     * 
     * @return The area of the ellipse.
     */
    public double getArea() {
        return 0.25 * Math.PI * width * height;
    }
    
    /**
     * Calculates the perimeter of an ellipse.
     * 
     * @return The perimeter of the ellipse.
     */
    public double getPerimeter() {
        // break up expressions in the Ramanujan equation
        double x = 3 * (width + height);
        double y = Math.sqrt((3 * width + height) * (3 * height + width));

        return 0.5 * Math.PI * (x - y);
    }
    
    /**
     * Override for the MyShape getName method.
     * 
     * @return The name of the shape("ellipse")
     */
    public String getName() {
        return "ellipse";
    }
}