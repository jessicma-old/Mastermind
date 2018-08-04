package edu.neu.ccs.cs5004.mvc.model;


import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList that represents a sequence of code pegs for a Mastermind game. CodePegs should always have
 * size = seqLength, and each element is an integer between 1 and nColors.
 */
public abstract class CodePegs extends EmptyPegs {

    protected final Integer N_COLORS = 6;
    protected List<Integer> pegs;


    public CodePegs(){
        this.pegs = new ArrayList<>(SEQUENCE_LENGTH);
    }

    public Integer getN_COLORS() {
        return N_COLORS;
    }

    public List<Integer> getPegs() {
        return pegs;
    }

    public void setPegs(List<Integer> pegs) {
        this.pegs = pegs;
    }

    public Integer getValueAt(Integer index){
        return getPegs().get(index);
    }

    /**
     * Verifies that a sequence is the right length and that its values are within the right range.
     *
     * @return true if sequence is valid, otherwise false
     */
    public boolean isValid() {
        return this.pegs.size() == SEQUENCE_LENGTH
                && this.pegs.stream()
                .map(peg -> (peg > 0 && peg <= N_COLORS))
                .reduce(true, (a, b) -> a && b);
    }

    public Boolean isEmpty(){
        return false;
    }


}

