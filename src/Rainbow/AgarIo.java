package Rainbow;

import java.util.ArrayList;

import processing.core.PApplet;

/**
 * Code taken from agarIo example, coding train
 * @author Coding train, Pallav dubey
 *
 */
public class AgarIo extends PApplet {
	/**
	 * food
	 * 
	 */
	Blob blob;
	ArrayList<Blob> blobs;

	float zoom = 1;
	PApplet pApplet;

	/**
	 * public constructor
	 * 
	 * @param pApplet mostly accepting "this" as input
	 * 
	 */
	public AgarIo(PApplet pApplet) {
		this.pApplet = pApplet;
		this.setup();
	}

	/**
	 * No need calling this specifically since already called form constructor
	 *
	 */
	public void setup() {
		blob = new Blob(0, 0, 64, pApplet);
		blobs = new ArrayList<Blob>();
		for (int i = 0; i < 200; i++) {
			float x = random(-pApplet.width, pApplet.width);
			float y = random(-pApplet.height, pApplet.height);
			blobs.add(new Blob(x, y, 16, pApplet));
		}
	}

	/**
	 * @param speed new Speed
	 */
	public void speed(int speed) {
		blob.speed = speed;
	}

	/**
	 * Will be called to set new color
	 * 
	 * @param r red component of new color
	 * @param g green component of new color
	 * @param b blue component of new color
	 */
	public void foodColor(int r, int g, int b) {
		blob.red = r;
		blob.g = g;
		blob.b = b;
	}

	/**
	 * Must be called from draw() of main function
	 */
	public void draw() {
		pApplet.background(0);
		pApplet.translate(pApplet.width / 2, pApplet.height / 2);
		float newzoom = 64 / blob.r;
		zoom = pApplet.lerp(zoom, newzoom, 0.1f);
		pApplet.scale(zoom);
		pApplet.translate(-blob.pos.x, -blob.pos.y);
		for (int i = blobs.size() - 1; i >= 0; i--) {
			blobs.get(i).show();
			if (blob.eats(blobs.get(i))) {
				blobs.remove(i);
			}
		}
		blob.show();
		blob.update();
	}
}
