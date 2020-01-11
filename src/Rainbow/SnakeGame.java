package Rainbow;

import processing.core.PApplet;
import processing.core.PVector;

public class SnakeGame {
	PApplet pApplet;
	Snake s;
	int scl = 20;
	PVector food;
	public int getScl() {
		return scl;
	}
	public void setScl(int scl) {
		this.scl = scl;
	}
	public SnakeGame(PApplet pApplet) {
		this.pApplet=pApplet;
		this.setup();
	}
	public void setup() {
		s = new Snake(pApplet);

		  pApplet.frameRate(10);

		  pickLocation();
		
	}
	
	public void draw() {
		pApplet. background(51);



		  if (s.eat(food)) {

		    pickLocation();

		  }

		  s.death();

		  s.update(scl);

		  s.show(scl);





		 pApplet. fill(255, 0, 100);

		 pApplet. rect(food.x, food.y, scl, scl);
		
	}

	
	void pickLocation() {

		  int cols = pApplet.width/scl;

		  int rows = pApplet.height/scl;

		  food = new PVector(pApplet.floor(pApplet.random(cols)), pApplet.floor(pApplet.random(rows)));

		  food.mult(scl);

		}

	public void mousePressed() {
		 s.total++;
	}
	public void speed() {
		
		
		
	}
	

public void keyPressed() {

	  if (pApplet.keyCode ==pApplet. UP) {

	    s.dir(0, -1);

	  } else if (pApplet.keyCode == pApplet.DOWN) {

	    s.dir(0, 1);

	  } else if (pApplet.keyCode == pApplet.RIGHT) {

	    s.dir(1, 0);

	  } else if (pApplet.keyCode == pApplet.LEFT) {

	    s.dir(-1, 0);

	  }

	}
}