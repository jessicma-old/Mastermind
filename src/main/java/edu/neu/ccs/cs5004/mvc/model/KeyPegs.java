package edu.neu.ccs.cs5004.mvc.model;

/**
 * Created by jessicamalloy on 4/1/17.
 */
public class KeyPegs extends EmptyPegs {

    private Integer red;
    private Integer white;
    private Integer empty;

    /**
     * Creates a set of key pegs with the number of red and white pegs, and the number of empty
     * slots.
     *
     * @param red number of red pegs
     * @param white number of white pegs
     * @param empty number of empty pegs
     */
    public KeyPegs(Integer red, Integer white, Integer empty) {
        this.red = red;
        this.white = white;
        this.empty = empty;
    }

    /**
     * Creates a set of key pegs with all empty slots.
     *
     */
    public KeyPegs() {
        this.red = 0;
        this.white = 0;
        this.empty = SEQUENCE_LENGTH;
    }


    public Integer getRed() {
        return red;
    }

    void setRed(Integer red) {
        this.red = red;
    }

    public Integer getWhite() {
        return white;
    }

    void setWhite(Integer white) {
        this.white = white;
    }

    public Integer getEmpty() {
        return empty;
    }

    void setEmpty(Integer empty) {
        this.empty = empty;
    }


    @Override
    public String toString() {
        return "{" +
                "red=" + red +
                ", white=" + white +
                ", empty=" + empty +
                '}';
    }

    @Override
    public Integer getSequenceLength() {
        return getRed() + getEmpty() + getWhite();
    }

    /**
     * Given an index, return the key at that index. Equivalent to get(idx) method for code pegs,
     * but since key pegs aren't ordered we have to do something a little different.
     * empty = empty value
     * white = empty value + 1
     * red = empty value + 2
     * @param index
     * @return integer mapped to the peg color at input index
     */
    @Override
    public Integer getValueAt(Integer index) {
       if(index < getRed()) {
            return EMPTY_VALUE+2;
        } else if(index < (getRed() + getWhite())){
            return EMPTY_VALUE+1;
        } else {
            return EMPTY_VALUE;
        }
    }

    @Override
    public Boolean isEmpty() {
        return getRed() == 0 && getWhite() == 0;
    }
}
