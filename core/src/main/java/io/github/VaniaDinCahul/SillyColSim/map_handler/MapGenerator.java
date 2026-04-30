package io.github.VaniaDinCahul.SillyColSim.map_handler;


import io.github.VaniaDinCahul.SillyColSim.Noise.FastNoiseLite;

public class MapGenerator {
    private final FastNoiseLite noise;

    private double[][] FertilityMap;
    private double[][] MoistureMap;
    private double[][] ResourceMap;
//    private double[][] MovmentMap;


    public MapGenerator() {
        this.noise = new FastNoiseLite((int)(Math.random() * 1000));

    }

    public float[][] generatePerlin2DMap(){
        noise.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2);

        float[][] tempMap = new float[120][120];

        for (int x = 0; x < 120; x++)
        {
            for (int y = 0; y < 120; y++)
            {
                if (noise.GetNoise(x, y) >= 0.9) {
                    tempMap[x][y] = 2;
                }

                if (noise.GetNoise(x, y) > 0.3 && noise.GetNoise(x, y) < 0.9) {
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

    public void generateResourceMap(){

    }

    public void generateMovmentCostMap(){

    }

   public Tile[][] generateMap(int width, int height) {
       Tile[][] tempMap = new Tile[width][height];
       float[][] heightMap = generatePerlin2DMap();

       for (int x = 0; x < width; x++) {
           for (int y = 0; y < height; y++) {
               TileStats tileStats = new TileStats(1, heightMap[x][y]);
               tempMap[x][y] = new Tile(x, y, tileStats);
           }
       }



       return tempMap;
   }
}
