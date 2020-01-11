package Rainbow;

import java.util.ArrayList;

import processing.core.*;

class Snake extends PApplet{
	float x = 0;
	float y = 0;

	float xspeed = 1;

	float yspeed = 0;

	int total = 0;
	PApplet pApplet;

	ArrayList<PVector> tail = new ArrayList<PVector>();

	Snake(PApplet pApplet) {

		this.pApplet=pApplet;
	}

	boolean eat(PVector pos) {

		float d = dist(x, y, pos.x, pos.y);

		if (d < 1) {

			total++;

			return true;

		} else {

			return false;

		}

	}

	void dir(float x, float y) {

		xspeed = x;

		yspeed = y;

	}

	void death() {

		for (int i = 0; i < tail.size(); i++) {

			PVector pos = tail.get(i);

			float d = dist(x, y, pos.x, pos.y);

			if (d < 1) {

				pApplet.println("starting over");

				total = 0;

				tail.clear();

			}

		}

	}

	void update(int scl) {

		// println(total + " " + tail.size());

		if (total > 0) {

			if (total == tail.size() && !tail.isEmpty()) {

				tail.remove(0);

			}

			tail.add(new PVector(x, y));

		}

		x = x + xspeed * scl;

		y = y + yspeed * scl;

		x =pApplet. constrain(x, 0, pApplet.width - scl);

		y = pApplet.constrain(y, 0, pApplet.height - scl);

	}

	void show(int scl) {

		pApplet.fill(255);

		for (PVector v : tail) {

			pApplet.rect(v.x, v.y, scl, scl);

		}

		pApplet.rect(x, y, scl, scl);

	}

}