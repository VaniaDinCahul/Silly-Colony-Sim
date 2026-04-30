package io.github.VaniaDinCahul.SillyColSim;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;

public class CameraHandler extends InputAdapter {
    private final OrthographicCamera viewport;

    float cameraSpeed = 24f;
    final float ZOOM_SPEED = 0.05f;
    final float ZOOM_MAX = 3f;
    final float ZOOM_MIN = 0.5f;

    public CameraHandler(OrthographicCamera viewport) {
        this.viewport = viewport;
    }

    public void handleInput(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) viewport.position.x -= cameraSpeed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) viewport.position.x += cameraSpeed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) viewport.position.y += cameraSpeed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) viewport.position.y -= cameraSpeed * delta;
//        if (Gdx.input.isKeyPressed(Input.Keys.F2))
        viewport.update();
    }

    public void update(float delta){
        handleInput(delta);
    }
    @Override
    public boolean scrolled(float amountX, float amountY){
        viewport.zoom = MathUtils.clamp(viewport.zoom + amountY * ZOOM_SPEED, ZOOM_MIN, ZOOM_MAX);
        return true;
    }

}
