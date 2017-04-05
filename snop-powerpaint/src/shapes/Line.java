/*
 * TCSS 305 – Autumn 2015 
 * Assignment 5b – powerpaint
 */

package shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;

/**
 * A Drawable, immutable line for PowerPaint.
 * @author Sophie Nop
 * @version 11 November 2015
 */
public class Line implements DrawableShape {
    
    /**
     * The X coordinate of the starting point.
     */
    private final int myStartX;
    /**
     * The Y coordinate of the starting point.
     */
    private final int myStartY;
    /**
     * The X coordinate of the ending point.
     */
    private final int myEndX;
    /**
     * The Y coordinate of the ending point.
     */
    private final int myEndY;
    
    /**
     * Thickness.
     */
    private final Stroke myStroke;
    /**
     * Color of the line.
     */
    private final Color myColor;
    
    /**
     * Creates a new Line.
     * @param theStartX The X starting point.
     * @param theStartY The Y starting point.
     * @param theEndX The X ending point.
     * @param theEndY The Y ending point.
     * @param theColor AWT Color of the line.
     * @param theStroke The stroke (thickness) of the line.
     */
    public Line(final int theStartX, final int theStartY,
                final int theEndX, final int theEndY,
                final Color theColor, final Stroke theStroke) {
        myStartX = theStartX;
        myEndX = theEndX;
        myStartY = theStartY;
        myEndY = theEndY;
        myStroke = theStroke;
        myColor = theColor;
    }
    
    /**
     * @see shapes.DrawableShape#drawSelf(java.awt.Graphics)
     * Draws this line on the given graphics object.
     * @param theG the Graphics object to draw on
     */
    public void drawSelf(final Graphics2D theG) {
        theG.setColor(myColor);
        theG.setStroke(myStroke);
        theG.draw(new Line2D.Float((float) myStartX, (float) myStartY,
                                   (float) myEndX, (float) myEndY));
    }
}
