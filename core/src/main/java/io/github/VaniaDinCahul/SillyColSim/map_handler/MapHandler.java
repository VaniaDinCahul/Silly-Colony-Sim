package io.github.VaniaDinCahul.SillyColSim.map_handler;

public class MapHandler {
    private long mapHeight;
    private long mapWidth;
    private Tile[][] map;

    private MapGenerator mapGenerator = new MapGenerator();
    //long setMapHeight, long setMapWidth  --was in MaoHandler, but I temporarily moved it
    public MapHandler(){
        // generate some randomness for map gen

        this.map = mapGenerator.generateMap(120, 120);

    }

    public Tile[][] getMap(){
        return map;
    }

    public Tile getTile(int x, int y) {
        return map[x][y];
    }

    public TileStats getTileStats(int x, int y) {
        return map[x][y].getStats();
    }
}
