package io.github.VaniaDinCahul.SillyColSim.map_handler;

public class ResourceNode {
    private String resourceName;
    private byte resourceType;
    private int resourceAmount;
    private boolean canRegenerate;
    private int regenPerTick;

    public ResourceNode(String setResourceName, byte setResourceType, int setResourceAmount, boolean setCanRegenerate, int setRegenPerTick){
        this.resourceName = setResourceName;
        this.resourceType = setResourceType;
        this.resourceAmount = setResourceAmount;
        this.canRegenerate = setCanRegenerate;
        this.regenPerTick = setRegenPerTick;
    }
}
