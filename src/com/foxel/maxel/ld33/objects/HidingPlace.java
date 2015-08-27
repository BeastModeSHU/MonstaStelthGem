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

public class HidingPlace extends Renderable implements MapObject {

	public HidingPlace(Map map, String ENTITY_TYPE) {
		super(map, ENTITY_TYPE);
		// TODO Auto-generated constructor stub
	}
	/*
	private Image hiding;

	public HidingPlace(float x, float y, int ID) {
		super(x, y, ID);
		activationCircle = new Circle(x, y, 0);
		try {
			image = new SpriteSheet(Constants.OBJECT_SPRITESHEET_LOC, TILESIZE, TILESIZE * 2)
					.getSubImage(ID, 0);
			hiding = new Image(Constants.HIDING_ICON);
			activationCircle.setRadius(image.getWidth());
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void render(Graphics g) throws SlickException {
		g.drawImage(image, x + image.getWidth() / 2, y - image.getHeight() / 2.5f);
		if (this.activated) {
			g.drawImage(hiding, x + hiding.getWidth() / 2, y - image.getHeight() / 3);
		}
//		g.draw(this.activationCircle);
	}*/

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

}
