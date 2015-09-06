package com.foxel.maxel.ld33.states;

import java.util.ArrayList;
import java.util.Collection;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.foxel.maxel.ld33.constants.Constants;
import com.foxel.maxel.ld33.entities.Player;
import com.foxel.maxel.ld33.entities.Tenant;
import com.foxel.maxel.ld33.map.Map;
import com.foxel.maxel.ld33.objects.HidingPlace;
import com.foxel.maxel.ld33.objects.MapObject;
import com.foxel.maxel.ld33.objects.NoiseMaker;
import com.foxel.maxel.ld33.objects.Target;
import com.foxel.maxel.ld33.resources.Camera;
import com.foxel.maxel.ld33.resources.Renderable;
import com.foxel.maxel.ld33.resources.XMLData;
import com.foxel.maxel.ld33.rendering.Renderer;

public class StateOne extends BasicGameState {

	private final int STATE_ID;
	private ArrayList<Renderable> renderable;
	private Map map;
	private Camera camera;
	private Player player;
	private ArrayList<MapObject> mapObjects;
	private ArrayList<Polygon> allPolys;
	private Renderer renderer;
	private float spottedTimer = 0;
	private int targetCount = 0;
	private Image splash;
	private boolean hasBegun;

	public StateOne(int STATE_ID) {
		this.STATE_ID = STATE_ID;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

		splash = new Image(Constants.OPENING_WINDOW_LOC);
		hasBegun = false;
		renderable = new ArrayList<Renderable>();

		map = new Map();
		map.init();

		XMLData.init(map);

		camera = new Camera(map.getWidth(), map.getHeight());

		player = new Player(map, Constants.ENTITY_PLAYER);
		// player.init(gc, sbg);

		ArrayList<Tenant> tenants = map.getTenants(camera);

		for (int i = 0; i < tenants.size(); i++) {
			// tenants.get(i).init(gc, sbg);
			renderable.add(tenants.get(i));
		}

		renderable.add(player);

		// zSort = new SortZAxis(player, map);

		mapObjects = new ArrayList<MapObject>();
		mapObjects = map.getObjects();
		renderable.addAll((Collection<? extends Renderable>) mapObjects);

		for (int i = 0; i < renderable.size(); ++i) {
			renderable.get(i).init(gc, sbg);
		}

		for (int i = 0; i < mapObjects.size(); ++i) {
			if (mapObjects.get(i).getID() == -1)
				++targetCount;
		}

		allPolys = new ArrayList<Polygon>();

		renderer = new Renderer(camera, player, map, renderable, allPolys);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		if (hasBegun) {
			camera.translate(g, player);

			renderer.render(gc, sbg, g, allPolys);
		} else {
			g.drawImage(splash, 0, 0);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if (hasBegun) {

			boolean spotted = false;
			if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE))
				gc.exit();
			allPolys.clear();

			for (int i = 0; i < renderable.size(); ++i) {
				renderable.get(i).update(gc, sbg, delta);
				Tenant t = null;
				if (renderable.get(i) instanceof Tenant)
					t = (Tenant) renderable.get(i);
				if (t != null) {

					for (int j = 0; j < t.polys.length; j++) {
						allPolys.add(t.polys[j]);
						if (t.polys[j].intersects(player.getCollider()) && !player.isPlayerHiding()) {
							player.spotted();
							spotted = true;
							// ADD TENANT REACTION TO SPOTTING PLAYER HERE
						}
					}
				}
			}

			if (spotted) {
				spottedTimer += (delta / 1000.f);
				if (spottedTimer > 0.2f) {
					// resetGame(gc, sbg);
					spottedTimer = 0.f;
				}
			} else {
				spottedTimer = 0.f;
			}

			for (int i = 0; i < renderable.size(); ++i) {
				renderable.get(i).update(gc, sbg, delta);
			}

			if (gc.getInput().isKeyPressed(Input.KEY_X))
				checkInteractables();

			if (targetCount <= 0)
				sbg.enterState(Constants.WIN_STATE_ID);
		} else {
			if (gc.getInput().isKeyPressed(Input.KEY_X))
				hasBegun = true;
			if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE))
				gc.exit();
		}
	}

	private void checkInteractables() {
		ArrayList<Renderable> tempList = new ArrayList<Renderable>();


		for (int i = 0; i < renderable.size(); ++i) {
			if (renderable.get(i) instanceof MapObject)
				if (renderable.get(i).getCollider().intersects(player.getCollider())) {
					tempList.add(renderable.get(i));
				}
			

		}
		Renderable tempRend = null;
		MapObject tempMapOb = null;
		
		if (tempList.size() > 0) {
			float closestDistance = new Vector2f(tempList.get(0).getPixelLocation().x
					+ Constants.TILESIZE / 2, tempList.get(0).getPixelLocation().y)
					.distanceSquared(player.getPixelLocation());

			tempRend = tempList.get(0);
			tempMapOb = (MapObject) tempList.get(0);

			if (tempList.size() > 1) {
				// tempInt = tempList.get(0);

				for (int i = 1; i < tempList.size(); ++i) {
					float thisDistance = new Vector2f(tempList.get(i).getPixelLocation().x
							+ Constants.TILESIZE / 2, tempList.get(i).getPixelLocation().y)
							.distanceSquared(player.getPixelLocation());
					if (thisDistance < closestDistance) {
						closestDistance = thisDistance;
						tempRend = tempList.get(i);
						tempMapOb = (MapObject) tempList.get(i);
					}
				}

			}
		}
		if (tempRend != null && tempMapOb != null) {
			if (tempMapOb instanceof NoiseMaker) {
				System.out.println("NoiseMaker");
				NoiseMaker temp = (NoiseMaker) (tempRend);
				distractTenants(new Vector2f(temp.getPixelLocation().x, temp.getPixelLocation().y),
						temp.getCollider());
			}

			if (tempMapOb instanceof HidingPlace) {
				System.out.println("Hiding Places");

				hidePlayer((HidingPlace) tempRend);
			}

			if (tempMapOb instanceof Target) {
				System.out.println("Target");
				killTarget((Target) tempRend);
			}
		}
	}

	private void killTarget(Target target) {

		if (target.isTargetAlive()) {
			targetCount -= 1;
			target.activate();
		}
	}

	private void distractTenants(Vector2f source, Shape collider) {
		// assert(source.equals(null)) : "distractTenants";

		for (int i = 0; i < renderable.size(); ++i) {
			if (renderable.get(i) instanceof Tenant) {

				Tenant temp = (Tenant) renderable.get(i);
				if (collider.intersects(temp.getCollider())) {
					temp.distract(source);
				}
			}
		}
	}

	private void hidePlayer(HidingPlace hidingPlace) {
		// Sanity checks
		assert (!hidingPlace.equals(null));

		if (!player.isPlayerHiding() && !hidingPlace.isActivated()) {
			hidingPlace.activate();
			player.setHidden(true);
			player.setPlayerLocation(hidingPlace.getPixelLocation().x,
					hidingPlace.getPixelLocation().y);

		} else if (player.isPlayerHiding()) {
			player.setHidden(false);
			hidingPlace.deactivate();
		}

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return STATE_ID;
	}

	private void resetGame(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO reset list of interactables
		for (Renderable e : renderable) {
			e.init(gc, sbg);
		}
		/*
		 * interactables.clear(); interactables = map.getInteractables();
		 */
		targetCount = 0;
		for (int i = 0; i < renderable.size(); ++i) {
			if (renderable.get(i) instanceof Target) {
				++targetCount;
			}
		}
		// renderer.setInteractables(interactables);
	}
}