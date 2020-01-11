### Code reference from 
Daniel Shiffman, Coding train [website](https://thecodingtrain.com)
## How to install Rainbow

You can install Rainbow eiteher from contribution manager or install it manually

for detail's check [How to install contributed library](https://github.com/processing/processing/wiki/How-to-Install-a-Contributed-Library)

## How to use

Import Rainbow either from contribution mangager or manual installation.

if you are able to write 
~~~
import Rainbow.*;
~~~
without any error, then you are good to go.

Next initialize any Rainbow class in setup(), pass PApplet (this) as arument in constructor.

For MengerSponge
~~~
MengerSponge mengerSponge;
void setup(){
  size(600,600,P3D);
  mengerSponge=new MengerSponge(this);
}
~~~
Now to run the actual MengerSponge Animation
~~~
void draw(){
  mengerSponge.draw(); 
}
~~~

Output

<img src="https://i.ibb.co/ZL3DKKJ/Screenshot-103.png" width="300dp" height="300dp"/>

You'll notice you still can't click on cube that's because

If the animation involves any events like mouseClicked(), MousePressed() etc you have to add corresponding events.

~~~
void mousePressed(){
  mengerSponge.mousePressed();
}
~~~
that's it.

<img src="https://i.ibb.co/tYHngNN/Screenshot-edited-104.png" width ="300dp" height="300dp"/>

now you can play with different parameters used in library, for example noise in blooby, angular velocity in planets.

~~~
import Rainbow.*;
MengerSponge mengerSponge;
void setup(){
  size(600,600,P3D);
  mengerSponge=new MengerSponge(this);
}
void draw(){
   mengerSponge.boxColor(127,0,225); // for voilet color box
   // notice boxColor isn't called from setup(), thats because
   // in the code the box is recreated everytime the onClick
   mengerSponge.draw();
}
void mouseClicked(){
  mengerSponge.mousePressed(); 
}

~~~

<img src="https://i.ibb.co/1r4MsbC/Screenshot-106.png" width="300dp" height="300dp"/>

### Classes
  - MengerSponge
  - PurpleRain
  - Blooby
  - SnakeGame 
  - Mitosis
  - SolarSystem
  - Roses
  - RandomWalker
  - AgarIo
  - Meta
  - Starfield
  - RDP
  - FractalTree
  - KaliedoScope
  - MetalBall

and still adding...

Main purpose of this library is to help beginners to get started with processing.

All classes in processing library are public to be used outside of package.

Which means food(snakeGame) can be used independently.
### Contributing

  - Open an issue: If you find any bug, or want any enhancement let me know in issues.
  - Adding more classes: Right now Rainbow consists of 30-35 classes, if you can also add your own by forking and creating PR.
  - If you found any typo or grammatical mistake, please Edit it.


### Troubleshooting

If you're having trouble, have a look at the [Processing Wiki](https://github.com/processing/processing/wiki/How-to-Install-a-Contributed-Library) for more information, or contact the author [Pallav Dubey](https://github.com/pallav12/).
