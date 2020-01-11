package Rainbow;

import processing.core.PApplet;

/**
 * @author Coding train, Pallav dubey
 *
 */
public class MetaBall extends PApplet {
	PApplet pApplet;
	MetalBallBlob[] blobs ;
	public MetaBall(PApplet pApplet) {
		this.pApplet=pApplet;
		this.setup();
	}
	public void setup() {
		blobs=new MetalBallBlob[10];
		colorMode(HSB);

		  for (int i = 0; i < blobs.length; i++) {

		    blobs[i] = new MetalBallBlob(random(pApplet.width), random(pApplet.height),pApplet);

		  }
	}
	public void draw() {
		pApplet. background(51);



		pApplet. loadPixels();

		  for (int x = 0; x <pApplet. width; x++) {

		    for (int y = 0; y < pApplet.height; y++) {

		      int index = x + y *pApplet. width;

		      float sum = 0;

		      for (MetalBallBlob b : blobs) {
		        float d = dist(x, y, b.pos.x, b.pos.y);
		        sum += 10 * b.r / d;
		      }
		      pApplet. pixels[index] = color(sum, 255, 255);
		    }

		  }

		  pApplet.  updatePixels();

		  for (MetalBallBlob b : blobs) {

		    b.update();

		    //b.show();

		  }

	}}
