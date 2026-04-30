package io.github.VaniaDinCahul.SillyColSim.map_handler;


import io.github.VaniaDinCahul.SillyColSim.Noise.FastNoiseLite;

public class MapGenerator {
    private final FastNoiseLite noise;

    private double[][] FertilityMap;
    private double[][] MoistureMap;
    private double[][] ResourceMap;
//    private double[][] MovementMap;


    public MapGenerator() {
        this.noise = new FastNoiseLite();

    }

    public float[][] generatePerlin2DMap(){

        //config of the noise
        noise.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2);
        noise.SetFractalType(FastNoiseLite.FractalType.Ridged);

//        noise.SetFractalGain(0.4f);
//        noise.SetFractalOctaves(6);
//        noise.SetFractalLacunarity(2.2f);
//        noise.SetFrequency(0.007f);


        // code itself
        float[][] tempMap = new float[120][120];

        for (int x = 0; x < 120; x++)
        {
            for (int y = 0; y < 120; y++)
            {
                if (noise.GetNoise(x, y) >= 0.85) {
                    tempMap[x][y] = 2;
                }

                if (noise.GetNoise(x, y) > 0.3 && noise.GetNoise(x, y) < 0.85) {
                    tempMap[x][y] = 1;
                }

                if (noise.GetNoise(x, y) <= 0.3) {
                    tempMap[x][y] = 0;
                }
            }
        }

        return tempMap;
    }

    public void generateFertilityMap(){

    }

    public void generateMoistureMap(){

    }

    public float[][] generateResourceMap(){
        float[][] tempMap = new float[120][120];
        noise.SetNoiseType(FastNoiseLite.NoiseType.Cellular);
        noise.SetCellularDistanceFunction(FastNoiseLite.CellularDistanceFunction.Hybrid);
        noise.SetCellularReturnType(FastNoiseLite.CellularReturnType.CellValue);
        noise.SetFrequency(0.2f);

        for (int x = 0; x < 120; x++)
        {
            for (int y = 0; y < 120; y++)
            {
                tempMap[x][y] = noise.GetNoise(x, y);
            }
        }

        return tempMap;
    }

    public void generateMovmentCostMap(){

    }

   public Tile[][] generateMap(int width, int height) {
       double heightmapSeed = changeMapSeed();
       double copperSeed = changeMapSeed();
       double coalSeed = changeMapSeed();


       Tile[][] tempMap = new Tile[width][height];

       setMapSeed((int)heightmapSeed);
       float[][] heightMap = generatePerlin2DMap();
       setMapSeed((int)copperSeed);
       float[][] copperResourceMap = generateResourceMap();
       setMapSeed((int)coalSeed);
       float[][] coalResourceMap = generateResourceMap();

       for (int x = 0; x < width; x++) {
           for (int y = 0; y < height; y++) {
               TileStats tileStats = new TileStats(1, heightMap[x][y]);

               if (tileStats.getTileHeight() == 1) { // You see?
                   if (copperResourceMap[x][y] > 0.5) {
                       ResourceNode resourceNode = new ResourceNode(
                           ResourceNode.ResourceType.Copper,
                           (int)(copperResourceMap[x][y] * 0.5),
                           false,
                           0);
                       tileStats.addResourceNode(resourceNode);
                   }

                   if (coalResourceMap[x][y] > 0.5) {
                       ResourceNode resourceNode = new ResourceNode(
                           ResourceNode.ResourceType.Coal,
                           (int)(copperResourceMap[x][y] * 0.5),
                           false,
                           0);
                       tileStats.addResourceNode(resourceNode);
                   }
               }



               tempMap[x][y] = new Tile(x, y, tileStats);
           }
       }



       return tempMap;
   }

   public void setMapSeed(int seed){
       noise.SetSeed(seed);
   }

   public double changeMapSeed() {
        return Math.random() * 1000;
   }
}
