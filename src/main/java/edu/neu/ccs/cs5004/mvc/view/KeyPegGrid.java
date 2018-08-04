package edu.neu.ccs.cs5004.mvc.view;

import java.awt.*;

import edu.neu.ccs.cs5004.mvc.model.PegSequence;

/**
 * Created by jessicamalloy on 5/3/17.
 */
public class KeyPegGrid extends GridOfPegs {

    private final Integer keyPegDiameter = 8;

    public KeyPegGrid(Integer xPos, Integer yPos, Integer yDist) {
        super(xPos, yPos, yDist);
    }

    @Override
    protected void drawGridHelper(Graphics g, PegSequence rowToDraw, Integer yPos) {
        RowOfPegs row = new RowOfPegs(xPos, yPos, keyPegDiameter, false);
        row.drawRow(g, rowToDraw);
    }
}
