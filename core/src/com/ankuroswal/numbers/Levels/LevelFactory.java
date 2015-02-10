package com.ankuroswal.numbers.Levels;

public class LevelFactory {

	public static final int TOTALLEVELS = 3;

	public static Level getLevel(int id) {
		switch (id) {
		case 1:
			return new Level1();
		case 2:
			return new Level2();
		case 3:
			return new Level3();
		}
		return new Level1();
	}

}
