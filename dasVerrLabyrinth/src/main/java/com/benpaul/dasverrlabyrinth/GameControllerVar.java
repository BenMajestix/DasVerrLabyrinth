/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benpaul.dasverrlabyrinth;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author benbartel
 */
public class GameControllerVar {
    boolean objecFound;
    //Straight
    Image imageS;
    //Turn
    Image imageT;
    //Alle Images mit Objekten
    Image imageBat;
    Image imageDragon;
    Image imageGhost;
    Image imageGnome;
    Image imageMoth;
    Image imageMouse;
    Image imageOwl;
    Image imagePoltergeist;
    Image imageSalamander;
    Image imageScarab;
    Image imageSpider;
    Image imageWitch;
    
    @FXML
    public ImageView i10;
    @FXML
    public ImageView i30;
    @FXML
    public ImageView i50;
    @FXML
    public ImageView i01;
    @FXML
    public ImageView i11;
    @FXML
    public ImageView i21;
    @FXML
    public ImageView i31;
    @FXML
    public ImageView i41;
    @FXML
    public ImageView i51;
    @FXML
    public ImageView i61;
    @FXML
    public ImageView i12;
    @FXML
    public ImageView i32;
    @FXML
    public ImageView i52;
    @FXML
    public ImageView i03;
    @FXML
    public ImageView i13;
    @FXML
    public ImageView i23;
    @FXML
    public ImageView i33;
    @FXML
    public ImageView i43;
    @FXML
    public ImageView i53;
    @FXML
    public ImageView i63;
    @FXML
    public ImageView i14;
    @FXML
    public ImageView i34;
    @FXML
    public ImageView i54;
    @FXML
    public ImageView i05;
    @FXML
    public ImageView i15;
    @FXML
    public ImageView i25;
    @FXML
    public ImageView i35;
    @FXML
    public ImageView i45;
    @FXML
    public ImageView i55;
    @FXML
    public ImageView i65;
    @FXML
    public ImageView i16;
    @FXML
    public ImageView i36;
    @FXML
    public ImageView i56;
    @FXML
    public ImageView currTile;
    @FXML
    public ImageView imgBackgr;

    @FXML
    public ImageView player_red;
    @FXML
    public ImageView player_yellow;
    @FXML
    public ImageView player_blue;
    @FXML
    public ImageView player_green;
    //For testing, for removal later
    public TextField txtAlgoStart;
    public TextField txtAlgoEnd;
    
    //The first Phase of a move, where the Player is putting a tile onto the Board
    boolean tilePhaseOver = false;
    //The second Phase of a move, where the Player is moving his piece
    boolean movingPhaseOver = false;
    
    public int playerTurn;
    
    public final int[] tileXCoor = new int[7];
    public final int[] tileYCoor = new int[7];
    
    boolean gameOver;
    @FXML
    public Label lblInstr;
    @FXML
    public ImageView imgObj1;
    @FXML
    public ImageView imgObj2;
    @FXML
    public ImageView imgObj3;
    
    
    @FXML
    private ImageView dp01;
    @FXML
    private ImageView dp02;
    @FXML
    private ImageView dp03;
    @FXML
    private ImageView dp04;
    @FXML
    private ImageView dp05;
    @FXML
    private ImageView dp06;
    @FXML
    private ImageView dp07;
    @FXML
    private ImageView dp08;
    @FXML
    private ImageView dp09;
    @FXML
    private ImageView dp10;
    @FXML
    private ImageView dp11;
    @FXML
    private ImageView dp12;
    
}
