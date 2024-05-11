package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.ExiledGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
// Git Test
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Exiled");
		config.setWindowedMode(1280, 720);
		new Lwjgl3Application(new ExiledGame(), config);
	}
}
