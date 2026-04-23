package io.github.VaniaDinCahul.SillyColSim.map_handler;

public class Tile{
    private int x;
    private int y;
    private TileStats stats;

    public Tile(int setTileX, int setTileY, TileStats setTileStats){
        this.x = setTileX;
        this.y = setTileY;
        this.stats = setTileStats;
    }


}
