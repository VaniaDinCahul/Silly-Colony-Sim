package io.github.VaniaDinCahul.SillyColSim.map_handler;



public class ResourceNode {
    private String resourceName;
    private ResourceType resourceType;
    private int resourceAmount;
    private boolean canRegenerate;
    private int regenPerTick;

    public ResourceNode(ResourceType setResourceType, int setResourceAmount, boolean setCanRegenerate, int setRegenPerTick){
        this.resourceType = setResourceType;
        this.resourceAmount = setResourceAmount;
        this.canRegenerate = setCanRegenerate;
        this.regenPerTick = setRegenPerTick;
    }

    public int getResourceAmount(){
        return this.resourceAmount;
    }

    public ResourceType getResourceType(){
        return this.resourceType;
    }

    public enum ResourceType
    {
        Copper,
        Coal
    };
}
