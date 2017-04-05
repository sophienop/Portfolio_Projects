/*
 * TCSS 305 – Autumn 2015 
 * Assignment 5b – powerpaint
 */

package gui;

import java.awt.EventQueue;

/**
 * The Runner class. 
 * 
 * @author Sophie Nop
 * @version 5 November 2015
 */
public final class PowerPaintRunner {
    
    /**
     * Constructor that runs the program.  
     */
    private PowerPaintRunner() {
        throw new IllegalStateException();
    }

    /**
     * @param theArgs that takes in the argument. 
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new PowerPaintGUI().start();
            }
        });
    }
}
