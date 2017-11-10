package com.example.graphsplayground.model;

/**
 * Represents an edge connecting two vertices of type <code>T</code>. A cost
 * might be associated to this edge. It is up to the {@link Graph}
 * implementation to interpret the edges as directed or undirected.
 *
 * @param <T>
 *            The type of the vertices
 */
public class Edge<T> {

	private T vertexA;
	private T vertexB;
	private int weight;

	/**
	 * Creates an edge connecting <code>vertexA</code> and <code>vertexB</code>.
	 * 
	 * @param vertexA
	 *            An existing vertex
	 * @param vertexB
	 *            Another existing vertex
	 * @param weight
	 *            The cost associated with this edge
	 */
	public Edge(T vertexA, T vertexB, int weight) {
		this.vertexA = vertexA;
		this.vertexB = vertexB;
		this.weight = weight;
	}

	/**
	 * Creates an edge connecting <code>vertexA</code> and <code>vertexB</code>.
	 * 
	 * @param vertexA
	 *            An existing vertex
	 * @param vertexB
	 *            Another existing vertex
	 */
	public Edge(T vertexA, T vertexB) {
		this(vertexA, vertexB, 1);
	}

	public T getVertexA() {
		return vertexA;
	}

	public T getVertexB() {
		return vertexB;
	}

	public int getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %s)", getVertexA(), getVertexB());
	}

}
