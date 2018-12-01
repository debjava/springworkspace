package com.ddlab.rnd.type1;


public class ObserverDemo {
	public static void main(String[] args) {
		Subject sub = new Subject();
		// Client configures the number and type of Observers
		new HexObserver(sub);
		new OctObserver(sub);
		new BinObserver(sub);

		sub.setState(5);

		// Scanner scan = new Scanner();
		// while (true) {
		// System.out.print( "\nEnter a number: " );
		// sub.setState( scan.nextInt() );
		// }
		// }

	}

}