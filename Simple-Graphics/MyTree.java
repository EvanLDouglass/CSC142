/**
 * A graphic component that creates a simple tree.
 * 
 * @author Evan L. Douglass
 * @version PA 4: MyScene
 * <br>Grade at standard
 */
public class MyTree extends NscComponent {

    // instance variables
    private NscRectangle trunk;
    private NscUpTriangle leaves;

    /**
     * Primary constructor for the class.
     * Specifies the location of the tree and the color of the leaves
     * 
     * @param x The x-coordinate for the object.
     * @param y The y-coordinate for the object.
     * @param c The color of the leaves.
     */
    public MyTree(int x, int y, java.awt.Color c) {

        // instantiate an NscComponent
        super(x, y, 60, 120);

        // instantiate the trunk
        trunk = new NscRectangle(23, 90, 14, 30);
        trunk.setFilled(true);
        trunk.setBackground(new java.awt.Color(139, 69, 19));

        // instantiate the leaves
        leaves = new NscUpTriangle(0, 0, 60, 90);
        leaves.setFilled(true);
        leaves.setBackground(c);

        // add tree to component
        add(trunk);
        add(leaves);
    }

    /**
     * Default color constructor for the class.
     * Creates a tree with dark green leaves.
     * 
     * @param x The x-coordinate for the object.
     * @param y The y-coordinate for the object.
     */
    public MyTree(int x, int y) {
        this(x, y, new java.awt.Color(0, 100, 0));
    }

    /**
     * Sets a color for the leaves.
     * 
     * @param c The color of the leaves.
     */
    public void setColor(java.awt.Color c) {
        leaves.setBackground(c);
    }

    /**
     * Gets the current color of the leaves.
     * 
     * @return The color of the leaves.
     */
    public java.awt.Color getColor() {
        return leaves.getBackground();
    }
}