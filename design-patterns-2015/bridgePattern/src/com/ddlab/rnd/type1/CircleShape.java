package com.ddlab.rnd.type1;

/** "Refined Abstraction" */
class CircleShape extends AbstractShape {
	public CircleShape(IDrawingAPI drawingAPI) {
		super(drawingAPI);
	}

	// low-level i.e. Implementation specific
	public void draw() {
		drawingAPI.drawCircle();
	}
}