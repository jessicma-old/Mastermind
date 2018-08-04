package edu.neu.ccs.cs5004.mvc.view;

import javax.swing.*;

/**
 * Represents the label that displays messages to the viewer.
 */
public class GameMessage extends JLabel {

    public GameMessage(String text) {
        super(text);
    }

    /**
     * Updates GUI when player wins.
     */
    public void drawWin() {
        setText("You win!");
    }

    /**
     * Updates GUI when a player's guess is invalid.
     */
    public void drawInvalidGuess() {
        setText("Invalid guess value, try again.");
    }

    /**
     * Updates GUI when a player loses.
     */
    public void drawLoss() {
        setText("Sorry, you lose.");
    }
}
