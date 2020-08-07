package physicsFinal;

import processing.core.PApplet;

public class Spot {
	private PApplet parent;
	private float centerX, centerY;
	private float radius;
	
	public Spot(PApplet p, float x, float y, float r) {
		parent = p;
		centerX = x;
		centerY = y;
		radius = r;

	}
	public void drawSpot() {
		parent.fill(300,200,100);
		parent.ellipse(centerX, centerY, radius*2, radius*2);

	}

	
}
