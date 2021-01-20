/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benpaul.dasverrlabyrinth;

import static com.benpaul.dasverrlabyrinth.App.boardTiles;
import static com.benpaul.dasverrlabyrinth.App.offBoardTile;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
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


    @FXML
    private ImageView imgTile1;
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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File file = new File("src/main/resources/all_tiles/straight.png");
        imageS = new Image(file.toURI().toString());
        File fileT = new File("src/main/resources/all_tiles/turn.png");
        imageT = new Image(fileT.toURI().toString());
        File file1 = new File("src/main/resources/all_tiles/bat.png");
        imageBat = new Image(file1.toURI().toString());
        File file2 = new File("src/main/resources/all_tiles/dragon.png");
        imageDragon = new Image(file2.toURI().toString());
        File file3 = new File("src/main/resources/all_tiles/ghost.png");
        imageGhost = new Image(file3.toURI().toString());
        File file4 = new File("src/main/resources/all_tiles/gnome.png");
        imageGnome = new Image(file4.toURI().toString());
        File file5 = new File("src/main/resources/all_tiles/moth.png");
        imageMoth = new Image(file5.toURI().toString());
        File file6 = new File("src/main/resources/all_tiles/mouse.png");
        imageMouse = new Image(file6.toURI().toString());
        File file7 = new File("src/main/resources/all_tiles/owl.png");
        imageOwl = new Image(file7.toURI().toString());
        File file8 = new File("src/main/resources/all_tiles/poltergeist.png");
        imagePoltergeist = new Image(file8.toURI().toString());
        File file9 = new File("src/main/resources/all_tiles/salamander.png");
        imageSalamander = new Image(file9.toURI().toString());
        File file0 = new File("src/main/resources/all_tiles/scarab.png");
        imageScarab = new Image(file0.toURI().toString());
        File file10 = new File("src/main/resources/all_tiles/spider.png");
        imageSpider = new Image(file10.toURI().toString());
        File file11 = new File("src/main/resources/all_tiles/witch.png");
        imageWitch = new Image(file11.toURI().toString());
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
        int x, y;
        for(x = 0; x < 7; x++){
            //Für jede x-Koordinate wird noch jede Kombination mit y-Koordinaten abgefragt
            for(y = 0; y < 7; y++){
                int imageViewName = x + y;
                switch(imageViewName){
                    //alle ImageViews haben namen wie ihre koordienate 
                    // zb.: 00, 01, 20, 30, 34, ...
                    //case 00: 00.setImage(); break;
                    case 01: break;
                    case 02: break;
                    case 03: break;
                    case 04: break;
                    case 05: break;
                    case 06: break;
                    case 10: break;
                    case 11: break;
                }
            }
        }
    }
    
    
    /*
    public void fillView(){
        int x;
        int y;
        
        for(x = 0; x < 7; x++){
            //Für jede x-Koordinate wird noch jede Kombination mit y-Koordinaten abgefragt
            for(y = 0; y < 7; y++){
                //Reihe 1
                if(y == 0){
                    switch(x){
                        //Wenn ein Feld mit einer festen karte erreicht wird, dann wird dort die richtige Karte hingesetzt
                        case 0: boardTiles[x][y] = new tileModel(new locationModel(0, x, y, false), false, null, false, "turn"); break;//oben links
                        //Wenn es ein Feld für eine Random Karte befüllt wird wird die getRandomTile Funktion aufgerufen
                        //Diese Funktion gibt ein Tile zurück, welches noch nicht benutzt ist.
                        case 1: switch (boardTiles[1][0].getTileKind()){
                            case "Straight":
                                imgTile1.set
                        }
                        case 2: boardTiles[x][y] = new tileModel(new locationModel(2, x, y, false), true, "helmet", false, "t-crossing"); break;
                        case 3: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 4: boardTiles[x][y] = new tileModel(new locationModel(2, x, y, false), true, "candleHolder", false, "t-crossing"); break;
                        case 5: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 6: boardTiles[x][y] = new tileModel(new locationModel(1, x, y, false), false, null, false, "turn"); break;//oben rechts
                    }
                }
                if(y == 2){
                    switch(x){
                        case 0: boardTiles[x][y] = new tileModel(new locationModel(1, x, y, false), true, "sword", false, "t-crossing"); break;
                        case 1: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 2: boardTiles[x][y] = new tileModel(new locationModel(1, x, y, false), true, "emerald", false, "t-crossing"); break;
                        case 3: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 4: boardTiles[x][y] = new tileModel(new locationModel(2, x, y, false), true, "chest", false, "t-crossing"); break;
                        case 5: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 6: boardTiles[x][y] = new tileModel(new locationModel(3, x, y, false), true, "ring", false, "t-crossing"); break;
                    }
                }
                if(y == 4){
                    switch(x){
                        case 0: boardTiles[x][y] = new tileModel(new locationModel(1, x, y, false), true, "skull", false, "t-crossing"); break;
                        case 1: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 2: boardTiles[x][y] = new tileModel(new locationModel(0, x, y, false), true, "keys", false, "t-crossing"); break;
                        case 3: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 4: boardTiles[x][y] = new tileModel(new locationModel(3, x, y, false), true, "crown", false, "t-crossing"); break;
                        case 5: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 6: boardTiles[x][y] = new tileModel(new locationModel(3, x, y, false), true, "map", false, "t-crossing"); break;
                    }
                }
                if(y == 6){
                    switch(x){
                        case 0: boardTiles[x][y] = new tileModel(new locationModel(3, x, y, false), false, null, false, "turn"); break;//unten links
                        case 1: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 2: boardTiles[x][y] = new tileModel(new locationModel(0, x, y, false), true, "coins", false, "t-crossing"); break;
                        case 3: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 4: boardTiles[x][y] = new tileModel(new locationModel(0, x, y, false), true, "bible", false, "t-crossing"); break;
                        case 5: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 6: boardTiles[x][y] = new tileModel(new locationModel(4, x, y, false), false, null, false, "turn"); break;//unten rechts
                    }
                }
            }
        }
    }*/
}
