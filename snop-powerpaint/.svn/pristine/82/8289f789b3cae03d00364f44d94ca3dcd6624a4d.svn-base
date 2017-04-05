/*
 * TCSS 305 – Autumn 2015 
 * Assignment 5b – powerpaint
 */

package tools;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import shapes.DrawableShape;
import shapes.Rectangle;

/**
 * The Rectangle tool.
 * @author Sophie Nop
 * @version 11 November 2015
 */
public class RectangleTool extends AbstractPowerPaintTool {

    /**
     * The Rectangle image icon.
     */
    private static final ImageIcon RECTANGLE_ICON = new ImageIcon("./images/rectangle_bw.gif");
    
    /**
     * Updates the current drawing with a new point.
     * @param theNewX the new X coordinate
     * @param theNewY the new Y coordinate 
     * @return The current drawing.
     */
    @Override
    public DrawableShape update(final int theNewX, final int theNewY) {
        return new Rectangle(myStartX, myStartY, theNewX, theNewY, myColor, myStroke);
    }

    /**
     * Gets the name of this tool.
     * @return The name of the tool.
     */
    @Override
    public String getName() {
        return "Rectangle";
    }

    /**
     * Gets the mnemonic key code for this tool.
     * @return The key code (from KeyEvent.VK_) for the keyboard shortcut.
     */
    @Override
    public int getKeyboardShortcut() {
        return KeyEvent.VK_R;
    }
    
    /**
     * Gets the Swing ImageIcon for the tool.
     * @return The ImageIcon for this tool
     */
    @Override
    public ImageIcon getIcon() {
        return RECTANGLE_ICON;
    }

}
