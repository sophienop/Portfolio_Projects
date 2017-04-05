
package controller;

import java.util.ArrayList;
import java.util.List;

import view.TetrisGame;

/**
 * An action that will pause or unpause any number of tetris games at once.
 * Note that it keeps its own value of whether all games are paused or unpaused.
 * Pausing/unpausing games individually can confuse it!
 * @author Sophie
 * @version 11 December 2015
 *
 */
public class PauseGameAction {

    /**
     * The Tetris game.
     */
    private final List<TetrisGame> myTetrisGames;

    /**
     * When the game is paused. 
     */
    private boolean myGameIsPaused;

    /**
     * Contructor that instatiates the pause action.
     */
    public PauseGameAction() {
        myTetrisGames = new ArrayList<TetrisGame>();
    }
    
    /**
     * Clears out the list of tetris games in this pause action.
     */
    public void clearGames() {
        myTetrisGames.clear();
    }
    
    /**
     * Adds a tetris game to this pause action.
     * @param theTetrisGame The tetris game that will be paused.
     */
    public void addGame(final TetrisGame theTetrisGame) {
        myTetrisGames.add(theTetrisGame);
    }

    /**
     * Method that pauses and un pauses the game. 
     */
    public void togglePauseGame() {
        // toggle buttons
        if (myGameIsPaused) {
            myGameIsPaused = false;
            for (final TetrisGame t : myTetrisGames) {
                t.unpause();
            }

        } else {
            myGameIsPaused = true;
            for (final TetrisGame t : myTetrisGames) {
                t.pause();
            }
        }
        
    }
    
    /**
     * @return when the game is paused. 
     */
    public boolean isGameIsPaused() {
        return myGameIsPaused;
    }
}
