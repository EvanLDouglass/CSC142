/**
 * Sieve describes the functionality required for classes that
 * use the Sieve of Eratosthenes algorithm for finding prime numbers.
 * @author Dan Jinguiji
 * @author Evan L. Douglass
 * @version PA 9: Sieve of Eratosthenes
 * <br>Grade at challenge
 */
public interface Sieve {
    
    /**
     * Gets all the prime numbers between 2 and n.
     * @param n The upper bound for the sieve algorithm.
     * @return A list of prime numbers up to n
     */
    public java.util.List<Integer> getPrimes(int n);
    
}