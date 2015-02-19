package com.ankuroswal.numbers.desktop;

import java.util.ArrayList;

import com.ankuroswal.numbers.External.LevelDirectory;
import com.ankuroswal.numbers.Levels.Level;
import com.ankuroswal.numbers.Operations.Operations;
// add headless backend
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl.LwjglFiles;
import com.badlogic.gdx.utils.GdxNativesLoader;

public class HeadlessLauncher {

	public static void main(String args[])
	{
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
	}
	
	public static void CreateLevel()
	{
		GdxNativesLoader.load();

        Gdx.files = new LwjglFiles();
		Integer[][] layout = 
			   {{1, 1, 1, 1},
				{1, 1, 1, 1}};
		
		int id = 2;
		double winningScore = 3000; 
		
		ArrayList<Operations> operations = new ArrayList<Operations>();;

		Level level = new Level(id, layout, winningScore, operations);
		
		LevelDirectory.getInstance().addLevel(level);
		LevelDirectory.getInstance().save();
	}
}