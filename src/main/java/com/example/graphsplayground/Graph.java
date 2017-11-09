package com.example.graphsplayground;

public interface Graph {

	/**
	 * @return The number of vertices on this graph.
	 */
	int numVertices();

	/**
	 * @return The number of edges on this graph.
	 */
	int numEdges();

	/**
	 * Adds a vertex to this graph. If the vertex already exists, this graph should
	 * keep unmodified.
	 * 
	 * @param vertex
	 *            The name of this vertex
	 * @return <code>true</code> if this vertex was successfully added.
	 */
	boolean addVertex(String vertex);

}
