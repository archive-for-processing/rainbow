package Rainbow;

import java.util.ArrayList;

import processing.core.PApplet;

/**
 * Code taken form Coding train, MengerSponge example
 * @author Coding train, Pallav dubey
 *
 */
public class MengerSponge {
	PApplet pApplet;
	float a = 0;
	ArrayList<Box> sponge;
	public MengerSponge(PApplet pApplet) {
		this.pApplet=pApplet;
		this.setup();
	}
	
	public void boxColor(int r,int g,int b) {
		Box.red=r;
		Box.g=g;
		Box.b=b;
		
	}
	
	public void setup() {
		sponge = new ArrayList<Box>();
		  Box b = new Box(0, 0, 0, 200,pApplet);
		  sponge.add(b);
		
	}
	
	public void mousePressed() {
		
		  ArrayList<Box> next = new ArrayList<Box>();

		  for (Box b : sponge) {

		    ArrayList<Box> newBoxes = b.generate();

		    next.addAll(newBoxes);

		  }

		  sponge = next;
					
		
	}
	
	public void draw() {
		
		pApplet.background(51);

		  pApplet.stroke(255);

		 pApplet. noFill();

		  pApplet.lights();

		  pApplet.translate(pApplet.width/2,pApplet. height/2);

		 pApplet. rotateX(a);

		  pApplet.rotateY((float) (a*0.4));

		  pApplet.rotateZ((float) (a*0.1));

		  // Show what you've got!

		  for (Box b : sponge) {

		    b.show();

		  }

		  a += 0.01;
		
		
	}

}
