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

public class NoiseMaker extends Renderable implements MapObject {
	
	private final int ID; 

	public NoiseMaker(float x, float y, int ID, Map map, String ENTITY_TYPE) {
		super(map, ENTITY_TYPE);
		this.x = x; 
		this.y = y; 
		this.ID = ID;
		
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
	/*
	 * Interactable object in the game which will distract enemies
	 */
	/*
	private Circle distractionCircle;
	private Image image;
	private final int MAX_RANGE = 320;

	public NoiseMaker(float x, float y, int ID) {
		super(x, y, ID);
		distractionCircle = new Circle(x + Constants.TILESIZE, y, MAX_RANGE);
		try {
			image = new SpriteSheet(Constants.OBJECT_SPRITESHEET_LOC, TILESIZE, TILESIZE * 2)
					.getSubImage(ID, 0);
			this.activationCircle = new Circle(x + Constants.TILESIZE,y+Constants.TILESIZE/2,Constants.ACTIVATION_RANGE);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public Circle getDistractionCircle() {
		return distractionCircle;
	}

	@Override
	public void render(Graphics g) throws SlickException {
		g.drawImage(image, (x - image.getWidth() / 2) + Constants.TILESIZE, y - image.getHeight()
				/ 2.5f);
	}*/

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
	
	
}