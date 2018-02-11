/**
 * This class provides the skeleton for the Pascal Triangle
 * assignment.
 */
public class PascalsTriangleBase {
    
    /**
     * This field controls the line spacing of the output triangle.
     */
    protected boolean doubleSpace;
    
    /**
     * Simple constructor to set the value for the field.
     */
    public PascalsTriangleBase() {
        doubleSpace = false;
    }
    
    /**
     * This method is the primary printing method for the triangle.
     * Override this method to control the spacing between values in
     * the output triangle.
     * @param n The value to be printed
     */
    protected void printInt(int n) {
        System.out.print(n);
    }
    
    /**
     * This method calculates the binomial coefficient, n choose k. These 
     * values are used to construct Pascal's Triangle. They are called
     * <i>binomial coefficients</i> because "n choose k" is the value of
     * the coefficient of the x<sup>k</sup> term in the expansion of
     * (1 + x)<sup>n</sup>.
     * <p>For this assignment, it should use the factorial algorithm; that is
     * the return value should be calculated as n! / (k! (n-k)!).
     * @param n The power for the binomial expansion
     * @param k The order of the term in the binomial expansion
     * @return The coefficient of the k<sup>th</sup> term.
     */
    protected int nChooseK(int n, int k) {
        return k;
    }
    
    /**
     * The is a special method that is used to print the first value in each
     * row of Pascal's triangle. The amount of "indent" for the line can be
     * determined by the parameter values.
     * @param row The number of the row being printed
     * @param height The height of the completed triangle
     */
    protected void printOne(int row, int height) {
        printInt(1);
    }
    
    /**
     * A simple input validation routine to see if the height is ok.
     * @param height The requested height for the triangle
     * @return True if the requested height is out of range
     */
    protected boolean heightOutOfRange(int height) {
        return false;
    }
    
    /**
     * The core method for this assignment. It prints out the triangle,
     * using the helper methods defined above. This method is marked with
     * the <b>final</b> keyword. This means that this method cannot be
     * overridden in a subclass. Notice that all of the helper methods
     * are not declared <b>final</b>, so they are all available for 
     * overriding.
     * @param height The requested height for the triangle to be printed.
     */
    public final void printTriangle(int height) {
        System.out.println("Pascal\'s Triangle of height " + height);
        if(heightOutOfRange(height)) {
           System.out.println("Height is out of range. Cannot print Pascal's triangle.");
           return;
        }
        System.out.println();
        for(int row = 0; row < height + 1; row ++) {
            printOne(row, height);
            for(int col = 1; col < row + 1; col ++) {
                printInt(nChooseK(row, col));
            }
            System.out.println();
            if(doubleSpace) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
    }
    
}
