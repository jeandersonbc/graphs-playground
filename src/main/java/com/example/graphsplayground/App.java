package com.example.graphsplayground;

import java.io.File;

public class App {

	static void loadGraph(String pathToFile) {
		if (pathToFile == null)
			throw new IllegalArgumentException();

		File f = new File(pathToFile);
		if (!f.exists() || !f.isFile())
			throw new IllegalArgumentException();

	}
}
