/*
 * TCSS 305 – Autumn 2015 
 * Assignment 6a – tetris
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Board;

/**
 * @author Sophie Nop
 * @version 29 November 2015.
 *
 */
public class TimerListener implements ActionListener {

    /**
     * The game board. 
     */
    private final Board myBoard;

    /**
     * @param theBoard the game board. 
     */
    public TimerListener(final Board theBoard) {
        super();
        myBoard = theBoard;
    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myBoard.step();
    }
    
}
