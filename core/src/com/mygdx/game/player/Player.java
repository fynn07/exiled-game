package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.animation.Animator;
import com.mygdx.game.screens.Play;

public class Player extends Sprite {
    private SpriteBatch spriteBatch;
    private Animator animator;
    private float stateTime;
    private float speed;
    private int prev_movement;
    private float X_COORD;
    private float Y_COORD;
    private float x;
    private float y;

    public Player(Sprite sprite){
        super(sprite);
        animator = new Animator();
        spriteBatch = new SpriteBatch();
        stateTime = 0f;
        speed = 180 * 2;
        prev_movement = 0;
        X_COORD = 500;
        Y_COORD = 300;
        x = this.getX();
        y = this.getY();
    }

    public Texture runNorth(){
        return new Texture(Gdx.files.internal("assets/Characters/Animations/run_N.png"));
    }
    public Texture runNorthWest(){
        return new Texture(Gdx.files.internal("assets/Characters/Animations/run_NW.png"));
    }
    public Texture runNorthEast(){
        return new Texture(Gdx.files.internal("assets/Characters/Animations/run_NE.png"));
    }
    public Texture runSouth(){
        return new Texture(Gdx.files.internal("assets/Characters/Animations/run_S.png"));
    }
    public Texture runSouthWest(){
        return new Texture(Gdx.files.internal("assets/Characters/Animations/run_SW.png"));
    }
    public Texture runSouthEast(){
        return new Texture(Gdx.files.internal("assets/Characters/Animations/run_SE.png"));
    }
    public Texture runWest(){
        return new Texture(Gdx.files.internal("assets/Characters/Animations/run_W.png"));
    }
    public Texture runEast(){
        return new Texture(Gdx.files.internal("assets/Characters/Animations/run_E.png"));
    }

    //TODO: Change to handle players
    public void handleMovement() {
        stateTime += Gdx.graphics.getDeltaTime() * 0.5f;
        TextureRegion currentFrame = null;


        // Check for diagonal movement
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                currentFrame = animator.animate(runNorthWest()).getKeyFrame(stateTime, true);
                float x = getX();
                float y = getY();
                this.setX(x -= Gdx.graphics.getDeltaTime() * speed / 1.5);
                this.setY(y += Gdx.graphics.getDeltaTime() * speed / 1.5);
                prev_movement = 5;
            } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                currentFrame = animator.animate(runNorthEast()).getKeyFrame(stateTime, true);
                float x = getX();
                float y = getY();
                this.setX(x += Gdx.graphics.getDeltaTime() * speed / 1.5);
                this.setY(y += Gdx.graphics.getDeltaTime() * speed / 1.5);
                prev_movement = 3;
            } else {
                currentFrame = animator.animate(runNorth()).getKeyFrame(stateTime, true);
                float y = getY();
                this.setY(y += Gdx.graphics.getDeltaTime() * speed / 1.2);
                prev_movement = 4;
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                currentFrame = animator.animate(runSouthWest()).getKeyFrame(stateTime, true);
                float x = getX();
                float y = getY();
                this.setX(x -= Gdx.graphics.getDeltaTime() * speed / 1.5);
                this.setY(y -= Gdx.graphics.getDeltaTime() * speed / 1.5);
                prev_movement = 7;
            } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                currentFrame = animator.animate(runSouthEast()).getKeyFrame(stateTime, true);
                float x = getX();
                float y = getY();
                this.setX(x += Gdx.graphics.getDeltaTime() * speed / 1.5);
                this.setY(y -= Gdx.graphics.getDeltaTime() * speed / 1.5);
                prev_movement = 1;
            } else {
                currentFrame = animator.animate(runSouth()).getKeyFrame(stateTime, true);
                float y = getY();
                this.setY(y -= Gdx.graphics.getDeltaTime() * speed / 1.2);
                prev_movement = 0;
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            currentFrame = animator.animate(runWest()).getKeyFrame(stateTime, true);
            float x = getX();
            this.setX(x -= Gdx.graphics.getDeltaTime() * speed);
            prev_movement = 6;
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            currentFrame = animator.animate(runEast()).getKeyFrame(stateTime, true);
            float x = getX();
            this.setX(x += Gdx.graphics.getDeltaTime() * speed);
            prev_movement = 2;
        }

        spriteBatch.begin();
        if (currentFrame != null) {
            spriteBatch.draw(currentFrame, X_COORD, Y_COORD);
        }
        else{
            if(prev_movement == 0){
                spriteBatch.draw(new Texture("assets/Characters/Male/Male_3_Idle0.png"), X_COORD, Y_COORD);
            }
            if(prev_movement == 1){
                spriteBatch.draw(new Texture("assets/Characters/Male/Male_2_Idle0.png"), X_COORD, Y_COORD);
            }
            if(prev_movement == 2){
                spriteBatch.draw(new Texture("assets/Characters/Male/Male_1_Idle0.png"), X_COORD, Y_COORD);
            }
            if(prev_movement == 3){
                spriteBatch.draw(new Texture("assets/Characters/Male/Male_0_Idle0.png"), X_COORD, Y_COORD);
            }
            if(prev_movement == 4){
                spriteBatch.draw(new Texture("assets/Characters/Male/Male_7_Idle0.png"), X_COORD, Y_COORD);
            }
            if(prev_movement == 5){
                spriteBatch.draw(new Texture("assets/Characters/Male/Male_6_Idle0.png"), X_COORD, Y_COORD);
            }
            if(prev_movement == 6){
                spriteBatch.draw(new Texture("assets/Characters/Male/Male_5_Idle0.png"), X_COORD, Y_COORD);
            }
            if(prev_movement == 7){
                spriteBatch.draw(new Texture("assets/Characters/Male/Male_4_Idle0.png"), X_COORD, Y_COORD);
            }
        }
        spriteBatch.end();

    }

}
