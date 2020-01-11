package Rainbow;

import java.util.ArrayList;

import processing.core.PApplet;

/**
 * 
 * @author Coding Train, Pallav Dubey
 *
 */
public class Mitosis {
	PApplet pApplet;
	ArrayList<Cell> cells;

	/**
	 * No need to call setup since setup() is already called from Mitosis
	 * @param pApplet 
	 * 
	 */
	public Mitosis(PApplet pApplet) {
		this.pApplet = pApplet;
		this.setup();
	}

	public void setup() {
		cells = new ArrayList<Cell>();
		cells.add(new Cell(pApplet));
		cells.add(new Cell(pApplet));
	}

	/**
	 * Must be called from draw()
	 * 
	 */
	public void draw() {
		pApplet.background(200);
		for (Cell c : cells) {
			c.move();
			c.show();
		}
	}

	/**
	 * (optional) should be called from onClick in main
	 * 
	 */
	public void keyPressed() {
		for (int i = cells.size() - 1; i >= 0; i--) {
			Cell c = cells.get(i);
			if (c.clicked(pApplet.mouseX, pApplet.mouseY)) {
				cells.add(c.mitosis());
				cells.add(c.mitosis());
				cells.remove(i);
			}
		}
	}
}
