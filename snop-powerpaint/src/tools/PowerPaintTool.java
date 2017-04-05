/*
 * TCSS 305 � Autumn 2015 
 * Assignment 5b � powerpaint
 */

package tools;

import java.awt.Color;

import javax.swing.ImageIcon;

import shapes.DrawableShape;

/**
 * An interface for PowerPaint tools.
 * @author Sophie Nop
 * @version 11 November 2015
 */
public interface PowerPaintTool {
    /**
     * Starts drawing with this tool.
     * @param theStartX The X starting point.
     * @param theStartY The Y starting point.
     * @param theThickness The thickness of the line to draw with.
     * @param theColor The color to draw with.
     */
    void startDrawing(final int theStartX, 
                             final int theStartY, 
                             final int theThickness, 
                             final Color theColor);
    
    /**
     * Updates the current drawing with a new point.
     * @param theNewX the new X coordinate
     * @param theNewY the new Y coordinate 
     * @return The current drawing.
     */
    DrawableShape update(int theNewX, int theNewY);
    
    /**
     * Gets the name of this tool.
     * @return The name of the tool.
     */
    String getName();
    
    /**
     * Gets the Swing ImageIcon for the tool.
     * @return The ImageIcon for this tool
     */
    ImageIcon getIcon();
    
    /**
     * Gets the mnemonic key code for this tool.
     * @return The key code (from KeyEvent.VK_) for the keyboard shortcut.
     */
    int getKeyboardShortcut();
}
