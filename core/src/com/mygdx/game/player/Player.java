package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.animation.Animator;
import com.mygdx.game.screens.Play;

public class Player{
    private Animator animator;
    private SpriteBatch spriteBatch;
    private float stateTime;

    public Player(){
        animator = new Animator();
        spriteBatch = new SpriteBatch();
        stateTime = 0f;
    }

    public Texture createPlayer(){
        return new Texture(Gdx.files.internal("assets/Characters/Male/Male_0_Idle0.png"));
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

        boolean isMovingDiagonal = false;

        // Check for diagonal movement
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                currentFrame = animator.animate(runNorthWest()).getKeyFrame(stateTime, true);
                isMovingDiagonal = true;
            } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                currentFrame = animator.animate(runNorthEast()).getKeyFrame(stateTime, true);
                isMovingDiagonal = true;
            } else {
                currentFrame = animator.animate(runNorth()).getKeyFrame(stateTime, true);
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                currentFrame = animator.animate(runSouthWest()).getKeyFrame(stateTime, true);
                isMovingDiagonal = true;
            } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                currentFrame = animator.animate(runSouthEast()).getKeyFrame(stateTime, true);
                isMovingDiagonal = true;
            } else {
                currentFrame = animator.animate(runSouth()).getKeyFrame(stateTime, true);
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            currentFrame = animator.animate(runWest()).getKeyFrame(stateTime, true);
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            currentFrame = animator.animate(runEast()).getKeyFrame(stateTime, true);
        }

        spriteBatch.begin();
        if (currentFrame != null) {
            spriteBatch.draw(currentFrame, 50, 50);
        }
        spriteBatch.end();
    }

}
