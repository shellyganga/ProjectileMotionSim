package physicsFinal;

import ballCollect.Ball;
import processing.core.PApplet;

public class main extends PApplet{
	
	private Ball ball;
	private Spot spot;
	private Math math;
	float time = 0, error, pointVelocity, pError;
	boolean move = false, doneMove = false;
	boolean vicinity = false,  done = false;
	private int sx, sy, seditx, sedity;
	private float theta, initialV;
	
	public static void main(String[] args) {
		PApplet.main("physicsFinal.main");
	}
	
	public void setup()
	{
		//Spot spot = new Spot(this, 500, 20, 5);
		sx = 40;
		sy = 40;
		theta = 0;
		initialV = 50;
	}
	
	public void settings()
	{
		size(1000, 1000);
	}
	
	public void draw()
	{
		background(0);
		fill(234,100,130);
		rect(0,640,1000,10);
		textSize(20);

			if(doneMove)
			{
				time += .05;//time is incremented until dy=0
				Math math = new Math(this, theta * (PI/180), initialV, time); // format is (this, angle(in degrees) * PI/180, velocity, time);
				if(math.verticalTravel()==0)
				{
					noLoop(); //stop at 0
					text("The ball was " + error + " pixels off from the center", 70, 20);
					text("Percent error: " + pError + "%", 70,60);
				}
				
				Ball ball = new Ball(this,math.horizontalTravel() + 20, 630 -math.verticalTravel() ,10); //changed from 650 -> 630
				ball.drawBall();
				
				//pixel distance
				error = dist(ball.getXCord(), ball.getYCord(), sx, sy);
				
				//speed
				pointVelocity = sqrt(sq(math.findFinalVy()) + sq(math.findVx()));
				
				//percent error
				pError = (abs(((float)sx)-ball.getXCord())/ball.getXCord())*100;

				text("Velocity: " + pointVelocity, 400, 60 );
			}
			
			if (dist(mouseX, mouseY, sx, sy) <= 30) 
			{
				vicinity = true;
			}else{ 
				vicinity = false;
			}
			
			Spot spot = new Spot(this, sx, sy, 30);
			spot.drawSpot();
			
			if(move == false && doneMove == false)
			{
				textSize(20);
				text("Click and drag spot to predicted place when done adjusting", 70, 20);
				
				text("Move UP or DOWN keys to adjust launch velocity", 25, 300);
				text("Velocity: " + initialV, 25, 340);
				
				text("Move LEFT or RIGHT keys to adjust launch angle", 25, 380);
				text("Angle: " + theta, 25, 420);
			}
			
	}
	
	public void mousePressed()
	{
		if(vicinity)
			move = true;
		else
			move = false;
		
		seditx = mouseX - sx;
		sedity = mouseY - sy;
		
	}
	public void mouseDragged() 
	{
		if(move)
		{
			sx = mouseX - seditx;
			sy = mouseY - sedity;
		}
	}
	
	public void mouseReleased()
	{
		move = false;
		doneMove = true;
	}
	
	public void keyPressed()
	{
		if(move == false && doneMove == false)
		{
			if(key == CODED)
			{
				if(keyCode == UP)
				{
					initialV+=5;
				}
				else if (keyCode == DOWN)
				{
					initialV-=5;
				}
				
				if(keyCode == RIGHT)
				{
					theta ++;
				} 
				else if( keyCode == LEFT)
				{
					theta--;
				}
			}
			
		}	
	}	
		
}
	


