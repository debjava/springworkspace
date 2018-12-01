package com.ddlab.rnd.type1;

/** "Client" */
class TestBridgePattern {
	public static void main(String[] args) {

		AbstractShape shape = new CircleShape(new ConcreteDrawingImpl());
		shape.draw();
	}
}