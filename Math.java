package physicsFinal;

import processing.core.PApplet;

public class Math {
	
	
	private PApplet parent;

	float angle, velocity, time;
	
	
	public Math(PApplet p, float theta, float totV, float t)
	{
		angle = theta;
		velocity = totV;
		time = t;
		parent = p;
	}
	
	public float horizontalTravel() //dx
	{
		return findVx()*time;
	}
	
	public float verticalTravel() //dy
	{
		 float dy = (float) ((findInitialVy()*time) + (.5*-9.80665*time*time));
		 if(dy>0)
		 {
			 return dy;
		 }
		return 0; //prevent method from returning negative value 
		
	}
	
	public float findVx() //x component 
	{
		return  parent.cos(angle)*velocity;
		
	}
	
	public float findInitialVy() //y component
	{
		return parent.sin(angle)*velocity;
		
	}
	
	public float findFinalVy()
	{
		return  (float) (findInitialVy() + -9.80665*time);
		
	}
	
	
	 
	

}
