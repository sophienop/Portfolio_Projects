/*
 * TCSS 305 – Autumn 2015 Assignment 6a – tetris
 */

package view;

import controller.TetrisScorer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.Rectangle2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;


/**
 * A panel that displays the score.
 * @author Sophie
 * @version 29 November 2015
 */
public class ScorePanel extends JPanel implements Observer {

    /**
     * Generated.
     */
    private static final long serialVersionUID = -7406471157310394433L;

    /** Font size for text in this panel. */
    private static final int FONT_SIZE = 18;

    /** String array containing the info for this panel. */
    private static final String[] SCORE_INFO =
    {"SCOREBOARD", "", "", "Score: ", "Level: ", "Lines to clear: "};

    /**
     * The Tetris game panel. 
     */
    private final TetrisScorer myTetrisScorer;

    /**
     * Constructor for TetrisPanel.
     * @param theTetrisScorer is the scorer object to use.
     */
    public ScorePanel(final TetrisScorer theTetrisScorer) {
        super();
        myTetrisScorer = theTetrisScorer;
        myTetrisScorer.addObserver(this);
    }

    /**
     * Paints the score panel.
     * @param theGraphics the graphics painter to use.
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);

        final Font font = new Font(Font.DIALOG,
                                   Font.LAYOUT_NO_START_CONTEXT + Font.HANGING_BASELINE,
                                   FONT_SIZE);
        g2d.setFont(font);
        g2d.setColor(Color.DARK_GRAY);
        // The number of lines down the screen we've used.
        int currentLine = 0;
        for (int i = 0; i <= 2; i++) {
            // Sets up the drawing for a font in the panel
            final FontRenderContext renderContext = g2d.getFontRenderContext();
            final GlyphVector glyphVector =
                            font.createGlyphVector(renderContext, SCORE_INFO[i]);
            final Rectangle2D visualBounds = glyphVector.getVisualBounds().getBounds();

            final int x = (int) ((getWidth() - visualBounds.getWidth()) / 2
                                 - visualBounds.getX());
            // Actually draws the font in the panel
            g2d.drawString(SCORE_INFO[i], x, (i + 1) * FONT_SIZE);
            currentLine = i;
        }

        currentLine++;
        final FontRenderContext renderContext = g2d.getFontRenderContext();
        GlyphVector glyphVector =
                        font.createGlyphVector(renderContext,
                                               SCORE_INFO[currentLine] + getScore());
        Rectangle2D visualBounds = glyphVector.getVisualBounds().getBounds();

        int x = (int) ((getWidth() - visualBounds.getWidth()) / 2 - visualBounds.getX());

        g2d.drawString(SCORE_INFO[currentLine] + getScore(),
                       x, (currentLine++ + 1) * FONT_SIZE);

        glyphVector = font.createGlyphVector(renderContext,
                                             SCORE_INFO[currentLine] + getLevel());
        visualBounds = glyphVector.getVisualBounds().getBounds();

        x = (int) ((getWidth() - visualBounds.getWidth()) / 2 - visualBounds.getX());

        g2d.drawString(SCORE_INFO[currentLine] + getLevel(),
                       x, (currentLine++ + 1) * FONT_SIZE);

        final int toClear = TetrisScorer.LINES_PER_LEVEL
                        - (getLinesCleared() % TetrisScorer.LINES_PER_LEVEL);
        glyphVector = font.createGlyphVector(renderContext, SCORE_INFO[currentLine] + toClear);
        visualBounds = glyphVector.getVisualBounds().getBounds();

        x = (int) ((getWidth() - visualBounds.getWidth()) / 2 - visualBounds.getX());

        g2d.drawString(SCORE_INFO[currentLine] + toClear, x, (currentLine++ + 1) * FONT_SIZE);
    }

    /**
     * Receives an update from an Observable.
     * In this case we will just accept it as a "hey, repaint yourself with some
     * new data" message.
     * @param theObservable the Observable object that generated this message. Not used.
     * @param theData the data passed in by the Observable that generated this message.
     * Not used.
     */
    @Override
    public void update(final Observable theObservable, final Object theData) {
        repaint();
    }
    
    /**
     * Gets the current score from the scorer.
     * @return the current score.
     */
    private int getScore() {
        return myTetrisScorer.getScore();
    }
    
    /**
     * Gets the number of lines cleared.
     * @return the current lines cleared.
     */
    private int getLinesCleared() {
        return myTetrisScorer.getLinesCleared();
    }
    
    /**
     * Gets the current game level.
     * @return The current game level.
     */
    private int getLevel() {
        return myTetrisScorer.getLevel();
    }

}
