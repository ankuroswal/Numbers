package com.ankuroswal.numbers.External;

import java.util.ArrayList;

import com.ankuroswal.numbers.Levels.Level;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter.OutputType;

public class LevelDirectory {
	
	private static LevelDirectory instance = null;
	private ArrayList<Level> directory = new ArrayList<Level>();
	private static final String LEVELDIRECTORYPATH = "leveldirectory";
	private boolean load = false;
	
	private LevelDirectory(){
	}
	
	// Singleton design pattern that is kind of thread safe
	public static LevelDirectory getInstance() {
		if (instance == null) {
			synchronized (ArrayList.class) {
				if (instance == null) {
					instance = new LevelDirectory();
				}
			}
		}
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public void load()
	{
		FileHandle handle = (Gdx.files.internal(LEVELDIRECTORYPATH + ".json"));
		if (handle.exists()) {
			Json json = new Json();
			directory = json.fromJson(ArrayList.class, handle);
		}
		if (directory == null)
			directory = new ArrayList<Level>();
		load = true;
	}
	
	public Level getLevel(int id)
	{
		if (!load) load();
		
		if (id < 0 || id > directory.size() - 1) 
		{
			return null;
		}
		return new Level(directory.get(id));
	}
	
	public int getTotalLevels()
	{
		return directory.size();
	}
	
	
	// these are created with the tools
	public void save()
	{
		directory.trimToSize();
		FileHandle handle = (Gdx.files.local(LEVELDIRECTORYPATH + ".json"));
		Json json = new Json();
		json.setOutputType(OutputType.json);
		handle.writeString(json.prettyPrint(directory), false);

	}
	
	public void addLevel(Level level)
	{
		if (!load) load();

		int size = level.getID() + 1;
		directory.ensureCapacity(size);
	    while (directory.size() < size) {
	    	directory.add(null);
	    }
		// TODO: test if level is fully initialized
		directory.add(level.getID(), level);
		clean();
	}
	
	private void clean()
	{
		if (!load) load();
		
		for (int i  = 0; i < directory.size(); i++)
		{
			if (directory.get(i) != null && directory.get(i).getID() != i)
			{
				directory.remove(i);
			}
		}
	}
	
}
