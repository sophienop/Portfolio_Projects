/*
 * TCSS 305 – Autumn 2015 Assignment 6a – tetris
 */

package view;
import controller.ColorRandomizer;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import model.AbstractPiece;
import model.Block;
import model.Board;

/**
 * A DrawingPanel class.
 * 
 * @author Sophie Nop
 * @version 28 November 2015
 *
 */
public class TetrisPanel extends JPanel {
    /**
     * Generated.
     */
    private static final long serialVersionUID = 2736984037130125450L;

    /**
     * Map of colors for each piece.
     */
    private final Map<Block, Color> myColorMap;

    /**
     * The game board.
     */
    private final Board myBoard;
    
    /**
     * A stroke used to display a big X over the game board when the game is over.
     */
    private final Stroke myXOutStroke = new BasicStroke(50);
    
    /**
     * Random rgb color generator. 
     */
    private final ColorRandomizer myColorRandomizer;

    /**
     * Constructs the board and assign colors to the pieces.
     * 
     * @param theBoard that we are working on.
     */
    public TetrisPanel(final Board theBoard) {
        super();
        myColorRandomizer = new ColorRandomizer();
        myBoard = theBoard;
        myColorMap = new HashMap<Block, Color>();
        setUpColorMap();
    }

    /**
     * Sets up the color map, so we have different color pieces!
     */
    private void setUpColorMap() {
        for (final Block b : Block.values()) {
            myColorMap.put(b, myColorRandomizer.randomizeColors());
        }
        // We need to have empty blocks be white so we can draw the background
        // properly.
        myColorMap.put(Block.EMPTY, Color.WHITE);
    }

    /**
     * Sets up the color map, to light color Tetris blocks. 
     */
    public void setUpLightColorMap() {
        for (final Block b : Block.values()) {
            myColorMap.put(b, myColorRandomizer.randomizeLightColors());
        }
        myColorMap.put(Block.EMPTY, Color.WHITE);
    }
    
    /**
     * Returns the colors used by this board.
     * @return The color map of colors used by this board.
     */
    public Map<Block, Color> getColorMap() {
        return myColorMap;
    }
    
    /**
     * This method draws our graphics objects painted by the user to the screen.
     * 
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     * @param theGraphics The graphics object to use for drawing.
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        // MAKE SURE you call the parent paintComponenet
        super.paintComponent(theGraphics);

        // cast Graphics object to the "newer-ish" Graphics2D class.
        final Graphics2D g2d = (Graphics2D) theGraphics;
        // for better graphics display
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);

        // Find the width and height of a grid square for resizing
        final int blockPixelWidth = this.getWidth() / myBoard.getWidth();
        final int blockPixelHeight = this.getHeight() / myBoard.getHeight();

        // Draw frozen pieces
        final List<Block[]> frozenBlocks = myBoard.getFrozenBlocks();
        // number of rows we need to pad out:
        final int heightPadding = myBoard.getHeight() - frozenBlocks.size();
        // pixel padding for height:
        final int pixelHeightPad = heightPadding * blockPixelHeight;
        for (int i = 0; i < frozenBlocks.size(); i++) {
            final int correctedY = frozenBlocks.size() - i;
            for (int j = 0; j < frozenBlocks.get(i).length; j++) {
                if (frozenBlocks.get(i)[j] != Block.EMPTY) {
                    g2d.setColor(myColorMap.get(frozenBlocks.get(i)[j]));
                    g2d.fillRect(j * blockPixelWidth,
                                 (correctedY - 1) * blockPixelHeight + pixelHeightPad,
                                 blockPixelWidth, blockPixelHeight);
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(j * blockPixelWidth,
                                 (correctedY - 1) * blockPixelHeight + pixelHeightPad,
                                 blockPixelWidth, blockPixelHeight);
                }
            }
        }

        // draw current piece
        // we need repeated typecasts to AbstractPiece because checkstyle is
        // unhappy with declaring abstract type variables
        final int[][] currentPiece =
                        ((AbstractPiece) myBoard.getCurrentPiece()).getBoardCoordinates();
        final Block currentBlock = ((AbstractPiece) myBoard.getCurrentPiece()).getBlock();
        final Color currentBlockColor = myColorMap.get(currentBlock);
        for (int i = 0; i < currentPiece.length; i++) {
            g2d.setColor(currentBlockColor);

            // We need the "corrected Y" because the Tetris coordinates start at
            // the
            // bottom left and the java graphics coordinates start at the upper
            // left
            final int correctedY = myBoard.getHeight() - currentPiece[i][1] - 1;
            g2d.fillRect(currentPiece[i][0] * blockPixelWidth, // x coordinate
                         // in current
                         // block
                         correctedY * blockPixelHeight, // y coordinate in
                         // current block
                         blockPixelWidth, blockPixelHeight);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(currentPiece[i][0] * blockPixelWidth, // x coordinate
                         // in current
                         // block
                         correctedY * blockPixelHeight, // y coordinate in
                         // current block
                         blockPixelWidth, blockPixelHeight);
            
        }
        if (myBoard.isGameOver()) {
            // uses a big fat red line to cross out the game board and show the
            // user the game is definitely OVER
            g2d.setStroke(myXOutStroke);
            g2d.setColor(Color.RED);
            g2d.drawLine(0, 0, this.getWidth(), this.getHeight());
            g2d.drawLine(this.getWidth(), 0, 0, this.getHeight());
        }
    }

    /**
     * Get the preferred size of this component so we can resize it gracefully.
     * Uses the width and returns a height.
     * 
     * @return Dimension of the preferred size.
     * @see javax.swing.JComponent#getPreferredSize()
     */
    @Override
    public Dimension getPreferredSize() {
        final int preferredHeight = this.getWidth() / myBoard.getWidth() * myBoard.getHeight();
        return new Dimension(this.getWidth(), preferredHeight);
    }


}
