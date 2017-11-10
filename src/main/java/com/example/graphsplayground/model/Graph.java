package com.example.graphsplayground.model;

import java.util.List;

public interface Graph<T> {

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
	boolean addVertex(T vertex);

	/**
	 * Adds an edge on this graph. It is up to the concrete implementation of this
	 * graph to consider it as a directed or undirected edge.
	 *
	 * @param edge
	 *            An edge connecting two existing vertices on this graph
	 */
	void addEdge(Edge<T> edge);

	/**
	 * Returns the vertices directly reachable from the given vertex.
	 *
	 * @param vertex
	 *            The vertex to check
	 * @return A list of neighbors from this vertex
	 */
	List<Edge<T>> neighborsFrom(T vertex);

}
