package physicsFinal;

import processing.core.PApplet;

public class Ball {
	private PApplet parent;
	private float centerX, centerY;
	private float radius;

	public Ball(PApplet p, float x, float y, float r) {
		parent = p;
		centerX = x;
		centerY = y;
		radius = r;

	}

	public void drawBall() {
		parent.fill(255);
		parent.ellipse(centerX, centerY, radius*2, radius*2);

	}
	public float getXCord()
	{
		return centerX;
	}
	public float getYCord()
	{
		return centerY;
	}
	
}
