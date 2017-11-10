package com.example.graphsplayground;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

import com.example.graphsplayground.model.AdjacencyList;
import com.example.graphsplayground.model.Edge;
import com.example.graphsplayground.model.Graph;

public class App {

	public static Graph<String> loadGraph(String pathToFile) throws FileNotFoundException {
		if (pathToFile == null)
			throw new IllegalArgumentException();

		Graph<String> graph = new AdjacencyList<>();
		Scanner sc = null;
		try {
			sc = new Scanner(new BufferedReader(new FileReader(pathToFile)));
			while (sc.hasNext()) {
				String[] fields = sc.nextLine().split(" ");
				graph.addVertex(fields[0]);
				graph.addVertex(fields[1]);
				graph.addEdge(new Edge<>(fields[0], fields[1], Integer.parseInt(fields[2])));
			}
		} finally {
			if (sc != null)
				sc.close();
		}
		return graph;
	}

	public static <T> Map<T, T> bfs(T source, T destiny, Graph<T> graph) {
		Queue<T> queue = new LinkedList<>();
		Set<T> visited = new HashSet<>();
		Map<T, T> discoveredBy = new HashMap<>();

		queue.add(source);
		visited.add(source);
		while (!queue.isEmpty()) {
			T current = queue.remove();
			if (current.equals(destiny)) {
				break;
			}
			for (Edge<T> edge : graph.neighborsFrom(current)) {
				T neighbor = edge.getVertexB();
				if (!visited.contains(neighbor)) {
					queue.add(neighbor);
					visited.add(neighbor);
					discoveredBy.put(neighbor, current);
				}
			}
		}
		return discoveredBy;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Graph<String> graph = App.loadGraph("data/digraph1.txt");
		System.out.println(traverseFrom("A", "D", bfs("A", "D", graph)));
	}

	private static <T> List<T> traverseFrom(T source, T destiny, Map<T, T> path) {
		LinkedList<T> traversal = new LinkedList<>();
		T current = destiny;
		traversal.addFirst(current);
		while (!current.equals(source)) {
			current = path.get(current);
			if (current == null)
				throw new RuntimeException("Unreachable path");
			traversal.addFirst(current);
		}
		return traversal;
	}
}
