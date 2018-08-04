package edu.neu.ccs.cs5004.mvc.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Represents a game of Mastermind with a target sequence, a list of guesses, and a list of their
 * corresponding keys.
 */
public class Game implements MastermindGame {

    private final TargetCode targetSeq;
    private List<PegSequence> guessHistory;
    private List<PegSequence> keyHistory;
    private Integer guessesMade;
    private Boolean isWon;
    protected final Integer TOTAL_GUESSES = 10;


    /**
     * Creates a game
     *  - generates a random target sequence
     *  - creates empty array of guesses and keys
     *  - sets fields that track status to initial values
     */
    public Game() {
        // generate target sequence
        targetSeq = new TargetCode();
        //System.out.println("Target = " + targetSeq);

        // create empty list of guesses and keys
        guessHistory = new ArrayList<>(TOTAL_GUESSES);
        keyHistory = new ArrayList<>(TOTAL_GUESSES);
        initGrids();

        isWon = false;
        guessesMade = 0;
    }

    /**
     * Populates new arrays for guesses and keys with their initial values
     */
    private void initGrids(){
        for(int i = 0; i < TOTAL_GUESSES; i++){
            getGuessHistory().add(i, new EmptyPegs());
            getKeyHistory().add(i, new KeyPegs());
        }
    }


    @Override
    public PegSequence getTargetSeq() {
        if(isWin() || outOfGuesses()){
            return targetSeq;
        } else {
            return new EmptyPegs();
        }
    }

    @Override
    public List<PegSequence> getGuessHistory() {
        return guessHistory;
    }

    @Override
    public List<PegSequence> getKeyHistory() {
        return keyHistory;
    }

    /**
     * Sets the status of the game.
     * @param won
     */
    public void setWon(Boolean won) {
        isWon = won;
    }


    /**
     * Given a string input, add the new guess to the history and update the other fields.
     * @param guessStr string representing the player's guess
     */
    public void makeGuess(String guessStr) {
        GuessCode guess = new GuessCode(guessStr);
        if(guess.isValid()) {
            getGuessHistory().set(guessesMade, guess);
            KeyPegs key = targetSeq.compareTo(guess);
            keyHistory.set(guessesMade, key);
            setWon(isWon || key.getRed().equals(key.getSequenceLength()));
            guessesMade += 1;
        } else {
            throw new InvalidGuessException("Guess was invalid");
        }
    }



    /**
     * @return true if game is won
     */
    public Boolean isWin() {
         return isWon;
    }


    /**
     * @return true if player has no guesses left (i.e., game is lost)
     */
    public Boolean outOfGuesses() {
        return guessesMade >= TOTAL_GUESSES;
    }



}
