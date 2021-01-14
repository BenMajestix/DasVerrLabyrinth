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
public class tileModel {
    locationModel location;
    //Ob und welche Treasure auf dem Tile ist
    boolean collectableOnTile;
    String collectable;
    boolean playerOnTile;
    //Ob Kurve, Gerade...
    String tileKind;
    //In welche Richtung der Spieler gehen kann
    boolean[] ableToExit = new boolean[4];

    public tileModel(locationModel location, boolean collectableOnTile, String collectable, boolean playerOnTile, String tileKind) {
        this.location = location;
        this.collectableOnTile = collectableOnTile;
        this.collectable = collectable;
        this.playerOnTile = playerOnTile;
        this.tileKind = tileKind;
    }

    
    
    public locationModel getLocation() {
        return location;
    }

    public void setLocation(locationModel location) {
        this.location = location;
    }

    public String getCollectable() {
        return collectable;
    }

    public void setCollectable(String collectable) {
        this.collectable = collectable;
    }

    public boolean isPlayerOnTile() {
        return playerOnTile;
    }

    public void setPlayerOnTile(boolean playerOnTile) {
        this.playerOnTile = playerOnTile;
    }

    public String getTileKind() {
        return tileKind;
    }

    public void setTileKind(String tileKind) {
        this.tileKind = tileKind;
    }

    public boolean[] getAbleToExit() {
        return ableToExit;
    }

    public void setAbleToExit(boolean[] ableToExit) {
        this.ableToExit = ableToExit;
    }

    public boolean isCollectableOnTile() {
        return collectableOnTile;
    }

    public void setCollectableOnTile(boolean collectableOnTile) {
        this.collectableOnTile = collectableOnTile;
    }
    
    
}
