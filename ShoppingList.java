/**
 * The ShoppingList class enables the use of an interactive shopping 
 * list using a partially-filled array. This version of the class can 
 * only hold up to ten items.
 * @author Evan L. Douglass
 * @version PA7: Shopping List
 * <br>Grade at challenge
 */
public class ShoppingList {
    
    private java.util.Scanner scan;
    private String[] shop;
    private int index;
    
    /**
     * Simple constructor that instantiates the class fields
     */
    public ShoppingList() {
        // Used nextLine method in getInput instead of useDelimiter in constructor.
        // Fixed a bug where if the first input is blank, an error message was not 
        // printed.
        scan = new java.util.Scanner(System.in);
        shop = new String[10];
        index = 0;
    }
    
    /**
     * Prints out items currently stored in the shopping list. Does 
     * not print out empty (null) items.
     */
    public void printList() {
        System.out.println("Your shopping list:");
        // print the list
        if (index > 0) {
            for (int i = 0; i < index; i++) {
                System.out.println("  " + (i+1) + ". " + shop[i]);
            }
        } else {
            System.out.println("  * No items on list.");
        }
    }
    
    /**
     * Adds an item to the shopping list at the next available index.
     * @param item The item being added to the list
     */
    public void addToList(String item) {
        shop[index ++] = item;
    }
    
    /**
     * Removes every item from the list and resets the index field.
     */
    public void emptyList() {
        // change all values to null
        for (int i = 0; i < index; i++) {
            shop[i] = null;
        }
        index = 0;
    }
    
    /**
     * Given an integer, removes the item at that index
     * from the shopping list.
     * @param num An index in the list (1-10)
     */
    public void removeFromList(int num) {
        // error if num is bigger than index or smaller than 1
        if (num > index || num < 1) {
            System.out.println("  * No item " + num + " in shopping list");
        } else {
            shop[num-1] = null;
            
            // reorder remaining values
            for (int i = num; i < index; i++) {
                shop[i-1] = shop[i];
            }
            
            // update index field
            index--;
        }
    }
    
    /**
     * Given a string, removes any equivalent items from the list. If 
     * the string is not found, checks if the string is numerical and calls 
     * the int version of the method, otherwise prints an error.
     * @param item The item to be removed
     */
    public void removeFromList(String item) {
        int nullIndex = index;
        boolean itemFound = false;
        // remove item
        for (int i = 0; i < index; i++) {
            if (shop[i].equals(item)) {
                shop[i] = null;
                // user index used for nullIndex
                nullIndex = i + 1;
                itemFound = true;
            }
        }
        
        // reorder remaining values
        for (int i = nullIndex; i < index; i++) {
            shop[i-1] = shop[i];
        }
        
        // update index field
        if (itemFound) {
            index--;
        } else if (isNumeric(item)) {
            removeFromList(Integer.parseInt(item));
        } else {
            System.out.println("  * No item " + item + " in shopping list");
        }
    }

    /**
     * Tests if a string input can be converted into an integer. 
     * Helper function for the removeFromList method.
     * @param input User input
     * @return A boolean value describing if the input is numerical
     */
    private boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException error) {
            return false;
        }
        return true;
    }
    
    /**
     * Tests if a given item is already in the shopping list.
     * @param item The item to check
     * @return a boolean value describing whether the item is in the list
     */
    public boolean isDuplicate(String item) {
        boolean duplicate = false;
        for (String thing : shop) {
            if (item.equals(thing)){
                duplicate = true;
            }
        }
        return duplicate;
    }
    
    /**
     * Gets user input from the keyboard.
     * @return The user's input
     */
    public String getInput() {
        System.out.print("Enter your item or command: ");
        return scan.nextLine().trim();
    }
    
    /**
     * Prints a greeting. Used when the program is started.
     */
    public void printWelcome() {
        System.out.println("Welcome to the XYZ Shopping List Program.");
    }
    
    /**
     * Prints a goodbye message. Used when the program ends.
     */
    public void printThankYou() {
        System.out.println("Thank you for using the XYZ Shopping List Program.");
    }
    
    /**
     * Prints a help menu that displays the supported commands of the 
     * shopping list.
     */
    public void printHelp() {
        System.out.println("Here are the list of commands:");
        System.out.println("  -p :   Print the list");
        System.out.println("  -e :   Empty the list");
        System.out.println("  -r n : Remove the nth item or the item " +
                           "n from the list");
        System.out.println("  -x :   Exit the application");
        System.out.println("  -h :   Print this command list");
    }
    
    /**
     * The driver method of the class. This method is responsible for all 
     * program-user interactions.
     */
    public void go() {
        String input;
        
        printWelcome();
        printHelp();
        input = getInput();
        while( ! input.equals("-x")) {
            switch(input) {
                case "":
                    System.out.println("Shopping list items cannot be blank.");
                    break;
                case "-h":
                    printHelp();
                    break;
                case "-p":
                    printList();
                    break;
                case "-x":
                    break;
                case "-e":
                    emptyList();
                    break;
                default:
                    // case "-r n"
                    if (input.startsWith("-r ") && input.length() > 3) {
                        String subInput = input.substring(3, input.length());
                        removeFromList(subInput);
                    
                    // identify unknown commands
                    } else if (input.startsWith("-")) {
                        System.out.println("Unrecognized command: " + input);
                        printHelp();
                        
                    // identify duplicates
                    } else if (isDuplicate(input)) {
                        System.out.println("Duplicate item " + input + 
                                           " not added to the list.");
                    
                    // check if list is full
                    } else if (index > 9) {
                        System.out.println("List is full. Item " + input +
                                           " not added to the list.");
                    
                    // if tests pass, add input to list
                    } else {
                        addToList(input);
                    }
            }
            input = getInput();
        }
        printThankYou();
    }
    
    /**
     * The application method. Calls the driver function to start the program.
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        ShoppingList list;
        
        list = new ShoppingList();
        list.go();
    }  
}