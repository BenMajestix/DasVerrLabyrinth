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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        makeBoard();
        
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
        //Von oben schiebend
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
        //von unten schiebend
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
        
        
        
        rotateImages();
        currTile.setImage(App.offBoardTile.tileImage);
    }
    
    public Image getTileImage(int x, int y){
        Image image = null;
        if(App.boardTiles[x][y].tileKind.equals("straight")){
            System.out.println("straight");
            image = imageS;
        }
        else if(App.boardTiles[x][y].tileKind.equals("turn") && !(App.boardTiles[x][y].collectableOnTile)){
            System.out.println("turn");
            image = imageT;
        }
        else if(App.boardTiles[x][y].collectableOnTile){
            switch(App.boardTiles[x][y].collectable){
                case "owl": image = imageOwl; System.out.println("owl");break;
                case "moth": image = imageMoth; System.out.println("moth");break;
                case "mouse": image = imageMouse; System.out.println("mouse");break;
                case "spider": image = imageSpider; System.out.println("spider");break;
                case "scarab": image = imageScarab; System.out.println("scarab");break;
                case "salamander": image = imageSalamander; System.out.println("salamander");break;
                case "witch": image = imageWitch; System.out.println("witch");break;
                case "dragon": image = imageDragon; System.out.println("dragon");break;
                case "poltergeist": image = imagePoltergeist; System.out.println("poltergeist");break;
                case "ghost": image = imageGhost; System.out.println("ghost");break;
                case "bat": image = imageBat; System.out.println("bat");break;
                case "gnome": image = imageGnome; System.out.println("gnome");break;
            }
        }
        
        return image;
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
        i34.setRotate(App.boardTiles[3][5].location.rotation);
        App.boardTiles[3][5].getLocation().setRotation((int) i34.getRotate());
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
    }


    @FXML
    private void tryAlg(ActionEvent event) {
        startAlg();
    }
    
    //Tiles which are connected to the startTile, but not yet looked at.
    ArrayList<algoTile> currObsTile = new ArrayList();
    //All tiles already looked at.
    ArrayList<tileModel> alrObsTiles = new ArrayList();
    
    public void startAlg(){
        //Setzt Start und End Tile
        tileModel startTile = App.boardTiles[2][1];
        tileModel endTile = App.boardTiles[4][1];
        
        
        currObsTile.add(new algoTile(0, startTile));
        
        if(currObsTile.get(0).equals(App.boardTiles[4][1])){System.out.println("test succeed");}
        int f = 0;
        //Break Flag für die While Loop
        breakWhile:
        //While das Ziel noch nicht gefunden wurde
        while(!(objecFound)){
            if(f == 3){break;}
            else if(currObsTile.isEmpty()){f++;}
            //Geht alle currently Observed Tiles durch und checkt ob diese das Endtile sindå
            for(algoTile currObTile : currObsTile){
                if(currObTile.tile == endTile){
                    objecFound = true;
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
                    if(alrObsTiles.get(o).equals(currObsTile.get(i).tile)){
                        continue breakFor;
                    }
                }
                System.out.println("start new tile");
                if (startTile(currObsTile.get(i), i).tile == (endTile)) {
                    System.out.println("found it");
                    objecFound = true;
                    break breakWhile;
                } else {}
            }
        }
        if(objecFound){System.out.println("found haha");}
        else{System.out.println("cant find it");}
    }
    
    
    
    public algoTile startTile(algoTile tile, int index){
        //Alle Seiten aus denen ein Weg geht
        boolean[] exit = tile.tile.ableToExit;
        System.out.println(tile.tile.ableToExit[0]);
        System.out.println(tile.tile.ableToExit[1]);
        System.out.println(tile.tile.ableToExit[2]);
        System.out.println(tile.tile.ableToExit[3]);
        //Die Seite aus der der Algorithmus gekommen ist wird als false gesetzt
        //Damit er nicht in eine Loop verfällt
        tile.tile.ableToExit[tile.fromDir] = false;
        //Geht alle Seiten des Tiles durch
        for(int i = 0; i < 4; i++){
            //Wenn die Seite einen Ausgang hat, und das Angrenzende Tile auch, dann true
            if(tile.tile.ableToExit[i] && checkNextTileInput(tile.tile, i)){
                switch(i){
                    //jenachdem auf welcher seite des tiles das passende tile ist, wird dieses der arrList hinzugefügt
                    case 0: currObsTile.add(new algoTile(i , App.boardTiles[tile.tile.location.xCoor - 1][tile.tile.location.yCoor])); System.out.println("up");break;
                    case 1: currObsTile.add(new algoTile(i , App.boardTiles[tile.tile.location.xCoor][tile.tile.location.yCoor + 1])); System.out.println("right"); break;
                    case 2: currObsTile.add(new algoTile(i , App.boardTiles[tile.tile.location.xCoor + 1][tile.tile.location.yCoor])); System.out.println("down"); break;
                    case 3: currObsTile.add(new algoTile(i , App.boardTiles[tile.tile.location.xCoor][tile.tile.location.yCoor - 1])); System.out.println("left"); break;
                }
                System.out.println("addtile");
            }
        }
        currObsTile.remove(index);
        alrObsTiles.add(tile.tile);
        return tile;
    }
    
    
    public boolean checkNextTileInput(tileModel currTile, int dir){
        boolean w = false;
        
        switch(dir){
            case 0: 
                if(App.boardTiles[currTile.location.xCoor - 1][currTile.location.yCoor].ableToExit[2]){w = true;} break;
            case 1: 
                if(App.boardTiles[currTile.location.xCoor][currTile.location.yCoor + 1].ableToExit[2]){w = true;} break;
            case 2: 
                if(App.boardTiles[currTile.location.xCoor + 1][currTile.location.yCoor].ableToExit[2]){w = true;} break;
            case 3: 
                if(App.boardTiles[currTile.location.xCoor][currTile.location.yCoor - 1].ableToExit[2]){w = true;} break;
        }
        return w;
    }

    @FXML
    private void currTileRight(ActionEvent event) {
        System.out.println("right");
    }


    public class algoTile{
        Integer fromDir;
        tileModel tile;

        public algoTile(Integer fromDir, tileModel tile) {
            this.fromDir = fromDir;
            this.tile = tile;
        }
        
    
    
    
    
    
    }
}
