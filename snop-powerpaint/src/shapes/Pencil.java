/*
 * TCSS 305 – Autumn 2015 
 * Assignment 5b – powerpaint
 */

package shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Path2D;

/**
 * A Drawable, immutable pencil line for PowerPaint.
 * @author Sophie Nop
 * @version 11 November 2015
 */
public class Pencil implements DrawableShape {
    
    /**
     * The path for this pencil line.
     */
    private final Path2D myPath2D;
    
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
     * @param thePath2D The Path2D traced by this Pencil drawing
     * @param theColor AWT Color of the line.
     * @param theStroke The stroke to draw this line
     */
    public Pencil(final Path2D thePath2D,
                final Color theColor, final Stroke theStroke) {
        myPath2D = thePath2D;
        myStroke = theStroke;
        myColor = theColor;
    }
    
    /**
     * @see shapes.DrawableShape#update(int, int)
     * updates the x and y coordinates. 
     * @param theUpdateX updates the x.
     * @param theUpdateY updates the y. 
     */
    public void update(final int theUpdateX, final int theUpdateY) {
        myPath2D.lineTo((double) theUpdateX, (double) theUpdateY);
    }
    
    /**
     * @see shapes.DrawableShape#drawSelf(java.awt.Graphics)
     * Draws this line on the given graphics object.
     * @param theG the Graphics object to draw on
     */
    public void drawSelf(final Graphics2D theG) {
        theG.setColor(myColor);
        theG.setStroke(myStroke);
        theG.draw(myPath2D);
    }
}
