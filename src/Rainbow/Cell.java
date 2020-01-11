package Rainbow;

import processing.core.*;

/**
 * Code taken from mitosis example coding train
 * @author Coding train, Mitosis
 *
 */
public class Cell extends PApplet {

	PVector pos;
	float r;
	int c;
	PApplet pApplet;

	public Cell(PVector pos, float r, int c, PApplet pApplet) {

		this.pos = pos.copy();
		this.r = r;
		this.c = c;
		this.pApplet = pApplet;
	}

	public Cell(PApplet pApplet) {
		this.pos = new PVector(random(pApplet.width), random(pApplet.height));
		this.r = 60;
		this.pApplet = pApplet;
		this.c = color(random(100, 255), 0, random(100, 255), 100);
	}

	public boolean clicked(int x, int y) {
		float d = dist(this.pos.x, this.pos.y, x, y);
		if (d < this.r) {
			return true;
		} else {
			return false;
		}
	}

	public Cell mitosis() {
		Cell cell = new Cell(this.pos, (float) (this.r * 0.8), this.c, pApplet);
		return cell;
	}

	public void move() {
		PVector vel = PVector.random2D();
		this.pos.add(vel);
	}

	public void show() {
		pApplet.noStroke();
		pApplet.fill(this.c);
		pApplet.ellipse(this.pos.x, this.pos.y, this.r, this.r);
	}
}