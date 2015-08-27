package com.foxel.maxel.ld33.objects;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.foxel.maxel.ld33.constants.Constants;
import com.foxel.maxel.ld33.map.Map;
import com.foxel.maxel.ld33.resources.Renderable;

public class Target extends Renderable implements MapObject {

	public Target(Map map, String ENTITY_TYPE) {
		super(map, ENTITY_TYPE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deactivate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isActivated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Circle getActivationCircle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector2f getDimensions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getMaxY() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/*
	private Image alive, dead;

	public Target(float x, float y, int ID) {
		super(x, y, ID);
		try {
			SpriteSheet temp = new SpriteSheet(Constants.TARGET_SPRITESHEET_LOC, TILESIZE, 96);
			alive = temp.getSubImage(0, 0);
			dead = temp.getSubImage(1, 0);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(Graphics g) throws SlickException {
		if (!activated)
			g.drawImage(alive, x + alive.getWidth()/2, y - alive.getHeight()/4);
		else
			g.drawImage(dead, x + dead.getWidth() / 2, y);
//		g.draw(activationCircle);
	}
	public boolean isTargetAlive(){ 
		return !activated; //return the opposite of activate to indicate entity is dead
	}*/ 
	
}
