package io.github.VaniaDinCahul.SillyColSim;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.VaniaDinCahul.SillyColSim.map_handler.MapHandler;

public class Main implements ApplicationListener {

    MapHandler mapManager;

    SpriteBatch spriteBatch;
    OrthographicCamera viewport;

    Texture groundTexture;

    float cameraSpeed;
    float cameraZoom;
    float TILE_WIDTH;
    float TILE_HEIGHT;

    public final int MAP_WIDTH = 120;
    public final int MAP_HEIGHT = 120;

    @Override
    public void create() {
        // Prepare your application here.
        mapManager = new MapHandler();


        cameraSpeed = 24f;
        cameraZoom = 4f;
        TILE_WIDTH = 128f;
        TILE_HEIGHT = 64f;

        groundTexture = new Texture("forest/ForestSoil.png");
        spriteBatch = new SpriteBatch();
        viewport = new OrthographicCamera(16, 16);

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

        update(Gdx.graphics.getDeltaTime());
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
    }

    public void update(float delta){
        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            viewport.position.x -= cameraSpeed * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            viewport.position.x += cameraSpeed * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            viewport.position.y += cameraSpeed * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            viewport.position.y -= cameraSpeed * delta;
        }

        viewport.update();
    }

    public void draw(){
        ScreenUtils.clear(new Color(0.47f, 0.6f, 0.64f, 1f));
        spriteBatch.setProjectionMatrix(viewport.combined);


        spriteBatch.begin();

        for (int x = 0; x < 120; x++) {
            for (int y = 0; y < 120; y++) {

                float screenX = (x-y) * cameraZoom;
                float screenY = (x+y) * cameraZoom/2f;

                spriteBatch.draw(groundTexture,screenX ,screenY, cameraZoom*2f, cameraZoom);
            }
        }

        spriteBatch.end();
    }
}
