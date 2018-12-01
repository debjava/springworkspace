package com.ddlab.rnd.type1;

class Fruit {

	@Override
	public String toString() {
		return "Fruit";
	}
}

class Banana extends Fruit {

	@Override
	public String toString() {
		return "Banana";
	}
}

public class Test1 {

	public void print(Fruit fruit) {

		System.out.println("Plain fruit ...");

	}

	public void print(Banana banana) {

		System.out.println("This is banana ...");

	}

	public static void main(String[] args) {

		Test1 test1 = new Test1();

		Fruit fruit = new Fruit();
		test1.print(fruit); //Output Plain fruit ...

		Banana banana = new Banana();

		test1.print((Fruit) banana); //Output Plain fruit ...

	}

}
