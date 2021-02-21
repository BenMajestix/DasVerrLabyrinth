package com.benpaul.dasverrlabyrinth;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */

public class App extends Application {
    static ArrayList<tileModel> allTiles;
    static tileModel[][] boardTiles =  new tileModel[7][7];
    static tileModel offBoardTile;
    public static playerModel[] players;
    public static ArrayList<itemModel> allItems;
    
    private static Scene scene;
    
    boolean[] isBotList = new boolean[4];

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("homeView"), 1500, 1000);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("--Das Verrückte Labyrinth--");
        
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        players = new playerModel[4];
        allItems = new ArrayList();
        
        
        createCards();
        createGame();
        
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
                        case 0: boardTiles[x][y] = new tileModel(new locationModel(0, x, y, false), false, null, false, "turn", null); break;//oben links
                        //Wenn es ein Feld für eine Random Karte befüllt wird wird die getRandomTile Funktion aufgerufen
                        //Diese Funktion gibt ein Tile zurück, welches noch nicht benutzt ist.
                        case 1: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 2: boardTiles[x][y] = new tileModel(new locationModel(90, x, y, false), true, allItems.get(4), false, "t-crossing", null); break;
                        case 3: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 4: boardTiles[x][y] = new tileModel(new locationModel(90, x, y, false), true, allItems.get(2), false, "t-crossing", null); break;
                        case 5: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 6: boardTiles[x][y] = new tileModel(new locationModel(270, x, y, false), false, null, false, "turn", null); break;//Unten links
                    }
                }
                if(y == 2){
                    switch(x){
                        case 0: boardTiles[x][y] = new tileModel(new locationModel(180, x, y, false), true, allItems.get(20), false, "t-crossing", null); break;
                        case 1: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 2: boardTiles[x][y] = new tileModel(new locationModel(90, x, y, false), true, allItems.get(11), false, "t-crossing", null); break;
                        case 3: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 4: boardTiles[x][y] = new tileModel(new locationModel(0, x, y, false), true, allItems.get(5), false, "t-crossing", null); break;
                        case 5: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 6: boardTiles[x][y] = new tileModel(new locationModel(0, x, y, false), true, allItems.get(12), false, "t-crossing", null); break;
                    }
                }
                if(y == 4){
                    switch(x){
                        case 0: boardTiles[x][y] = new tileModel(new locationModel(180, x, y, false), true, allItems.get(22), false, "t-crossing", null); break;
                        case 1: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 2: boardTiles[x][y] = new tileModel(new locationModel(180, x, y, false), true, allItems.get(7), false, "t-crossing", null); break;
                        case 3: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 4: boardTiles[x][y] = new tileModel(new locationModel(270, x, y, false), true, allItems.get(3), false, "t-crossing", null); break;
                        case 5: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 6: boardTiles[x][y] = new tileModel(new locationModel(0, x, y, false), true, allItems.get(17), false, "t-crossing", null); break;
                    }
                }
                if(y == 6){
                    switch(x){
                        case 0: boardTiles[x][y] = new tileModel(new locationModel(90, x, y, false), false, null, false, "turn", null); break;//Oben rechts
                        case 1: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 2: boardTiles[x][y] = new tileModel(new locationModel(270, x, y, false), true, allItems.get(10), false, "t-crossing", null); break;
                        case 3: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 4: boardTiles[x][y] = new tileModel(new locationModel(270, x, y, false), true, allItems.get(1), false, "t-crossing", null); break;
                        case 5: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 6: boardTiles[x][y] = new tileModel(new locationModel(180, x, y, false), false, null, false, "turn", null); break;//unten rechts
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
        //Generiert eine Random Int, welche Max so groß ist wie die ArrList.
        int i = (int) (Math.random() * allTiles.size());
        //Dann wird das Random Tile Hier gespeichert
        tileModel tile = allTiles.get(i);
        //Und hier wird das Tile dann removed
        allTiles.remove(i);
        //Und zurückgegeben
        return tile;
    }
    
    public static int randomRotation(){
        int rotation;
        rotation = (int) (Math.random() * 4);
        switch(rotation){
            case 0: rotation = 0; break;
            case 1: rotation = 90; break;
            case 2: rotation = 180; break;
            case 3: rotation = 270; break;
        
        }
        return rotation;
    }
    
    public static void createTiles(){
        allTiles = new ArrayList();
        
        File file = new File("src/main/resources/all_tiles/straight.png");
        File fileT = new File("src/main/resources/all_tiles/turn.png");
        File file1 = new File("src/main/resources/all_tiles/bat.png");
        File file2 = new File("src/main/resources/all_tiles/dragon.png");
        File file3 = new File("src/main/resources/all_tiles/ghost.png");
        File file4 = new File("src/main/resources/all_tiles/gnome.png");
        File file5 = new File("src/main/resources/all_tiles/moth.png");
        File file6 = new File("src/main/resources/all_tiles/mouse.png");
        File file7 = new File("src/main/resources/all_tiles/owl.png");
        File file8 = new File("src/main/resources/all_tiles/poltergeist.png");
        File file9 = new File("src/main/resources/all_tiles/salamander.png");
        File file0 = new File("src/main/resources/all_tiles/scarab.png");
        File file10 = new File("src/main/resources/all_tiles/spider.png");
        File file11 = new File("src/main/resources/all_tiles/witch.png");
        
        
        
        //CORNERS
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn", new Image(fileT.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn", new Image(fileT.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn", new Image(fileT.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn", new Image(fileT.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn", new Image(fileT.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn", new Image(fileT.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn", new Image(fileT.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn", new Image(fileT.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn", new Image(fileT.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn", new Image(fileT.toURI().toString())));
        //turns with tiles
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, allItems.get(15), false, "turn", new Image(file7.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, allItems.get(13), false, "turn", new Image(file5.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, allItems.get(14), false, "turn", new Image(file6.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, allItems.get(21), false, "turn", new Image(file10.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, allItems.get(19), false, "turn", new Image(file0.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, allItems.get(18), false, "turn", new Image(file9.toURI().toString())));
        
        //STRAIGHTS
        //all empty
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, allItems.get(23), false, "t-crossing", new Image(file11.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, allItems.get(6), false, "t-crossing", new Image(file2.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, allItems.get(16), false, "t-crossing", new Image(file8.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, allItems.get(8), false, "t-crossing", new Image(file3.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, allItems.get(0), false, "t-crossing", new Image(file1.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, allItems.get(9), false, "t-crossing", new Image(file4.toURI().toString())));
    }
    
    public static itemModel getRndmItem(){
        int rndm = (int) (Math.random() * allItems.size());
        itemModel item = allItems.get(rndm);
        allItems.remove(rndm);
        return item;
    }
    
    public static void createCards(){
        File batFile = new File("src/main/resources/img/batCard.png");
        File candleHolderFile = new File("src/main/resources/img/candleHolderCard.png");
        File bibleFile = new File("src/main/resources/img/bibleCard.png");
        File chestFile = new File("src/main/resources/img/chestCard.png");
        File coinsFile = new File("src/main/resources/img/coinsCard.png");
        File crownFile = new File("src/main/resources/img/crownCard.png");
        File dragonFile = new File("src/main/resources/img/dragonCard.png");
        File emeraldFile = new File("src/main/resources/img/emeraldCard.png");
        File ghostFile = new File("src/main/resources/img/ghostCard.png");
        File gnomeFile = new File("src/main/resources/img/gnomeCard.png");
        File helmetFile = new File("src/main/resources/img/helmetCard.png");
        File keysFile = new File("src/main/resources/img/keysCard.png");
        File mapFile = new File("src/main/resources/img/mapCard.png");
        File mothFile = new File("src/main/resources/img/mothCard.png");
        File mouseFile = new File("src/main/resources/img/mouseCard.png");
        File owlFile = new File("src/main/resources/img/owlCard.png");
        File poltergeistFile = new File("src/main/resources/img/poltergeistCard.png");
        File ringFile = new File("src/main/resources/img/ringCard.png");
        File salamanderFile = new File("src/main/resources/img/salamanderCard.png");
        File scarabFile = new File("src/main/resources/img/scarabCard.png");
        File skullFile = new File("src/main/resources/img/skullCard.png");
        File spiderFile = new File("src/main/resources/img/spiderCard.png");
        File swordFile = new File("src/main/resources/img/swordCard.png");
        File witchFile = new File("src/main/resources/img/witchCard.png");
        
        itemModel batItem = new itemModel("Bat", new Image(batFile.toURI().toString()));
        itemModel candleHolderItem = new itemModel("CandleHolder", new Image(candleHolderFile.toURI().toString()));
        itemModel bibleItem = new itemModel("Bible", new Image(bibleFile.toURI().toString()));
        itemModel chestItem = new itemModel("Chest", new Image(chestFile.toURI().toString()));
        itemModel coinsItem = new itemModel("Coins", new Image(coinsFile.toURI().toString()));
        itemModel crownItem = new itemModel("Crown", new Image(crownFile.toURI().toString()));
        itemModel dragonItem = new itemModel("Dragon", new Image(dragonFile.toURI().toString()));
        itemModel emeraldItem = new itemModel("Emerald", new Image(emeraldFile.toURI().toString()));
        itemModel ghostItem = new itemModel("Ghost", new Image(ghostFile.toURI().toString()));
        itemModel gnomeItem = new itemModel("Gnome", new Image(gnomeFile.toURI().toString()));
        itemModel helmetItem = new itemModel("Helmet", new Image(helmetFile.toURI().toString()));
        itemModel keysItem = new itemModel("Keys", new Image(keysFile.toURI().toString()));
        itemModel mapItem = new itemModel("Map", new Image(mapFile.toURI().toString()));
        itemModel mothItem = new itemModel("Moth", new Image(mothFile.toURI().toString()));
        itemModel mouseItem = new itemModel("Mouse", new Image(mouseFile.toURI().toString()));
        itemModel owlItem = new itemModel("Owl", new Image(owlFile.toURI().toString()));
        itemModel poltergeistItem = new itemModel("Poltergeist", new Image(poltergeistFile.toURI().toString()));
        itemModel ringItem = new itemModel("Ring", new Image(ringFile.toURI().toString()));
        itemModel salamanderItem = new itemModel("Salamander", new Image(salamanderFile.toURI().toString()));
        itemModel scarabItem = new itemModel("Scarab", new Image(scarabFile.toURI().toString()));
        itemModel skullItem = new itemModel("Skull", new Image(skullFile.toURI().toString()));
        itemModel spiderItem = new itemModel("Spider", new Image(spiderFile.toURI().toString()));
        itemModel swordItem = new itemModel("Sword", new Image(swordFile.toURI().toString()));
        itemModel witchItem = new itemModel("Witch", new Image(witchFile.toURI().toString()));
        
        allItems.add(batItem);
        allItems.add(candleHolderItem);
        allItems.add(bibleItem);
        allItems.add(chestItem);
        allItems.add(coinsItem);
        allItems.add(crownItem);//5
        allItems.add(dragonItem);
        allItems.add(emeraldItem);
        allItems.add(ghostItem);
        allItems.add(gnomeItem);
        allItems.add(helmetItem);//10
        allItems.add(keysItem);
        allItems.add(mapItem);
        allItems.add(mothItem);
        allItems.add(mouseItem);
        allItems.add(owlItem);//15
        allItems.add(poltergeistItem);
        allItems.add(ringItem);
        allItems.add(salamanderItem);
        allItems.add(scarabItem);
        allItems.add(skullItem);//20
        allItems.add(spiderItem);
        allItems.add(swordItem);
        allItems.add(witchItem);
    }
    
    public void resetGame(){
        for(int i = 0; i < 4; i++){
            players[i] = null;
        }
        for(int i = 0; i < 7; i++){
            for(int o = 0; o < 7; o++){
                boardTiles[i][o] = null;
            }
        }
        offBoardTile = null;
        
        createGame();
    }
    
    public static void createGame(){
        createTiles();
        createBoard();
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