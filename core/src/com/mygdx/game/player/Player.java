package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Player {

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
}
