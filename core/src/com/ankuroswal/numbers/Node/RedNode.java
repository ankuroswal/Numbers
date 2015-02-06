package com.ankuroswal.numbers.Node;

import com.ankuroswal.Utils.UI;
import com.ankuroswal.numbers.Actions.Transform;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

public class RedNode extends Node{
	
	private final StaticTiledMapTile REGION = 
			new StaticTiledMapTile(new TextureRegion(new Texture("redtile.png"), UI.TILEWIDTH, UI.TILEHEIGHT));
	
	
	private static final Color COLOR = new Color(1,0,0,1);

	
	public RedNode() {
		super(-9, -1, COLOR);
		setID(1);
		addAction(new Transform(0));
	}
	

	@Override
	public TiledMapTile getTile() {
		return REGION;
	}
	
}
