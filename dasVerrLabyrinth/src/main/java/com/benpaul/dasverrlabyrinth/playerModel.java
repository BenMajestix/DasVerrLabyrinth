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
public class playerModel {
    itemModel[] items = new itemModel[3];
    String name;
    int[] pos = new int[2];

    public playerModel(String name) {
        this.name = name;
    }

    public itemModel[] getItems() {
        return items;
    }

    public void setItems(itemModel[] items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getPos() {
        return pos;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }
    
    
}
