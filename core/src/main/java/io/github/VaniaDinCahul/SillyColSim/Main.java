package io.github.VaniaDinCahul.SillyColSim;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.VaniaDinCahul.SillyColSim.map_handler.MapHandler;
import io.github.VaniaDinCahul.SillyColSim.map_handler.ResourceNode;
import io.github.VaniaDinCahul.SillyColSim.map_handler.Tile;

public class Main implements ApplicationListener {

    Tile[][] gameMap;

    MapHandler mapManager;

    SpriteBatch spriteBatch;
    OrthographicCamera viewport;
    CameraHandler cameraManager;

    Texture groundTexture;
    Texture wallTexture;
    Texture rockTexture;
    Texture waterTexture;
    Texture coalDebugTexture;
    Texture copperDebugTexture;

    public final float TILE_W = 2f;
    public final float TILE_H = 1f;
    public final float VIEWPORT_W = 16f;
    public final float VIEWPORT_H = 16f;

    public boolean RESOURCE_DEBUG_TOGGLE;

    @Override
    public void create() {
        // Prepare your application here.

        //GDX feature thingy idk
        spriteBatch = new SpriteBatch();
        viewport = new OrthographicCamera(VIEWPORT_W, VIEWPORT_H);

        // Game Managers/Handlers
        mapManager = new MapHandler();
        cameraManager = new CameraHandler(viewport);

        // Defining Variables
        RESOURCE_DEBUG_TOGGLE = true;

        // Textures
        groundTexture = new Texture("forest/ForestSoil.png");
        waterTexture = new Texture("water/Water.png");
        rockTexture = new Texture("rock/Rock.png");
        wallTexture = new Texture("BlankTile.png");

        coalDebugTexture = new Texture("BlankTile.png");
        copperDebugTexture = new Texture("BlankTileOrange.png");

        // Run Code and stuff IDK

        mapManager.generateMap();
        gameMap = mapManager.getMap();
        Gdx.input.setInputProcessor(cameraManager);

        viewport.update();
    }

    @Override
    public void resize(int width, int height) {
        // If the window is minimized on a desktop (LWJGL3) platform, width and height are 0, which causes problems.
        // In that case, we don't resize anything, and wait for the window to be a normal size before updating.
        if(width <= 0 || height <= 0) return;

        // Resize your application here. The parameters represent the new window size.
    }

    @Override
    public void render(){

        cameraManager.update(Gdx.graphics.getDeltaTime());
        draw();

    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void dispose() {
        // Destroy application's resources here.
        spriteBatch.dispose();
        groundTexture.dispose();
        waterTexture.dispose();
        wallTexture.dispose();
        rockTexture.dispose();
    }

    public void draw(){
        ScreenUtils.clear(new Color(0.47f, 0.6f, 0.64f, 1f));
        spriteBatch.setProjectionMatrix(viewport.combined);


        spriteBatch.begin();

        for (int x = 0; x < 120; x++) {
            for (int y = 0; y < 120; y++) {

                float screenX = (x-y) * TILE_W / 2f;
                float screenY = (x+y) * TILE_H / 2f;

                float TileHeight = gameMap[x][y].getStats().getTileHeight();

                Texture tex = groundTexture;
                if (TileHeight == 0) {
                    tex = waterTexture;
                }
                if (TileHeight == 2) {
                    tex = rockTexture;
                }

                spriteBatch.draw(tex,screenX ,screenY, TILE_W, TILE_H);

                if (RESOURCE_DEBUG_TOGGLE) {
                    ResourceNode[] tileResourceNodes = gameMap[x][y].getStats().getResourceNodes();
                    if (tileResourceNodes.length > 0){
                        for (int i = 0; i < tileResourceNodes.length; i++) {
                            if (tileResourceNodes[i].getResourceType() == ResourceNode.ResourceType.Coal) {

//                                spriteBatch.setColor(1, 1, 1, tileResourceNodes[i].getResourceAmount());
                                spriteBatch.draw(coalDebugTexture, screenX, screenY, TILE_W, TILE_H);
                            }

                            if (tileResourceNodes[i].getResourceType() == ResourceNode.ResourceType.Copper) {
//                                spriteBatch.setColor(1, 1, 1, tileResourceNodes[i].getResourceAmount());
                                spriteBatch.draw(copperDebugTexture, screenX, screenY, TILE_W, TILE_H);
                            }
                        }
                    }
                }
            }
        }

        spriteBatch.end();
    }
}
