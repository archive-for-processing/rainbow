package Rainbow;

import processing.core.PApplet;
import processing.event.MouseEvent;

/**
 * Code taken from Fractal tree example coding train
 * @author Coding train, Pallav dubey
 *
 */
public class FractalTree {
	float angle = 45;

	public float getAngle() {
		return angle;
	}
	public void setAngle(float angle) {
		this.angle = angle;
	}

	float branch_ratio = 0.67f;
	public int branch;
	PApplet pApplet;
	public FractalTree(PApplet pApplet) {
		this.pApplet=pApplet;
		branch=100;
		this.setup();
		
	}
	public void setup() {
		
		
	}
	
	public void branchNumber(int branch) {
		this.branch=branch;
	}
	public void draw() {
		
		pApplet.background(51);

		  pApplet.stroke(255);

		  pApplet.translate(pApplet.width/2, pApplet.height);

		  branch(branch);
	}
	void branch(float len){

		  pApplet.line(0,0,0,-len);

		  pApplet.translate(0, -len);

		  if (len > 4){

		    pApplet.pushMatrix();

		    pApplet.rotate(angle);

		    branch(len * branch_ratio);

		    pApplet.popMatrix();

		    pApplet.pushMatrix();

		    pApplet.rotate(-angle);

		    branch(len * branch_ratio);

		    pApplet.popMatrix();

		  }

		}

		public void mouseWheel(MouseEvent event){

		   angle += event.getCount()/10.0;

		 }
}
