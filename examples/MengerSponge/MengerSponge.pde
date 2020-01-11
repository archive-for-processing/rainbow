import Rainbow.*;

MengerSponge rainbow;
//SolarSystem rainbow;
void setup() {
  size(600,600,P3D);
  rainbow=new MengerSponge(this);
//  rainbow=new SolarSystem(this);
}
void draw(){
  rainbow.draw();
}

void mousePressed(){
  rainbow.mousePressed();

}
