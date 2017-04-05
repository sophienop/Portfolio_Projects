/*
 * TCSS 305 – Autumn 2015 
 * Assignment 5b – powerpaint
 */

package gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * An action to show the about box. 
 * @author Sophie Nop
 * @version 21 November 2015
 */
public class AboutAction extends AbstractAction {
    
    /**
     * Generated. 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * The frame the about box will be shown on. 
     */
    private final JFrame myParentFrame;
    
    /**
     * Constructs the about button.
     * @param theParentFrame is the frame the about box will be shown on. 
     */
    public AboutAction(final JFrame theParentFrame) {
        super("About...");
        this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
        myParentFrame = theParentFrame;
    }
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        JOptionPane.showMessageDialog(myParentFrame,
                                      "TCSS 305 PowerPaint, Autumn 2015",
                                      "Sophie Nop", JOptionPane.INFORMATION_MESSAGE);

    }

}
