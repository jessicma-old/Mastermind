package edu.neu.ccs.cs5004.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.neu.ccs.cs5004.mvc.model.InvalidGuessException;
import edu.neu.ccs.cs5004.mvc.model.MastermindGame;
import edu.neu.ccs.cs5004.mvc.view.Board;

/**
 * Represents a controller for the mastermind game (obvious)
 */
public class MastermindController {

    private MastermindGame game;
    private Board gui;


    /**
     * Creates a controller with a new Mastermind game and a new GUI.
     */
    public MastermindController() {
        this.game = MastermindGame.startGame();
        this.gui = new Board(this.game);
        gui.registerListener(new TextFieldListener());
    }

    /**
     * Creates the listener class for the GUI's text field. Listener checks that the input is valid,
     * then updates the GUI and clears the text field.
     */
    class TextFieldListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!game.outOfGuesses() && !game.isWin()) {
                String playerInput = gui.getGuessStr();
                try {
                    game.makeGuess(playerInput);
                } catch (InvalidGuessException | NumberFormatException badGuess) {
                    gui.drawInvalidGuess();
                }
                gui.setGuessField("");
                update();
            }
        }
    }

    /**
     * Getter for GUI
     * @return the gui in this controller
     */
    public Board getGui() {
        return gui;
    }

    /**
     * Updates the GUI with the current game state.
     */
    private void update() {

        // redraw guesses and keys
        gui.setGameState(game);

        // check if game is won or lost
        if (game.isWin()) {
            gui.drawWin();
        } else if (game.outOfGuesses()) {
            gui.drawLoss();
        }

        gui.repaint();
    }


}
