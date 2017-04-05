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
 * A redo action for PowerPaint.
 * @author Sophie Nop
 * @version 21 November 2015
 */
public class RedoAction extends AbstractAction {
    
    /**
     * Generated.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * The PowerPaintDrawingPanel to redo on.
     */
    private final PowerPaintDrawingPanel myDrawingPanel;
    
    /**
     * Build a new Redo action.
     * Text "Redo"
     * Accelerator key CTRL-Y
     * @param theDrawingPanel The PowerPaintDrawingPanel to act on
     */
    public RedoAction(final PowerPaintDrawingPanel theDrawingPanel) {
        super("Redo");
        this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Y,
                                                             InputEvent.CTRL_DOWN_MASK));
        myDrawingPanel = theDrawingPanel;
    }
    
    /**
     * @param theEvent that evokes the action. 
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        if (myDrawingPanel.canRedo()) {
            myDrawingPanel.redo();
        }
    }

}
