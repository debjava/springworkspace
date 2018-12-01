package com.ddlab.rnd.type2;

public class HighPerformanceEngine extends Engine {
	private TwinTurboEngine twinTurbo = new TwinTurboEngine();

	public HighPerformanceEngine() {

		super("High Performance");
	}

	public void start() {
		twinTurbo.turnOn();
	}

	public void stop() {
		twinTurbo.turnOff();
	}

	public void accelerate() {
		twinTurbo.engage();
	}

	public void decelerate() {
		twinTurbo.disengage();
		twinTurbo.brake();
	}
}