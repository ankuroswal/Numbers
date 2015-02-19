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
		
		// ensure there is a directory
		if (directory == null)
			directory = new ArrayList<SaveFragment>();	
		
		// new game save
		if (directory.size() == 0 || directory.get(0) == null)
			directory.add(0, new SaveFragment(0, 0.0, true));

		// initialize new levels that haven't been added to save game list
		for (int i = directory.size(); i <= LevelDirectory.getInstance()
				.getTotalLevels(); i++) {
			directory.add(i, new SaveFragment(i, 0.0, false));
		}

	}
	
	public void save() {
		directory.trimToSize();
		FileHandle handle = (Gdx.files.local(LOADFILE + ".json"));
		Json json = new Json();
		json.setOutputType(OutputType.json);
		handle.writeString(json.prettyPrint(directory), false);
	}

	public SaveFragment getsaveScoreFragment(Integer id) {		
		if (directory.size() < id) 
		{
			directory.add(id, new SaveFragment(id, 0.0, false));
		}
		return directory.get(id);
	}
}