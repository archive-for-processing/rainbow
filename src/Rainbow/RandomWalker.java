package Rainbow;

import processing.core.PApplet;

public class RandomWalker extends PApplet{
	int x;

	int y;

	PApplet pApplet;
	public RandomWalker(PApplet pApplet) {
		this.pApplet=pApplet;
		this.setup();
		
	}
	
	public void setup() {

		  x = 200;

		  y = 200;

		 pApplet. background(51);

		
	}
	public void draw() {
		 pApplet.stroke(255, 100);
		  pApplet.strokeWeight(2);
		  pApplet.point(x, y);
		  int r = (int) (random(4));
		  switch (r) {
		  case 0:
		    x = x + 1;
		    break;
		  case 1:
		    x = x - 1;
		    break;
		  case 2:
		    y = y + 1;
		    break;
		  case 3:
		    y = y - 1;
		    break;
		
	}
	}
	}
