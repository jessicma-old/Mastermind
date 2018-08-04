package edu.neu.ccs.cs5004.mvc.model;

/**
 * Created by jessicamalloy on 4/5/17.
 */
public class EmptyPegs implements PegSequence {

    protected final Integer SEQUENCE_LENGTH = 4;
    protected final Integer EMPTY_VALUE = 0;

    @Override
    public Integer getSequenceLength() {
        return SEQUENCE_LENGTH;
    }


    @Override
    public Integer getValueAt(Integer index) {
        if(withinRange(index)) {
            return EMPTY_VALUE;
        } else {
            throw new IndexOutOfBoundsException("Index must be between 0 and "
                    + (SEQUENCE_LENGTH-1) + ". You provided: " + index);
        }
    }

    protected Boolean withinRange(Integer index){
        return index >= 0 && index < SEQUENCE_LENGTH;
    }

    @Override
    public Boolean isEmpty() {
        return true;
    }
}
