package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;

public class Play implements Screen {
    private TiledMap map;
    private IsometricTiledMapRenderer renderer;
    private OrthographicCamera camera;

    // Initial zoom level
    private static final float INITIAL_ZOOM = 2.0f;
    // Zoom step for each key press
    private static final float ZOOM_STEP = 0.1f;

    @Override
    public void show() {
        // Load the tiled map
        map = new TmxMapLoader().load("map/exiled.tmx");

        // Create the isometric tiled map renderer
        renderer = new IsometricTiledMapRenderer(map);

        // Initialize the orthographic camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Set the initial zoom level
        camera.position.set(3680, -60, 0);
        camera.zoom = 1.00f;
    }

    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Handle zooming based on user input
        handleMovement();



        // Update the camera
        camera.update();

        // Set the camera view for the renderer and render the map
        renderer.setView(camera);
        renderer.render();
    }

    // Method to handle zooming based on user input
    private void handleMovement() {
        // Zoom in with the plus key
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            camera.position.x -= 10;
        }
        // Zoom out with the minus key
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            camera.position.x += 10;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            camera.position.y += 10;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            camera.position.y -= 10;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.P)) {
            camera.zoom += ZOOM_STEP;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.MINUS)) {
            camera.zoom -= ZOOM_STEP;
        }

    }

    @Override
    public void resize(int width, int height) {
        // Update the camera's viewport size
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();
    }

    @Override
    public void pause() {
        // No special logic needed for pause in this example
    }

    @Override
    public void resume() {
        // No special logic needed for resume in this example
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        // Dispose of the map and renderer
        map.dispose();
        renderer.dispose();
    }
}
