package io.github.VaniaDinCahul.SillyColSim.map_handler;

public class MapHandler {
    private long mapHeight;
    private long mapWidth;
    private Tile[][] map;

    private MapGenerator mapGenerator = new MapGenerator();
    //long setMapHeight, long setMapWidth  --was in MaoHandler, but I temporarily moved it
    public MapHandler(){
        // generate some randomness for map gen

    }

    public void generateMap() {
        this.map = this.mapGenerator.generateMap(120, 120);
    }

    public Tile[][] getMap(){
        return this.map;
    }

    public Tile getTile(int x, int y) {
        return this.map[x][y];
    }

    public TileStats getTileStats(int x, int y) {
        return this.map[x][y].getStats();
    }
}
