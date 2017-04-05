package controller;

import java.util.Observable;
import java.util.Observer;

import model.Board;

/**
 * Holds information about a tetris game's score including current level
 * and lines cleared.
 * Observes the board, and is observable so that score panels can update the score
 * and the game timer can get faster with new levels.
 * @author Sophie
 * @version 11 December 2015
 */
public class TetrisScorer extends Observable implements Observer {

    /**
     * Number of lines required to advance to the next level.
     */
    public static final int LINES_PER_LEVEL = 10;
    
    /**
     * The multiplier for the score so we're not always working with single points.
     */
    private static final int SCORE_MULTIPLIER = 10;
    
    /**
     * The score.
     */
    private int myScore;
    
    /**
     * The number of lines currently on the observed board. If this decreases, the user
     * has cleared some lines.
     */
    private int myNumberOfLines;
    
    /**
     * The number of lines cleared so far by the user.
     */
    private int myLinesCleared;
    
    /**
     * The current game level.
     */
    private int myCurrentLevel;
    
    /**
     * The number of lines that must be cleared before reaching the next level.
     */
    private int myLinesToNextLevel;
    
    /**
     * Construct a new tetris scorer with 0 in everything, to be used to
     * start a new game. Accepts a game that it will observe.
     * @param theGameToObserve the game this scorer will monitor to update scores.
     */
    public TetrisScorer(final Board theGameToObserve) {
        super();
        theGameToObserve.addObserver(this);
        privateReset();
    }
    
    /**
     * The reset method is called by the constructor, and public methods can
     * be easily overridden. So the real logic lives here, and is just called
     * by the public reset method. 
     */
    private void privateReset() {
        myScore = 0;
        myLinesCleared = 0;
        myCurrentLevel = 1;
        myNumberOfLines = 0;
        myLinesToNextLevel = LINES_PER_LEVEL;
    }
    
    /**
     * Reset all values to zero (for example, for a new game).
     */
    public void reset() {
        privateReset();
    }
    
    /**
     * Clear some lines and update the score.
     * Scoring algorithm is linesCleared^2 * 10 to make it better to clear
     * more lines at once.
     * Also increments the current level if necessary.
     * Lines do "carry over" - so if you have 2 lines to next level and clear 4,
     * then you'll get a "bonus" two lines towards the next level.
     * @param theLinesCleared The number of lines cleared.
     */
    public void clearLines(final int theLinesCleared) {
        myScore += theLinesCleared * theLinesCleared * SCORE_MULTIPLIER;
        myLinesCleared += theLinesCleared;
        myLinesToNextLevel -= theLinesCleared;
        if (myLinesToNextLevel <= 0) {
            myCurrentLevel++;
            myLinesToNextLevel += LINES_PER_LEVEL;
        }
        notifyObservers();
    }
    
    /**
     * Gets the current score.
     * @return the current game score as an int. 
     */
    public int getScore() {
        return myScore;
    }
    
    /**
     * Gets the current game level.
     * @return The current game level as an int.
     */
    public int getLevel() {
        return myCurrentLevel;
    }
    
    /**
     * Sets the game level.
     * @param theNewLevel The new level to use. 1-10 are typical values.
     */
    public void setLevel(final int theNewLevel) {
        myCurrentLevel = theNewLevel;
    }
    
    /**
     * Gets the number of lines cleared.
     * @return The number of lines cleared.
     */
    public int getLinesCleared() {
        return myLinesCleared;
    }
    
    /**
     * Receives updates from boards we observe.
     * It is possible to register other observables to watch, but they will be ignored
     * by this method.
     * @param theObjectObserved The object we have observed.
     * @param theData Not used.
     */
    @Override
    public void update(final Observable theObjectObserved, final Object theData) {
        if (theObjectObserved instanceof Board) {
            final Board observedBoard = (Board) theObjectObserved;
            final int newNumberOfLines = observedBoard.getFrozenBlocks().size();
            // We are notified immediately after the board clears lines, so if the
            // number goes down, we have just cleared some lines.
            if (newNumberOfLines < myNumberOfLines) {
                clearLines(myNumberOfLines - newNumberOfLines);
            }
            // Update the number of lines last seen.
            myNumberOfLines = newNumberOfLines;
        }
    }

}
