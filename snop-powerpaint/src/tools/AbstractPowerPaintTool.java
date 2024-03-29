/*
 * TCSS 305 � Autumn 2015 
 * Assignment 5b � powerpaint
 */

package tools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;

/**
 * An abstract PowerPaint tool.
 * @author Sophie Nop
 * @version 21 November 2015
 */
public abstract class AbstractPowerPaintTool implements PowerPaintTool {
    
    /**
     * The starting X coordinate of the current drawing.
     */
    protected int myStartX;
    
    /**
     * The starting Y coordinate of the current drawing.
     */
    protected int myStartY;
    
    /**
     * The stroke (thickness) of the current drawing.
     */
    protected Stroke myStroke;
    
    /**
     * The color of the current drawing.
     */
    protected Color myColor;
    
    /**
     * Starts drawing with a given X and Y coordinate, thickness, and color.
     * @param theStartX The starting X coordinate
     * @param theStartY The starting Y coordinate
     * @param theThickness The starting thickness
     * @param theColor The starting color
     */
    public void startDrawing(final int theStartX, 
                             final int theStartY, 
                             final int theThickness, 
                             final Color theColor) {
        myStartX = theStartX;
        myStartY = theStartY;
        myStroke = new BasicStroke(theThickness);
        myColor = theColor;
    }
    
}
