package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import model.Board;
import view.TetrisControls;
import view.TetrisGame;

/**
 * Key adapter for tetris controls. Handles down, left, right, rotate, and
 * hard drop. These controls are customizable. Also handles pause and new
 * game. These controls are not customizable.
 * 
 * @author Sophie Nop
 * @version 29 November 2015
 */
public class TetrisControlAdapter extends KeyAdapter {
    
    /**
     * A map to hold the customizable controls. It maps integers to
     * TetrisControls because Java treats KeyEvents as integers internally.
     */
    private final Map<Integer, TetrisControls> myControlMap;
 
    
    /**
     * The Tetris Game. 
     */
    private final TetrisGame myTetrisGame;
    
    /**
     * The board of the Tetris game we'll use. Kept around for convenience.
     */
    private final Board myBoard;
    
    /**
     * Action to use to pause/unpause the game.
     */
    private final PauseGameAction myPauseGameAction;


    /**
     * Creates a new control adapter for this tetris game.
     * @param theTetrisGame the game of tetris to control.
     * @param thePauseGameAction the pause-game action to use for this  
     */
    public TetrisControlAdapter(final TetrisGame theTetrisGame,
                                final PauseGameAction thePauseGameAction) {
        super();
        myTetrisGame = theTetrisGame;
        myBoard = theTetrisGame.getBoard();
        myPauseGameAction = thePauseGameAction;
        myControlMap = new HashMap<Integer, TetrisControls>();
        // Set up default controls
        controlMap();

    }
    
    /**
     * Creates a map of key events and controls. 
     */
    private void controlMap() {
        myControlMap.put(KeyEvent.VK_DOWN, TetrisControls.DOWN);
        myControlMap.put(KeyEvent.VK_UP, TetrisControls.ROTATE);
        myControlMap.put(KeyEvent.VK_LEFT, TetrisControls.LEFT);
        myControlMap.put(KeyEvent.VK_RIGHT, TetrisControls.RIGHT);
        myControlMap.put(KeyEvent.VK_SPACE, TetrisControls.HARD_DROP);
    }
    
    /**
     * Gets the control map.
     * 
     * @return A map of KeyEvent integers to TetrisControls
     */
    public Map<Integer, TetrisControls> getControlMap() {
        return myControlMap;
    }

    /**
     * Handle the game control input (down, rotate, left/right, hard drop).
     * 
     * @param theEvent The game control key event.
     */
    private void handleGameControls(final KeyEvent theEvent) {
        final TetrisControls gameInput = myControlMap.get(theEvent.getKeyCode());
        if (gameInput != null) {
            switch (gameInput) {
                case LEFT:
                    myBoard.moveLeft();
                    break;
                case RIGHT:
                    myBoard.moveRight();
                    break;
                case DOWN:
                    myBoard.moveDown();
                    break;
                case ROTATE:
                    myBoard.rotate();
                    break;
                case HARD_DROP:
                    myBoard.hardDrop();
                    break;
                default:
                    // Shouldn't ever get here. Do nothing.
                    break;
            }
        }
    }

    /* (non-Javadoc)
     * @see java.awt.event.KeyAdapter#keyPressed(java.awt.event.KeyEvent)
     */
    @Override
    public void keyPressed(final KeyEvent theEvent) {

        if (!myPauseGameAction.isGameIsPaused() && !myBoard.isGameOver()) {
            handleGameControls(theEvent);
        }

        if (theEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
            myTetrisGame.endCurrentGame();
        }

        if (theEvent.getKeyCode() == KeyEvent.VK_P) {
            myPauseGameAction.togglePauseGame();
        }
        if (myTetrisGame.isGameOver() && theEvent.getKeyCode() == KeyEvent.VK_N) {
            myTetrisGame.newGame();
        }
    }

}