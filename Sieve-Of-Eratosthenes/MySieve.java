import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The MySieve class holds an implementation of the Sieve of 
 * Eratosthenes algorithm for finding all prime numbers up to 
 * a given limit.
 * @author Evan L. Douglass
 * @version PA 9: Sieve of Eratosthenes
 * <br>Grade at challenge
 */
public class MySieve implements Sieve {
    
    private List<Integer> nums;
    private List<Integer> primes;
    
    /**
     * Finds all the prime numbers from 2 up through n.
     * @param n The number at which to stop looking for primes.
     * @return A list of all the prime numbers up to n.
     */
    public List<Integer> getPrimes(int n) {
        
        // make a list of all numbers from 2 to n
        nums = new ArrayList<Integer>();
        // add numbers to list
        for (int i = 2; i <= n; i++) {
            nums.add(i);
        }
        // make a list for prime numbers
        primes = new ArrayList<Integer>();
        
        // declare nums iterator
        Iterator<Integer> it;
        // loop while primes is smaller than sqrt(n)
        while (primes.size() < Math.sqrt(n)) {
            // init iterator
            it = nums.iterator();
            // get first number
            int currentPrime = it.next();
            // add to primes
            primes.add(currentPrime);
            // remove from nums
            it.remove();
            // loop through list
            while (it.hasNext())
                // remove if divisible by num
                if (it.next() % currentPrime == 0) {
                    it.remove();
                }
        }
        
        // remaining numbers are primes
        for (int i = 0; i < nums.size(); i++) {
            primes.add(nums.get(i));
        }
        
        return primes;
    }
}