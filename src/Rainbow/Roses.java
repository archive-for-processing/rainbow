package Rainbow;

import processing.core.PApplet;

public class Roses extends PApplet {
	PApplet pApplet;
	float d = 8;

	float n = 5;


	public Roses(PApplet pApplet) {
		this.pApplet=pApplet;
		this.setup();
	}
	public void setup() {
		
	}
	public void draw() {
		float k = n / d;
		  pApplet.background(51);
		  pApplet.translate(pApplet.width / 2,pApplet. height / 2);
		  pApplet. beginShape();
		  pApplet.stroke(255);
		  pApplet.noFill();
		  pApplet. strokeWeight(1);
		  for (float a = 0; a < TWO_PI * d; a += 0.02) {
		    float r = 200 * cos(k * a);
		    float x = r * cos(a);
		    float y = r * sin(a);
		    pApplet. vertex(x, y);
		  }

		 pApplet. endShape(CLOSE);
	}
}
