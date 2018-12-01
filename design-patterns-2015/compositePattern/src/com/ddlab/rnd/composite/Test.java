package com.ddlab.rnd.composite;

public class Test {

	public static void main(String[] args) {
		Directory dirOne = new Directory("dir111");
		Directory dirTwo = new Directory("dir222");
		
		File a = new File("a");
		File b = new File("b");
		File c = new File("c");
		File d = new File("d");
		
		dirOne.add(a);
		dirOne.add(dirTwo);
		dirOne.add(b);
		dirTwo.add(c);
		dirTwo.add(d);
		
		dirOne.ls();
		
	}
}
