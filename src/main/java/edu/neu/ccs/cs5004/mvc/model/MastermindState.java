package edu.neu.ccs.cs5004.mvc.model;

import java.util.List;

/**
 * Represents a "read-only" game of Mastermind for the GUI to draw.
 */
public interface MastermindState {

    /**
     * Returns the target sequence for display. If game is won, returns the target sequence.
     * Otherwise, return a blank sequence.
     * (This logic should probably be in the controller... oops)
     * @return
     */
    PegSequence getTargetSeq();

    /**
     * Returns list of guesses.
     * @return
     */
    List<PegSequence> getGuessHistory();

    /**
     * returns list of keys.
     * @return
     */
    List<PegSequence> getKeyHistory();

    /**
     * True if game is won.
     * @return true if game is won, otherwise false.
     */
    Boolean isWin();

    /**
     * True if there are no guesses left.
     * @return true if game is lost (no guesses left), otherwise false.
     */
    Boolean outOfGuesses();
}
