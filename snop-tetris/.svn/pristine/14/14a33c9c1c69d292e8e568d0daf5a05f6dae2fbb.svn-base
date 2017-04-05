
package controller;

import java.awt.Color;


/**
 * Random Color maker.
 * 
 * @author Sophie Nop
 * @version 6 December 2015
 */
public class ColorRandomizer {

    /**
     * The random color. 
     */
    private Color myRandomColor;

    /**
     * @param theTetrisGUI
     * @param theBoard
     */
    public ColorRandomizer() {
        myRandomColor = new Color(0, 0, 0);
    }

    /**
     * Randomizes a color, light or dark.
     * @return the random color. 
     */
    public Color randomizeColors() {
        final int r = (int) (Math.random() * 256);
        final int g = (int) (Math.random() * 256);
        final int b = (int) (Math.random() * 256);
        myRandomColor = new Color(r, g, b);
        return myRandomColor;
    }
    
    /**
     * Returns a random light color (127-254 each on R, G, B).
     * @return the random color. 
     */
    public Color randomizeLightColors() {
        // (int)(Math.random() * ((upperbound - lowerbound) + 1) + lowerbound);
        //(where lowerbound is inclusive and upperbound exclusive)
        
        final int r = (int) (Math.random() * 127 + 127);
        final int g = (int) (Math.random() * 127 + 127);
        final int b = (int) (Math.random() * 127 + 127);
        myRandomColor = new Color(r, g, b);
        return myRandomColor;
    }

}
