/*
 * TCSS 305 – Autumn 2015 
 * Assignment 5b – powerpaint
 */

package tools;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import shapes.DrawableShape;
import shapes.Line;

/**
 * A line tool.
 * @author Sophie Nop
 * @version 21 November 2015
 */
public class LineTool extends AbstractPowerPaintTool {

    /**
     * The ImageIcon for the Pencil tool.
     */
    private static final ImageIcon LINE_ICON = new ImageIcon("./images/line_bw.gif");
    
    /**
     * Updates the ellipse when drawn. 
     * @param theNexX the new position of the X. 
     * @param theNewY the new position of the Y. 
     */
    @Override
    public DrawableShape update(final int theNewX, final int theNewY) {
        return new Line(myStartX, myStartY, theNewX, theNewY, myColor, myStroke);
    }

    /**
     * Gets the name of the string. 
     * @return the name. 
     */
    @Override
    public String getName() {
        return "Line";
    }

    /**
     * Gets the keyboard shortcut. 
     * @return the virtual key. 
     */
    @Override
    public int getKeyboardShortcut() {
        return KeyEvent.VK_L;
    }

    /**
     * Gets the Swing ImageIcon for the tool.
     * @return The ImageIcon for this tool
     */
    @Override
    public ImageIcon getIcon() {
        return LINE_ICON;
    }

}
