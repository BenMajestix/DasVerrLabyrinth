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
    private ImageView i00;
    @FXML
    private ImageView i10;
    @FXML
    private ImageView i20;
    @FXML
    private ImageView i30;
    @FXML
    private ImageView i40;
    @FXML
    private ImageView i50;
    @FXML
    private ImageView i60;
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
    private ImageView i02;
    @FXML
    private ImageView i12;
    @FXML
    private ImageView i22;
    @FXML
    private ImageView i32;
    @FXML
    private ImageView i42;
    @FXML
    private ImageView i52;
    @FXML
    private ImageView i62;
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
    private ImageView i04;
    @FXML
    private ImageView i14;
    @FXML
    private ImageView i24;
    @FXML
    private ImageView i34;
    @FXML
    private ImageView i44;
    @FXML
    private ImageView i54;
    @FXML
    private ImageView i64;
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
    private ImageView i06;
    @FXML
    private ImageView i16;
    @FXML
    private ImageView i26;
    @FXML
    private ImageView i36;
    @FXML
    private ImageView i46;
    @FXML
    private ImageView i56;
    @FXML
    private ImageView i66;
    
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
        int x, y;
        for(x = 0; x < 7; x++){
            //Für jede x-Koordinate wird noch jede Kombination mit y-Koordinaten abgefragt
            for(y = 0; y < 7; y++){
                String koor = Integer.toString(x)+Integer.toString(y);
                int imageViewName = Integer.parseInt(koor);
                System.out.println(imageViewName);
                switch(imageViewName){
                    //alle ImageViews haben namen wie ihre koordienate 
                    // zb.: 00, 01, 20, 30, 34, ...
                    case 00: i00.setImage(getTileImage(x, y)); break;
                    case 01: i01.setImage(getTileImage(x, y)); break;
                    case 02: i02.setImage(getTileImage(x, y)); break;
                    case 03: i03.setImage(getTileImage(x, y)); break;
                    case 04: i04.setImage(getTileImage(x, y)); break;
                    case 05: i05.setImage(getTileImage(x, y)); break;
                    case 06: i06.setImage(getTileImage(x, y)); break;
                    case 10: i10.setImage(getTileImage(x, y)); break;
                    case 11: i11.setImage(getTileImage(x, y)); break;
                    case 12: i12.setImage(getTileImage(x, y)); break;
                    case 13: i13.setImage(getTileImage(x, y)); break;
                    case 14: i14.setImage(getTileImage(x, y)); break;
                    case 15: i15.setImage(getTileImage(x, y)); break;
                    case 16: i16.setImage(getTileImage(x, y)); break;
                    case 20: i20.setImage(getTileImage(x, y)); break;
                    case 21: i21.setImage(getTileImage(x, y)); break;
                    case 22: i22.setImage(getTileImage(x, y)); break;
                    case 23: i23.setImage(getTileImage(x, y)); break;
                    case 24: i24.setImage(getTileImage(x, y)); break;
                    case 25: i25.setImage(getTileImage(x, y)); break;
                    case 26: i26.setImage(getTileImage(x, y)); break;
                    case 30: i30.setImage(getTileImage(x, y)); break;
                    case 31: i31.setImage(getTileImage(x, y)); break;
                    case 32: i32.setImage(getTileImage(x, y)); break;
                    case 33: i33.setImage(getTileImage(x, y)); break;
                    case 34: i34.setImage(getTileImage(x, y)); break;
                    case 35: i35.setImage(getTileImage(x, y)); break;
                    case 36: i36.setImage(getTileImage(x, y)); break;
                    case 40: i40.setImage(getTileImage(x, y)); break;
                    case 41: i41.setImage(getTileImage(x, y)); break;
                    case 42: i42.setImage(getTileImage(x, y)); break;
                    case 43: i43.setImage(getTileImage(x, y)); break;
                    case 44: i44.setImage(getTileImage(x, y)); break;
                    case 45: i45.setImage(getTileImage(x, y)); break;
                    case 46: i46.setImage(getTileImage(x, y)); break;
                    case 50: i50.setImage(getTileImage(x, y)); break;
                    case 51: i51.setImage(getTileImage(x, y)); break;
                    case 52: i52.setImage(getTileImage(x, y)); break;
                    case 53: i53.setImage(getTileImage(x, y)); break;
                    case 54: i54.setImage(getTileImage(x, y)); break;
                    case 55: i55.setImage(getTileImage(x, y)); break;
                    case 56: i56.setImage(getTileImage(x, y)); break;
                    case 60: i60.setImage(getTileImage(x, y)); break;
                    case 61: i61.setImage(getTileImage(x, y)); break;
                    case 62: i62.setImage(getTileImage(x, y)); break;
                    case 63: i63.setImage(getTileImage(x, y)); break;
                    case 64: i64.setImage(getTileImage(x, y)); break;
                    case 65: i65.setImage(getTileImage(x, y)); break;
                    case 66: i66.setImage(getTileImage(x, y)); break;
                    
                }
            }
        }
    }
    
    public Image getTileImage(int x, int y){
        System.out.println("gettile image");
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
            System.out.println("tile with obj");
            switch(App.boardTiles[x][y].collectable){
                case "owl": image = imageOwl; break;
                case "moth": image = imageMoth; break;
                case "mouse": image = imageMouse; break;
                case "spider": image = imageSpider; break;
                case "scarab": image = imageScarab; break;
                case "salamander": image = imageSalamander; break;
                case "witch": image = imageWitch; break;
                case "dragon": image = imageDragon; break;
                case "poltergeist": image = imagePoltergeist; break;
                case "ghost": image = imageGhost; break;
                case "bat": image = imageBat; break;
                case "gnome": image = imageGnome; break;
            }
        }
        
        return image;
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
