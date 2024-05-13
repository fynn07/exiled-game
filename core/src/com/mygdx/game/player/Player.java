package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Intersector;
import com.mygdx.game.screens.Map;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.game.utilities.Animator;


import java.awt.*;

public class Player extends Sprite {
    public Map map;
    public SpriteBatch spriteBatch;
    public MapObjects objects;
    public Rectangle bounds;
    private Animator animator;
    private float stateTime;
    private float speed;
    private float X_COORD;
    private float Y_COORD;
    private float prev_x;
    private float prev_y;
    private int prev_movement;

    //Idle Textures
    private Texture Idle_0;
    private Texture Idle_1;
    private Texture Idle_2;
    private Texture Idle_3;
    private Texture Idle_4;
    private Texture Idle_5;
    private Texture Idle_6;
    private Texture Idle_7;


    //Movement textures
    private Texture runNorth;
    private Texture runNorthWest;
    private Texture runNorthEast;
    private Texture runSouth;
    private Texture runSouthWest;
    private Texture runSouthEast;
    private Texture runWest;
    private Texture runEast;

    //debugging



    public Player(Sprite sprite){
        super(sprite);
        map = new Map();
        objects = map.getCollissionObjects();
        animator = new Animator();
        spriteBatch = new SpriteBatch();
        prev_x = 0;
        prev_y = 0;
        stateTime = 0f;
        speed = 180 * 2;
        prev_movement = 3;
        X_COORD = 500;
        Y_COORD = 300;
        bounds = new Rectangle(3680, -300, getWidth(), getHeight());
        System.out.println(bounds);

        //Initializing Idle Textures
        Idle_0 = new Texture("assets/Characters/Male/Male_3_Idle0.png");
        Idle_1 = new Texture("assets/Characters/Male/Male_2_Idle0.png");
        Idle_2 = new Texture("assets/Characters/Male/Male_1_Idle0.png");
        Idle_3 = new Texture("assets/Characters/Male/Male_0_Idle0.png");
        Idle_4 = new Texture("assets/Characters/Male/Male_7_Idle0.png");
        Idle_5 = new Texture("assets/Characters/Male/Male_6_Idle0.png");
        Idle_6 = new Texture("assets/Characters/Male/Male_5_Idle0.png");
        Idle_7 = new Texture("assets/Characters/Male/Male_4_Idle0.png");

        //Initializing Movement Textures
        runNorth = new Texture(Gdx.files.internal("assets/Characters/Animations/run_N.png"));
        runNorthWest = new Texture(Gdx.files.internal("assets/Characters/Animations/run_NW.png"));
        runNorthEast = new Texture(Gdx.files.internal("assets/Characters/Animations/run_NE.png"));
        runSouth = new Texture(Gdx.files.internal("assets/Characters/Animations/run_S.png"));
        runSouthWest = new Texture(Gdx.files.internal("assets/Characters/Animations/run_SW.png"));
        runSouthEast = new Texture(Gdx.files.internal("assets/Characters/Animations/run_SE.png"));
        runWest = new Texture(Gdx.files.internal("assets/Characters/Animations/run_W.png"));
        runEast = new Texture(Gdx.files.internal("assets/Characters/Animations/run_E.png"));

    }

    //TODO Preload the textures to optimize performance

    public void handleMovement() {
        stateTime += Gdx.graphics.getDeltaTime() * 0.5f;
        TextureRegion currentFrame = null;

        for(RectangleMapObject rectangleObject : objects.getByType(RectangleMapObject.class)){
            Rectangle rectangle = rectangleObject.getRectangle();


            if(Intersector.overlaps(rectangle, bounds)){
                System.out.println("FINALLY");
            }
        }

        // Check for diagonal movement
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                currentFrame = animator.animate(runNorthWest).getKeyFrame(stateTime, true);
                float x = getX();
                float y = getY();
                prev_x = x;
                prev_y = y;
                this.setX(x -= Gdx.graphics.getDeltaTime() * speed / 1.5);
                this.setY(y += Gdx.graphics.getDeltaTime() * speed / 1.5);
                prev_movement = 5;
            } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                currentFrame = animator.animate(runNorthEast).getKeyFrame(stateTime, true);
                float x = getX();
                float y = getY();
                prev_x = x;
                prev_y = y;
                this.setX(x += Gdx.graphics.getDeltaTime() * speed / 1.5);
                this.setY(y += Gdx.graphics.getDeltaTime() * speed / 1.5);
                prev_movement = 3;
            } else {
                currentFrame = animator.animate(runNorth).getKeyFrame(stateTime, true);
                float y = getY();
                prev_y = y;
                this.setY(y += Gdx.graphics.getDeltaTime() * speed / 1.2);
                prev_movement = 4;
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                currentFrame = animator.animate(runSouthWest).getKeyFrame(stateTime, true);
                float x = getX();
                float y = getY();
                prev_x = x;
                prev_y = y;
                this.setX(x -= Gdx.graphics.getDeltaTime() * speed / 1.5);
                this.setY(y -= Gdx.graphics.getDeltaTime() * speed / 1.5);
                prev_movement = 7;
            } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                currentFrame = animator.animate(runSouthEast).getKeyFrame(stateTime, true);
                float x = getX();
                float y = getY();
                prev_x = x;
                prev_y = y;
                this.setX(x += Gdx.graphics.getDeltaTime() * speed / 1.5);
                this.setY(y -= Gdx.graphics.getDeltaTime() * speed / 1.5);
                prev_movement = 1;
            } else {
                currentFrame = animator.animate(runSouth).getKeyFrame(stateTime, true);
                float y = getY();
                prev_y = y;
                this.setY(y -= Gdx.graphics.getDeltaTime() * speed / 1.2);
                prev_movement = 0;
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            currentFrame = animator.animate(runWest).getKeyFrame(stateTime, true);
            float x = getX();
            prev_x = x;
            this.setX(x -= Gdx.graphics.getDeltaTime() * speed);
            prev_movement = 6;
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            currentFrame = animator.animate(runEast).getKeyFrame(stateTime, true);
            float x = getX();
            prev_x = x;
            this.setX(x += Gdx.graphics.getDeltaTime() * speed);
            prev_movement = 2;
        }

        spriteBatch.begin();
        if (currentFrame != null) {
            spriteBatch.draw(currentFrame, X_COORD, Y_COORD);
        }
        else{
            if(prev_movement == 0){
                spriteBatch.draw(Idle_0, X_COORD, Y_COORD);
            }
            if(prev_movement == 1){
                spriteBatch.draw(Idle_1, X_COORD, Y_COORD);
            }
            if(prev_movement == 2){
                spriteBatch.draw(Idle_2, X_COORD, Y_COORD);
            }
            if(prev_movement == 3){
                spriteBatch.draw(Idle_3, X_COORD, Y_COORD);
            }
            if(prev_movement == 4){
                spriteBatch.draw(Idle_4, X_COORD, Y_COORD);
            }
            if(prev_movement == 5){
                spriteBatch.draw(Idle_5, X_COORD, Y_COORD);
            }
            if(prev_movement == 6){
                spriteBatch.draw(Idle_6, X_COORD, Y_COORD);
            }
            if(prev_movement == 7){
                spriteBatch.draw(Idle_7, X_COORD, Y_COORD);
            }
        }
        bounds = new Rectangle(getX(), getY(), getWidth(), getHeight());
        spriteBatch.end();

    }


}
