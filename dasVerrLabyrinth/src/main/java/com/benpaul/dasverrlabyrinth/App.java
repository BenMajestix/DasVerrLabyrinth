package com.benpaul.dasverrlabyrinth;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {
    static ArrayList<tileModel> allTiles;
    static tileModel[][] boardTiles =  new tileModel[7][7];
    tileModel offBoardTile;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("homeView"), 640, 480);
        stage.setScene(scene);
        stage.show();
        
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        
        createTiles();
        createBoard();
        
        launch();
    }

    public static int randomRotation(){
        int rotation;
        rotation = (int) (Math.random() * 4);
        return rotation;
    }
    
    public static void createBoard(){
        int x;
        int y;
        
        for(x = 0; x < 7; x++){
            for(y = 0; y < 7; y++){
                //Reihe 1
                if(y == 0){
                    switch(x){
                        case 0: boardTiles[x][y] = new tileModel(new locationModel(0, x, y, false), false, null, false, "corner"); break;//oben links
                        case 1: boardTiles[x][y] = getRandomTile(); break;
                        case 2: boardTiles[x][y] = new tileModel(new locationModel(2, x, y, false), true, "helmet", false, "t-crossing"); break;
                        case 3: boardTiles[x][y] = getRandomTile(); break;
                        case 4: boardTiles[x][y] = new tileModel(new locationModel(2, x, y, false), true, "candleHolder", false, "t-crossing"); break;
                        case 5: boardTiles[x][y] = getRandomTile(); break;
                        case 6: boardTiles[x][y] = new tileModel(new locationModel(1, x, y, false), false, null, false, "corner"); break;//oben rechts
                    }
                }
                if(y == 2){
                    switch(x){
                        case 0: boardTiles[x][y] = new tileModel(new locationModel(1, x, y, false), true, "sword", false, "t-crossing"); break;
                        case 1: boardTiles[x][y] = getRandomTile(); break;
                        case 2: boardTiles[x][y] = new tileModel(new locationModel(1, x, y, false), true, "emerald", false, "t-crossing"); break;
                        case 3: boardTiles[x][y] = getRandomTile(); break;
                        case 4: boardTiles[x][y] = new tileModel(new locationModel(2, x, y, false), true, "chest", false, "t-crossing"); break;
                        case 5: boardTiles[x][y] = getRandomTile(); break;
                        case 6: boardTiles[x][y] = new tileModel(new locationModel(3, x, y, false), true, "ring", false, "t-crossing"); break;
                    }
                }
                if(y == 4){
                    switch(x){
                        case 0: boardTiles[x][y] = new tileModel(new locationModel(1, x, y, false), true, "skull", false, "t-crossing"); break;
                        case 1: boardTiles[x][y] = getRandomTile(); break;
                        case 2: boardTiles[x][y] = new tileModel(new locationModel(0, x, y, false), true, "keys", false, "t-crossing"); break;
                        case 3: boardTiles[x][y] = getRandomTile(); break;
                        case 4: boardTiles[x][y] = new tileModel(new locationModel(3, x, y, false), true, "crown", false, "t-crossing"); break;
                        case 5: boardTiles[x][y] = getRandomTile(); break;
                        case 6: boardTiles[x][y] = new tileModel(new locationModel(3, x, y, false), true, "map", false, "t-crossing"); break;
                    }
                }
                if(y == 6){
                    switch(x){
                        case 0: boardTiles[x][y] = new tileModel(new locationModel(3, x, y, false), false, null, false, "corner"); break;//unten links
                        case 1: boardTiles[x][y] = getRandomTile(); break;
                        case 2: boardTiles[x][y] = new tileModel(new locationModel(0, x, y, false), true, "coins", false, "t-crossing"); break;
                        case 3: boardTiles[x][y] = getRandomTile(); break;
                        case 4: boardTiles[x][y] = new tileModel(new locationModel(0, x, y, false), true, "bible", false, "t-crossing"); break;
                        case 5: boardTiles[x][y] = getRandomTile(); break;
                        case 6: boardTiles[x][y] = new tileModel(new locationModel(4, x, y, false), false, null, false, "corner"); break;//unten rechts
                    }
                }
                if(y == 1 || y == 3 || y == 5){
                    boardTiles[x][y] = getRandomTile(); 
                }
            }
        }
    }
    
    
    public static tileModel getRandomTile(){
        tileModel tile;
        int i = (int) (Math.random() * allTiles.size());
        tile = allTiles.get(i);
        return tile;
    }
    
    
    
    
    public static void createTiles(){
        allTiles = new ArrayList();
        //CORNERS
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        //corners with tiles
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "owl", false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "moth", false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "mouse", false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "spider", false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "scarab", false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "salamander", false, "corner"));
        
        //STRAIGHTS
        //all empty
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "witch", false, "t-crossing"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "dragon", false, "t-crossing"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "poltergeist", false, "t-crossing"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "ghost", false, "t-crossing"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "bat", false, "t-crossing"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "gnome", false, "t-crossing"));
    }
    
    
    public tileModel[][] getBoardTiles() {
        return boardTiles;
    }

    public void setBoardTiles(tileModel[][] boardTiles) {
        this.boardTiles = boardTiles;
    }

    public tileModel getTileOutOfGame() {
        return offBoardTile;
    }

    public void setTileOutOfGame(tileModel tileOutOfGame) {
        this.offBoardTile = tileOutOfGame;
    }

    
    
}