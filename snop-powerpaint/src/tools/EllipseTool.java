/*
 * TCSS 305 – Autumn 2015 
 * Assignment 5b – powerpaint
 */

package tools;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import shapes.DrawableShape;
import shapes.Ellipse;

/**
 * The ellipse tool.
 * @author Sophie Nop
 * @version 11 November 2015
 */
public class EllipseTool extends AbstractPowerPaintTool {
    
    /**
     * The ImageIcon for the Ellipse tool.
     */
    private static final ImageIcon ELLIPSE_ICON = new ImageIcon("./images/ellipse_bw.gif");
    
    /**
     * Updates the ellipse when drawn. 
     * @param theNexX the new position of the X. 
     * @param theNewY the new position of the Y. 
     */
    @Override
    public DrawableShape update(final int theNewX, final int theNewY) {
        return new Ellipse(myStartX, myStartY, theNewX, theNewY, myColor, myStroke);
    }
    
    /**
     * Gets the name of the string. 
     * @return the name. 
     */
    @Override
    public String getName() {
        return "Ellipse";
    }

    /**
     * Gets the keyboard shortcut. 
     * @return the virtual key. 
     */
    @Override
    public int getKeyboardShortcut() {
        return KeyEvent.VK_E;
    }

    /**
     * Gets the Swing ImageIcon for the tool.
     * @return The ImageIcon for this tool
     */
    @Override
    public ImageIcon getIcon() {
        return ELLIPSE_ICON;
    }

}
