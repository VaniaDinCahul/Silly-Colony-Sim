package io.github.VaniaDinCahul.SillyColSim.map_handler;

public class TileStats{
    private int groundFertility;
    private int moistureLevel;
    private int resourceNodeId;
    private int movementCost;

    public TileStats(int setGroundFertility, int setMoistureLevel, int setResourceNodeId, int setMovementCost){
        this.groundFertility = setGroundFertility;
        this.moistureLevel = setMoistureLevel;
        this.resourceNodeId = setResourceNodeId;
        this.movementCost = setMovementCost;
    }
}
