package com.example.graphsplayground.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdjacencyList<T> implements Graph<T> {

	private int numEdges;
	private Map<T, List<Edge<T>>> adjacencyList;

	public AdjacencyList() {
		this.adjacencyList = new HashMap<>();
	}

	@Override
	public int numVertices() {
		return this.adjacencyList.keySet().size();
	}

	@Override
	public int numEdges() {
		return this.numEdges;
	}

	@Override
	public boolean addVertex(T vertex) {
		if (vertex == null || this.adjacencyList.keySet().contains(vertex))
			return false;
		this.adjacencyList.put(vertex, new LinkedList<Edge<T>>());
		return true;
	}

	@Override
	public void addEdge(Edge<T> edge) {
		validate(edge);
		this.adjacencyList.get(edge.getVertexA()).add(edge);
		this.numEdges++;
	}

	@Override
	public List<Edge<T>> neighborsFrom(T vertex) {
		List<Edge<T>> dest = new LinkedList<>();
		for (Edge<T> e: this.adjacencyList.get(vertex)) {
			dest.add(e);
		}
		return dest;
	}

	private void validate(Edge<T> edge) {
		Set<T> vertices = this.adjacencyList.keySet();
		if (!vertices.contains(edge.getVertexA()) || !vertices.contains(edge.getVertexB()))
			throw new IllegalArgumentException("All vertices must exist on this graph");
	}

}
