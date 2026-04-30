package io.github.VaniaDinCahul.SillyColSim.map_handler;

public class TileStats{
    private int groundFertility;
//    private int moistureLevel;
//    private int resourceNodeId;
//    private int movementCost;
    private float tileHeight;

    public TileStats(int setGroundFertility, float setTileHeight){
        this.groundFertility = setGroundFertility;
//        this.moistureLevel = setMoistureLevel;
//        this.resourceNodeId = setResourceNodeId;
//        this.movementCost = setMovementCost;
        this.tileHeight = setTileHeight;
    }

    public float getTileHeight() {
        return this.tileHeight;
    }
}
//int setMoistureLevel, int setResourceNodeId, int setMovementCost,
