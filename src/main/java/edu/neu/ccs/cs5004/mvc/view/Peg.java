package edu.neu.ccs.cs5004.mvc.view;

import java.awt.*;

/**
 * Defines a peg (circle) on the GUI with its color and radius.
 */
public class Peg {

    private final Integer radius;
    private Color color;


    public Peg(Color color, Integer radius){
        this.color = color;
        this.radius = radius;

    }


    public Boolean isEmpty(){
        return color == null;
    }

    public Color getColor() {
        return color;
    }


    /**
     * Draws the peg at the specified position on the GUI
     * @param g graphics object
     * @param xPos x coordinate on the gui
     * @param yPos y coordinate on the gui
     */
    public void drawPeg(Graphics g, Integer xPos, Integer yPos) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        g.setColor(Color.black);
        g.drawOval(xPos, yPos, radius+1, radius+1);

        // if peg is filled in
        if(!this.isEmpty()) {
            g.setColor(this.getColor());
            g.fillOval(xPos+1, yPos+1, radius, radius);
        }
    }




}
