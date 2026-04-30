package io.github.VaniaDinCahul.SillyColSim.map_handler;

import java.util.ArrayList;

public class TileStats{
    private int groundFertility;
//    private int moistureLevel;
    private ArrayList<ResourceNode> resourceNodes = new ArrayList<>();
//    private int movementCost;
    private float tileHeight;

    public TileStats(int setGroundFertility, float setTileHeight){
        this.groundFertility = setGroundFertility;
//        this.moistureLevel = setMoistureLevel;
//        this.movementCost = setMovementCost;
        this.tileHeight = setTileHeight;
    }

    public float getTileHeight() {
        return this.tileHeight;
    }

    public void addResourceNode(ResourceNode node) {
        this.resourceNodes.add(node);
    }
    public ResourceNode[] getResourceNodes() {
        ResourceNode[] tempList = new ResourceNode[this.resourceNodes.size()];
        for (int i = 0; i < this.resourceNodes.size(); i++) {
            tempList[i] = this.resourceNodes.get(i);
        }
        return tempList;
    }

}
//int setMoistureLevel, int setResourceNodeId, int setMovementCost,
