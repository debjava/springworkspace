package com.ddlab.rnd.composite;

class File implements AbstractFile {
	private String name;

	public File(String name) {
		this.name = name;
	}

	public void ls() {
		System.out.println(name);
	}
}