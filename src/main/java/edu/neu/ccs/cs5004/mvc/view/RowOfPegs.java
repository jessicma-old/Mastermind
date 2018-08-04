package edu.neu.ccs.cs5004.mvc.view;

import java.awt.*;

import edu.neu.ccs.cs5004.mvc.model.PegSequence;

/**
 * Created by jessicamalloy on 5/3/17.
 */
public class RowOfPegs {

    protected Integer xPos;
    protected Integer yPos;
    protected final Integer xDist = 5;
    protected final Integer PEG_DIAMETER;
    protected PegColorMap pegColorMapping;

    public RowOfPegs(Integer xPos, Integer yPos, Integer pegDiameter, Boolean isCodePegs) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.PEG_DIAMETER = pegDiameter;
        this.pegColorMapping = new PegColorMap(isCodePegs);
    }

    public Integer getxPos() {
        return xPos;
    }

    public void setxPos(Integer xPos) {
        this.xPos = xPos;
    }

    public Integer getyPos() {
        return yPos;
    }

    public void setyPos(Integer yPos) {
        this.yPos = yPos;
    }

    public Integer getxDist() {
        return xDist;
    }

    /**
     * Given a peg sequence, draw a row of pegs.
     * TODO rewrite without two for loops
     *
     * @param g graphics handle
     * @param pegs sequence of pegs to be drawn
     */
    public void drawRow(Graphics g, PegSequence pegs) {

        if(pegs.isEmpty()){
            for(int i = 0; i < pegs.getSequenceLength(); i++){
                drawSinglePeg(g, PEG_DIAMETER, null, getPegPosition(i));
            }
        } else {
            for (int i = 0; i < pegs.getSequenceLength(); i++) {
                drawSinglePeg(g,
                        PEG_DIAMETER,
                        pegColorMapping.getColor(pegs.getValueAt(i)),
                        getPegPosition(i));
            }
        }
    }


    /**
     * Draw a single peg in the row. Basically a helper for calling the method to draw a single peg.
     * @param g graphics handle
     * @param diameter peg diameter
     * @param pegColor peg color
     * @param xPos x-coordinate of peg position
     */
    protected void drawSinglePeg(Graphics g, Integer diameter, Color pegColor, Integer xPos) {
        Peg peg = new Peg(pegColor, diameter);
        peg.drawPeg(g, xPos, this.getyPos());
    }

    /**
     * Helper to drawRow. Computes a peg's x-coordinate based on its index in the sequence.
     * Basically so we only have to store the first peg's coordinates - all pegs are in a row, so
     * their coordinates follow a predictable pattern.
     *
     * @param pegIndex
     * @return x-coordinate
     */
    private Integer getPegPosition(Integer pegIndex){
        return xPos + pegIndex*(xDist + PEG_DIAMETER);
    }


}
