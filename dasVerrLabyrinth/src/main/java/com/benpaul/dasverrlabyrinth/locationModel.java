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
public class locationModel {
    int rotation;
    int xCoor;
    int yCoor;
    boolean ifAtEdge;

    public locationModel(int rotation, int xCoor, int yCoor, boolean ifAtEdge) {
        this.rotation = rotation;
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.ifAtEdge = ifAtEdge;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public int getxCoor() {
        return xCoor;
    }

    public void setxCoor(int xCoor) {
        this.xCoor = xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public void setyCoor(int yCoor) {
        this.yCoor = yCoor;
    }

    public boolean isIfAtEdge() {
        return ifAtEdge;
    }

    public void setIfAtEdge(boolean ifAtEdge) {
        this.ifAtEdge = ifAtEdge;
    }
    
    
}
