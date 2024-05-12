package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.mygdx.game.player.Player;

public class Play implements Screen {
    private final Map map;
    private ShapeRenderer shapeRenderer;
    private final IsometricTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private Player player;

    public Play(){
        map =  new Map();
        shapeRenderer = new ShapeRenderer();
        renderer = map.makeMap();
        player = new Player(new Sprite(new Texture("assets/Characters/Male/Male_0_Idle0.png")));
    }

    @Override
    public void show() {

        // Initialize the orthographic camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Sets the initial stage for the level
        camera.position.set(3680, -60, 0);
        player.setPosition(3680, -300);
        camera.zoom = 1.00f;
    }

    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Handles camera movement based on user input
        camera.position.set(player.getX() + player.getWidth() / 2, player.getY() + player.getHeight() / 2, 0);
        System.out.println(player.getX() + " " + player.getY());
        // Update the camera
        camera.update();
        // Set the camera view for the renderer and render the map
        renderData();
    }

    public void renderData(){
        renderer.setView(camera);
        renderer.render(new int[]{0, 2});

        player.handleMovement();
        shapeRenderer.end();
        renderer.render(new int[]{3});
        renderer.render(new int[]{4});
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
}
