package com.ankuroswal.numbers.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ankuroswal.numbers.Numbers;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "N";
		cfg.useGL30 = true;
		cfg.height = 320;
		cfg.width = 480;
		new LwjglApplication(new Numbers(), cfg);
	}
}
