import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * The SieveDriver class is used to execute and output the algorithm
 * in the MySieve class.
 * @author Evan L. Douglass
 * @version PA 9: Sieve of Eratosthenes
 * <br>Grade at challenge
 */
public class SieveDriver {
    
    private Scanner scan;
    private Sieve theSieve;
    
    /**
     * Sets up the SieveDriver fields
     */
    public SieveDriver() {
        scan = new Scanner(System.in);
        theSieve = new MySieve();
    }
    
    /**
     * The driver in SieveDriver. Gets the primes and prints
     * them out using other methods.
     */
    public void go() {
        
        List<Integer> primes;
        
        int n = getNumber();
        while (n != 0) {
            primes = theSieve.getPrimes(n);
            printPrimes(n, primes);
            n = getNumber();
        }
    }
    
    /**
     * Gets user input for the upper bound of the sieve algorithm
     * @return The upper bound as an int
     */
    public int getNumber() {
        int bound;
        String message = "Please enter the upper bound (0 to exit): ";
        
        System.out.print(message);
        
        while (true) {
            
            // make sure bound is an int
            if ( ! scan.hasNextInt()) {
                scan.next();
                System.out.println("Upper bound must be an integer.");
                System.out.print(message);
                continue;
                
            // bound is an int    
            } else {
                bound = scan.nextInt();
                
                // make sure bound is positive
                if (bound < 0) {
                    System.out.println("Upper bound must be positive.");
                    System.out.print(message);
                    continue;
                
                // only break loop when bound is a valid int
                } else {
                    break;
                }
            }
        }
        return bound;
    }
    
    /**
     * Prints out the formatted values contained in a given list.
     * @param bound The upper bound given for the sieve algorithm.
     * @param list The list of primes resulting from the algorithm.
     */
    public void printPrimes(int bound, List<Integer> list) {
        System.out.println("Here are the primes between 2 and " + bound);
        Iterator it = list.iterator();
        int numCount = 0;
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
            numCount++;
            // limit output to 12 numbers
            if (numCount == 12) {
                System.out.println();
                numCount = 0;
            }
        }
        System.out.println();
        
        // calculate percentage of primes
        double percent = ((double)list.size() / bound) * 100;
        System.out.printf("%.0f%% of the numbers between 1 and %d are prime.\n",
                          percent, bound);
        System.out.println();
    }
    
    /**
     * The application method.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        
        new SieveDriver().go(); 
        
    }   
    
}