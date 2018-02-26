import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This class demonstrates the use of functional buttons in 
 * simple Java graphics windows.
 * @author Evan L. Douglass
 * @version LA10: ButtonButton
 * <br>Grade at plus
 */
public class ButtonButton extends JFrame
    implements ActionListener {
    
    private NscWindow win;
    private NscEllipse oval;
    private Color[] colors;
    private JButton fwdBtn;
    private JButton backBtn;
    
    /**
     * Instantiates a ButtonButton object. Creates a window with 
     * a colored oval and two buttons that cause the oval to change 
     * colors.
     */
    public ButtonButton () {
        // color array
        colors = new Color[] {Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN, 
                            Color.BLUE, Color.MAGENTA};

        // window
        win = new NscWindow();
        win.setTitle("ButtonButton");
        
        // oval
        oval = new NscEllipse(100, 70, 200, 150);
        oval.setFilled(true);
        // set to blue initially
        oval.setBackground(colors[4]);
        
        // forward button
        fwdBtn = new JButton("Next Color");
        fwdBtn.setSize(120, 35);
        fwdBtn.setLocation(220, 10);
        fwdBtn.addActionListener(this);
        
        // back button
        backBtn = new JButton("Prev Color");
        backBtn.setSize(120, 35);
        backBtn.setLocation(60, 10);
        backBtn.addActionListener(this);
        
        // add components to window
        win.add(oval);
        win.add(fwdBtn);
        win.add(backBtn);

        // update window
        win.repaint();
    }
    
    /**
     * The Method from ActionListener
     * @param e The action that triggered this handler
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // current color index
        int index = getIndex(oval.getBackground());

        // forward button pressed
        if ((JButton) e.getSource() == fwdBtn) {
            // if last index, move to first
            if (index == 5) {
                oval.setBackground(colors[0]);
                win.repaint();
            // else increment color via index
            } else {
                oval.setBackground(colors[index+1]);
                win.repaint();
            }
        
        // back button pressed
        } else if ((JButton) e.getSource() == backBtn) {
            // if first index move to last
            if (index == 0) {
                oval.setBackground(colors[5]);
                win.repaint();
            // else decrement color via index
            } else {
                oval.setBackground(colors[index-1]);
                win.repaint();
            }
        }
    }

    /**
     * Finds the index of a color in the colors array field.
     * @param c A Color object
     * @return The index of the color
     */
    private int getIndex(Color c) {
        // cycle through colors until match is found
        // match must be found thanks to button functionality
        for (int i = 0; i < colors.length; i++) {
            if (colors[i].equals(c)) {
                return i;
            }
        }
        // if not found (won't happen in this implementation)
        return -1;
    }
    
    /**
     * The application method.
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        new ButtonButton();
    }
}