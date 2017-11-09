package com.example.graphsplayground;

import java.util.HashSet;

public class DummyGraph implements WeightedGraph {

	private int numEdges;
	private HashSet<String> vertices;
	
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
	public boolean addVertex(String vertex) {
		return this.vertices.add(vertex);
	}

	@Override
	public void addEdge(String vertexA, String vertexB, int weight) {
		// TODO Auto-generated method stub
		this.numEdges++;

	}

}
