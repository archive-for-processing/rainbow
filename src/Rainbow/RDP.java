package Rainbow;

import java.util.ArrayList;

import processing.core.*;

public class RDP {
	ArrayList<PVector> allPoints;

	float epsilon = 0;

	PApplet pApplet;
	public RDP(PApplet pApplet) {
		this.pApplet=pApplet;	
		allPoints = new ArrayList<PVector>();
		this.setup();
	}
	public void setup() {
		 for (int x = 0; x <pApplet. width; x++) {

			    float xval = pApplet.map(x, 0,pApplet. width, 0, 5);

			    float yval = PApplet.exp(-xval) *pApplet. cos(PApplet.TWO_PI*xval);

			    float y = PApplet.map(yval, -1, 1, pApplet.height, 0);

			    allPoints.add(new PVector(x, y));}
		
	}
		 void rdp(int startIndex, int endIndex, ArrayList<PVector> allPoints, ArrayList<PVector> rdpPoints) {

			  int nextIndex = findFurthest(allPoints, startIndex, endIndex);

			  if (nextIndex > 0) {

			    if (startIndex != nextIndex) {

			      rdp(startIndex, nextIndex, allPoints, rdpPoints);

			    }

			    rdpPoints.add(allPoints.get(nextIndex));

			    if (endIndex != nextIndex) {

			      rdp(nextIndex, endIndex, allPoints, rdpPoints);

			    }

			  }

			}


		 int findFurthest(ArrayList<PVector> points, int a, int b) {

			  float recordDistance = -1;

			  PVector start = points.get(a);

			  PVector end = points.get(b);

			  int furthestIndex = -1;

			  for (int i = a+1; i < b; i++) {

			    PVector currentPoint = points.get(i);

			    float d = lineDist(currentPoint, start, end);

			    if (d > recordDistance) {

			      recordDistance = d;

			      furthestIndex = i;

			    }

			  }

			  if (recordDistance > epsilon) {

			    return furthestIndex;

			  } else {

			    return -1;

			  }

			}

		 float lineDist(PVector c, PVector a, PVector b) {

			  PVector norm = scalarProjection(c, a, b);

			  return PVector.dist(c, norm);

			}
		 
		 PVector scalarProjection(PVector p, PVector a, PVector b) {

			  PVector ap = PVector.sub(p, a);

			  PVector ab = PVector.sub(b, a);

			  ab.normalize(); // Normalize the line

			  ab.mult(ap.dot(ab));

			  PVector normalPoint = PVector.add(a, ab);

			  return normalPoint;

			}
	public	void draw() {

			  pApplet.background(0);



			  ArrayList<PVector> rdpPoints = new ArrayList<PVector>();



			  int total = allPoints.size();

			  PVector start = allPoints.get(0);

			  PVector end = allPoints.get(total-1);

			  rdpPoints.add(start);

			  rdp(0, total-1, allPoints, rdpPoints);

			  rdpPoints.add(end);

			 pApplet. println(allPoints.size(), rdpPoints.size());



			  epsilon += 0.1;

			  if (epsilon > 100) {

			    epsilon = 0;

			  }



			  pApplet.stroke(255, 0, 255);

			  pApplet.strokeWeight(4);

			  pApplet.noFill();

			 pApplet. beginShape();

			  for (PVector v : allPoints) {

			   pApplet. vertex(v.x, v.y);

			  }

			 pApplet. endShape();



			  pApplet.stroke(255);

			  pApplet.strokeWeight(4);

			 pApplet. beginShape();

			  for (PVector v : rdpPoints) {

			   pApplet. vertex(v.x, v.y);

			  }

			  pApplet.endShape();

			  pApplet.fill(255);

			  pApplet.textSize(64);

			  pApplet.text("epsilon: " + pApplet.nf(epsilon,2,2), 100, 75);

			  pApplet.text("n: " + rdpPoints.size(), 100, 150);

			}
	
}
