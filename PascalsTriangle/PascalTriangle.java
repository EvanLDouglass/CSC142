/**
 * This class contains functionality allowing clients to print 
 * out Pascal's Triangle.
 * @author Evan L. Douglass
 * @version PA6: Pascal's Triangle, Implementation
 * <br>Grade at challenge
 */
public class PascalTriangle extends PascalsTriangleBase {
    
    /**
     * Constructor for PascalTriangle that allows doubleSpace 
     * field assignment.
     * @param b A boolean value
     */
    public PascalTriangle(boolean b) {
        super();
        setDoubleSpace(true);
    }
    
    /**
     * Sets the superclass field doubleSpace to a boolean value
     * @param b = A boolean value
     */
    public void setDoubleSpace(boolean b) {
        doubleSpace = b;
    }
    
    /**
     * Gets the value of the superclass field doubleSpace
     * @return The boolean value of doubleSpace
     */
    public boolean getDoubleSpace() {
        return doubleSpace;
    }
    
    /**
     * This method is the primary printing method for the triangle.
     * @param n The value to be printed
     */
    protected void printInt(int n) {
        if (n / 10 == 0) {
            // 5 spaces for single digit numbers
            System.out.print("     " + n);
        } else if (n / 100 == 0) {
            // 4 spaces for double digit numbers
            System.out.print("    " + n);
        } else if (n / 1000 == 0) {
            // 3 spaces for triple digit numbers
            System.out.print("   " + n);
        } else if (n / 10000 == 0) {
            // 2 spaces for quadruple digit numbers
            System.out.print("  " + n);
        }
    }
    
    /**
     * This method calculates the binomial coefficient, n choose k. These 
     * values are used to construct Pascal's Triangle. They are called
     * <i>binomial coefficients</i> because "n choose k" is the value of
     * the coefficient of the x<sup>k</sup> term in the expansion of
     * (1 + x)<sup>n</sup>.
     * @param n The power for the binomial expansion
     * @param k The order of the term in the binomial expansion
     * @return The coefficient of the k<sup>th</sup> term.
     */
    protected int nChooseK(int n, int k) {
        if (n <= 12) {
            return fact(n) / (fact(k) * fact(n - k));
            
        // n > 12 produces values that cannot fit in int type
        } else {
            // iterative implementation for cancelling common values of
            // n! and k! or (n-k)! depending on the higher value
            int num = 1;
            int stop = Math.max(k, n-k);
            for (int i = n; i > stop; i--) {
                num *= i;
            }
            
            // choose denominator as factorial of lower value
            if (k > n-k) {
                return num / fact(n-k);
            } else {
                return num / fact(k);
            }
        }
    }
    
    /**
     * This is a special method that is used to print the first value in each
     * row of Pascal's triangle. The amount of "indent" for the line is
     * determined by the parameter values.
     * @param row The number of the row being printed
     * @param height The height of the completed triangle
     */
    protected void printOne(int row, int height) {
        int spaces = (height - row) * 3;
        // print appropriate amount of spaces
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        // print first number (always a one)
        System.out.print(1);
    }
    
    /**
     * A simple input validation routine to see if the height is ok.
     * @param height The requested height for the triangle
     * @return True if the requested height is out of range
     */
    protected boolean heightOutOfRange(int height) {
        return (height < 0 || height > 15);
    }
    
    /**
     * Helper method for the class that calculates the factorial of a 
     * given number.
     * @param x An integer for which to calculate the factorial (i.e. x!)
     * @return The result of the factorial.
     */
    private int fact(int x) {
        // result for x == 0
        if (x == 0) {
            return 1;
        }

        // initialize result to x
        int result = x;
        // decrement and multiply by result
        for (int i = x-1; i > 0; i--) {
            result *= i;
        }

        return result;
    }

    /**
     * The application method.
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        
        PascalTriangle p = new PascalTriangle(true);
        
        if (args.length == 0) {
            // print test cases
            p.printTriangle(0);
            p.printTriangle(10);
            p.printTriangle(4);
            p.printTriangle(6);
            p.printTriangle(-1);
            
        } else if (args.length > 0) {
            // print all triangles with height 0 to 10 inclusive
            // if "all" is the argument
            if (args[0].equals("all")) {
                for (int i = 0; i <= 10; i++) {
                    p.printTriangle(i);
                }
                
            // if args.length > 0 and "all" not used, assume args 
            // are numerical and use them as heights for triangles
            } else {  
                for (int i = 0; i < args.length; i++) {
                    p.printTriangle(Integer.parseInt(args[i]));
                }
            }
        }
    }
}
