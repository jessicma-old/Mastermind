package edu.neu.ccs.cs5004.mvc.model;

/**
 * Represents a game of Mastermind for the controller.
 */
public interface MastermindGame extends MastermindState{


    /**
     * Starts a new game of Mastermind.
     *
     * @return a new game
     */
    static MastermindGame startGame() {
        return new Game();
    }

    /**
     * Given a string (text field input) representing a guess, update the game. Specifically:
     *  - update guess history
     *  - create a set of key pegs comparing guess to target
     *  - update key history
     *  - check if game is won
     *
     * @param guess string representing the player's guess
     * @return Integer array representing key peg counts
     */
    void makeGuess(String guess);


}
