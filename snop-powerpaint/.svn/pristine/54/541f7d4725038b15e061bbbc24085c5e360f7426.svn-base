/*
 * TCSS 305 – Autumn 2015 
 * Assignment 5b – powerpaint
 */

package gui.actions;

import gui.PowerPaintDrawingPanel;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import tools.PowerPaintTool;

/**
 * An action to select a tool for PowerPaint.
 * @author Sophie Nop
 * @version 11 November 2015
 */
public class ToolSelectAction extends AbstractAction {

    /**
     * Generated.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * The tool to select.
     */
    private final PowerPaintTool myTool;
    
    /**
     * The panel whose tool we will change.
     */
    private final PowerPaintDrawingPanel myPanel;
    
    /**
     * Build a new ToolSelectAction.
     * @param theTool The tool this action will select.
     * @param thePanel The PowerPaint drawing panel this tool will go onto.
     */
    public ToolSelectAction(final PowerPaintTool theTool,
                            final PowerPaintDrawingPanel thePanel) {
        super(theTool.getName(), theTool.getIcon());
        myTool = theTool;
        myPanel = thePanel;
        this.putValue(MNEMONIC_KEY, theTool.getKeyboardShortcut());
    }
    
    /**
     * Selects the tools. 
     * @param theEvent that selects the tools. 
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        setThisTool();
    }
    
    /**
     * Public method to fire this action manually, so we can set default button.
     */
    public void setThisTool() {
        myPanel.setMyTool(myTool);
        this.putValue(SELECTED_KEY, true);
    }

}
