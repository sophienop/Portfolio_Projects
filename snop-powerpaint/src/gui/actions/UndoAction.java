/*
 * TCSS 305 – Autumn 2015 
 * Assignment 5b – powerpaint
 */

package gui.actions;

import gui.PowerPaintDrawingPanel;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

/**
 * An undo action for PowerPaint.
 * @author Sophie Nop
 * @version 21 November 2015
 */
public class UndoAction extends AbstractAction {

    /**
     * Generated.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * The PowerPaintDrawingPanel to undo on.
     */
    private final PowerPaintDrawingPanel myDrawingPanel;
    
    /**
     * Build a new Undo action.
     * Text "Undo"
     * Accelerator key CTRL-Z
     * @param theDrawingPanel The PowerPaintDrawingPanel to act on
     */
    public UndoAction(final PowerPaintDrawingPanel theDrawingPanel) {
        super("Undo");
        this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                                                             InputEvent.CTRL_DOWN_MASK));
        myDrawingPanel = theDrawingPanel;
    }

    /**
     * @param theEvent the event that calls the undo button. 
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        if (myDrawingPanel.canUndo()) {
            myDrawingPanel.undo();
        }
    }

}
