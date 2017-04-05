
package view;

import controller.PopupMessages;
import controller.TetrisScorer;
import controller.TimerListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.Board;



/**
 * The game panel. 
 * 
 * @author Sophie Nop
 * @version 10 December 2015. 
 */
public class TetrisGame extends Observable implements Observer {

    /**
     * The minimum default size of the game panel - int width, int height.
     */
    private static final Dimension TETRIS_PANEL_DEFAUL_MINIMUM_DIMENSION =
                    new Dimension(400, 600);

    /**
     * The size of the nex piece panel.
     */
    private static final int NEXT_PIECE_BOX_PANEL_WIDTH = 200;

    /**
     * Height of the score panel.
     */
    private static final int SCORE_PANEL_HEIGHT = 200;

    /**
     * Height of the information panel.
     */
    private static final int INFO_PANEL_HEIGHT = 200;

    /**
     * The default timer(the smaller the int the faster the timer).
     */
    private static final int DEFAULT_TIMER_SPEED = 900;

    /**
     * The board's width in blocks.
     */
    private static final int BOARD_WIDTH = 10;

    /**
     * The board's height in blocks.
     */
    private static final int BOARD_HEIGHT = 20;

    /**
     * The board game.
     */
    private final Board myBoard;

    /**
     * The panel that will hold all the game components.
     */
    private final JPanel myGameJPanel;

    /**
     * The panel that displays the next piece.
     */
    private final NextPiece myNextPiecePanel;

    /**
     * The panel that will display the score.
     */
    private final ScorePanel myScorePanel;

    /**
     * The panel that will display the information (controls etc).
     */
    private final InfoPanel myInfoPanel;

    /**
     * The timer for the game.
     */
    private final Timer myTimer;

    /**
     * The messages for displaying on the Tetris game. 
     */
    private final PopupMessages myTetrisMessage;

    /**
     * The west panel containing the game panel. 
     */
    private final JPanel myWestPanel;
    
    /**
     * The scorer for the game. 
     */
    private final TetrisScorer myTetrisScorer;
    
    /**
     * The panel that will display the game of Tetris!
     */
    private TetrisPanel myTetrisPanel;
    
    /**
     * The current game level.
     */
    private int myCurrentLevel;

    /**
     * Constructor that instantiates the member fields and creates
     * a new game of Tetris.
     */
    public TetrisGame() {
        myGameJPanel = new JPanel();
        myBoard = new Board(BOARD_WIDTH, BOARD_HEIGHT);
        myNextPiecePanel = new NextPiece(myBoard);
        myInfoPanel = new InfoPanel();
        myTimer = new Timer(DEFAULT_TIMER_SPEED, new TimerListener(myBoard));

        myTetrisScorer = new TetrisScorer(myBoard);
        
        myScorePanel = new ScorePanel(myTetrisScorer);

        // share the same controls for the two panels
        myWestPanel = new JPanel();
       
        myTetrisMessage = new PopupMessages();
        setupObservers();
    }
    
    /**
     * A constructor helper method to connect observers.
     */
    private void setupObservers() {
        myBoard.addObserver(this);
        myTetrisScorer.addObserver(this);
        myCurrentLevel = myTetrisScorer.getLevel();
    }
    
    /**
     * Sets up the control map description.
     * @param theControlMap The controls to describe for this player.
     */
    public void setControlMapDescription(final Map<Integer, TetrisControls> theControlMap) {
        myInfoPanel.setControls(theControlMap);
    }
    
    /**
     * Resets everything to a new game.
     */
    public void newGame() {
        myBoard.newGame(BOARD_WIDTH, BOARD_HEIGHT, null);
        myTetrisScorer.reset();
        myCurrentLevel = 1;
        myTimer.setDelay(DEFAULT_TIMER_SPEED);
        myTimer.start();
    }
    
    /**
     * Checks if the current game is over.
     * @return True if the game is over, false if it is currently playing.
     */
    public boolean isGameOver() {
        return myBoard.isGameOver();
    }
    
    /**
     * Forces a game over in the current game.
     */
    public void endCurrentGame() {
        myTimer.stop();
        myBoard.forceGameOver();
    }

    /**
     * Creates the JPanel with the game panel and info, score, and next piece.
     * @return the JPanel to add to the frame. 
     */
    public JPanel setUpGamePanel() {
        //represents one game panel
        myGameJPanel.add(getGamePanel());
        return myGameJPanel; 
    }

    @Override
    public void update(final Observable theObject, final Object theArgs) {
        myGameJPanel.repaint();
        myNextPiecePanel.repaint();
        myScorePanel.repaint();

        if (myBoard.isGameOver()) {
            myTimer.stop();
            myTetrisMessage.gameOverMessage();
        }
        if (myCurrentLevel != myTetrisScorer.getLevel()) {
            setLevel(myTetrisScorer.getLevel());
        }
        
    }

    /**
     * sets up the west panel.
     * 
     * @return theSingleGamePanel returns the west panel.
     */
    private JPanel getWestPanel() {

        myWestPanel.setLayout(new BorderLayout());
        myTetrisPanel = new TetrisPanel(myBoard);

        //displays the game only when it's BorderLayout.Center 
        //when the BorderLayout.WEST is set the game is not displayed
        myWestPanel.add(myTetrisPanel, BorderLayout.CENTER);

        //sets the background of the game panels to the specified color
        //        tp.setBackground(myColorRandomizer.randomizeLightColors());
        myTetrisPanel.setBackground(Color.WHITE);
        myWestPanel.setPreferredSize(TETRIS_PANEL_DEFAUL_MINIMUM_DIMENSION);
        myTimer.start();
        return myWestPanel;
    }

    /**
     * Sets up the east panel.
     */
    /**
     * @return mySingleGamePanel;
     */
    private JPanel getEastPanel() {
        // the whole east panel
        final JPanel eastPanel = new JPanel();
        //randomize the color of the east panel
        //        eastPanel.setBackground(myColorRandomizer.randomizeColors());
        eastPanel.setBackground(Color.WHITE);
        eastPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //      myGameJPanel.setLayout(new BoxLayout(myGameJPanel, BoxLayout.LINE_AXIS));

        final Box eastBox = new Box(BoxLayout.Y_AXIS);
        eastBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        // myNextPiecePanel.setBounds(x, y, width, height);

        final JLabel nextPieceStr = new JLabel("NEXT PIECE");
        myNextPiecePanel.add(nextPieceStr);

        myNextPiecePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        myNextPiecePanel.setBackground(Color.WHITE);

        myNextPiecePanel.setPreferredSize(new Dimension(NEXT_PIECE_BOX_PANEL_WIDTH,
                                                        NEXT_PIECE_BOX_PANEL_WIDTH));
        // creates padding between the panel\
        //      eastBox.add(Box.createHorizontalStrut(PADDING));

        myScorePanel.setBackground(Color.WHITE);
        myScorePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        myScorePanel.setPreferredSize(new Dimension(NEXT_PIECE_BOX_PANEL_WIDTH,
                                                    SCORE_PANEL_HEIGHT));
        //        eastBox.add(Box.createHorizontalStrut(PADDING));

        myInfoPanel.setBackground(Color.WHITE);
        // creates a border for the panel
        myInfoPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        myInfoPanel.setPreferredSize(new Dimension(NEXT_PIECE_BOX_PANEL_WIDTH,
                                                   INFO_PANEL_HEIGHT));

        eastBox.add(myNextPiecePanel);
        eastBox.add(myScorePanel);
        eastBox.add(myInfoPanel);
        eastPanel.add(eastBox);
        return eastPanel;

    }


    /**
     * Gets the game panel with the game board and instructions. 
     * @return singGamePanel to be added to the window. 
     */
    public JPanel getGamePanel() {

        final JPanel singleGamePanel = new JPanel();
        singleGamePanel.setLayout(new BorderLayout());
        //west panel is the game board
        singleGamePanel.add(getWestPanel(), BorderLayout.WEST);
        //east panel is the score board 
        singleGamePanel.add(getEastPanel(), BorderLayout.EAST);
        return singleGamePanel;
    }

    /**
     * Sets the difficulty level of the game. We start at DEFAULT_TIMER_SPEED
     * and the game gets 33% faster with each additional difficulty level
     * 
     * @param theLevel is the level selected by the user. 
     */
    public void setLevel(final int theLevel) {
        myCurrentLevel = theLevel;
        // It is necessary to set the scorer's level to the same as the current
        // level!
        myTetrisScorer.setLevel(theLevel);
        // Each level is 33% faster than the previous
        final int newTimerSpeed = DEFAULT_TIMER_SPEED 
                        / (int) (Math.pow(1.33D, myTetrisScorer.getLevel()));
        myTimer.setDelay(newTimerSpeed);
        // Let the menu bar know we have changed levels!
        notifyObservers();
    }
    
    /**
     * Gets the current game level.
     * @return The current game level.
     */
    public int getLevel() {
        return myCurrentLevel;
    }
    
    /**
     * Pauses this game.
     */
    public void pause() {
        myTimer.stop();
    }
    
    /**
     * Unpauses this game.
     */
    public void unpause() {
        // Be careful not to start an ended game back up!
        if (!myBoard.isGameOver()) {
            myTimer.start();    
        }
    }
    
    /**
     * Gets the Tetris game board.
     * @return The board used for this game of Tetris.
     */
    public Board getBoard() {
        return myBoard;
    }
    
    /**
     * Randomizes the game colors for a bit of fun.
     */
    public void randomizeColors() {
        myTetrisPanel.setUpLightColorMap();
    }

}
