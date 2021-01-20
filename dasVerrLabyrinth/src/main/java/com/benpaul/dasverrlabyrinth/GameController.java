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
            for(y = 0; y < 7; y++){
                String koor = Integer.toString(x)+Integer.toString(y);
                int imageViewName = Integer.parseInt(koor);
                switch(imageViewName){
                    //alle ImageViews haben namen wie ihre koordienate 
                    // zb.: 00, 01, 20, 30, 34, ...
                    case 01: i01.setImage(getTileImage(x, y)); break;
                    case 03: i03.setImage(getTileImage(x, y)); break;
                    case 05: i05.setImage(getTileImage(x, y)); break;
                    case 10: i10.setImage(getTileImage(x, y)); break;
                    case 11: i11.setImage(getTileImage(x, y)); break;
                    case 12: i12.setImage(getTileImage(x, y)); break;
                    case 13: i13.setImage(getTileImage(x, y)); break;
                    case 14: i14.setImage(getTileImage(x, y)); break;
                    case 15: i15.setImage(getTileImage(x, y)); break;
                    case 16: i16.setImage(getTileImage(x, y)); break;
                    case 21: i21.setImage(getTileImage(x, y)); break;
                    case 23: i23.setImage(getTileImage(x, y)); break;
                    case 25: i25.setImage(getTileImage(x, y)); break;
                    case 30: i30.setImage(getTileImage(x, y)); break;
                    case 31: i31.setImage(getTileImage(x, y)); break;
                    case 32: i32.setImage(getTileImage(x, y)); break;
                    case 33: i33.setImage(getTileImage(x, y)); break;
                    case 34: i34.setImage(getTileImage(x, y)); break;
                    case 35: i35.setImage(getTileImage(x, y)); break;
                    case 36: i36.setImage(getTileImage(x, y)); break;
                    case 41: i41.setImage(getTileImage(x, y)); break;
                    case 43: i43.setImage(getTileImage(x, y)); break;
                    case 45: i45.setImage(getTileImage(x, y)); break;
                    case 50: i50.setImage(getTileImage(x, y)); break;
                    case 51: i51.setImage(getTileImage(x, y)); break;
                    case 52: i52.setImage(getTileImage(x, y)); break;
                    case 53: i53.setImage(getTileImage(x, y)); break;
                    case 54: i54.setImage(getTileImage(x, y)); break;
                    case 55: i55.setImage(getTileImage(x, y)); break;
                    case 56: i56.setImage(getTileImage(x, y)); break;
                    case 61: i61.setImage(getTileImage(x, y)); break;
                    case 63: i63.setImage(getTileImage(x, y)); break;
                    case 65: i65.setImage(getTileImage(x, y)); break;
                }
            }
        }
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
        int x, y;
        for(x = 0; x < 7; x++){
            for(y = 0; y < 7; y++){
            
            }
        
        }
    }
    
    
    
    
}
