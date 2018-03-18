import java.util.*;
import java.io.*;

/**
 * The WordCount class is used to count the number of token types in 
 * a simple text file. Command line arguments are used to determine which
 * file to analyze. Multiple files can be given and will be analyzed in turn. 
 * An optional command, "-o", can be given as the first argument to order the 
 * output from most frequently occuring token to least. Tokens that occur at
 * the same frequency do not have any sub-ordering. The current implementation 
 * is case insensitive but <i>is</i> punctuation sensitive.
 * @author Evan L. Douglass
 * @version PA 10: Word Count
 * <br>Grade at challenge
 */
public class WordCount {

    // determines if map should be sorted
    private static boolean isSorted;
    
    /**
     * Gets the token data from a given input file and outputs the
     * total number of tokens with a list of each token type and its
     * frequency. Output data is printed in the format:
     * <br>&nbsp;&nbsp;&nbsp;&nbsp; frequency : token
     * @param text The name of the file to be analyzed. Must be readable
     * by a Scanner.
     */
    public static void tokenCount(String text) {
        
        // ====================get data====================

        Scanner scan;
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        // open the file for reading using Scanner
        try {
            scan = new Scanner(new File(text));
        } catch(FileNotFoundException e) {
            System.out.println(text + " cannot be opened");
            return;
        }
        
        // process the file, token by token
        int i = 0;
        while(scan.hasNext()) {
            // get next token
            String token = scan.next().toLowerCase();
            // track number of tokens
            i++;
            // get value of token or 0 if not in map
            int value = map.getOrDefault(token, 0);
            // add or replace incremented value
            map.put(token, ++value);
        }
        
        // close the file
        scan.close();

        // sort map
        if (isSorted == true) {
            map = new TreeMap<String, Integer>(sortMap(map));
        }
        
        // ====================output statistics====================

        // number of tokens
        System.out.println(text + ": " + i + " tokens");

        // create iterable set from map object
        Set<Map.Entry<String, Integer>> mapSet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> it = mapSet.iterator();
        
        // value : key for all entries
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.printf("%5d : " + key, value);
            System.out.println();
        }
        
    }

    /**
     * Takes a map of Strings to Integers and sorts it according to the 
     * Integer values, from highest to lowest.
     * @param map The map to be sorted
     * @return The sorted map
     */
    public static TreeMap<String, Integer> sortMap(Map<String, Integer> map) {
       
        // init comparator for map values
        Comparator<String> comp = new ValueComparator(map);
        // add comparator to TreeMap
        TreeMap<String, Integer> sorted = new TreeMap<String, Integer>(comp);
        // add values to TreeMap
        sorted.putAll(map);
        // return sorted map
        return sorted;
    }
    
    /**
     * The application method. Provides command line functionality to the 
     * class.
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        
        // error message if no file given
        if (args.length == 0 || (args[0].equals("-o") && args.length == 1)) {

            System.out.println("No filename given.");

        } else {

            // sort results if first argument is "-o"
            if (args[0].equals("-o")) {
                isSorted = true;
                // process all files given in turn
                for (int i = 1; i < args.length; i++) {
                    tokenCount(args[i]);
                    System.out.println();
                }
            } else {
                isSorted = false;
                // process all files given in turn
                for (int i = 0; i < args.length; i++) {
                    tokenCount(args[i]);
                    System.out.println();
                }
            }
        }
    }
    
}

/**
 * ValueComparator is a helper class to WordCount that defines a 
 * sorting hierarchy for a String to Integer map. It provides
 * a Comparator used in the sortMap method of WordCount.
 * @author Evan L. Douglass
 * @version PA 10: Word Count
 * <br>Grade at challenge
 */
class ValueComparator implements Comparator<String> {

    Map<String, Integer> forSorting;

    /**
     * Attaches a local field to the map passed in.
     * @param map The map to be sorted
     */
     public ValueComparator(Map<String, Integer> map) {
         forSorting = map;
     }
    
     /**
      * Provides a comparison function for a TreeMap to sort 
      * its entries.
      * @param s1 A key used in the comparison.
      * @param s2 Another key used in the comparison.
      * @return An int value indicating which entry should be sorted
      * to the back. Sorting is from higher values to lower values.
      */
    @Override
    public int compare(String s1, String s2) {
        if (forSorting.get(s1) >= forSorting.get(s2)) {
            return -1;
        } else {
            return 1;
        }
    }
}