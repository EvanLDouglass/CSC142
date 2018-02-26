import java.awt.Point;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * The TicTacToe class provides gameplay for Tic-Tac-Toe.
 * @author Evan L. Douglass
 * @version PA 8: Tic-Tac-Toe, the Game
 * <br>Grade at challenge
 */
public class TicTacToe extends NscWindow implements ActionListener {
    
    // initial fields
    private JButton[] btns;
    private JLabel prompt;
    private char turn;

    // added fields
    // counts the number of moves made in the game
    private int countMoves;
    // keep track of board layout
    private int[] board;
    // button for reset
    private JButton resetBtn;
    
    /**
     * Starts the game by creating an interactive game board in a
     * new window.
     */
    public TicTacToe() {
        // new window
        super(10, 10, 235, 280);
        setTitle("Tic-Tac-Toe");

        // an array to hold the location of each button
        Point[] locations = {
            new Point(30, 30), new Point(85, 30), new Point(140, 30),
            new Point(30, 85), new Point(85, 85), new Point(140, 85),
            new Point(30, 140), new Point(85, 140), new Point(140, 140)
            };

        // button array
        btns = new JButton[9];

        // fill button array
        for (int i = 0; i < btns.length; i++) {
            btns[i] = new JButton();
            btns[i].setSize(50, 50);
            btns[i].setLocation(locations[i]);
            btns[i].setFont(new Font("Ariel", Font.BOLD, 20));
            btns[i].addActionListener(this);
            add(btns[i]);
        }

        // set up reset button (don't add it yet)
        resetBtn = new JButton("Reset");
        resetBtn.setSize(70, 25);
        resetBtn.setLocation(75, 1);
        resetBtn.addActionListener(this);

        // set up board tracker
        board = new int[9];

        // set prompt for initial turn info
        prompt = new JLabel("X's turn.");
        prompt.setSize(160, 20);
        prompt.setLocation(30, 200);
        prompt.setHorizontalAlignment(JLabel.CENTER);
        add(prompt);

        // set to X's turn
        turn = 'X';

        // update window
        repaint();
    }

    /**
     * Describes the actions to take upon clicking a button.
     * @param e The action that trigged this method
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // get source (For minimal: disable button)
        JButton btn = (JButton) e.getSource();
        //btn.setEnabled(false);

        // reset functionality
        if (btn == resetBtn) {
            reset();
            return;
        }

        // get index for board tracker
        int index = getIndex(btn);

        // check for valid move (button has no text)
        String text = btn.getText();
        if ( ! text.equals("")) {
            getToolkit().beep();
        
        // valid move for X
        } else if (turn == 'X') {

            // claim square for X
            btn.setText("X");

            // update board tracker & test for win
            board[index] = 1;
            if (testWin()) {
                prompt.setText("X wins!");
                endGame();
                return;
            }

            // switch turns
            prompt.setText("O's turn.");
            turn = 'O';
            countMoves++;

        // valid move for O
        } else {

            // claim square for O
            btn.setText("O");

            // update board tracker & test for win
            board[index] = -1;
            if (testWin()) {
                prompt.setText("O wins!");
                endGame();
                return;
            }

            // switch turns
            prompt.setText("X's turn.");
            turn = 'X';
            countMoves++;
        }

        // if board is full (9 valid moves)
        if (countMoves == 9) {
            prompt.setText("Cat's game.");
            endGame();
        }
    }

    /**
     * Helper function to test if a player has won the game. Represents
     * X and O as 1 and -1 respectively. The game is won when the absolute
     * value of the sum of a row, column or diagonal is 3.
     * @return true if a player has won, false otherwise
     */
    private boolean testWin() {
        // check horizontals
        for (int i = 0; i < board.length; i += 3) {
            if (Math.abs(board[i] + board[i+1] + board[i+2]) == 3) {
                return true;
            }
        }

        // check verticals
        for (int i = 0; i < 3; i++) {
            if (Math.abs(board[i] + board[i+3] + board[i+6]) == 3) {
                return true;
            }
        }

        // check diagonals
        if (Math.abs(board[0] + board[4] + board[8]) == 3 ||
            Math.abs(board[2] + board[4] + board[6]) == 3) {
                return true;
        }

        // no wins
        return false;
    }

    /**
     * Searches through the btns field to find the array index of
     * one of the buttons.
     * @return the index of the given button in btns
     */
    private int getIndex(JButton btn) {
        // find index of matching button
        for (int i = 0; i < btns.length; i++) {
            if (btns[i] == btn) {
                return i;
            }
        }
        // no matches
        return -1;
    }

    /**
     * Ends the current game when a player has won or there is
     * a draw.
     */
    private void endGame() {
        // disable all buttons
        for (int i = 0; i < btns.length; i++) {
            btns[i].setEnabled(false);
        }
        // add reset button
        add(resetBtn);
        repaint();
    }

    /**
     * Resets the game board to it's initial state.
     */
    private void reset() {
        // re-enable buttons and remove text
        // reset game tracker
        for (int i = 0; i < btns.length; i++) {
            btns[i].setEnabled(true);
            btns[i].setText("");
            board[i] = 0;
        }

        // reset prompt
        prompt.setText("X's turn.");

        // reset turn
        turn = 'X';
        
        // reset move counter
        countMoves = 0;

        // remove reset button
        remove(resetBtn);
        repaint();
    }
    
    /**
     * The application method.
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
    }
}