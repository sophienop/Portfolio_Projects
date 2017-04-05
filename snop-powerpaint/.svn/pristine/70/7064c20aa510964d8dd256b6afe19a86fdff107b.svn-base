/*
 * TCSS 305 – Autumn 2015 
 * Assignment 5b – powerpaint
 */

package gui.actions;

import gui.PowerPaintDrawingPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JColorChooser;


/**
 * Creates the color chooser. 
 * 
 * @author Sophie Nop
 * @version 21 November 2015
 */
public class ColorChooserAction extends AbstractAction {
    
    /**
     * Generated.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * the Drawing panel whose color we will set. 
     */
    private final PowerPaintDrawingPanel myDrawingPanel; 
    
    /**
     * The color icon that will change with the selection of the color. 
     */
    private final ColorIcon myColorIcon; 
    
    /**
     * Construct the color chooser with color icon. 
     * @param theDrawingPanel whose color we will set. 
     */
    public ColorChooserAction(final PowerPaintDrawingPanel theDrawingPanel) {
        super("Color...");
        this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
        myDrawingPanel = theDrawingPanel;
        myColorIcon = new ColorIcon(Color.BLACK);
        this.putValue(SMALL_ICON, myColorIcon);

    }
    
    /**
     * Get the new color from the user and set it on the drawing panel. 
     * @param theEvent whose color we will set. 
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        final Color colorUserChose =
                        JColorChooser.showDialog(null, "Color Chooser", null);
        if (colorUserChose != null) {
            myDrawingPanel.setColor(colorUserChose);
            myColorIcon.setColor(colorUserChose);
        }

    }

    /**
     * A dynamic color icon.
     */
    private class ColorIcon implements Icon {

        /**
         * The height and width of this icon in pixels.
         */
        private static final int SIZE = 19;
        
        /**
         * The color of this icon.
         */
        private Color myColor;
        
        /**
         * Constructs a color icon of the given color. 
         * @param theColor is the color to use. 
         */
        public ColorIcon(final Color theColor) {
            myColor = theColor;
        }
        
        /**
         * Sets the color of this icon.
         * @param theNewColor The new color.
         */
        public void setColor(final Color theNewColor) {
            myColor = theNewColor;
        }
        
        /** 
         * gets the icon height. 
         */
        @Override
        public int getIconHeight() {
            return SIZE;
        }
        
        /** 
         * gets the icon width. 
         */
        @Override
        public int getIconWidth() {
            return SIZE;
        }

        /** 
         * changes the icon color to the selected color. 
         */
        @Override
        public void paintIcon(final Component theComponent,
                              final Graphics theGraphics,
                              final int theX,
                              final int theY) {
            theGraphics.setColor(myColor);
            theGraphics.fillRect(theX, theY, SIZE, SIZE);
        }

    }

}
