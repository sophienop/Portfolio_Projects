
package view;


import controller.AboutAction;
import controller.PauseGameAction;
import controller.PopupMessages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * A menu bar for a Tetris frame.
 * @author Sophie Nop.
 * @version 6 December 2015
 */
public class TetrisMenuBar implements Observer {

    /**
     * The max int represented on the slider.
     */
    private static final int MAXIMUM_ON_SLIDER = 10;

    /**
     * The minimum int represented on the slider.
     */
    private static final int MINIMUM_ON_SLIDER = 1;
    /**
     * The menu bar.
     */
    private final JMenuBar myMenuBar;


    // /**
    // * The key controllers for the game.
    // */
    // private final TetrisControlAdapter myAdapterControllers;

    /**
     * Popup messages.
     */
    private final PopupMessages myTetrisMessage;

    /**
     * The tetris GUI.
     */
    private final TetrisGUI myTetrisGUI;

    /**
     * The Tetris Game that holds the score, next piece, info, and game panel.
     */
    private final TetrisGame myTetrisGame;
    
    /**
     * An action to use to pause the game.
     */
    private final PauseGameAction myPauseGameAction;
    
    /**
     * The difficulty slider. Kept as a field so we can change it when the
     * difficulty level of the game changes.
     */
    private JSlider myDifficultySlider;

    /**
     * Sets up the key controllers for the Tetris game.
     */
    // private TetrisControlAdapter myAdapterControllers;

    /**
     * @param theTetrisGUI the tetris panel we are using.
     * @param theTetrisGame the tetris game to act on.
     * @param thePauseGameAction the pause-game action to use
     */
    public TetrisMenuBar(final TetrisGUI theTetrisGUI, final TetrisGame theTetrisGame,
                         final PauseGameAction thePauseGameAction) {
        myTetrisGame = theTetrisGame;
        myTetrisGUI = theTetrisGUI;
        myMenuBar = new JMenuBar();
        // myAdapterControllers = theControls;
        myTetrisMessage = new PopupMessages();
        myPauseGameAction = thePauseGameAction;
        myPauseGameAction.addGame(myTetrisGame);
    }

    /**
     * @return the menu bar.
     */
    public JMenuBar buildMenuBar() {
        myMenuBar.add(buildFileMenu());
        myMenuBar.add(buildOptionMenu());
        myMenuBar.add(buildHelpMenu());
        return myMenuBar;

    }

    /**
     * @return the file menu.
     */
    private JMenu buildFileMenu() {
        final JMenu fileMenu = new JMenu("Game");
        fileMenu.setMnemonic(KeyEvent.VK_G);

        final JMenuItem newGame = new JMenuItem("Start New Game");
        newGame.setMnemonic(KeyEvent.VK_N);
        newGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                if (myTetrisGame.isGameOver()) {
                    myTetrisGame.newGame();
                }
            }
        });

//      UNIMPLEMENTED:
//        final JMenuItem twoPlayerGame = new JMenuItem("Two Player Game");
//        twoPlayerGame.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(final ActionEvent theEvent) {
//                // end current game
//                myTetrisGame.endCurrentGame();
//                // prompts the user to confirm a two player game
//                myTetrisMessage.twoPlayerGameMessage();
//                // call method that has two panels
//            }
//        });

        final JMenuItem endGame = new JMenuItem("End Game");
        endGame.setMnemonic(KeyEvent.VK_E);

        endGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                // when the user ends the game the user can hit new game and it
                // should work
                myTetrisGame.endCurrentGame();
                myTetrisMessage.gameOverMessage();

            }

        });
        final JMenuItem save = new JMenuItem("Save");
        save.setMnemonic(KeyEvent.VK_S);

        final JMenuItem pause = new JMenuItem("Pause");
        pause.setMnemonic(KeyEvent.VK_P);
        pause.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myPauseGameAction.togglePauseGame();
            }

        });
        final JMenuItem exit = new JMenuItem("Exit");
        exit.setMnemonic(KeyEvent.VK_X);
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myTetrisGUI.properlyCloseWindow();
                myTetrisGUI.getJFrame().dispose();
            }

        });

        fileMenu.add(newGame);
//      UNIMPLEMENTED:
//      fileMenu.add(twoPlayerGame);
        fileMenu.add(pause);
        fileMenu.add(endGame);
        fileMenu.add(exit);

        return fileMenu;
    }

    /**
     * @return the option menu.
     */
    private JMenu buildOptionMenu() {
        final JMenu optionMenu = new JMenu("Option");
        // can't add a MenuItem to another MenuItem must be to a Menu
        final JMenu level = new JMenu("Levels");
        level.setMnemonic(KeyEvent.VK_L);

        final JMenuItem color = new JMenuItem("Color Change");
        color.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myTetrisGame.randomizeColors();
            }
            
        });
        myDifficultySlider = new JSlider(JSlider.VERTICAL);
        myDifficultySlider.setMaximum(MAXIMUM_ON_SLIDER);
        myDifficultySlider.setMinimum(MINIMUM_ON_SLIDER);
        myDifficultySlider.setMajorTickSpacing(1);
        myDifficultySlider.setPaintTicks(true);
        myDifficultySlider.setPaintLabels(true);
        myDifficultySlider.setValue(1);
        // import swing event needed - defines and object when listens for
        // change events
        myDifficultySlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(final ChangeEvent theEvent) {
                myTetrisGame.setLevel(myDifficultySlider.getValue());
            }

        });

        level.add(myDifficultySlider);

        optionMenu.add(level);
        optionMenu.add(color);

        return optionMenu;
    }

    /**
     * @return helpMenu returns the help menu.
     */
    private JMenu buildHelpMenu() {
        final JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);

        helpMenu.add(new AboutAction(myTetrisGUI.getJFrame()));
        return helpMenu;
    }

    @Override
    public void update(final Observable theObservable, final Object theData) {
        if (myDifficultySlider.getValue() != myTetrisGame.getLevel()) {
            myDifficultySlider.setValue(myTetrisGame.getLevel());
        }
    }

}
