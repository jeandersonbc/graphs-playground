package com.example.graphsplayground;

import java.util.HashSet;
import java.util.Set;

public class DummyGraph<T> implements WeightedGraph<T> {

	private int numEdges;
	private Set<T> vertices;
	
	public DummyGraph() {
		this.vertices = new HashSet<>();
	}

	@Override
	public int numVertices() {
		return this.vertices.size();
	}

	@Override
	public int numEdges() {
		return this.numEdges;
	}

	@Override
	public boolean addVertex(T vertex) {
		return this.vertices.add(vertex);
	}

	@Override
	public void addEdge(T vertexA, T vertexB, int weight) {
		// TODO Auto-generated method stub
		this.numEdges++;

	}

}
