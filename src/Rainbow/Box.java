package Rainbow;

import java.util.ArrayList;

import processing.core.*;

/**
 * Helper class for MengerSponge
 * @author Coding Train, pallav dubey
 *
 */
public class Box extends PApplet{
	 /**
	 * 
	 * PVector for controlling movement along three dimensions
	 */
	public PVector pos;
	 public float r;
	  PApplet  pApplet;
	  public static int red,g,b;
	/**
	 * Public constructor that can be used without MengerSponge class
	 * @param x initial x coordinate of Box
	 * @param y initial y coordinate of Box
	 * @param z initial z coordinate of Box
	 * @param r_
	 * @param pApplet
	 */
	public  Box(float x, float y, float z, float r_,PApplet pApplet) {
	    pos = new PVector(x, y, z);
	    this.pApplet=pApplet;
	    red=255;
	    g=255;
	    b=255;
	    r = r_;
	  }
	 public ArrayList<Box> generate() {
	    ArrayList<Box> boxes = new ArrayList<Box>();
	    for (int x = -1; x < 2; x++) {
	      for (int y = -1; y < 2; y++) {
	        for (int z = -1; z < 2; z++) {
	          int sum = abs(x) + abs(y) + abs(z);
	          float newR = r/3;
	          if (sum > 1) {
	            Box b = new Box(pos.x+x*newR, pos.y+ y*newR, pos.z+z*newR, newR,pApplet);
	            boxes.add(b);
	          }
	        }
	      }
	    }
	    return boxes;
	  }
	public  void show() {

	    pApplet.pushMatrix();
	    pApplet.translate(pos.x, pos.y, pos.z);
	    pApplet.noStroke();
	    pApplet.fill(red,g,b);
	    pApplet.box(r);
	    pApplet.popMatrix();
	  }
	}