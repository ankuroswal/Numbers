package com.ankuroswal.numbers.External;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter.OutputType;

public class UserSaveDirectory {

	private static UserSaveDirectory instance = null;
	private final static String LOADFILE = "SCORESAVEFILE";
	private ArrayList<SaveFragment> directory = new ArrayList<SaveFragment>();
	private Boolean load = false;
	
	private UserSaveDirectory(){};
	
	// Singleton design pattern that is kind of thread safe
	public static UserSaveDirectory getInstance() {
		if (instance == null) {
			synchronized (ArrayList.class) {
				if (instance == null) {
					instance = new UserSaveDirectory();
				}
			}
		}
		return instance;
	}

	public void saveScoreFragment(SaveFragment fragment) {
		// load directory if it's not load
		if (!load)
			load();

		int id = fragment.getId();
		SaveFragment current = directory.get(id);

		if (current == null) {
			directory.add(id, fragment);
		} else if (current.getScore() < fragment.getScore()) {
			directory.remove(id);
			directory.add(id, fragment);
		}
	}

	@SuppressWarnings("unchecked")
	public void load() {
		FileHandle handle = (Gdx.files.internal(LOADFILE + ".json"));
		if (handle.exists()) {
			Json json = new Json();
			directory = json.fromJson(ArrayList.class, handle);
		}

		// initialize new levels that haven't been added to save game list
		for (int i = directory.size(); i <= LevelDirectory.getInstance()
				.getTotalLevels(); i++) {
			directory.add(i, new SaveFragment(i, 0.0, false));
		}

		load = true;
	}

	public void save() {
		directory.trimToSize();
		FileHandle handle = (Gdx.files.local(LOADFILE + ".json"));
		Json json = new Json();
		json.setOutputType(OutputType.json);
		handle.writeString(json.prettyPrint(directory), false);
	}

	public SaveFragment getsaveScoreFragment(Integer id) {
		if (!load) load();
		
		if (directory.size() <= id) 
		{
			directory.add(id, new SaveFragment(id));
		}
		return directory.get(id);
	}
}