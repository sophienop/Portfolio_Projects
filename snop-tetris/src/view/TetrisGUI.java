/*
 * TCSS 305 – Autumn 2015 Assignment 6a – Tetris.
 */

// This gives a warning that a high number of imports indicates bad coupling.
// We need to have those imports for GUI work.

package view;
import controller.PauseGameAction;
import controller.TetrisControlAdapter;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.WindowConstants;

/**
 * @author Sophie Nop
 * @version 29 November 2015
 */
public class TetrisGUI {

    /**
     * The default size of the Tetris game panel. 
     */
    private static final Dimension DIMENSION_OF_WINDOW = 
                    new Dimension(400, 600);

    /**
     * The Tetris Game. 
     */
    private final TetrisGame myTetrisGame;

    /**
     * The Window. 
     */
    private final JFrame myJFrame;

    /**
     * The Menu bar that is added to the Window. 
     */
    //    private final TetrisMenuBar myTetrisMenuBar;




    /**
     * The Tetris' menu bar. 
     */
    private final TetrisMenuBar myTetrisMenuBar;



    /**
     * Constructor that instantiates member fields.
     */
    public TetrisGUI() {
        myJFrame = new JFrame("Tetris");
        myTetrisGame = new TetrisGame();
        // The pause game action is declared here in TetrisGUI so that it can be used
        // in multiple places (key controls, menu bar)
        final PauseGameAction pauseGameAction = new PauseGameAction();
        pauseGameAction.addGame(myTetrisGame);

        final TetrisControlAdapter controls = 
                        new TetrisControlAdapter(myTetrisGame, pauseGameAction);
        myTetrisGame.setControlMapDescription(controls.getControlMap());

        myJFrame.addKeyListener(controls);
        // share the same controls for the two panels
        myTetrisMenuBar = new TetrisMenuBar(this, myTetrisGame, pauseGameAction);
        

    }

    /**
     * Builds the frame and GUI components, and starts up the game.
     */
    public void start() {
        myJFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            
            /**
             * When we shut down the window, we need to stop the timer, so the
             * program can close completely.
             * 
             * @param theEvent the window closing event
             */
            @Override
            public void windowClosed(final WindowEvent theEvent) {
                // Ending the current game will stop the timer.
                myTetrisGame.endCurrentGame();
            }
        });
        
        myJFrame.addComponentListener(new ResizeListener());
        myJFrame.setJMenuBar(setMenuBar());
        myTetrisGame.addObserver(myTetrisMenuBar);

        myJFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("./images/tetris.jpg"));
        myJFrame.setSize(new Dimension(DIMENSION_OF_WINDOW));
        // This must not be EXIT_ON_CLOSE or our timers keep running!
        myJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //represents one game panel
        myJFrame.add(myTetrisGame.setUpGamePanel());

        myJFrame.pack();
        //to center the frame we have to call setLocationRelativeTo(null) only after we pack!
        myJFrame.setLocationRelativeTo(null);
        //set visible last
        myJFrame.setVisible(true);


    }

    /**
     * Returns the menu bar for the window. 
     * @return the menu bar for the window. 
     */
    private JMenuBar setMenuBar() {
        return myTetrisMenuBar.buildMenuBar();
    }

    /**
     * Returns the JFrame.
     * @return the JFrame.
     */
    public JFrame getJFrame() {
        return myJFrame;
    }

    /**
     * Closes the window and stops the timer. 
     */
    public void properlyCloseWindow() {
        myTetrisGame.endCurrentGame();
        myJFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * Handles resizes of the Tetris class so the game board is kept the
         correct
     * size.
     *
     * @author Sophie Nop
     * @version 12 December 2015
     */
    private class ResizeListener extends ComponentAdapter {

        /**
         * When the frame is resized, force the height to be proportional to the
         * width.
         *
         * @param theEvent The component event that notified us of the resize.
         * @see java.awt.event.ComponentAdapter#componentResized
         (java.awt.event.ComponentEvent)
         */
        public void componentResized(final ComponentEvent theEvent) {
            myJFrame.setResizable(false);
            // myJFrame.pack();
        }
    }

}
