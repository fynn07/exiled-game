package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.mygdx.game.animation.Animator;
import com.mygdx.game.player.Player;

public class Play implements Screen {
    private final IsometricTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private SpriteBatch spriteBatch;
    private Animator animator;
    private Player player;
    private float stateTime;

    // Initial zoom level
    private static final float INITIAL_ZOOM = 2.0f;
    // Zoom step for each key press
    private static final float ZOOM_STEP = 0.1f;

    public Play(){
        renderer = new Map().makeMap();
        player = new Player();
        spriteBatch = new SpriteBatch();
        animator = new Animator();
        stateTime = 0f;
    }

    @Override
    public void show() {

        // Initialize the orthographic camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Sets the initial stage for the level
        camera.position.set(3680, -60, 0);
        camera.zoom = 1.00f;
    }

    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        // Handles camera movement based on user input
        handleMovement();


        // Update the camera
        camera.update();

        // Set the camera view for the renderer and render the map
        renderer.setView(camera);
        renderer.render();
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
        //TODO
    }

    @Override
    public void resume() {
        //TODO
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        // Dispose of the map and renderer
        renderer.dispose();
    }

    // Method to handle zooming based on user input
    //TODO: Change to handle players
    private void handleMovement() {
        stateTime += Gdx.graphics.getDeltaTime() * 0.5f;
        TextureRegion currentFrame = null;

        boolean isMovingDiagonal = false;

        // Check for diagonal movement
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                currentFrame = animator.animate(player.runNorthWest()).getKeyFrame(stateTime, true);
                isMovingDiagonal = true;
            } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                currentFrame = animator.animate(player.runNorthEast()).getKeyFrame(stateTime, true);
                isMovingDiagonal = true;
            } else {
                currentFrame = animator.animate(player.runNorth()).getKeyFrame(stateTime, true);
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                currentFrame = animator.animate(player.runSouthWest()).getKeyFrame(stateTime, true);
                isMovingDiagonal = true;
            } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                currentFrame = animator.animate(player.runSouthEast()).getKeyFrame(stateTime, true);
                isMovingDiagonal = true;
            } else {
                currentFrame = animator.animate(player.runSouth()).getKeyFrame(stateTime, true);
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            currentFrame = animator.animate(player.runWest()).getKeyFrame(stateTime, true);
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            currentFrame = animator.animate(player.runEast()).getKeyFrame(stateTime, true);
        }

        spriteBatch.begin();
        if (currentFrame != null) {
            spriteBatch.draw(currentFrame, 50, 50);
        }
        spriteBatch.end();
    }



}
