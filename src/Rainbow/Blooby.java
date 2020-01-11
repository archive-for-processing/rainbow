package Rainbow;

import processing.core.PApplet;

/**
 * Code taken form blooby example coding train
 * @author Coding train, Pallav dubey
 *
 */
public class Blooby extends PApplet {
	PApplet pApplet;
	float yoff = 0.0f;
	/**
	 * control radius of the blob
	 */
	float radius;
	/**
	 * control noise of the blob
	 */
	float noise;

	/**
	 * public constructor
	 * 
	 * @param pApplet
	 */
	public Blooby(PApplet pApplet) {
		this.pApplet = pApplet;
		this.setup();
		radius = 150;
		noise = 25f;
	}

	public void setup() {

	}

	/**
	 * public setter for radius
	 * 
	 * @param radius
	 */
	public void radius(float radius) {
		this.radius = radius;
	}

	/**
	 * puclic setter for noise
	 * 
	 * @param noise
	 */
	public void blobNoise(float noise) {
		this.noise = noise;
	}

	/**
	 * Must be called from draw()
	 *
	 */
	public void draw() {
		pApplet.background(0);
		pApplet.translate(pApplet.width / 2, pApplet.height / 2);

		pApplet.beginShape();
		float xoff = 0;
		for (float a = 0; a < PApplet.TWO_PI; a += 0.1) {
			float offset = map(pApplet.noise(xoff, yoff), 0, 1, -noise, noise);
			float r = radius + offset;
			float x = r * cos(a);
			float y = r * sin(a);
			pApplet.vertex(x, y);
			xoff += 0.1;
			// ellipse(x, y, 4, 4);

		}

		pApplet.endShape();

		yoff += 0.01;
	}
}
