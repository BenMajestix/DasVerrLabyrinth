/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benpaul.dasverrlabyrinth;

import static com.benpaul.dasverrlabyrinth.App.boardTiles;
import static com.benpaul.dasverrlabyrinth.App.offBoardTile;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author benbartel
 */
public class GameController implements Initializable {


    @FXML
    private ImageView imgTile1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    }
}
