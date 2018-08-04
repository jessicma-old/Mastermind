package edu.neu.ccs.cs5004.mvc.view;

import java.awt.*;

import java.util.List;
import edu.neu.ccs.cs5004.mvc.model.PegSequence;

/**
 * Created by jessicamalloy on 5/3/17.
 */
public abstract class GridOfPegs {

    protected Integer xPos;
    protected Integer yPos;
    protected Integer yDist;

    protected final Integer codePegDiameter = 16;

    public GridOfPegs(Integer xPos, Integer yPos, Integer yDist) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.yDist = yDist;
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

    public Integer getyDist() {
        return yDist;
    }

    public void setyDist(Integer yDist) {
        this.yDist = yDist;
    }


    public void drawGrid(Graphics g, List<PegSequence> allPegs) {
        for (int i = 0; i < allPegs.size(); i++) {
            drawGridHelper(g, allPegs.get(i), yPos + i*(yDist + codePegDiameter));
        }
    }

    protected abstract void drawGridHelper(Graphics g, PegSequence rowToDraw, Integer yPos);
}
