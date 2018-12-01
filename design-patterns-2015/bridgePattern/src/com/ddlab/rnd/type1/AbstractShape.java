package com.ddlab.rnd.type1;

/** "Abstraction" */
public abstract class AbstractShape {
	protected IDrawingAPI drawingAPI;

	protected AbstractShape(IDrawingAPI drawingAPI) {
		this.drawingAPI = drawingAPI;
	}

	public abstract void draw();
}
