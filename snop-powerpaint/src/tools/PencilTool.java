/*
 * TCSS 305 – Autumn 2015 
 * Assignment 5b – powerpaint
 */

package tools;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.geom.Path2D;

import javax.swing.ImageIcon;

import shapes.DrawableShape;
import shapes.Pencil;

/**
 * The pencil tool.
 * @author Sophie Nop
 * @version 11 November 2015
 */
public class PencilTool extends AbstractPowerPaintTool {

    /**
     * The ImageIcon for the Pencil tool.
     */
    private static final ImageIcon PENCIL_ICON = new ImageIcon("./images/pencil.gif");
    
    /**
     * Holds the Path2D for this Pencil tool.
     */
    private Path2D myPath2D;
    
    /**
     * Starts drawing a Pencil trace using a Path2D.
     * @param theStartX The X starting point
     * @param theStartY The Y starting point
     * @param theThickness The thickness to draw with
     * @param theColor The color to draw with
     */
    public void startDrawing(final int theStartX, 
                             final int theStartY, 
                             final int theThickness, 
                             final Color theColor) {
        super.startDrawing(theStartX, theStartY, theThickness, theColor);
        myPath2D = new Path2D.Float();
        myPath2D.moveTo((float) theStartX, (float) theStartY);
    }
    
    /**
     * Updates the current drawing with a new point.
     * @param theNewX the new X coordinate
     * @param theNewY the new Y coordinate 
     * @return The current drawing.
     */
    @Override
    public DrawableShape update(final int theNewX, final int theNewY) {
        myPath2D.lineTo((float) theNewX, (float) theNewY);
        return new Pencil(myPath2D, myColor, myStroke);
    }

    /**
     * Returns the text we use in the menu for this tool.
     * @return the name of the tool. 
     */
    @Override
    public String getName() {
        return "Pencil";
    }

    /**
     * Returns the accelerator key for pencils.
     * @return the key event. 
     */
    @Override
    public int getKeyboardShortcut() {
        return KeyEvent.VK_P;
    }

    /**
     * Gets the Swing ImageIcon for the tool.
     * @return The ImageIcon for this tool
     */
    @Override
    public ImageIcon getIcon() {
        return PENCIL_ICON;
    }

}
