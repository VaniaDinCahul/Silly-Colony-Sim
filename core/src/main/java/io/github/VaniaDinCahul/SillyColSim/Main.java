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


    @Override
    public void create() {
        // Prepare your application here.

        groundTexture = new Texture("forest/ForestSoil.png");
        spriteBatch = new SpriteBatch();
        viewport = new OrthographicCamera();


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
    public void render() {
        // Draw your application here.
        ScreenUtils.clear(new Color(0.47f, 0.6f, 0.64f, 1f));
        spriteBatch.setProjectionMatrix(viewport.combined);

        spriteBatch.begin();

        spriteBatch.draw(groundTexture, 1, 1, 1, 1);
        viewport.update();
        spriteBatch.end();
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
}
