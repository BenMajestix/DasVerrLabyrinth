/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benpaul.dasverrlabyrinth;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author benbartel
 */
public class GameControllerVar {
    
    //ENTHÄLT ALLE VARIABLEN DES GAMECONTROLLERS.
    //GEMACHT, DAMIT DER GAMECONTROLLER ÜBERSICHTLICHER IST.
    
    //Für Algorithmus, welcher überprüft, ob der Spieler von einem Punkt zu einem anderen laufen kann. 
    //Falls das Ziel gefunden wurde, wird dieser boolean true -- objectiveFound
    boolean objecFound;
    
    //Bild einer Geraden
    Image imageS;
    //Bild einer Kurve
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
    
    //Alle ImageViews der Tiles
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
    
    
    
    //The first Phase of a move, where the Player is putting a tile onto the Board
    boolean tilePhaseOver = false;
    //The second Phase of a move, where the Player is moving his piece
    boolean movingPhaseOver = false;
    //The first Phase of a bot move, where he evaluates, where to go and what to move.
    boolean botTilePhaseOver = false;
    //The first Phase of a move, where the Bot is putting a tile onto the Board
    boolean botMovingPhaseOver = false;
    //The second Phase of a move, where the Bot is moving his piece
    boolean botEvalPhaseOver = false;
    //Zeigt welcher Spieler am Zug ist.
    public int playerTurn;
    //Alle Koordinaten aller ImageViews der Tiles
    public final int[] tileXCoor = new int[7];
    public final int[] tileYCoor = new int[7];
    //Ob das Spiel vorbei ist.
    boolean gameOver;
    
    @FXML
    public Label lblInstr;
    @FXML
    public ImageView imgObjRed1;
    @FXML
    public ImageView imgObjRed2;
    @FXML
    public ImageView imgObjRed3;
    @FXML
    public ImageView imgObjBlue1;
    @FXML
    public ImageView imgObjBlue2;
    @FXML
    public ImageView imgObjBlue3;
    @FXML
    public ImageView imgObjYellow1;
    @FXML
    public ImageView imgObjYellow2;
    @FXML
    public ImageView imgObjYellow3;
    @FXML
    public ImageView imgObjGreen1;
    @FXML
    public ImageView imgObjGreen2;
    @FXML
    public ImageView imgObjGreen3;
    @FXML
    public Label labelCardsLeft;
    @FXML
    public ImageView cardStack;
    @FXML
    public ImageView backgroundRed;
    @FXML
    public ImageView backgroundBlue;
    @FXML
    public ImageView backgroundYellow;
    @FXML
    public ImageView backgroundGreen;
    @FXML
    public Button btnDrehen;
    
    
    
    //VAR für "Pathfinder" ;D
    //Tiles which are connected to the startTile, but not yet looked at.
    ArrayList<GameController.algoTile> currObsTile = new ArrayList();
    //All tiles already looked at.
    ArrayList<tileModel> alrObsTiles = new ArrayList();
    
    //BOT VARIABLES
    //The best Location the Bot can move to.
    Integer[] botBestPos = new Integer[2];
    //Shortest Distance to an Objective
    Integer botBestPosDist = null;
    //The Current Objective of the Bot Algo
    Integer[] botCurrObjective = new Integer[2];
    //The Best Side the Bot can put a Tile
    Integer botBestTileSide;
    //The Best Rotation from the Off Board Tile
    Integer botBestTileRot;
    //The Side which is currently looked at by the Bot Algo
    Integer currTileSide;
}
