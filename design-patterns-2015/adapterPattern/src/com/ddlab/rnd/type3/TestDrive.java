package com.ddlab.rnd.type3;

public class TestDrive {
	
	public static void test(Duck duck ) {
		duck.quack();
		duck.fly();
	}
	
	public static void main(String[] args) {
		
		MDuck duck = new MDuck();
		
		WildTurkey turkey = new WildTurkey();
		Duck turkeyAdapter = new TurkeyAdapter(turkey);
		
		System.out.println("Tukey says .....");
		turkey.gobble();
		turkey.fly();
		
		System.out.println("Duck says ...");
		test(duck);
		
		System.out.println("Turkey adapter says ...");
		test(turkeyAdapter);
		
	}

}
