package com.ankuroswal.numbers.Node;

import com.ankuroswal.numbers.Utils.UI;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;


public class EmptyNode extends Node{
	
	private final StaticTiledMapTile REGION = 
			new StaticTiledMapTile(new TextureRegion(new Texture("nothing.png"), UI.TILEWIDTH, UI.TILEHEIGHT));
	
	private static final Color COLOR = new Color(0,0,0,1);
	
	public EmptyNode() {
		super(0, 0, COLOR);
		setID(0);
	}

	@Override
	public TiledMapTile getTile() {
		return REGION;
	}

}
