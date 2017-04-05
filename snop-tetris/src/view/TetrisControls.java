package view;

/**
 * Tetris game controls.
 * This is an enum so we can customize them and keep the 
 * customizations in a Map.
 * @author Sophie Nop
 * @version 3 December 2015
 */
public enum TetrisControls {
    /**
     * Single step down. 
     */
    DOWN, 
    /**
     * Move piece left.
     */
    LEFT,
    /**
     * Move piece right.
     */
    RIGHT,
    /**
     * Rotate piece.
     */
    ROTATE,
    /**
     * Drop the piece to the bottom instantly.
     */
    HARD_DROP
}
