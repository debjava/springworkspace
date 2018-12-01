package com.ddlab.rnd.type2;

public class Car {

	private int quantity;

	// Optional Parameters
	private boolean isAVS;
	private boolean isAutomaticGear;
	private boolean isBulletProof;

	public static class CarBuilder {

		private int quantity;

		private boolean isAVS;
		private boolean isAutomaticGear;
		private boolean isBulletProof;

		public CarBuilder(int quantity) {
			this.quantity = quantity;
		}

		public CarBuilder avsSystem(boolean flag) {
			isAVS = flag;
			return this;
		}

		public CarBuilder automaticGear(boolean flag) {
			isAutomaticGear = flag;
			return this;
		}

		public CarBuilder bulletProof(boolean flag) {
			isBulletProof = flag;
			return this;
		}

		public Car build() {
			return new Car(this);
		}
	}

	private Car(CarBuilder builder) {
		isAVS = builder.isAVS;
		isAutomaticGear = builder.isAutomaticGear;
		isBulletProof = builder.isBulletProof;
	}

}
