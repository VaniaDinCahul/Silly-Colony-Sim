package io.github.VaniaDinCahul.SillyColSim.map_handler;

public class MapGenerator {
//    private final PerlinNoise noise;

    public MapGenerator() {
//        this.noise = new PerlinNoise();

    }

    public void generatePerlin2DMap(){

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
       for (int x = 0; x < width; x++) {
           for (int y = 0; y < height; y++) {
//               TileStats tileStats = new TileStats();
//               tempMap[x][y] = new Tile(x, y,);
           }
       }

       return tempMap;
   }
}
