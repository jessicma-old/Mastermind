package edu.neu.ccs.cs5004.mvc.view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

import edu.neu.ccs.cs5004.mvc.model.MastermindState;

/**
 * Represents the Mastermind board in the view. Most of the GUI action takes place here.
 */
public class Board extends JPanel {

    private GameMessage gameMessage;
    private GridOfPegs codePegGrid;
    private RowOfPegs targetRow;
    private GridOfPegs keyGrid;
    private JTextField guessField;
    private MastermindState gameState;



    /**
     * Creates a new Board.
     * @param game
     */
    public Board(MastermindState game) {
        setLayout(null);

        // add components that don't change state
        addColorKey();
        addTargetLabel();

        guessField = createInputField();
        gameMessage = new GameMessage("");
        gameMessage.setBounds(100, 375, 300, 20);

        codePegGrid = new CodePegGrid(200, 100, 5);
        keyGrid = new KeyPegGrid(290, 105, 5);

        gameState = game;

        targetRow = new RowOfPegs(30, 225, 16, true);

        addToBoard();
    }


    /**
     * Creates a color key and adds it to the Board.
     */
    private void addColorKey() {
        // create label with text
        JLabel keyLabel = new JLabel("<html>"
                + "1: Red<br>"
                + "2: Orange<br>"
                + "3: Yellow<br>"
                + "4: Green<br>"
                + "5: Blue<br>"
                + "6: Purple</html>");

        // Format borders
        TitledBorder keyLabelBorder;
        keyLabelBorder = BorderFactory.createTitledBorder("Color Key");
        Border invisible = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        keyLabel.setBorder(new CompoundBorder(keyLabelBorder, invisible));

        keyLabel.setVerticalTextPosition(SwingConstants.CENTER);
        keyLabel.setBounds(10, 25, 100, 150);

        add(keyLabel);
    }

    /**
     * Creates a label for the target and adds it to the Board.
     */
    private void addTargetLabel() {
        JLabel targetLabel = new JLabel("");
        targetLabel.setBounds(10, 195, 130, 70);

        // Format borders
        TitledBorder targetLabelBorder;
        targetLabelBorder = BorderFactory.createTitledBorder("Target Sequence");
        Border invisible = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        targetLabel.setBorder(new CompoundBorder(targetLabelBorder, invisible));

        add(targetLabel);
    }

    /**
     * Adds Swing elements that change state.
     */
    private void addToBoard() {
        add(guessField);
        add(gameMessage);
    }

    /**
     * Returns text currently in the text field as a string. (This is a method for the controller.)
     * @return player input
     */
    public String getGuessStr() {
        return guessField.getText();
    }

    /**
     * Puts the input string in the text field. (This is a method for the controller.)
     * @param text
     */
    public void setGuessField(String text) {
        guessField.setText(text);
    }

    /**
     * Creates the text field.
     * @return new text field to be added to the Board.
     */
    private JTextField createInputField() {
        guessField = new JTextField("Enter your guess");
        guessField.setBounds(100, 400, 200, 25);
        return guessField;
    }

    /**
     * Method to add controller as a listener for the text field.
     * @param listener
     */
    public void registerListener(ActionListener listener) {
        guessField.addActionListener(listener);
    }


    /**
     * Updates GUI when player wins.
     */
    public void drawWin() {
        gameMessage.drawWin();
    }

    /**
     * Updates GUI when a player's guess is invalid.
     */
    public void drawInvalidGuess() {
        gameMessage.drawInvalidGuess();
    }

    /**
     * Updates GUI when a player loses.
     */
    public void drawLoss() {
        gameMessage.drawLoss();
    }

    /**
     * Updates the game state with a new Mastermind state to draw.
     * @param gameState
     */
    public void setGameState(MastermindState gameState) {
        this.gameState = gameState;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        codePegGrid.drawGrid(g, gameState.getGuessHistory());
        this.keyGrid.drawGrid(g, gameState.getKeyHistory());
        this.targetRow.drawRow(g, gameState.getTargetSeq());
    }



}
