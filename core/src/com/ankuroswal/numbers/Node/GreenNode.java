package com.ankuroswal.numbers.Node;

import com.ankuroswal.Utils.UI;
import com.ankuroswal.numbers.Actions.Transform;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

public class GreenNode extends Node{

	private final StaticTiledMapTile REGION = 
			new StaticTiledMapTile(new TextureRegion(new Texture("greentile.png"), UI.TILEWIDTH, UI.TILEHEIGHT));
	
	private static final Color COLOR = new Color(0,1,0,1);

	public GreenNode() {
		super(0, 9, COLOR);
		setID(2);
		addAction(new Transform(1));
	}

	@Override
	public TiledMapTile getTile() {
		return REGION;
	}
}
