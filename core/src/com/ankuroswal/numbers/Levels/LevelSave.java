package com.ankuroswal.numbers.Levels;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter.OutputType;

public class LevelSave {

	private static String LOADFILE = "LevelScoreDirectory";
	private static ArrayList<Double> directory = new ArrayList<Double>();

	public static void setLevel(Integer id, Double score) {
		if (score > directory.get(id)) {
			directory.add(id, score);
		}
	}

	@SuppressWarnings("unchecked")
	public static void load() {
		FileHandle handle = (Gdx.files.internal(LOADFILE + ".json"));
		if (handle.exists()) {
			Json json = new Json();
			directory = json.fromJson(ArrayList.class, handle);
		}

		// initialize new levels that haven't been added to save game list
		for (int i = directory.size(); i <= LevelFactory.TOTALLEVELS; i++) {
			directory.add(i, 0.0);
		}
	}

	public static void save() {
		directory.trimToSize();
		FileHandle handle = (Gdx.files.local(LOADFILE + ".json"));
		Json json = new Json();
		json.setOutputType(OutputType.json);
		handle.writeString(json.prettyPrint(directory), false);
	}

	public static double getLevel(Integer id) {
		return directory.get(id);
	}

}
