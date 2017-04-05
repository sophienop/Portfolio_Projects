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
 * A clear-all action for PowerPaint.
 * @author Sophie Nop
 * @version 21 November 2015
 */
public class ClearAction extends AbstractAction {

    /**
     * Generated.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * The PowerPaintDrawingPanel to undo on.
     */
    private final PowerPaintDrawingPanel myDrawingPanel;
    
    /**
     * Build a new Clear-all action.
     * Text "Undo all changes"
     * Mnemonic key U
     * @param theDrawingPanel The PowerPaintDrawingPanel to act on
     */
    public ClearAction(final PowerPaintDrawingPanel theDrawingPanel) {
        super("Undo all changes");
        this.putValue(MNEMONIC_KEY, KeyEvent.VK_U);
        myDrawingPanel = theDrawingPanel;
    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        if (myDrawingPanel.canUndo()) {
            myDrawingPanel.clearMyDrawings();
        }
    }

}
