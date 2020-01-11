package Rainbow;

import processing.core.*;
import Rainbow.Star.*;

/**
 * Starfield example from coding train
 * @author Coding train, Pallav dubey
 *
 */
public class Starfield extends PApplet {

	PApplet myParent;
	/**
	 * 
	 * To control speed of starfield
	 */
	float speed;
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	Star[] stars;

	public Starfield(PApplet theParent) {
		myParent = theParent;
		stars = new Star[800];

		this.setup();
		this.draw();
	}

	public void setup() {

		for (int i = 0; i < stars.length; i++) {

			stars[i] = new Star(myParent);

		}

	}

	public void draw() {

		speed = myParent.map(myParent.mouseX, 0, myParent.width, 0, 50);

		myParent.background(0);
		myParent.translate(myParent.width / 2,myParent. height / 2);

		for (int i = 0; i < stars.length; i++) {
			stars[i].update(speed);
			stars[i].show();

		}

	}
}
