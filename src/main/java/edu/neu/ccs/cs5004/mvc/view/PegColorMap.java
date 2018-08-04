package edu.neu.ccs.cs5004.mvc.view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jessicamalloy on 5/3/17.
 */
public class PegColorMap {

    private List<Color> colorMap;

    public PegColorMap(Boolean isCodePegs) {
        colorMap = new ArrayList<>();
        colorMap.add(null);
        if(isCodePegs) {
            initCodePegMap();
        } else {
            initKeyPegMap();
        }
    }

    private void initCodePegMap(){
        colorMap.add(Color.red);
        colorMap.add(Color.orange);
        colorMap.add(Color.yellow);
        colorMap.add(Color.green);
        colorMap.add(Color.blue);
        colorMap.add(Color.magenta);
        colorMap.add(Color.cyan);
        colorMap.add(Color.pink);
        colorMap.add(Color.gray);
        colorMap.add(Color.black);
    }

    private void initKeyPegMap(){
        colorMap.add(Color.white);
        colorMap.add(Color.red);
    }


    public Color getColor(Integer index){
        return colorMap.get(index);
    }



}
