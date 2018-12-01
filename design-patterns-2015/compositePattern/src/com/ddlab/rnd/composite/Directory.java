package com.ddlab.rnd.composite;

import java.util.ArrayList;

public class Directory implements AbstractFile {

	private String name;
	private ArrayList<AbstractFile> files = new ArrayList<AbstractFile>();

	public Directory(String name) {
		this.name = name;
	}

	public void add(AbstractFile f) {
		files.add(f);
	}

	public void ls() {
		System.out.println(name);
		for (AbstractFile file : files) {
			file.ls();
		}
	}

}
