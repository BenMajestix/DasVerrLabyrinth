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
        i03.setRotate(App.boardTiles[0][3].location.rotation);
        i05.setRotate(App.boardTiles[0][5].location.rotation);
        i10.setRotate(App.boardTiles[1][0].location.rotation);
        i11.setRotate(App.boardTiles[1][1].location.rotation);
        i12.setRotate(App.boardTiles[1][2].location.rotation);
        i13.setRotate(App.boardTiles[1][3].location.rotation);
        i14.setRotate(App.boardTiles[1][4].location.rotation);
        i15.setRotate(App.boardTiles[1][5].location.rotation);
        i16.setRotate(App.boardTiles[1][6].location.rotation);
        i21.setRotate(App.boardTiles[2][1].location.rotation);
        i23.setRotate(App.boardTiles[2][3].location.rotation);
        i25.setRotate(App.boardTiles[2][5].location.rotation);
        i30.setRotate(App.boardTiles[3][0].location.rotation);
        i31.setRotate(App.boardTiles[3][1].location.rotation);
        i32.setRotate(App.boardTiles[3][2].location.rotation);
        i33.setRotate(App.boardTiles[3][3].location.rotation);
        i34.setRotate(App.boardTiles[3][4].location.rotation);
        i35.setRotate(App.boardTiles[3][5].location.rotation);
        i36.setRotate(App.boardTiles[3][6].location.rotation);
        i41.setRotate(App.boardTiles[4][1].location.rotation);
        i43.setRotate(App.boardTiles[4][3].location.rotation);
        i45.setRotate(App.boardTiles[4][5].location.rotation);
        i50.setRotate(App.boardTiles[5][0].location.rotation);
        i51.setRotate(App.boardTiles[5][1].location.rotation);
        i52.setRotate(App.boardTiles[5][2].location.rotation);
        i53.setRotate(App.boardTiles[5][3].location.rotation);
        i54.setRotate(App.boardTiles[5][4].location.rotation);
        i55.setRotate(App.boardTiles[5][5].location.rotation);
        i56.setRotate(App.boardTiles[5][6].location.rotation);
        i61.setRotate(App.boardTiles[6][1].location.rotation);
        i63.setRotate(App.boardTiles[6][3].location.rotation);
        i65.setRotate(App.boardTiles[6][5].location.rotation);
    }

    @FXML
    private void currTileLeft(ActionEvent event) {
        currTile.setRotate(currTile.getRotate() + 90);
    }

    @FXML
    private void currTileRight(ActionEvent event) {
        currTile.setRotate(currTile.getRotate() - 90);
    }
    
    
    
    
}
