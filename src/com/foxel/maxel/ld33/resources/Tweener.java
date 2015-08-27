package com.foxel.maxel.ld33.resources;

public class Tweener {

	//General variables
	private double currentValue = 1d;
	private double startValue, endValue;
	private boolean returnToStart;
	private boolean finished = true;
	
	//Tweener value generation variables
	private double deltaValue;
	private double PI = Math.PI;
	private double angle, endAngle;
	private double deltaAngle;

	public void tween(double start, double end, float time, boolean returnBack) {

		startValue = start;
		currentValue = startValue;
		endValue = end;
		returnToStart = returnBack;
		finished = false;
		
		deltaValue = end - start;
		angle = 0d;
		if (returnBack)
			endAngle = PI;
		else
			endAngle = PI / 2d;
		deltaAngle = (1f / 1000f) * (1f / time) * (endAngle);
	}

	public double update(int delta) {
		
		if (!finished) {
			
			angle += delta * deltaAngle;
			if (angle >= endAngle) {
				currentValue = 1f;
				finished = true;
			}
			
			currentValue = startValue + Math.sin(angle) * deltaValue;
		}
		
		return currentValue;
	}

	public double getValue() {
		return currentValue;
	}
	
	public boolean isFinished() {
		return finished;
	}
}
