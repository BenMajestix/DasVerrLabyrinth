/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benpaul.dasverrlabyrinth;

import static com.benpaul.dasverrlabyrinth.App.boardTiles;
import static com.benpaul.dasverrlabyrinth.App.offBoardTile;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;


/**
 * FXML Controller class
 *
 * @author benbartel
 */
public class GameController implements Initializable {

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
    private ImageView i10;
    @FXML
    private ImageView i30;
    @FXML
    private ImageView i50;
    @FXML
    private ImageView i01;
    @FXML
    private ImageView i11;
    @FXML
    private ImageView i21;
    @FXML
    private ImageView i31;
    @FXML
    private ImageView i41;
    @FXML
    private ImageView i51;
    @FXML
    private ImageView i61;
    @FXML
    private ImageView i12;
    @FXML
    private ImageView i32;
    @FXML
    private ImageView i52;
    @FXML
    private ImageView i03;
    @FXML
    private ImageView i13;
    @FXML
    private ImageView i23;
    @FXML
    private ImageView i33;
    @FXML
    private ImageView i43;
    @FXML
    private ImageView i53;
    @FXML
    private ImageView i63;
    @FXML
    private ImageView i14;
    @FXML
    private ImageView i34;
    @FXML
    private ImageView i54;
    @FXML
    private ImageView i05;
    @FXML
    private ImageView i15;
    @FXML
    private ImageView i25;
    @FXML
    private ImageView i35;
    @FXML
    private ImageView i45;
    @FXML
    private ImageView i55;
    @FXML
    private ImageView i65;
    @FXML
    private ImageView i16;
    @FXML
    private ImageView i36;
    @FXML
    private ImageView i56;
    @FXML
    private ImageView currTile;
    @FXML
    private ImageView imgBackgr;

    @FXML
    private ImageView player_red;
    @FXML
    private ImageView player_yellow;
    @FXML
    private ImageView player_blue;
    @FXML
    private ImageView player_green;
    //For testing, for removal later
    @FXML
    private TextField txtAlgoStart;
    @FXML
    private TextField txtAlgoEnd;
    
    //The first Phase of a move, where the Player is putting a tile onto the Board
    boolean tilePhaseOver = false;
    //The second Phase of a move, where the Player is moving his piece
    boolean movingPhaseOver = false;
    
    private int playerTurn;
    
    private String objMoved;
    
    private double mouseX;
    private double mouseY;
    
    private int[] oldRedPlayerTilePos = new int[2];
    private int[] oldBluePlayerTilePos = new int[2];
    private int[] oldYellowPlayerTilePos = new int[2];
    private int[] oldGreenPlayerTilePos = new int[2];
    private int[] mouseTilePos = new int[2];
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        playerTurn = 0;
        player_red.toFront();
        player_blue.toBack();
        player_yellow.toBack();
        player_green.toBack();
        
        player_red.setX(315);
        player_red.setY(662);
        player_yellow.setX(313);
        player_yellow.setY(141);
        player_blue.setX(828);
        player_blue.setY(143);
        player_green.setX(830);
        player_green.setY(660);
        imgBackgr.setRotate(270);
        makeBoard();
        
        playerModel playerRed = new playerModel("Red");
        playerModel playerBlue = new playerModel("Blue");
        playerModel playerYellow = new playerModel("Yellow");
        playerModel playerGreen = new playerModel("Green");
        
        playerYellow.pos[0] = 0;
        playerYellow.pos[1] = 0;
        
        playerBlue.pos[0] = 0;
        playerBlue.pos[1] = 6;
        
        playerRed.pos[0] = 6;
        playerRed.pos[1] = 0;
        
        playerGreen.pos[0] = 6;
        playerGreen.pos[1] = 6;
        
        App.players[0] = playerRed;
        App.players[1] = playerBlue;
        App.players[2] = playerYellow;
        App.players[3] = playerGreen;
        
        
    }
    
    //GAME
    //--------------
    //startPlayerRound
    public void startPlRound(playerModel player){
        
        
        while(!(tilePhaseOver)){
            
        }
        tilePhaseOver = false;
        while(!(movingPhaseOver)){
            
        }
        movingPhaseOver = false;
        
    }
    
    
    
    public void startMoveRow(int row, int direction) throws Exception{
        if(row == 1 || row == 3 || row == 5){
            moveRow(row, direction);
        }
        else{
            throw new Exception("Diese Reihe kann nicht bewegt werden.");
        }
    }
    
    public void moveRow(int row, int direction){
        //Von rechts schiebend
        if(direction == 0){
            tileModel offBoardTemp = offBoardTile;
            
            offBoardTile = boardTiles[row][0];
            boardTiles[row][0] = boardTiles[row][1];
            boardTiles[row][1] = boardTiles[row][2];
            boardTiles[row][2] = boardTiles[row][3];
            boardTiles[row][3] = boardTiles[row][4];
            boardTiles[row][4] = boardTiles[row][5];
            boardTiles[row][5] = boardTiles[row][6];
            boardTiles[row][6] = offBoardTemp;
        }
        //von links schiebend
        else if(direction == 1){
            tileModel offBoardTemp = offBoardTile;
            
            offBoardTile = boardTiles[row][6];
            boardTiles[row][6] = boardTiles[row][5];
            boardTiles[row][5] = boardTiles[row][4];
            boardTiles[row][4] = boardTiles[row][3];
            boardTiles[row][3] = boardTiles[row][2];
            boardTiles[row][2] = boardTiles[row][1];
            boardTiles[row][1] = boardTiles[row][0];
            boardTiles[row][0] = offBoardTemp;
        }
        makeBoard();
    }
    
    public void startMoveColumn(int column, int direction) throws Exception{
        if(column == 1 || column == 3 || column == 5){
            moveColumn(column, direction);
        }
        else{
            throw new Exception("Diese Zeile kann nicht bewegt werden.");
        }
    }
    
    public void moveColumn(int column, int direction){
        //Von unten schiebend
        if(direction == 0){
            tileModel offBoardTemp = offBoardTile;
            
            offBoardTile = boardTiles[0][column];
            
            boardTiles[0][column] = boardTiles[1][column];
            boardTiles[1][column] = boardTiles[2][column];
            boardTiles[2][column] = boardTiles[3][column];
            boardTiles[3][column] = boardTiles[4][column];
            boardTiles[4][column] = boardTiles[5][column];
            boardTiles[5][column] = boardTiles[6][column];
            boardTiles[6][column] = offBoardTemp;
        }
        //von oben schiebend
        else if(direction == 1){
            tileModel offBoardTemp = offBoardTile;
            
            offBoardTile = boardTiles[6][column];
            boardTiles[6][column] = boardTiles[5][column];
            boardTiles[5][column] = boardTiles[4][column];
            boardTiles[4][column] = boardTiles[3][column];
            boardTiles[3][column] = boardTiles[2][column];
            boardTiles[2][column] = boardTiles[1][column];
            boardTiles[1][column] = boardTiles[0][column];
            boardTiles[0][column] = offBoardTemp;
        }
        makeBoard();
    }
    
    public void updateTileLoc(){
        int x, y;
        for(x = 0; x < 7; x++){
            for(y = 0; y < 7; y++){
                App.boardTiles[x][y].location.setxCoor(x);
                App.boardTiles[x][y].location.setyCoor(y);
            }
        }
    }
    
    
    
    
    public void makeBoard(){
        i01.setImage(App.boardTiles[0][1].tileImage);
        i03.setImage(App.boardTiles[0][3].tileImage);
        i05.setImage(App.boardTiles[0][5].tileImage);
        i10.setImage(App.boardTiles[1][0].tileImage);
        i11.setImage(App.boardTiles[1][1].tileImage);
        i12.setImage(App.boardTiles[1][2].tileImage);
        i13.setImage(App.boardTiles[1][3].tileImage);
        i14.setImage(App.boardTiles[1][4].tileImage);
        i15.setImage(App.boardTiles[1][5].tileImage);
        i16.setImage(App.boardTiles[1][6].tileImage);
        i21.setImage(App.boardTiles[2][1].tileImage);
        i23.setImage(App.boardTiles[2][3].tileImage);
        i25.setImage(App.boardTiles[2][5].tileImage);
        i30.setImage(App.boardTiles[3][0].tileImage);
        i31.setImage(App.boardTiles[3][1].tileImage);
        i32.setImage(App.boardTiles[3][2].tileImage);
        i33.setImage(App.boardTiles[3][3].tileImage);
        i34.setImage(App.boardTiles[3][4].tileImage);
        i35.setImage(App.boardTiles[3][5].tileImage);
        i36.setImage(App.boardTiles[3][6].tileImage);
        i41.setImage(App.boardTiles[4][1].tileImage);
        i43.setImage(App.boardTiles[4][3].tileImage);
        i45.setImage(App.boardTiles[4][5].tileImage);
        i50.setImage(App.boardTiles[5][0].tileImage);
        i51.setImage(App.boardTiles[5][1].tileImage);
        i52.setImage(App.boardTiles[5][2].tileImage);
        i53.setImage(App.boardTiles[5][3].tileImage);
        i54.setImage(App.boardTiles[5][4].tileImage);
        i55.setImage(App.boardTiles[5][5].tileImage);
        i56.setImage(App.boardTiles[5][6].tileImage);
        i61.setImage(App.boardTiles[6][1].tileImage);
        i63.setImage(App.boardTiles[6][3].tileImage);
        i65.setImage(App.boardTiles[6][5].tileImage);
        
        
        currTile.setImage(App.offBoardTile.tileImage);
        
        rotateImages();
        updateTileLoc();
    }
    
    public void checkExits(){
        int x, y;
        for(x = 0; x < 7; x++){
            for(y = 0; y < 7; y++){
                App.boardTiles[x][y].getLocation().setxCoor(x);
                App.boardTiles[x][y].getLocation().setyCoor(y);
                App.boardTiles[x][y].checkExit();
            }
        }
        App.offBoardTile.checkExit();
    }
    
    public void rotateImages(){
        i01.setRotate(App.boardTiles[0][1].location.rotation);
        App.boardTiles[0][1].getLocation().setRotation((int) i01.getRotate());
        i03.setRotate(App.boardTiles[0][3].location.rotation);
        App.boardTiles[0][3].getLocation().setRotation((int) i03.getRotate());
        i05.setRotate(App.boardTiles[0][5].location.rotation);
        App.boardTiles[0][5].getLocation().setRotation((int) i05.getRotate());
        i10.setRotate(App.boardTiles[1][0].location.rotation);
        App.boardTiles[1][0].getLocation().setRotation((int) i10.getRotate());
        i11.setRotate(App.boardTiles[1][1].location.rotation);
        App.boardTiles[1][1].getLocation().setRotation((int) i11.getRotate());
        i12.setRotate(App.boardTiles[1][2].location.rotation);
        App.boardTiles[1][2].getLocation().setRotation((int) i12.getRotate());
        i13.setRotate(App.boardTiles[1][3].location.rotation);
        App.boardTiles[1][3].getLocation().setRotation((int) i13.getRotate());
        i14.setRotate(App.boardTiles[1][4].location.rotation);
        App.boardTiles[1][4].getLocation().setRotation((int) i14.getRotate());
        i15.setRotate(App.boardTiles[1][5].location.rotation);
        App.boardTiles[1][5].getLocation().setRotation((int) i15.getRotate());
        i16.setRotate(App.boardTiles[1][6].location.rotation);
        App.boardTiles[1][6].getLocation().setRotation((int) i16.getRotate());
        i21.setRotate(App.boardTiles[2][1].location.rotation);
        App.boardTiles[2][1].getLocation().setRotation((int) i21.getRotate());
        i23.setRotate(App.boardTiles[2][3].location.rotation);
        App.boardTiles[2][3].getLocation().setRotation((int) i23.getRotate());
        i25.setRotate(App.boardTiles[2][5].location.rotation);
        App.boardTiles[2][5].getLocation().setRotation((int) i25.getRotate());
        i30.setRotate(App.boardTiles[3][0].location.rotation);
        App.boardTiles[3][0].getLocation().setRotation((int) i30.getRotate());
        i31.setRotate(App.boardTiles[3][1].location.rotation);
        App.boardTiles[3][1].getLocation().setRotation((int) i31.getRotate());
        i32.setRotate(App.boardTiles[3][2].location.rotation);
        App.boardTiles[3][2].getLocation().setRotation((int) i32.getRotate());
        i33.setRotate(App.boardTiles[3][3].location.rotation);
        App.boardTiles[3][3].getLocation().setRotation((int) i33.getRotate());
        i34.setRotate(App.boardTiles[3][4].location.rotation);
        App.boardTiles[3][4].getLocation().setRotation((int) i34.getRotate());
        i35.setRotate(App.boardTiles[3][5].location.rotation);
        App.boardTiles[3][5].getLocation().setRotation((int) i35.getRotate());
        i36.setRotate(App.boardTiles[3][6].location.rotation);
        App.boardTiles[3][6].getLocation().setRotation((int) i36.getRotate());
        i41.setRotate(App.boardTiles[4][1].location.rotation);
        App.boardTiles[4][1].getLocation().setRotation((int) i41.getRotate());
        i43.setRotate(App.boardTiles[4][3].location.rotation);
        App.boardTiles[4][3].getLocation().setRotation((int) i43.getRotate());
        i45.setRotate(App.boardTiles[4][5].location.rotation);
        App.boardTiles[4][5].getLocation().setRotation((int) i45.getRotate());
        i50.setRotate(App.boardTiles[5][0].location.rotation);
        App.boardTiles[5][0].getLocation().setRotation((int) i50.getRotate());
        i51.setRotate(App.boardTiles[5][1].location.rotation);
        App.boardTiles[5][1].getLocation().setRotation((int) i51.getRotate());
        i52.setRotate(App.boardTiles[5][2].location.rotation);
        App.boardTiles[5][2].getLocation().setRotation((int) i52.getRotate());
        i53.setRotate(App.boardTiles[5][3].location.rotation);
        App.boardTiles[5][3].getLocation().setRotation((int) i53.getRotate());
        i54.setRotate(App.boardTiles[5][4].location.rotation);
        App.boardTiles[5][4].getLocation().setRotation((int) i54.getRotate());
        i55.setRotate(App.boardTiles[5][5].location.rotation);
        App.boardTiles[5][5].getLocation().setRotation((int) i55.getRotate());
        i56.setRotate(App.boardTiles[5][6].location.rotation);
        App.boardTiles[5][6].getLocation().setRotation((int) i56.getRotate());
        i61.setRotate(App.boardTiles[6][1].location.rotation);
        App.boardTiles[6][1].getLocation().setRotation((int) i61.getRotate());
        i63.setRotate(App.boardTiles[6][3].location.rotation);
        App.boardTiles[6][3].getLocation().setRotation((int) i63.getRotate());
        i65.setRotate(App.boardTiles[6][5].location.rotation);
        App.boardTiles[6][5].getLocation().setRotation((int) i65.getRotate());
        
        currTile.setRotate(App.offBoardTile.location.rotation);
        App.offBoardTile.location.setRotation((int) (currTile.getRotate()));
        
        checkExits();
    }


    
    //ALGORITHM
    //---------------
    
    @FXML
    private void tryAlg(ActionEvent event) throws Exception{
        String[] koorStart = txtAlgoStart.getText().split(" ");
        String[] koorEnd = txtAlgoEnd.getText().split(" ");
        int startX = Integer.parseInt(koorStart[0]);
        int startY = Integer.parseInt(koorStart[1]);
        int endX = Integer.parseInt(koorEnd[0]);
        int endY = Integer.parseInt(koorEnd[1]);
        
        startAlg(startX, startY, endX, endY);
    }
    
    //Tiles which are connected to the startTile, but not yet looked at.
    ArrayList<algoTile> currObsTile = new ArrayList();
    //All tiles already looked at.
    ArrayList<tileModel> alrObsTiles = new ArrayList();
    
    public boolean startAlg(int startX, int startY, int endX, int endY) throws Exception{
        boolean erfolgreich = false;
        //Clearing everything and resetting it.
        
        for(int x = 0; x < 7; x++){
            for(int y = 0; y < 7; y++){
                App.boardTiles[x][y].ableToExit[0] = false;
                App.boardTiles[x][y].ableToExit[1] = false;
                App.boardTiles[x][y].ableToExit[2] = false;
                App.boardTiles[x][y].ableToExit[3] = false;
            }
        }
        
        checkExits();
        
        
        currObsTile.clear();
        alrObsTiles.clear();
        objecFound = false;
        
        tileModel startTile;
        tileModel endTile;
        
        //Die Koordinaten müssen sich im Spielbaren Feld befinden
        if(startX < 0 || startX > 6 || startY < 0 || startY > 6 || endX < 0 || endX > 6 || endY < 0 || endY > 6){
            throw new Exception("Die Koordinaten sind ungültig.");
        }
        else{
            //Setzt Start und End Tile
            startTile = App.boardTiles[startX][startY];
            endTile = App.boardTiles[endX][endY];
        }
            
        System.out.println("EndX: " + endTile.location.xCoor);
        System.out.println("EndY: " + endTile.location.yCoor);
        
        //currObsTile.add(new algoTile(0, startTile));
        System.out.println("Exits of StartTile :");
        System.out.println(startTile.ableToExit[0]);
        System.out.println(startTile.ableToExit[1]);
        System.out.println(startTile.ableToExit[2]);
        System.out.println(startTile.ableToExit[3]);
        System.out.println(" ");
        
        for(int i = 0; i < 4; i++){
            if(startTile.ableToExit[i] && checkNextTileInput(startTile, i)){
                System.out.println("Hit at Exit Nr.: " + i);
                int o = 5;
                switch(i){
                    case 0: o = 2; break;
                    case 1: o = 3; break;
                    case 2: o = 0; break;
                    case 3: o = 1; break;
                }
                switch(i){
                    case 0: currObsTile.add(new algoTile(o, App.boardTiles[startTile.location.xCoor - 1][startTile.location.yCoor])); break;
                    case 1: currObsTile.add(new algoTile(o, App.boardTiles[startTile.location.xCoor][startTile.location.yCoor + 1])); break;
                    case 2: currObsTile.add(new algoTile(o, App.boardTiles[startTile.location.xCoor + 1][startTile.location.yCoor])); break;
                    case 3: currObsTile.add(new algoTile(o, App.boardTiles[startTile.location.xCoor][startTile.location.yCoor - 1])); break;
                }
            }
        }
        
        
        int fCount = 0;
        //Break Flag für die While Loop
        breakWhile:
        //wird ausgeführt während das Ziel noch nicht gefunden wurde
        while(!(objecFound)){
            if(fCount == 10){System.out.println("---fbreak"); break;}
            else if(currObsTile.isEmpty()){fCount++;
                System.out.println("F: " + fCount);}
            //Geht alle currently Observed Tiles durch und checkt ob diese das Endtile sind
            for(algoTile currObTile : currObsTile){
                if(compareTiles(currObTile.tile, endTile)){
                    objecFound = true;
                    System.out.println("--Found EndTile!");
                    //Also breaks to stop the whole thing immediatly, and not to wait for everything to finish first
                    //Better performance
                    break breakWhile;
                }
            }
            //continue flag für die For Loop
            breakFor:
            //Geht alle currently observed tiles durch
            for (int i = 0; i < currObsTile.size(); i++){
                //Wenn dieses Tile schon in der alreadyObservedList ist, dann wird beim nächsten weitergemacht
                for(int o = 0; o < alrObsTiles.size(); o++) {
                    if(compareTiles(alrObsTiles.get(o), (currObsTile.get(i).tile))){
                        currObsTile.remove(i);
                        continue breakFor;
                    }
                }
                System.out.println("-----------------");
                System.out.println("     Check Tile at: " + currObsTile.get(i).tile.location.xCoor + currObsTile.get(i).tile.location.yCoor);
                System.out.println("Tile: " + currObsTile.get(i).tile.tileKind + currObsTile.get(i).tile.collectable + currObsTile.get(i).tile.location.rotation);
                if(compareTiles(currObsTile.get(i).tile, endTile)){
                    objecFound = true;
                    System.out.println("--Found EndTile!");
                    //Also breaks to stop the whole thing immediatly, and not to wait for everything to finish first
                    //Better performance
                    break breakWhile;
                }
                else{
                    startTile(currObsTile.get(i), i);
                }
                    
            }
        }
        if(objecFound){System.out.println("--Algorithmus erfolgreich!");erfolgreich = true;}
        else{System.out.println("|--Der Spieler kann dort nicht hinlaufen!--|");}
        return erfolgreich;
    }
    
    public algoTile startTile(algoTile tile, int index){
        //Alle Seiten aus denen ein Weg geht
        System.out.println("Oben Ausgang: " + tile.tile.ableToExit[0]);
        System.out.println("Rechts Ausgang: " + tile.tile.ableToExit[1]);
        System.out.println("Unten Ausgang: " + tile.tile.ableToExit[2]);
        System.out.println("Links Ausgang: " + tile.tile.ableToExit[3]);
        //Die Seite aus der der Algorithmus gekommen ist wird als false gesetzt
        //Damit er nicht in eine Loop verfällt
        tile.tile.ableToExit[tile.fromDir] = false;
        
        //Geht alle Seiten des Tiles durch
        for(int i = 0; i < 4; i++){
            //Wenn die Seite einen Ausgang hat, und das Angrenzende Tile auch, dann true
            if(tile.tile.ableToExit[i] && checkNextTileInput(tile.tile, i)){
                System.out.println("Hit at Exit Nr.: " + i);
                int o = 5;
                switch(i){
                    case 0: o = 2; break;
                    case 1: o = 3; break;
                    case 2: o = 0; break;
                    case 3: o = 1; break;
                }
                switch(i){
                    //jenachdem auf welcher seite des tiles das passende tile ist, wird dieses der arrList hinzugefügt
                    case 0: currObsTile.add(new algoTile(o , App.boardTiles[tile.tile.location.xCoor - 1][tile.tile.location.yCoor])); System.out.println("up");break;
                    case 1: currObsTile.add(new algoTile(o , App.boardTiles[tile.tile.location.xCoor][tile.tile.location.yCoor + 1])); System.out.println("right"); break;
                    case 2: currObsTile.add(new algoTile(o , App.boardTiles[tile.tile.location.xCoor + 1][tile.tile.location.yCoor])); System.out.println("down"); break;
                    case 3: currObsTile.add(new algoTile(o , App.boardTiles[tile.tile.location.xCoor][tile.tile.location.yCoor - 1])); System.out.println("left"); break;
                }
            }
        }
        currObsTile.remove(index);
        alrObsTiles.add(tile.tile);
        return tile;
    }
    
    public boolean compareTiles(tileModel tile1, tileModel tile2){
        int x1, y1, x2, y2;
        x1 = tile1.location.xCoor;
        y1 = tile1.location.yCoor;
        x2 = tile2.location.xCoor;
        y2 = tile2.location.yCoor;
        
        boolean match = false;
        
        if(x1 == x2 && y1 == y2){
            match = true;
        }
        return match;
    }
    
    public boolean checkNextTileInput(tileModel currTile, int dir){
        boolean w = false;
        try{
            switch(dir){
                case 0: 
                    System.out.println("-Oberes Tile: " + App.boardTiles[currTile.location.xCoor - 1][currTile.location.yCoor].tileKind);
                    if(App.boardTiles[currTile.location.xCoor - 1][currTile.location.yCoor].ableToExit[2]){w = true;} break;
                case 1: 
                    System.out.println("-Rechtes Tile: " + App.boardTiles[currTile.location.xCoor][currTile.location.yCoor + 1].tileKind);
                    if(App.boardTiles[currTile.location.xCoor][currTile.location.yCoor + 1].ableToExit[3]){w = true;} break;
                case 2: 
                    System.out.println("-Unteres Tile: " + App.boardTiles[currTile.location.xCoor + 1][currTile.location.yCoor].tileKind);
                    if(App.boardTiles[currTile.location.xCoor + 1][currTile.location.yCoor].ableToExit[0]){w = true;} break;
                case 3:
                    System.out.println("-Linkes Tile: " + App.boardTiles[currTile.location.xCoor][currTile.location.yCoor - 1].tileKind);
                    if(App.boardTiles[currTile.location.xCoor][currTile.location.yCoor - 1].ableToExit[1]){w = true;} break;
            }
        }
        catch(Exception e){
            w = false;
        }
        return w;
    }

    

    public class algoTile{
        Integer fromDir;
        tileModel tile;

        public algoTile(Integer fromDir, tileModel tile) {
            this.fromDir = fromDir;
            this.tile = tile;
        }
    }
    
    
    
    //--------------
    //Algorithm Done
        
    
    
    //Rotates the Off-Board Tile
    @FXML
    private void currTileRight(ActionEvent event) {
        
        if(currTile.getRotate() == 270){
            currTile.setRotate(0);
            App.offBoardTile.location.setRotation(0);
        }
        else{
            currTile.setRotate(currTile.getRotate() + 90);   
            App.offBoardTile.location.setRotation(App.offBoardTile.location.rotation + 90);
        }
        System.out.println("Rotate OffBoard Tile to: " + currTile.getRotate());
    }
    
    
    
    //-------------------------------
    //Drag 'n Drop --> OffBoard Tile
    
    @FXML
    private void tileDrag(MouseEvent event) {
        event.setDragDetect(true);
    }

    @FXML
    private void tileDragDetec(MouseEvent event) {
        System.out.println("Source Img drag detected");

            Dragboard db = currTile.startDragAndDrop(TransferMode.ANY);
            
            ClipboardContent content = new ClipboardContent();
            content.putString("ImageView source text");
            Image temp = currTile.snapshot(null, null);
            
            content.putImage(temp);
            db.setContent(content);
    }
    
    
    @FXML
    private void btnTurnSwap(ActionEvent event) {
        switch(playerTurn){
            case 0: 
                playerTurn = playerTurn + 1;
                player_blue.toFront();
                player_red.toBack();
                player_yellow.toBack();
                player_green.toBack();
            break;
            case 1: 
                playerTurn = playerTurn + 1;
                player_yellow.toFront();
                player_red.toBack();
                player_blue.toBack();
                player_green.toBack();
            break;
            case 2: 
                playerTurn = playerTurn + 1;
                player_green.toFront();
                player_red.toBack();
                player_blue.toBack();
                player_yellow.toBack();
                
            break;
            case 3: 
                playerTurn = 0;
                player_red.toFront();
                player_blue.toBack();
                player_yellow.toBack();
                player_green.toBack();
            break;
        }
    }

    @FXML
    private void redPlayerDrag(MouseEvent event) {
        event.setDragDetect(true);
    }

    @FXML
    private void redPlayerDragDetec(MouseEvent event) {
        System.out.println("Source Img drag detected");

            Dragboard db = player_red.startDragAndDrop(TransferMode.ANY);
            
            ClipboardContent content = new ClipboardContent();
            content.putString("player");
            Image temp = player_red.snapshot(null, null);
            
            content.putImage(temp);
            db.setContent(content);
    }
    @FXML
    private void yellowPlayerDrag(MouseEvent event) {
        event.setDragDetect(true);
    }

    @FXML
    private void yellowPlayerDragDetec(MouseEvent event) {
        System.out.println("Source Img drag detected");

            Dragboard db = player_yellow.startDragAndDrop(TransferMode.ANY);
            
            ClipboardContent content = new ClipboardContent();
            content.putString("player");
            Image temp = player_yellow.snapshot(null, null);
            
            content.putImage(temp);
            db.setContent(content);
    }
    @FXML
    private void bluePlayerDrag(MouseEvent event) {
        event.setDragDetect(true);
    }

    @FXML
    private void bluePlayerDragDetec(MouseEvent event) {
        System.out.println("Source Img drag detected");

            Dragboard db = player_blue.startDragAndDrop(TransferMode.ANY);
            
            ClipboardContent content = new ClipboardContent();
            content.putString("player");
            Image temp = player_blue.snapshot(null, null);
            
            content.putImage(temp);
            db.setContent(content);
    }
    @FXML
    private void greenPlayerDrag(MouseEvent event) {
        event.setDragDetect(true);
    }

    @FXML
    private void greenPlayerDragDetec(MouseEvent event) {
        System.out.println("Source Img drag detected");

            Dragboard db = player_green.startDragAndDrop(TransferMode.ANY);
            
            ClipboardContent content = new ClipboardContent();
            content.putString("player");
            Image temp = player_green.snapshot(null, null);
            
            content.putImage(temp);
            db.setContent(content);
    }

    
    
    //TARGETs FOR DROPPING
    
    @FXML
    private void dp1DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp1DragDrop(DragEvent event) {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 1");
            tilePhaseOver = true;
            moveColumn(1, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void dp2DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp2DragDrop(DragEvent event) {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 2");
            tilePhaseOver = true;
            moveColumn(3, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void dp3DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp3DragDrop(DragEvent event) {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 3");
            tilePhaseOver = true;
            moveColumn(5, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void dp4DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp4DragDrop(DragEvent event) {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 4");
            tilePhaseOver = true;
            moveRow(1, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void dp5DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp5DragDrop(DragEvent event) {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 5");
            tilePhaseOver = true;
            moveRow(3, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void dp6DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp6DragDrop(DragEvent event) {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 6");
            tilePhaseOver = true;
            moveRow(5, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void dp7DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp7DragDrop(DragEvent event) {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 7");
            tilePhaseOver = true;
            moveColumn(5, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void dp8DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp8DragDrop(DragEvent event) {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 8");
            tilePhaseOver = true;
            moveColumn(3, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void dp9DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp9DragDrop(DragEvent event) {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 9");
            tilePhaseOver = true;
            moveColumn(1, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void dp10DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp10DragDrop(DragEvent event) {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 10");
            tilePhaseOver = true;
            moveRow(5, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void dp11DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp11DragDrop(DragEvent event) {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 11");
            tilePhaseOver = true;
            moveRow(3, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void dp12DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp12DragDrop(DragEvent event) {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 12");
            tilePhaseOver = true;
            moveRow(1, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    
    private void movePlayer(double mouseX, double mouseY, int x, int y) throws Exception{
        
        int[] oldRedTilePos = new int[2];
        int[] oldBlueTilePos = new int[2];
        int[] oldYellowTilePos = new int[2];
        int[] oldGreenTilePos = new int[2];
        
        oldRedTilePos[0] = App.players[0].pos[0];
        oldRedTilePos[1] = App.players[0].pos[1];
        
        oldBlueTilePos[0] = App.players[1].pos[0];
        oldBlueTilePos[1] = App.players[1].pos[1];
        
        oldYellowTilePos[0] = App.players[2].pos[0];
        oldYellowTilePos[1] = App.players[2].pos[1];
        
        oldGreenTilePos[0] = App.players[3].pos[0];
        oldGreenTilePos[1] = App.players[3].pos[1];
        
        
        switch(playerTurn){
            case 0:
                System.out.println("Alte Spielerposition: " + oldRedTilePos[0] + " " + oldRedTilePos[1]);
                System.out.println("Mausposition: " +  x + " " + y);
                if(startAlg(oldRedTilePos[0], oldRedTilePos[1], x, y)){
                    player_red.setX(mouseX);
                    player_red.setY(mouseY);
                    App.players[0].pos[0] = x;
                    App.players[0].pos[1] = y;
                    System.out.println( "Spielerposition (red): " + App.players[0].pos[0] + " " + App.players[0].pos[1]);
                }
                else{
                    throw new Exception("Der Weg des Spielers ist versperrt");
                }
            break;
            
            case 1:
                System.out.println("Alte Spielerposition: " + oldBlueTilePos[0] + " " + oldBlueTilePos[1]);
                System.out.println("Mausposition: " +  x + " " + y);
                if(startAlg(oldBlueTilePos[0], oldBlueTilePos[1], x, y)){
                    player_blue.setX(mouseX);
                    player_blue.setY(mouseY);
                    App.players[1].pos[0] = x;
                    App.players[1].pos[1] = y;
                    System.out.println( "Spielerposition (blue): " + App.players[1].pos[0] + " " + App.players[1].pos[1]);
                }
                else{
                    throw new Exception("Der Weg des Spielers ist versperrt");
                }
            break;
            
            case 2:
                System.out.println("Alte Spielerposition: " + oldYellowTilePos[0] + " " + oldYellowTilePos[1]);
                System.out.println("Mausposition: " +  x + " " + y);
                if(startAlg(oldYellowTilePos[0], oldYellowTilePos[1], x, y)){
                    player_yellow.setX(mouseX);
                    player_yellow.setY(mouseY);
                    App.players[2].pos[0] = x;
                    App.players[2].pos[1] = y;
                    System.out.println( "Spielerposition (yellow): " + App.players[2].pos[0] + " " + App.players[2].pos[1]);
                }
                else{
                    throw new Exception("Der Weg des Spielers ist versperrt");
                }
            break;
            
            case 3:
                System.out.println("Alte Spielerposition: " + oldGreenTilePos[0] + " " + oldGreenTilePos[1]);
                System.out.println("Mausposition: " +  x + " " + y);
                if(startAlg(oldGreenTilePos[0], oldGreenTilePos[1], x, y)){
                    player_green.setX(mouseX);
                    player_green.setY(mouseY);
                    App.players[3].pos[0] = x;
                    App.players[3].pos[1] = y;
                    System.out.println( "Spielerposition (green): " + App.players[3].pos[0] + " " + App.players[3].pos[1]);
                }
                else{
                    throw new Exception("Der Weg des Spielers ist versperrt");
                }
            break;
        }
        
        //App.players[0].setPos(mouseX mouseY);
    }
    @FXML
    private void mouseReleased(MouseEvent event) {
    }
    
    @FXML
    private void Ti00DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti00DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            
            System.out.println("Dropped at DropPoint 00");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 0, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti01DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti01DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 01");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 0, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti02DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti02DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 02");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 0, 2);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti03DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti03DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 03");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 0, 3);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti04DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti04DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 04");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 0, 4);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti05DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti05DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 05");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 0, 5);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti06DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti06DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 06");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 0, 6);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti10DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti10DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 10");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 1, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti11DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti11DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 11");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 1, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti12DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti12DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 12");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 1, 2);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti13DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti13DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 13");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 1, 3);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti14DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti14DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 14");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 1, 4);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti15DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti15DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 15");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 1, 5);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti16DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti16DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 16");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 1, 6);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti20DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti20DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 20");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 2, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti21DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti21DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 21");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 2, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti22DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti22DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 22");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 2, 2);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti23DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti23DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 23");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 2, 3);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti24DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti24DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 24");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 2, 4);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti25DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti25DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 25");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 2, 5);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti26DragOver(DragEvent event) throws Exception {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti26DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 26");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 2, 6);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti30DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti30DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 30");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 3, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti31DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti31DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 31");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 3, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti32DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti32DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 32");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 3, 2);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti33DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti33DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 33");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 3, 3);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti34DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti34DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 34");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 3, 4);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti35DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti35DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 35");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 3, 5);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti36DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti36DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 36");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 3, 6);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti40DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti40DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 40");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 4, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti41DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti41DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 41");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 4, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti42DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti42DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 42");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 4, 2);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti43DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti43DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 43");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 4, 3);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti44DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti44DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 44");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 4, 4);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti45DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti45DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 45");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 4, 5);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti46DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti46DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 46");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 4, 6);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti50DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti50DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 50");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 5, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti51DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti51DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 51");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 5, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti52DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti52DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 52");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 5, 2);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti53DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti53DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 53");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 5, 3);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti54DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti54DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 54");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 5, 4);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti55DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti55DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 55");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 5, 5);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti56DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti56DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 56");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 5, 6);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti60DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti60DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 60");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 6, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti61DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti61DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 61");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 6, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti62DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti62DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 62");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 6, 2);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti63DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti63DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 63");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 6, 3);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti64DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti64DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 64");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 6, 4);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti65DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti65DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 65");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 6, 5);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    @FXML
    private void Ti66DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti66DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 66");
            tilePhaseOver = true;
            double mouseX = event.getSceneX() - 15;
            double mouseY = event.getSceneY() - 15;
            movePlayer(mouseX, mouseY, 6, 6);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
    
}

