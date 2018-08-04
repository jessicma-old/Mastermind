package edu.neu.ccs.cs5004.mvc.model;

import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Represents a target code sequence in the Mastermind game.
 */
public class TargetCode extends CodePegs {

    private final Boolean hasDupValues = true;

    /**
     * Creates a new target sequence.
     */
    public TargetCode() {
        super();
        if (this.hasDupValues) {
            this.generateTarget();
        } else {
            this.generateTargetNoDup();
        }
    }


    /**
     * Creates a pseudorandomly-generated target sequence.
     */
    public void generateTarget() {
        for (int i = 0; i < this.SEQUENCE_LENGTH; i++) {
            int next = ThreadLocalRandom.current().nextInt(1, N_COLORS + 1);
            this.pegs.add(next);
        }
    }

    /**
     * Creates a pseudorandomly-generated target sequence with no duplicate values. This was
     * specified in some versions of mastermind, added it just in case.
     */
    public void generateTargetNoDup() {
        try {
            for (int i = 1; i <= N_COLORS; i++) {
                this.pegs.add(i);
            }

            Collections.shuffle(this.pegs);
            removeColors();
            setPegs(getPegs().subList(0, SEQUENCE_LENGTH));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e);
            System.out.println("Sequence length is greater than the number of colors.");
        }
    }

    private void removeColors(){
        setPegs(pegs.stream().filter(peg -> peg <= N_COLORS).collect(Collectors.toList()));
    }



    /**
     * Given a guess sequence, find the key pegs.
     * Reflexive - target.compareTo(guess) == guess.compareTo(target)
     *
     * @param guess the guess sequence being guessed
     * @return the key pegs indicating correct color and placement in the guess
     */
    public KeyPegs compareTo(GuessCode guess) {

        // create new key peg sequence
        KeyPegs keyCounts = new KeyPegs(0,0,0);

        // represents whether or not we've counted the frequency of a value in the target sequence
        boolean[] counted = new boolean[10];

        for (int i = 0; i < this.pegs.size(); i++) {
            Integer element = this.pegs.get(i);

            // check if current element is a red peg
            if (guess.getPegs().get(i).equals(element)) {
                keyCounts.setRed(keyCounts.getRed() + 1);
            }

            if (!counted[element]) {
                // get frequency of element for both sequences
                Integer targetFreq = Collections.frequency(this.getPegs(), element);
                Integer guessFreq = Collections.frequency(guess.getPegs(), element);

                // add minimum (n pegs in common) to white peg count
                keyCounts.setWhite(keyCounts.getWhite() + Math.min(targetFreq, guessFreq));

                counted[element] = true;
            }
        }

        // subtract red pegs from white peg count to get pegs in common that do NOT also share
        // location
        keyCounts.setWhite(keyCounts.getWhite() - keyCounts.getRed());

        // subtract red and white pegs from total amount to get empty pegs
        keyCounts.setEmpty(SEQUENCE_LENGTH - keyCounts.getRed() - keyCounts.getWhite());
        return keyCounts;
    }
}
