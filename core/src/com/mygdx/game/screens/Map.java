package com.mygdx.game.screens;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;

//Creates and Renders The Map
public class Map {
    private TiledMap map;
    private int[] backgroundLayers;
    private int[] foregroundLayers;

    public Map(){
        map = new TmxMapLoader().load("map/exiled.tmx");
        backgroundLayers = new int[]{0};
        backgroundLayers = new int[]{1, 2};
    }

    public TiledMap getMap(){
        return map;
    }

    public int[] getBackgroundLayers(){
        return backgroundLayers;
    }

    public int[] getForegroundLayers(){
        return foregroundLayers;
    }

    public IsometricTiledMapRenderer makeMap(){
        return new IsometricTiledMapRenderer(map);
    }
}
