package com.ankuroswal.numbers.External;

import java.util.ArrayList;

import com.ankuroswal.numbers.Levels.Level;
import com.ankuroswal.numbers.Operations.Operations;


// add headless backend
public class LevelCreationTool {

	public void CreateLevel()
	{
		Integer[][] layout = 
			   {{3, 2, 1, 2},
				{3, 2, 1, 2}};
		
		int id = 1;
		double winningScore = 3000; 
		
		ArrayList<Operations> operations = new ArrayList<Operations>();;

		Level level = new Level(id, layout, winningScore, operations);
		
		LevelDirectory.getInstance().addLevel(level);
		LevelDirectory.getInstance().save();
	}
}