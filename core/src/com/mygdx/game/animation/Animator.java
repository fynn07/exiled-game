package com.mygdx.game.animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animator{
    private static final int FRAME_COLS = 4, FRAME_ROWS = 3;

    public Animation<TextureRegion> animate(Texture animateTexture){
       TextureRegion[][] tmp = TextureRegion.split(animateTexture,
               animateTexture.getWidth() / FRAME_COLS,
               animateTexture.getHeight() / FRAME_ROWS);

       TextureRegion[] runFrames = new TextureRegion[(FRAME_ROWS * FRAME_COLS) - 2];
       int index = 0;
       for(int i = 0; i < FRAME_ROWS; i++){
           for(int j = 0; j < FRAME_COLS; j++){
               if(i == FRAME_ROWS - 1 && j > FRAME_COLS - 3){
                   break;
               }
               runFrames[index++] = tmp[i][j];
           }
       }
       return new Animation<TextureRegion>(0.025f, runFrames);
    }
}

