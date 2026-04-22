public class MapHandler {
    public MapHandler(long setMapHeight, long setMapWidth){
        // generate some randomness for map gen


    }


    private bool GenerateMap(long setMapHeight, long setMapWidth /* terrain randomness (perlin noise), resource randomness (idfk) */){

    }

    private long mapHeight;
    private long mapWidth;
    private mapData Tile[][];
}

public class ResourceNode{
    public ResourceNode(String setResourceName, byte setResourceType, int setResourceAmount, boolean setCanRegenerate, int setRegenPerTick){
        this.resourceName = setResourceName;
        this.resourceType = setResourceType;
        this.resourceAmount = setResourceAmount;
        this.canRegenerate = setCanRegenerate;
        this.regenPerTick = setRegenPerTick;
    }


    private String resourceName;
    private byte resourceType;
    private int resourceAmount;
    private boolean canRegenerate;
    private int regenPerTick; 
}

// resource nodes stats, probably move into separate config file
ResourceNode[] resNodesStats = {
    new ResourceNode("grass"),
    new ResourceNode("rock"),
};


public class TileStats{
    public TileStats(int setGroundFertility, int setMoistureLevel, int setResourceNodeId, int setMovementCost){
        this.groundFertility = setGroundFertility;
        this.moistureLevel = setMoistureLevel;
        this.resourceNodeId = setResourceNodeId;
        this.movementCost = setMovementCost;
    }

    private int groundFertility;
    private int moistureLevel;
    private int resourceNodeId;
    private int movementCost;
}

public class Tile{

    public Tile(int setTileX, int setTileY, TileStats setTileStats){
        this.x = setTileX;
        this.y = setTileY;
        this.stats = setTileStats;
    }

    private int x;
    private int y;
    private TileStats stats;
}
