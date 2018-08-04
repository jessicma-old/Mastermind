package edu.neu.ccs.cs5004.mvc.model;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Represents a guessed code sequence in the Mastermind game.
 */
public class GuessCode extends CodePegs {

    /**
     * Creates a new code sequence using values input from the player.
     */
    public GuessCode(String strGuess) {
        super();

        setPegs(Arrays
                .stream(strGuess.split("")) // convert to array
                .map(s -> Integer.parseInt(s)) // map to integer value
                .collect(Collectors.toList())); // collect as a list
    }



}
