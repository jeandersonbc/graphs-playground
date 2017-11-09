package com.example.graphsplayground;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class App {

	public static Graph<String> loadGraph(String pathToFile) throws FileNotFoundException {
		if (pathToFile == null)
			throw new IllegalArgumentException();

		WeightedGraph<String> graph = new DummyGraph<>();
		Scanner sc = null;
		try {
			sc = new Scanner(new BufferedReader(new FileReader(pathToFile)));
			while (sc.hasNext()) {
				String[] fields = sc.nextLine().split(" ");
				graph.addVertex(fields[0]);
				graph.addVertex(fields[1]);
				graph.addEdge(fields[0], fields[1], Integer.parseInt(fields[2]));
			}

		} finally {
			if (sc != null)
				sc.close();
		}

		return graph;
	}
}
