import java.awt.Color;

/**
 * The TicTacToeBoards class contains functionality that allows client
 * code to draw static Tic-Tac-Toe boards in a new window on the 
 * computer screen.
 * 
 * @author Evan L. Douglass
 * @version PA3: Static Tic-Tac-Toe
 * <br>Grade at Standard
 */
public class TicTacToeBoards {

    // window field for the class
    private NscWindow win;

    /**
     * Zero parameter constructor for the TicTacToeBoards class. 
     * Creates a window of size 300 x 330 and draws four 
     * tic-tac-toe boards inside it.
     */
    public TicTacToeBoards() {

        // create the window
        win = new NscWindow(10, 10, 300, 330);
        win.setTitle("Tic-Tac-Toe Boards");

        // draw four tic-tac-toe boards
        drawBoard(40, 40);
        drawBoard(40, 170, Color.RED);
        drawBoard(170, 40, 6);
        drawBoard(170, 170);
    }

    /**
     * Draws a standard Tic-Tac-Toe board of size 90 x 90 pixels in the window.
     * 
     * @param x X coordinate of the upper-left corner of the bounding square.
     * @param y Y coordinate of the upper-left corner of the bounding square.
     */
    public void drawBoard(int x, int y) {

        // create the four lines for a tic-tac-toe board
        NscLine vert1, vert2, hor1, hor2;
        vert1 = new NscLine(x+30, y+90, x+30, y);
        vert2 = new NscLine(x+60, y+90, x+60, y);
        hor1 = new NscLine(x, y+30, x+90, y+30);
        hor2 = new NscLine(x, y+60, x+90, y+60);

        // add lines to the window
        win.add(vert1);
        win.add(vert2);
        win.add(hor1);
        win.add(hor2);

        // update the window
        win.repaint();
    }

    /**
     * Draws a colored Tic-Tac-Toe board of size 90 x 90 pixels in the window.
     * 
     * @param x X coordinate of the upper-left corner of the bounding square.
     * @param y Y coordinate of the upper-left corner of the bounding square.
     * @param c The color of the board.
     */
    public void drawBoard(int x, int y, Color c) {

         // create the four lines for a tic-tac-toe board
        NscLine vert1, vert2, hor1, hor2;
        vert1 = new NscLine(x+30, y+90, x+30, y);
        vert2 = new NscLine(x+60, y+90, x+60, y);
        hor1 = new NscLine(x, y+30, x+90, y+30);
        hor2 = new NscLine(x, y+60, x+90, y+60);
        
         // color the lines
        vert1.setForeground(c);
        vert2.setForeground(c);
        hor1.setForeground(c);
        hor2.setForeground(c);

         // add lines to the window
         win.add(vert1);
         win.add(vert2);
         win.add(hor1);
         win.add(hor2);
 
         // update the window
         win.repaint();
    }

    /**
     * Draws a Tic-Tac-Toe board of size 90 x 90 pixels and a given 
     * width in the window.
     * 
     * @param x X coordinate of the upper-left corner of the bounding square.
     * @param y Y coordinate of the upper-left corner of the bounding square.
     * @param w The width of the lines that make up the board.
     */
    public void drawBoard(int x, int y, int w) {

        // create the four thick lines for a tic-tac-toe board
        NscRectangle vert1, vert2, hor1, hor2;
        vert1 = new NscRectangle((x + 30 - w / 2), y, w, 90);
        vert2 = new NscRectangle((x + 60 - w / 2), y, w, 90);
        hor1 = new NscRectangle(x, (y + 30 - w / 2), 90, w);
        hor2 = new NscRectangle(x, (y + 60 - w / 2), 90, w);

        // fill thick lines with black
        vert1.setFilled(true);
        vert2.setFilled(true);
        hor1.setFilled(true);
        hor2.setFilled(true);

        vert1.setBackground(Color.BLACK);
        vert2.setBackground(Color.BLACK);
        hor1.setBackground(Color.BLACK);
        hor2.setBackground(Color.BLACK);

        // add lines to the window
        win.add(vert1);
        win.add(vert2);
        win.add(hor1);
        win.add(hor2);

        // update the window
        win.repaint();        
   }

    /**
     * The application method.
     * 
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        TicTacToeBoards test = new TicTacToeBoards();
    }
    
}