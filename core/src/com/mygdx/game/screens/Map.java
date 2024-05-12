package com.mygdx.game.screens;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;

//Creates and Renders The Map
public class Map {
    private TiledMap map;

    public Map(){
        map = new TmxMapLoader().load("map/exiled.tmx");
    }

    public TiledMap getMap(){
        return map;
    }

    public MapObjects getCollissionObjects(){
        MapLayer collisionObjectLayer = map.getLayers().get(4);
        System.out.println(collisionObjectLayer.getObjects().getCount());
        return collisionObjectLayer.getObjects();
    }

    public IsometricTiledMapRenderer makeMap(){
        return new IsometricTiledMapRenderer(map);
    }
}
