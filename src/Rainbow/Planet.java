package Rainbow;

import processing.core.*;

/**
 * Helper class of solar system
 * @author Coding Train, Pallav dubey
 *
 */
class Planet extends PApplet {

	/**
	 * 
	 * For Used in radius setter
	 * 
	 */
	float radius;
	float distance;
	Planet[] planets;
	float angle;
	float orbitspeed;
	PApplet pApplet;

/**
 * Public constructor that can be used even independently
 * @param r radius
 * @param d diameter
 * @param o orbitspeed
 * @param pApplet
 */
public	Planet(float r, float d, float o, PApplet pApplet) {
		radius = r;
		this.pApplet = pApplet;
		distance = d;
		angle = random(TWO_PI);
		orbitspeed = o;
		// println(angle);
	}

/**
 * Function for controlling Orbit speed
 * 
 */
public void orbit() {
		angle = angle + orbitspeed;
		if (planets != null) {
			for (int i = 0; i < planets.length; i++) {
				planets[i].orbit();
			}
		}
	}

	void spawnMoons(int total, int level) {
		planets = new Planet[total];
		for (int i = 0; i < planets.length; i++) {
			float r = radius / (level * 2);
			float d = random(50, 150);
			float o = random(-0.1f, 0.1f);
			planets[i] = new Planet(r, d / level, o, pApplet);
			if (level < 3) {
				int num = (int) (random(0f, 4f));
				planets[i].spawnMoons(num, level + 1);
			}
		}
	}

	void show() {
		pApplet.pushMatrix();
		pApplet.fill(255, 100);
		pApplet.rotate(angle);
		pApplet.translate(distance, 0);
		pApplet.ellipse(0, 0, radius * 2, radius * 2);
		if (planets != null) {
			for (int i = 0; i < planets.length; i++) {
				planets[i].show();
			}
		}
		pApplet.popMatrix();
	}
}