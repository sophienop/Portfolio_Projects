/*
 * TCSS 305 � Autumn 2015 Assignment 6a � Tetris
 */

package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import model.AbstractPiece;
import model.Board;
import model.Piece;

/**
 * @author Sophie
 * @version 29 November 2015
 */
public class NextPiece extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /** Size of each block, in pixels. */
    private static final int BLOCK_SIZE = 25;
    
    /**
     * The maximum height of a Tetris block.
     * Kept here because the coordinate systems for Tetris blocks and
     * Java displays are different, so we need to be able to flip the block
     * on the y-axis.
     * Flipping is done by MAX_BLOCK_HEIGHT - y
     */
    private static final int MAX_BLOCK_HEIGHT = 4;
    
    /** The Tetris board that this panel represents. */
    private final Board myBoard;

    /**
     * Constructor for TetrisPanel.
     * 
     * @param theBoard The Tetris Board whose next piece will be displayed on
     *            this panel.
     */
    public NextPiece(final Board theBoard) {
        super();
        myBoard = theBoard;
        
    }

    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);

        final Graphics2D g2d = (Graphics2D) theGraphics;

        final Piece piece = myBoard.getNextPiece();
        final int[][] currentPiece = ((AbstractPiece) piece).getRotation();

        for (int block = 0; block < currentPiece.length; block++) {
            g2d.setColor(Color.LIGHT_GRAY);

            g2d.fillRect(BLOCK_SIZE * 2 + currentPiece[block][0] * BLOCK_SIZE, 
                         // currentPiece[block][0] is X
                         BLOCK_SIZE * 2 
                             + (MAX_BLOCK_HEIGHT - currentPiece[block][1]) * BLOCK_SIZE,
                         // we are using the flipped Y value here as noted above
                         BLOCK_SIZE, BLOCK_SIZE);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(BLOCK_SIZE * 2 + currentPiece[block][0] * BLOCK_SIZE, 
                         // currentPiece[block][0] is X
                         BLOCK_SIZE * 2 
                             + (MAX_BLOCK_HEIGHT - currentPiece[block][1]) * BLOCK_SIZE,
                         // we are using the flipped Y value here as noted above
                         BLOCK_SIZE, BLOCK_SIZE);
        }
    }
}
