package com.foxel.maxel.ld33.objects;

import org.newdawn.slick.geom.Circle;

public interface ObjectInterface {

	public void activate();
	
	public void deactivate();
	
	public boolean isActivated();
	
	public Circle getActivationCircle(); 
	
	public int getID();
	
}
