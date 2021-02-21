/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benpaul.dasverrlabyrinth;

import java.util.ArrayList;

/**
 *
 * @author benbartel
 */
public class pathfinderPathModel {
    int length;
    ArrayList<int[]> tileCoords = new ArrayList();
    int[] startPoint;

    public pathfinderPathModel(int[] startPoint) {
        this.startPoint = startPoint;
        length = 1;
        tileCoords.add(startPoint);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ArrayList<int[]> getTileCoords() {
        return tileCoords;
    }

    public void setTileCoords(ArrayList<int[]> tileCoords) {
        this.tileCoords = tileCoords;
    }

    public int[] getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(int[] startPoint) {
        this.startPoint = startPoint;
    }
    
    
}
