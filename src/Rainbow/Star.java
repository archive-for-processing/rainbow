package Rainbow;
import processing.core.*;

public class Star extends PApplet{
  float x;
  float y;
  float z;
  float pz;
  PApplet applet;
  
 public Star(PApplet applet) {
	  this.applet=applet;
   x = random(-applet.width/2, applet.width/2);
   y = random(-applet.height/2,applet.height/2);
   z = random(applet.width/2);

    pz = z;

  }

public  void update(float speed) {

    z = z - speed;
    if (z < 1) {
      z = applet.width/2;

      x = random(-applet.width/2, applet.width/2);

      y = random(-applet.height/2, applet.height/2);

      pz = z;

    }

  }



 public void show() {

    applet.fill(255);

    applet.noStroke();




    float sx =applet. map(x / z, 0, 1, 0,applet. width/2);

    float sy =applet. map(y / z, 0, 1, 0, applet.height/2);;



    float r =applet. map(z, 0, applet.width/2, 16, 0);

    applet.ellipse(sx, sy, r, r);



    // Here i use the "pz" valute to get the previous position of the stars,

    // so I can draw a line from the previous position to the new (current) one.

    float px = applet.map(x / pz, 0, 1, 0,applet. width/2);

    float py = applet.map(y / pz, 0, 1, 0,applet. height/2);



    // Placing here this line of code, I'm sure the "pz" value are updated after the

    // coordinates are already calculated; in this way the "pz" value is always equals

    // to the "z" value of the previous frame.

    pz = z;



    applet.stroke(255);

    applet.line(px, py, sx, sy);



  }

}