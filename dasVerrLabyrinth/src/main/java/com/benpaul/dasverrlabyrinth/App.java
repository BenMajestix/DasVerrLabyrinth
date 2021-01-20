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
    static tileModel offBoardTile;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("homeView"), 1500, 1000);
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

    
    public static void createBoard(){
        //Erstellt das Board und setzt die Karten auf das Bord.
        //Die festen Karten werden festgesetzt, die anderen Slots werden Random mit anderen Karten besetzt
        //Die letzte Karte wird außerhalb des Spiels als Handkarte gespeichert
        int x;
        int y;
        //Es werden alle x-Koordinaten durchgegangen
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
                        case 1: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
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
                //Alle Plätze in den Spalten 1, 3 und 5 werden immer mit Random Tiles besetzt.
                if(y == 1 || y == 3 || y == 5){
                    boardTiles[x][y] = getRandomTile(); 
                    boardTiles[x][y].location.xCoor = x; 
                    boardTiles[x][y].location.yCoor = y; 
                }
            }
        }
        //Das letzte übrige Tile wird auserhalb des Spiels platziert
        offBoardTile = getRandomTile();
    }
    
    
    
    
    
    
    public static tileModel getRandomTile(){
        int i = (int) (Math.random() * allTiles.size());
        tileModel tile = allTiles.get(i);
        allTiles.remove(i);
        return tile;
    }
    
    public static int randomRotation(){
        int rotation;
        rotation = (int) (Math.random() * 4);
        return rotation;
    }
    
    public static void createTiles(){
        allTiles = new ArrayList();
        //CORNERS
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn"));
        //turns with tiles
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "owl", false, "turn"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "moth", false, "turn"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "mouse", false, "turn"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "spider", false, "turn"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "scarab", false, "turn"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "salamander", false, "turn"));
        
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