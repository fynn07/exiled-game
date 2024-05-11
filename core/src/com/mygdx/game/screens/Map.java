package com.mygdx.game.screens;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;

//Creates and Renders The Map
public class Map {
    private TiledMap map;

    public IsometricTiledMapRenderer makeMap(){
        map = new TmxMapLoader().load("map/exiled.tmx");
        return new IsometricTiledMapRenderer(map);
    }
}
