import java.awt.Color;

/**
 * The Flags class is designed to draw and display the flags from 
 * a number of countries, and one state, using the graphics 
 * package NscWindow. 
 * 
 * @author Evan L. Douglass
 * @version PA2: Flags
 * <p>Grade at challenge level</p>
 */
public class Flags {

    /**
     * Draws the flag of Niger in a new window. The flag is a 7:6 ratio, width to height. 
     * The window surrounds the flag with a 20 pixel padding.
     * <p><b>Calculations</b></p>
     * <ul>
     * <li><i>Flag Ratio</i>
     *      <p>Height (H) is entered as an integer</p>
     *      <p>Width (W): 7/6 = W / H</p>
     *      <p>W = H * 7/6</p></li>
     * <li><i>Bar Ratio</i>
     *      <p>The ratio of colored bars vertically is 1:1:1. So each bar is equal to 
     *         one third of the height (e.g. barH = H/3). The top bar is placed at 
     *         (0, 0) relative to the flag and the bottom bar at (0, H - barH). The 
     *         middle bar is the flag itself.</p></li>
     * <li><i>Circle Placement</i>
     *      <p>The circle in the flag of Niger is centered in the flag. Therefore its 
     *         x, y coordinates of the bounding box are:</p>
     *      <p>(W/2 - diameter/2, H/2 - diameter/2)</p></li>
     * </ul>
    */
    public void drawNigerFlag() {
        
        // set constants for width and height (7:6)
        int height = 270;
        // casting to float, not double, in Math.round avoids casting result to int
        int width = Math.round((float) 7 / 6 * height);
        // set color constants
        Color orange = new Color(255, 127, 0);
        Color green = new Color(0, 204, 0);
        
        // init new window with 20 pixel padding
        // account for extra pixels from Java 8/Windows 10 interaction
        NscWindow win = new NscWindow(0, 0, (width + 16 + 40), (height + 39 + 40));
        win.setTitle("Flag of Niger");

        // init new rectangle for flag
        NscRectangle Niger = new NscRectangle(20, 20, width, height);

        // init new rectangle for colored bars of 1/3 height
        int barHeight = Math.round((float) height * 1 / 3);
        NscRectangle top = new NscRectangle(0, 0, width, barHeight);
        NscRectangle bottom = new NscRectangle(0, (height - barHeight), width, barHeight);
        
        // set rectangle colors
        Niger.setFilled(true);
        Niger.setBackground(Color.WHITE);

        top.setFilled(true);
        top.setBackground(orange);

        bottom.setFilled(true);
        bottom.setBackground(green);

        // init a circle with diameter 75% height of colored bars, centered in flag
        int diameter = (int) (0.75 * barHeight);
        int x, y;
        x = (int) Math.round(0.5 * width - 0.5 * diameter);
        y = (int) Math.round(0.5 * height - 0.5 * diameter); 
        NscEllipse circle = new NscEllipse(x, y, diameter, diameter);
        // Color same as upper bar.
        circle.setFilled(true);
        circle.setBackground(orange);

        // place flag in window and bars/circle in flag
        win.add(Niger);
        Niger.add(top);
        Niger.add(bottom);
        Niger.add(circle);

        // update window
        win.repaint();
    }

    /**
     * Draws the flag of Sweden in a new window. The flag is an 8:5 ratio, width to height. 
     * The window surrounds the flag with a 20 pixel padding.
     * <p><b>Calculations</b></p>
     * <ul>
     * <li><i>Flag Ratio</i>
     *     <p>Height (H) is entered as an integer.</p>
     *     <p>Width (W): 8/5 = W / H</p>
     *     <p>W = H * 8/5</p></li>
     * <li><i>Bar Ratios</i>
     *     <p>The horizontal color ratio is 5:2:9. This means the first section has length 
     *        <i>H * 5/16</i>, the second: <i>H/8</i>, the third: <i>H * 9/16</i>.
     *        This means the vertical bar should start where the first section ends, at 
     *        <i>x = H * 5/16</i> and <i>y = 0</i>. Its width should be that of the second section
     *        and height that of the whole flag.</p>
     *     <p>The vertical color ratio is 2:1:2. The horizonal bar should start after the first section 
     *        at <i>x = 0</i> and <i>y = H * 2/5</i>. Its height is <i> barH = H/5</i> and width
     *        that of the whole flag.</p></li>
     * </ul>
     */
    public void drawSwedenFlag() {

        // set constants for width and height (8:5)
        int height = 270;
        int width = Math.round((float) height * 8 / 5);

        // init new window with space for 20 pixel padding
        NscWindow win = new NscWindow(0, 0, (width + 16 + 40), (height + 39 + 40));
        win.setTitle("Flag of Sweden");

        // init two new rectangles, one for the flag, one to maintain a boarder
        // on the finished flag.
        NscRectangle Sweden = new NscRectangle(20, 20, width, height);
        NscRectangle boarder = new NscRectangle(20, 20, width, height);

        // init new rectangles for colored bars
        // width ratios = 5:2:9
        int vertX, vertWidth;
        vertX = Math.round((float) width * 5 / 16);
        vertWidth = Math.round((float) width / 8);
        NscRectangle vert = new NscRectangle(vertX, 0, vertWidth, height);
        
        // height ratios = 4:2:4
        int horzY, horzHeight;
        horzY = Math.round((float) height * 2 / 5);
        horzHeight = Math.round((float) height / 5);
        NscRectangle horz = new NscRectangle(0, horzY, width, horzHeight);

        // set rectangle colors
        Sweden.setFilled(true);
        Sweden.setBackground(Color.BLUE);
        Sweden.setForeground(Color.BLUE);
        
        vert.setFilled(true);
        vert.setBackground(Color.YELLOW);
        vert.setForeground(Color.YELLOW);

        horz.setFilled(true);
        horz.setBackground(Color.YELLOW);
        horz.setForeground(Color.YELLOW);

        // place flag in window and bars in flag
        win.add(Sweden);
        Sweden.add(vert);
        Sweden.add(horz);
        win.add(boarder);

        // update window
        win.repaint();
    }

    /**
     * Draws the flag of Norway in a new window. The flag is a 22:16 ratio, width to height. 
     * The window surrounds the flag with a 20 pixel padding.
     * <p><b>Calculations</b></p>
     * <ul>
     * <li><i>Flag Ratio</i>
     *     <p>Height (H) is entered as an integer.</p>
     *     <p>Width (W): 22/16 = W / H</p>
     *     <p>W = H * 22/16</p></li>
     * <li><i>Bar Ratios</i>
     *     <p>The horizontal color ratio is 6:1:2:1:12. The vertical white bar stops where the red ends,
     *        at <i>x = W * 3/11</i>. The vertical blue bar starts where the first white bar ends, at
     *        <i>x = W * 7/22</i>. The white bar's width is both white bars plus the blue bar, so <i>
     *        whiteW = H * 2/11</i>. The blue bar's width is simply its fraction of the ratio, <i>blueW = 
     *        H/11</i>. Both bars have x values of 0 and are equal in height to the whole flag</p>
     *     <p>The vertical color ratio is 6:1:2:1:6. The starting locations and height of the horizontal bars
     *        are similar to the equations of the vertical bars. For the white bar, <i>y = H * 3/8</i> and 
     *        <i>whiteH = H/4</i>. For the blue bar, <i>y = H * 7/16</i> and <i>blueH = H/8</i></p></li>
     * </ul>
     */
    public void drawNorwayFlag() {

        // set constants for width and height (22:16)
        int height = 270;
        int width = Math.round((float) height * 22 / 16);

        // init new window with 20 pixel padding for flag
        NscWindow win = new NscWindow(0, 0, (width + 16 + 40), (height + 39 + 40));
        win.setTitle("Flag of Norway");

        // init new rectangle for flag and final boarder
        NscRectangle Norway = new NscRectangle(20, 20, width, height);
        NscRectangle boarder = new NscRectangle(20, 20, width, height);

        // find values for location and size of bars in the flag as needed
        int vertWhiteX, vertWhiteWidth, horzWhiteY, horzWhiteHeight;
        vertWhiteX = Math.round((float) width * 3 /11);
        vertWhiteWidth = Math.round((float) width * 2 / 11);
        horzWhiteY = Math.round((float) height * 3 / 8);
        horzWhiteHeight = Math.round((float) height / 4);

        int vertBlueX, vertBlueWidth, horzBlueY, horzBlueHeight;
        vertBlueX = Math.round((float) width * 7 / 22);
        vertBlueWidth = Math.round((float) width / 11);
        horzBlueY = Math.round((float) height * 7 / 16);
        horzBlueHeight = Math.round((float) height / 8);

        // init bars
        NscRectangle vertWhite, horzWhite, vertBlue, horzBlue;
        vertWhite = new NscRectangle(vertWhiteX, 0, vertWhiteWidth, height);
        horzWhite = new NscRectangle(0, horzWhiteY, width, horzWhiteHeight);
        vertBlue = new NscRectangle(vertBlueX, 0, vertBlueWidth, height);
        horzBlue = new NscRectangle(0, horzBlueY, width, horzBlueHeight);

        // set rectangle colors
        Norway.setFilled(true);
        Norway.setBackground(Color.RED);
        Norway.setForeground(Color.RED);

        vertWhite.setFilled(true);
        horzWhite.setFilled(true);
        vertWhite.setBackground(Color.WHITE);
        horzWhite.setBackground(Color.WHITE);
        vertWhite.setForeground(Color.WHITE);
        horzWhite.setForeground(Color.WHITE);

        vertBlue.setFilled(true);
        horzBlue.setFilled(true);
        vertBlue.setBackground(Color.BLUE);
        horzBlue.setBackground(Color.BLUE);
        vertBlue.setForeground(Color.BLUE);
        horzBlue.setForeground(Color.BLUE);

        // place flag in window and bars in flag
        win.add(Norway);
        Norway.add(vertWhite);
        Norway.add(horzWhite);
        Norway.add(vertBlue);
        Norway.add(horzBlue);
        win.add(boarder);

        // update window
        win.repaint();
    }

    /**
     * Draws the flag of Seychelles in a new window. The flag is a 2:1 ratio, width to height. 
     * The window surrounds the flag with a 20 pixel padding.
     * <p><b>Calculations</b></p>
     * <ul>
     * <li><i>Flag Ratio</i>
     *     <p>Height (H) is entered as an integer.</p>
     *     <p>Width (W): 2 = W / H</p>
     *     <p>W = H * 2</p></li>
     * <li><i>Triangles</i>
     *     <p>The color ratios for both the vertical and horizonal of the flag is 1:1:1. The triangles 
     *        in the NscWindow package do not allow point reassignment so the bands of color in the flag 
     *        are produced by laying NscDownTriangles on top of one another, with each one's middle point on 
     *        the lower left corner of the flag. The calculations for each triangle folow. Note that the
     *        y coordinate of all the triangles is 0 and the height is H.</p>
     *     <p>White Triangle: Slope of visible triangle <i>= (H/3) / W</i>, or <i>H/3W</i>. We can
     *        solve for x with the equation, <i>H = (H/3W)x</i>. We find <i>x = 3W</i>. The x coordinate 
     *        is then <i>-(3W)</i> and the width <i>6W</i>.</p>
     *     <p>Red Triangle: Slope of visible triangle <i>= (2H/3) / W</i>, or <i>2H/3W</i>. We can
     *        solve for x with the equation, <i>H = (2H/3W)x</i>. We find <i>x = 3W/2</i>. The x coordinate 
     *        is then <i>-(3W/2)</i> and the width <i>3W</i>.</p>
     *     <p>Yellow Triangle: We know the width is <i>2 * 2/3 * W</i> because of the color ratio, so 
     *        <i>yellowW = W * 4/3</i> and the x coordinate is is <i>-(W * 2/3)</i>.</p>
     *     <p>Blue Triangle: We know the width is <i>2 * 1/3 * W</i> because of the color ratio, so 
     *        <i>blueW = W * 2/3</i> and the x coordinate is is <i>-(W/3)</i>.</p>
     *     <p>The green triangle is simply a result of drawing the other triangles on top of a green
     *        filled Rectangle object.</p>
     * </ul>
     */
    public void drawSeychellesFlag() {

        // set constants for width and height (2:1)
        int height = 270;
        int width = 2 * height;
        // set constant for custom green
        Color green = new Color(0, 128, 0);

        // init new window with padding of 20 pixels
        NscWindow win = new NscWindow(0, 0, (width + 16 + 40), (height + 39 + 40));
        win.setTitle("Flag of Seychelles");

        // init new rectangle for flag and final boarder
        NscRectangle Seychelles = new NscRectangle(20, 20, width, height);
        NscRectangle boarder = new NscRectangle(20, 20, width, height);

        // declare and init triangles for flag
        NscDownTriangle blue, yellow, red, white;
        white = new NscDownTriangle((-3 * width), 0, (6 * width), height);
        red = new NscDownTriangle(-(Math.round((float) width * 3 / 2)), 0, (3 * width), height);
        yellow = new NscDownTriangle(-(Math.round((float) width * 2 / 3)), 0, 
                Math.round((float) width * 4 / 3), height);
        blue = new NscDownTriangle(-(Math.round((float) width / 3)), 0, 
                Math.round((float) width * 2 / 3), height);

        // set colors
        Seychelles.setFilled(true);
        white.setFilled(true);
        red.setFilled(true);
        yellow.setFilled(true);
        blue.setFilled(true);

        Seychelles.setBackground(green);        
        white.setBackground(Color.WHITE);
        red.setBackground(Color.RED);
        yellow.setBackground(Color.YELLOW);
        blue.setBackground(Color.BLUE);

        // place flag in window and triangles in flag
        win.add(Seychelles);
        Seychelles.add(white);
        Seychelles.add(red);
        Seychelles.add(yellow);
        Seychelles.add(blue);
        win.add(boarder);

        // update window
        win.repaint();
    }

    /**
     * Draws the flag of Alabama in a new window. The flag is a 10:6 ratio, width to height. 
     * The window surrounds the flag with a 20 pixel padding.
     * <p><b>Calculations</b></p>
     * <ul>
     * <li><i>Flag Ratio</i>
     *     <p>Height (H) is entered as an integer.</p>
     *     <p>Width (W): 10/6 = W / H</p>
     *     <p>W = H * 5/3</p></li>
     * <li><i>Triangles</i>
     *     <p>The color ratios for both the vertical and horizonal of the flag is 1:9:1. White triangles 
     *        are used to create the look of diagonal red bands.</p>
     *     <p>The x coordinate, width and height of the upper and lower triangles are equal. Using
     *        the color ratio, <i>x = W/11</i> and <i>w = W * 9/11</i>. The height is 1/11 of the flag 
     *        height less than half of the flag height. So, <i>h = H/2 - H/11 = 9H/22</i>. The y coordinate 
     *        of the upper triangle is zero, while that of the lower is <i>y = H - h = H * 13/22</i></p>
     *     <p>The y coordinate, width and height of the left and right triangles are equal. Using
     *        the color ratio, <i>y = H/11</i> and <i>h = H * 9/11</i>. The width is 1/11 of the flag 
     *        width less than half of the flag height. So, <i>w = W/2 - W/11 = 9W/22</i>. The x coordinate 
     *        of the left triangle is zero, while that of the right is <i>x = W - w = W * 13/22</i></p>
     * </ul>
     */
    public void drawAlabamaFlag() {

        // set constants for width and height (10:6)
        int height = 270;
        int width = Math.round((float) height * 5 / 3);

        // init new window with 20 pixel padding
        NscWindow win = new NscWindow(0, 0, (width + 16 + 40), (height + 39 + 40));
        win.setTitle("Flag of Alabama");

        // init flag
        NscRectangle Alabama = new NscRectangle(20, 20, width, height);

        // init new triangles for flag
        int upX, upY, upW, upH;
        upX = Math.round((float) width / 11);
        upY = Math.round((float) height * 13 / 22);
        upW = Math.round((float) width * 9 / 11);
        upH = Math.round((float) height * 9 / 22);
        NscUpTriangle up = new NscUpTriangle(upX, upY, upW, upH);

        int downX, downY, downW, downH;
        downX = upX;
        downY = 0;
        downW = upW;
        downH = upH;
        NscDownTriangle down = new NscDownTriangle(downX, downY, downW, downH);

        int rightX, rightY, rightW, rightH;
        rightX = 0;
        rightY = Math.round((float) height / 11);
        rightW = Math.round((float) width * 9 / 22);
        rightH = Math.round((float) height * 9 / 11);
        NscRightTriangle right = new NscRightTriangle(rightX, rightY, rightW, rightH);

        int leftX, leftY, leftW, leftH;
        leftX = width - rightW;
        leftY = rightY;
        leftW = rightW;
        leftH = rightH;
        NscLeftTriangle left = new NscLeftTriangle(leftX, leftY, leftW, leftH);

        // set colors
        Alabama.setFilled(true);
        up.setFilled(true);
        down.setFilled(true);
        right.setFilled(true);
        left.setFilled(true);

        Alabama.setBackground(Color.RED);
        up.setBackground(Color.WHITE);
        down.setBackground(Color.WHITE);
        right.setBackground(Color.WHITE);
        left.setBackground(Color.WHITE);

        // place flag in window and triangles in flag
        win.add(Alabama);
        Alabama.add(up);
        Alabama.add(down);
        Alabama.add(right);
        Alabama.add(left);

        // update window
        win.repaint();
    }

    /**
     * The application method. Displays each flag in the 
     * Flags class.
     * 
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        
        // init a new Flags object
        Flags test = new Flags();
        // display each flag described in the class
        test.drawAlabamaFlag();
        test.drawSeychellesFlag();
        test.drawNorwayFlag();
        test.drawSwedenFlag();
        test.drawNigerFlag();
    }
}