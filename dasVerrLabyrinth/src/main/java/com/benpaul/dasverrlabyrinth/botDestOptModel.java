/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benpaul.dasverrlabyrinth;

/**
 *
 * @author benbartel
 */
public class botDestOptModel {
    int[] coor;
    int tileMoved;
    int offTileRot;

    public botDestOptModel(int[] coor, int tileMoved, int offTileRot) {
        this.coor = coor;
        this.tileMoved = tileMoved;
        this.offTileRot = offTileRot;
    }

    public int getOffTileRot() {
        return offTileRot;
    }

    public void setOffTileRot(int offTileRot) {
        this.offTileRot = offTileRot;
    }

    public int[] getCoor() {
        return coor;
    }

    public void setCoor(int[] coor) {
        this.coor = coor;
    }

    public int getTileMoved() {
        return tileMoved;
    }

    public void setTileMoved(int tileMoved) {
        this.tileMoved = tileMoved;
    }
    
    
}
