/*
 * TCSS 305 – Autumn 2015 
 * Assignment 5b – powerpaint
 */

package gui.actions;

import gui.PowerPaintDrawingPanel;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

/**
 * Constructs the grid. 
 * @author Sophie Nop
 * @version 21 November 2015
 *
 */
public class GridAction extends AbstractAction {

    /**
     * Generated. 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * The drawing panel we will set the grid on. 
     */
    private PowerPaintDrawingPanel myDrawingPanel;

    /**
     * Constructs the grid for the drawing panel. 
     * @param theDrawingPanel we will set the grid on. 
     */
    public GridAction(final PowerPaintDrawingPanel theDrawingPanel) {
        super("Grid");
        // We have to set this up here so that Swing will update it
        this.putValue(SELECTED_KEY, false);
        this.putValue(MNEMONIC_KEY, KeyEvent.VK_G);
        myDrawingPanel = theDrawingPanel;
    }

    /**
     * The state of whether the grid is selected or not. 
     * @param theEvent the event that triggered this action. 
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myDrawingPanel.setGridEnabled((Boolean) this.getValue(SELECTED_KEY));
    }

}
