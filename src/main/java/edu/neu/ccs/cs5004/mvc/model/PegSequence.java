package edu.neu.ccs.cs5004.mvc.model;


/**
 * Created by jessicamalloy on 5/3/17.
 */
public interface PegSequence {

    Integer getSequenceLength();

    Integer getValueAt(Integer index);

    Boolean isEmpty();

}
