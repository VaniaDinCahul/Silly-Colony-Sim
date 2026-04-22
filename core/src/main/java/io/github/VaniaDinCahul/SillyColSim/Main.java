package io.github.VaniaDinCahul.SillyColSim;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main implements ApplicationListener {

    SpriteBatch spriteBatch;
    OrthographicCamera viewport;

    Texture groundTexture;

    float cameraSpeed;
    float cameraZoom;
    float TILE_WIDTH;
    float TILE_HEIGHT;


    @Override
    public void create() {
        // Prepare your application here.

        cameraSpeed = 1f;
        cameraZoom = 1f;
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

    }

    public void draw(){
        ScreenUtils.clear(new Color(0.47f, 0.6f, 0.64f, 1f));
        spriteBatch.setProjectionMatrix(viewport.combined);


        spriteBatch.begin();

        spriteBatch.draw(groundTexture, 1, 1, 1, 1);

        spriteBatch.end();
    }
}
