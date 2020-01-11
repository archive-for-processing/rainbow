package Rainbow;

import processing.core.PApplet;

public class SolarSystem {
	PApplet pApplet;
	Planet sun;
	public SolarSystem(PApplet pApplet) {
		this.pApplet=pApplet;
		this.setup();
		
	}
	public void setup() {
		
		sun = new Planet(50, 0, 0,pApplet);

		  sun.spawnMoons(5, 1);
	}
	
	public void draw() {
		
		pApplet. background(0);

		 pApplet. translate(pApplet.width/2,pApplet. height/2);

		  sun.show();

		  sun.orbit();	
	}
}
