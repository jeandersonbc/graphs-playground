package com.example.graphsplayground;

public interface WeightedGraph extends Graph {

	/**
	 * Adds an edge connecting <code>vertexA</code> and <code>vertexB</code>. It is
	 * up to the underlying implementation to consider it as a directed or
	 * undirected edge.
	 * 
	 * @param vertexA
	 *            A vertex from this graph
	 * @param vertexB
	 *            Other vertex from this graph
	 * @param weight
	 *            The cost of traversing this edge
	 */
	void addEdge(String vertexA, String vertexB, int weight);

}
