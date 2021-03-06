/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benpaul.dasverrlabyrinth;

import javafx.scene.image.Image;

/**
 *
 * @author benbartel
 */
public class tileModel {
    locationModel location;
    //Ob und welche Treasure auf dem Tile ist
    boolean collectableOnTile;
    itemModel collectable;
    boolean playerOnTile;
    //Ob Kurve, Gerade...
    String tileKind;
    //In welche Richtung der Spieler gehen kann
    boolean[] ableToExit = new boolean[4];
    //Das Image des tiles.
    Image tileImage;

    public tileModel(locationModel location, boolean collectableOnTile, itemModel collectable, boolean playerOnTile, String tileKind, Image tileImage) {
        this.location = location;
        this.collectableOnTile = collectableOnTile;
        this.collectable = collectable;
        this.playerOnTile = playerOnTile;
        this.tileKind = tileKind;
        this.tileImage = tileImage;
    }

    public void checkExit(){
        //Setzt die Booleans für alle Seiten, ob dort ein Ausgang ist auf dem Tile.
        switch(tileKind){
            //Jenachdem welches tile es ist, wird es verschiedene Arten von Ausgängen geben.
            case "t-crossing": 
                switch(location.rotation){
                    //Jenachdem in welche Richtung das Tile gedreht ist, werden verschiedene Seiten offen sein.
                    case 0: ableToExit[0] = true; ableToExit[1] = true; ableToExit[2] = false; ableToExit[3] = true; break;
                    case 90: ableToExit[0] = true; ableToExit[1] = true; ableToExit[2] = true; ableToExit[3] = false; break;
                    case 180: ableToExit[0] = false; ableToExit[1] = true; ableToExit[2] = true; ableToExit[3] = true; break;
                    case 270: ableToExit[0] = true; ableToExit[1] = false; ableToExit[2] = true; ableToExit[3] = true; break;
                }
                break;
            case "turn": 
                switch(location.rotation){
                    case 0: ableToExit[0] = false; ableToExit[1] = true; ableToExit[2] = true; ableToExit[3] = false; break;
                    case 90: ableToExit[0] = false; ableToExit[1] = false; ableToExit[2] = true; ableToExit[3] = true; break;
                    case 180: ableToExit[0] = true; ableToExit[1] = false; ableToExit[2] = false; ableToExit[3] = true; break;
                    case 270: ableToExit[0] = true; ableToExit[1] = true; ableToExit[2] = false; ableToExit[3] = false; break;
                }
                break;
            case "straight":
                switch(location.rotation){
                    case 0: ableToExit[0] = false; ableToExit[1] = true; ableToExit[2] = false; ableToExit[3] = true; break;
                    case 90: ableToExit[0] = true; ableToExit[1] = false; ableToExit[2] = true; ableToExit[3] = false; break;
                    case 180: ableToExit[0] = false; ableToExit[1] = true; ableToExit[2] = false; ableToExit[3] = true; break;
                    case 270: ableToExit[0] = true; ableToExit[1] = false; ableToExit[2] = true; ableToExit[3] = false; break;
                }
                break;    
        }
    }
    
    
    
    public locationModel getLocation() {
        return location;
    }

    public void setLocation(locationModel location) {
        this.location = location;
        checkExit();
    }

    public itemModel getCollectable() {
        return collectable;
    }

    public void setCollectable(itemModel collectable) {
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
