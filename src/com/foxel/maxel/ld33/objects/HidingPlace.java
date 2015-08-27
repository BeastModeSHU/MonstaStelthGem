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

	private final int ID;
	private Image image, hiding;
	private boolean activated;

	public HidingPlace(float x, float y, int ID, Map map, String ENTITY_TYPE) {
		super(map, ENTITY_TYPE);
		this.x = x;
		this.y = y;
		this.ID = ID;
		

	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		image = new SpriteSheet(Constants.OBJECT_SPRITESHEET_LOC, TILESIZE, TILESIZE * 2)
				.getSubImage(ID, 0);
		hiding = new Image(Constants.HIDING_ICON);
		collider = new Circle(x,y,image.getWidth());
		activated = false; 
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(image, x + image.getWidth() / 2, y - image.getHeight() / 2.5f);
		if (this.activated) {
			g.drawImage(hiding, x + hiding.getWidth() / 2, y - image.getHeight() / 3);
		}

	}

	@Override
	public Vector2f getDimensions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getMaxY() {
		// TODO Auto-generated method stub
		return y + image.getHeight();
	}

	@Override
	public Vector2f getPixelLocation() {
		return new Vector2f(x, y);
	}

	@Override
	public void activate() {
		activated = true;
	}

	@Override
	public void deactivate() {
		activated = false;
	}

	@Override
	public boolean isActivated() {
		// TODO Auto-generated method stub
		return activated;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

}
