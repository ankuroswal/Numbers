package com.ankuroswal.numbers.Node;

import com.ankuroswal.numbers.Actions.Transform;
import com.ankuroswal.numbers.Utils.UI;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

public class YellowNode extends Node{

	private final StaticTiledMapTile REGION = 
			new StaticTiledMapTile(new TextureRegion(new Texture("yellowtile.png"), UI.TILEWIDTH, UI.TILEHEIGHT));
	
	private static final Color COLOR = new Color(1,1,.5f,1);

	
	public YellowNode() {
		super(10, 20, COLOR);
		setID(3);
		addAction(new Transform(2));
	}

	@Override
	public TiledMapTile getTile() {
		return REGION;
	}
}
