package Rainbow;

import processing.core.PApplet;
import processing.core.PVector;

public class MetalBallBlob extends PApplet{

	  PVector pos;

	  float r;

	  PVector vel;

	  PApplet pApplet;
	 public MetalBallBlob(float x, float y,PApplet pApplet) {

	    pos = new PVector(x, y);

	    vel = PVector.random2D();

	    vel.mult(random(2, 5));

	    r = random(120, 400);
	    
	    this.pApplet=pApplet;

	  }



	  void update() {

	    pos.add(vel); 

	    if (pos.x >pApplet. width || pos.x < 0) {

	      vel.x *= -1;

	    }

	    if (pos.y > pApplet.height || pos.y < 0) {

	      vel.y *= -1;

	    }

	  }



	  void show() {

	   pApplet. noFill();

	   pApplet. stroke(0);

	   pApplet.  strokeWeight(4);

	   pApplet.  ellipse(pos.x, pos.y, r*2, r*2);

	  }

	}