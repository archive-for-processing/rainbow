package Rainbow;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * Code taken from Blooby example coding train
 * @author Coding train, Pallav dubey
 *
 */
public class Blob extends PApplet {
	
	/**
	 * PVectors for controlling location of invidual food items 
	 * 
	 */
	PVector pos, vel;
	float r;
	/**
	 * for controlling speed
	 */
	public int speed;
	/**
	 * for colors
	 */
	public int red, g, b;
	PApplet pApplet;

	/**
	 * public constructor, can be used event without AgarIo
	 * @param _x X coordinate
	 * @param _y Y coordinate
	 * @param _r
	 * @param pApplet
	 * 
	 * 
	 */
	public Blob(float _x, float _y, float _r, PApplet pApplet) {
		pos = new PVector(_x, _y);
		vel = new PVector(0, 0);
		red = 255;
		g = 255;
		b = 255;
		r = _r;
		speed = 3;
		this.pApplet = pApplet;
	}

	/**
	 * 
	 * for updating individual food items
	 */
	public void update() {
		PVector newvel = new PVector(pApplet.mouseX - pApplet.width / 2, pApplet.mouseY - pApplet.height / 2);
		newvel.setMag(speed);
		vel.lerp(newvel, (float) 0.2);
		pos.add(vel);
	}

	public boolean eats(Blob other) {
		float d = PVector.dist(pos, other.pos);
		if (d < r + other.r) {
			float sum = PI * r * r + PI * other.r * other.r;
			r = sqrt(sum / PI);
			return true;
		} else {
			return false;
		}
	}

	public void show() {
		pApplet.fill(red, g, b);
		pApplet.ellipse(pos.x, pos.y, r * 2, r * 2);
	}
}