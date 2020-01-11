package Rainbow;

import processing.core.PApplet;

/**
 * Code taken from kaleidoScope example coding train
 * @author Coding train, Pallav dubey
 *
 */
public class KaleidoScope {
	int symmetry = 6;

	int angle = 360 / symmetry;

	float strokeSize = 4; // use + and - keys to change instead of slider

	float xoff;
	PApplet pApplet;
	public KaleidoScope(PApplet pApplet) {
		this.pApplet=pApplet;
		this.setup();
	}
	
	public void setup() {


		 pApplet. background(127);


		}
	public void keyPressed() {

		  if (pApplet.key == 's' || pApplet.key == 'S') {

		    pApplet.save("snowflake.png");

		   pApplet. println("snowflake saved!");

		  } else if (pApplet.key == 'c' || pApplet.key == 'C') {

		    pApplet.background(127);

		  }
	}
	public void draw() {
		  pApplet.translate(pApplet.width / 2,pApplet. height / 2);

		  

		  int mx =pApplet. mouseX -pApplet. width / 2;

		  int my = pApplet.mouseY -pApplet. height / 2;

		  int pmx = pApplet.pmouseX - pApplet.width / 2;

		  int pmy = pApplet.pmouseY - pApplet.height / 2;

		  

		  if (pApplet.mousePressed) {

		    int hu = (int) (pApplet.map(pApplet.sin(pApplet.radians(xoff)), -1, 1, 0, 255));

		    xoff += 1;

		 pApplet. stroke(hu, 100);

		    

		    for (int i = 0; i < symmetry; i++) {

		     pApplet. rotate(pApplet.radians(angle));

		      

		      // float d = dist(mx, my, pmx, pmy);

		      // float sw = map(d, 0, 16, 16, 2);

		      float sw = strokeSize;

		     pApplet. strokeWeight(sw);

		      

		     pApplet. line(mx, my, pmx, pmy);

		      

		     pApplet.pushMatrix();

		      pApplet.scale(1, -1);

		      pApplet.line(mx, my, pmx, pmy);

		     pApplet.popMatrix();

		    }

		}
	
	
	}
	}

