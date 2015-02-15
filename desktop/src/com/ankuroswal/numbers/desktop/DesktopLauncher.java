package com.ankuroswal.numbers.desktop;

import com.ankuroswal.numbers.Numbers;
import com.ankuroswal.numbers.Google.IActivityRequestHandler;
import com.ankuroswal.numbers.Google.IRequestHandlerDesktop;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher implements IActivityRequestHandler {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "N";
		cfg.height = 320;
		cfg.width = 480;
		new LwjglApplication(new Numbers(new IRequestHandlerDesktop()), cfg);
	}

	@Override
	public void showAds(boolean show) {
		
	}
}
