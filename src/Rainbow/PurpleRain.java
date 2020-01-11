package Rainbow;

import processing.core.*;

public class PurpleRain extends PApplet {
	PApplet pApplet;
	PurpleDrop[] drops;
	public PurpleRain(PApplet pApplet) {
		this.pApplet=pApplet;
		drops = new PurpleDrop[500]; // array of drop objects
		this.setup();
	}


	public void setup() {

	  for (int i = 0; i < drops.length; i++) { // we create the drops 

	    drops[i] = new PurpleDrop(pApplet);

	  }

	}



	public void draw() {

	  pApplet.background(230, 230, 250); // background color in RGB color cordinates

	  for (int i = 0; i < drops.length; i++) {

	    drops[i].fall(); // sets the shape and speed of drop

	    drops[i].show(); // render drop

	  }

	}
}
