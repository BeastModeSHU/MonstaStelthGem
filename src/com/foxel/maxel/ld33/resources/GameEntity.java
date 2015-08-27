package com.foxel.maxel.ld33.resources;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import com.foxel.maxel.ld33.constants.Constants;
import com.foxel.maxel.ld33.map.Map;

public abstract class GameEntity {
	protected final int TILESIZE;
	protected final String ENTITY_TYPE;
	protected float x, y;
	protected Map map;
	protected Rectangle collider;

	public GameEntity(Map map, String ENTITY_TYPE) {
		this.map = map;
		this.TILESIZE = Constants.TILESIZE;
		this.ENTITY_TYPE = ENTITY_TYPE;
	}

	public abstract void init(GameContainer gc, StateBasedGame sbg) throws SlickException;

	public abstract void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException;

	public abstract void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException;
	
}
