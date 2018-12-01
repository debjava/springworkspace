package com.ddlab.rnd.type1;

class Vegetable {
	
	@Override
	public String toString() {
		return "Vegetable";
	}
}

class Tomato extends Vegetable {
	
	@Override
	public String toString() {
		return "Tomato";
	}
}

public class Test2 {
	
	public void print(Vegetable vegetable ) {
		
		if( vegetable instanceof Tomato ) {
			System.out.println("It is Tomato ...");
		}
		else {
			System.out.println("It is vegetable");
		}


	}

	public static void main(String[] args) {
		
		Test2 test2 = new Test2();
		
		Vegetable vegetable = new Vegetable();
		test2.print(vegetable); // Output It is vegetable

		Tomato tomato = new Tomato();

		test2.print((Vegetable) tomato); // Output It is Tomato ...

	}

}
